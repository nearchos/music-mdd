package org.istmusic.mdd.example;

import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.plugins.AbstractContextReasonerPlugin;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.model.api.IContextDataset;
import org.istmusic.mdd.operators.ImageComparingOperator;

import java.util.LinkedList;
import java.awt.image.BufferedImage;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class SimpleMotionDetectorPlugin extends AbstractContextReasonerPlugin
{
    public static final String PLUGIN_ID = "SimpleMotionDetectorPlugin";

    public static final MotionDetectorPluginMetadata MOTION_DETECTOR_PLUGIN_METADATA =
            new MotionDetectorPluginMetadata();

    public SimpleMotionDetectorPlugin()
    {
        super(PLUGIN_ID, MOTION_DETECTOR_PLUGIN_METADATA);
    }

    public static final double LOWER_THRESHOLD = 0.2d;

    private final LinkedList queue = new LinkedList();

    public void contextChanged(ContextChangedEvent event)
    {
        // somehow extract the "image" from the input event -- in the generated
        // code this is expected to happen automatically using for example an
        // instance of the ContextToDMC connector
        final BufferedImage bufferedImage = null;

        queue.addFirst(bufferedImage);
        // Maintain that the queue has a fixed size of 2 - actually the
        // generated code will not have to do so, because it will be maintained
        // by the input DMC.
        // Also, the DMC will automatically maintain that both values in the
        // queue are "fresh" enough (not shown here).
        while(queue.size() > 2)
        {
            queue.removeLast();
        }

        if(queue.size() == 2)
        {
            final BufferedImage bufferedImage1 = (BufferedImage) queue.get(0);
            final BufferedImage bufferedImage2 = (BufferedImage) queue.get(1);

            // in the actual MDD-generated code the access to this method will
            // be achieved indirectly (via compute()) which is not a static
            // method anyway (thus we will need an actual instance of the
            // operator)
            final double result = ImageComparingOperator.compareImages(bufferedImage1, bufferedImage2);

            // output the result - in the MDD generated code, this should happen
            // automatically via an MDCToContext connector
            final IContextDataset contextDataset = null;

            contextListener.contextChanged(EventFactory.createContextChangedEvent(bufferedImage, contextDataset));
        }
    }
}