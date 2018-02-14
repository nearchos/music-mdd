package org.istmusic.mdd.example.plain;

import org.istmusic.mdd.example.mdd.MotionDetectorPluginMetadata;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.model.api.IContextData;
import org.istmusic.mw.context.model.api.IContextElement;
import org.istmusic.mw.context.model.api.IValue;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.AbstractContextReasonerPlugin;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.model.api.IContextDataset;
import org.istmusic.mdd.operators.ImageComparingOperator;

import java.util.LinkedList;
import java.awt.image.BufferedImage;

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

    public static final double LOWER_THRESHOLD = 0.2d;

    private final LinkedList queue = new LinkedList();

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
System.out.println("loading: " + filename);

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

                // in the actual MDD-mdd code the access to this method will
                // be achieved indirectly (via compute()) which is not a static
                // method anyway (thus we will need an actual instance of the
                // operator)
                final double result = ImageComparingOperator.compareImages(bufferedImage1, bufferedImage2);

                // output the result - in the MDD mdd code, this should happen
                // automatically via an MDCToContext connector
                final IContextDataset contextDataset = null;

                contextListener.contextChanged(EventFactory.createContextChangedEvent(bufferedImage, contextDataset));
            }
        }
    }
}