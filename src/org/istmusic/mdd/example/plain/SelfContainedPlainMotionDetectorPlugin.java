package org.istmusic.mdd.example.plain;

import org.istmusic.mdd.example.mdd.MotionDetectorPluginMetadata;
import org.istmusic.mdd.operators.ImageComparingOperator;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.ContextValueMap;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.model.impl.MetadataMap;
import org.istmusic.mw.context.plugins.AbstractContextReasonerPlugin;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SelfContainedPlainMotionDetectorPlugin extends AbstractContextReasonerPlugin
{
    public static final String PLUGIN_ID = "PlainMotionDetectorPlugin";

    public static final MotionDetectorPluginMetadata MOTION_DETECTOR_PLUGIN_METADATA =
            new MotionDetectorPluginMetadata();

    public SelfContainedPlainMotionDetectorPlugin()
    {
        super(PLUGIN_ID, MOTION_DETECTOR_PLUGIN_METADATA);
    }

    public static final double LOWER_THRESHOLD = 0.1d;

    private final LinkedList queue = new LinkedList();

    private double threshold = LOWER_THRESHOLD;

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public void contextChanged(ContextChangedEvent event)
    {
        // somehow extract the "image" from the input event -- in the mdd code this happens automatically using an
        // instance of the ContextToDMC connector (and mediation where needed)
        final IContextElement[] contextElements = event.getContextElements();
        if(contextElements != null && contextElements.length > 0) {
            final IContextElement fromElement = event.getContextElements()[0];
            final IContextData contextData = fromElement.getContextData();
            final IValue value = contextData.getValue(Factory.createScope("#concept.contextscope.abstract.image_captured"));
            final String filename = (String) value.getValue();

            final BufferedImage bufferedImage = ImageComparingOperator.load(filename);

            queue.addFirst(bufferedImage);
            // Maintain that the queue has a fixed size of 2 - actually the mdd code will not have to do so, because it
            // will be maintained by the input DMC.
            // Also, the DMC will automatically maintain that both values in the queue are "fresh" enough (not shown here).
            while(queue.size() > 2)
            {
                queue.removeLast();
            }

            if(queue.size() == 2)
            {
                final BufferedImage bufferedImage1 = (BufferedImage) queue.get(0);
                final BufferedImage bufferedImage2 = (BufferedImage) queue.get(1);

                // in the actual MDD-mdd code, the access to this method is achieved indirectly (via compute()) which
                // is not a static method anyway (thus need an actual instance of the operator)
                final double result = compareImages(bufferedImage1, bufferedImage2);
                final boolean motionDetected = result > threshold;

                // output the result - in the MDD mdd code, this happens automatically via an MDCToContext connector
                final Map map = new HashMap();
                final IContextValue motionDetectedValue = Factory.createContextValue(
                        Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag"),
                        Factory.createRepresentation("#representation.environment.Boolean"),
                        Factory.createValue(motionDetected),
                        (IMetadata) MetadataMap.EMPTY_METADATA_MAP);
                map.put(Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag"), motionDetectedValue);
                final ContextValueMap contextValueMap = Factory.createContextValueMap(map);
                final IContextElement contextElement = Factory.createContextElement(
                        PlainMotionDetectorPluginMetadata.Output_MOTION_DETECTED_ENTITY,
                        PlainMotionDetectorPluginMetadata.Output_MOTION_DETECTED_SCOPE,
                        PlainMotionDetectorPluginMetadata.Output_MOTION_DETECTED_REPRESENTATION,
                        this,
                        contextValueMap
                );
                final IContextDataset contextDataset = Factory.createContextDataset(contextElement);

                contextListener.contextChanged(EventFactory.createContextChangedEvent(bufferedImage, contextDataset));
            }
        }
    }

    public static final double PIXEL_RANGE = 255d;

    private static double compareImages(final BufferedImage bufferedImage0, final BufferedImage bufferedImage1)
    {
        if(bufferedImage0 == null || bufferedImage1 == null)
        {
            throw new NullPointerException("Illegal null argument(s)");
        }

        final int width1 = bufferedImage0.getWidth();
        final int height1 = bufferedImage0.getHeight();
        final Raster raster1 = bufferedImage0.getData();
        final int numOfBands1 = raster1.getNumBands();

        final int width2 = bufferedImage1.getWidth();
        final int height2 = bufferedImage1.getHeight();
        final Raster raster2 = bufferedImage1.getData();
        final int numOfBands2 = raster2.getNumBands();

        if(width1 != width2 || height1 != height2 || numOfBands1 != numOfBands2)
        {
            throw new IllegalArgumentException("The dimensions of the" +
                    " arguments and their number of bands must be equal");
        }

        final double [] differenceByBand = new double[numOfBands1];
        for(int band = 0; band < numOfBands1; band++)
        {
            differenceByBand[band] = compareRasters(raster1, raster2, band);
        }

        final double maxDifference = width1 * height1 * PIXEL_RANGE;

        double overallDifference = 0;

        for(int band = 0; band < numOfBands1; band++)
        {
            final double percentageOfDifferenceByBand = differenceByBand[band] / maxDifference;
            overallDifference += percentageOfDifferenceByBand;
        }
        overallDifference /= numOfBands1;
        return overallDifference;
    }

    private static double compareRasters(final Raster raster1, final Raster raster2, final int band)
    {
        final int width1 = raster1.getWidth();
        final int height1 = raster1.getHeight();
        final int width2 = raster2.getWidth();
        final int height2 = raster2.getHeight();

        if(width1 != width2 || height1 != height2)
        {
            throw new IllegalArgumentException("The provided rasters are not of equal dimensions");
        }

        double countingDifference = 0;

        for(int row = 0; row < height1; row++)
        {
            for(int col = 0; col < width1; col++)
            {
                final double pixel1 = raster1.getSampleDouble(col, row, band);
                final double pixel2 = raster2.getSampleDouble(col, row, band);

                final double difference = Math.abs(pixel1 - pixel2);

                countingDifference += difference;
            }
        }

        return countingDifference;
    }
}
