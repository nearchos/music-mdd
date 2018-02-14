package org.istmusic.mdd.example.plain;

import org.istmusic.mdd.example.mdd.MotionDetectorPluginMetadata;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.ContextDataset;
import org.istmusic.mw.context.model.impl.ContextValueMap;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.model.impl.MetadataMap;
import org.istmusic.mw.context.plugins.AbstractContextReasonerPlugin;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mdd.operators.ImageComparingOperator;

import java.util.HashMap;
import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class PlainMotionDetectorPlugin extends AbstractContextReasonerPlugin
{
    public static final String PLUGIN_ID = "PlainMotionDetectorPlugin";

    public static final MotionDetectorPluginMetadata MOTION_DETECTOR_PLUGIN_METADATA =
            new MotionDetectorPluginMetadata();

    public PlainMotionDetectorPlugin()
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
        final IContextElement [] contextElements = event.getContextElements();
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
                final double result = ImageComparingOperator.compareImages(bufferedImage1, bufferedImage2);
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
}