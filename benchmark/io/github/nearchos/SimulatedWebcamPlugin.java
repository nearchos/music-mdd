package io.github.nearchos;

import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.ContextValueMap;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.AbstractContextPlugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.github.nearchos.SimulatedWebcamPluginMetadata.ENTITY_WEBCAM;
import static io.github.nearchos.SimulatedWebcamPluginMetadata.REPRESENTATION_BUFFERED_IMAGE;
import static io.github.nearchos.SimulatedWebcamPluginMetadata.SCOPE_IMAGE_CAPTURE;

public class SimulatedWebcamPlugin extends AbstractContextPlugin implements Runnable {

    public static final long DELAY = 1000; // 1 sec

    public SimulatedWebcamPlugin() {
        super(SimulatedWebcamPlugin.class.getSimpleName(), new SimulatedWebcamPluginMetadata());
    }

    private boolean active;

    @Override
    public void activate() {
        super.activate();

        active = true;
        new Thread(this).start();
    }

    @Override
    public void deactivate() {
        super.deactivate();
        active = false;
    }

    @Override
    public void run() {
        int currentPictureIndex = 0;
        while (active) {
            // generate context change event with current picture
            final String currentWebcamFrame = simulatedWebcamFrames[currentPictureIndex];
            final Map<IScope, IContextValue> map = new HashMap<>();
            final IValue value = Factory.createValue(currentWebcamFrame);
            final IContextValue contextValue = Factory.createContextValue(SCOPE_IMAGE_CAPTURE, REPRESENTATION_BUFFERED_IMAGE, value, IMetadata.EMPTY_METADATA);
            map.put(SCOPE_IMAGE_CAPTURE, contextValue);
            final ContextValueMap contextValueMap = Factory.createContextValueMap(map);
            final IContextElement contextElement = Factory.createContextElement(
                    ENTITY_WEBCAM,
                    SCOPE_IMAGE_CAPTURE,
                    REPRESENTATION_BUFFERED_IMAGE,
                    this,
                    contextValueMap);
            final IContextDataset contextDataset = Factory.createContextDataset(contextElement);
            final ContextChangedEvent contextChangedEvent = EventFactory.createContextChangedEvent(this, contextDataset);
            fireContextChangedEvent(contextChangedEvent);

            currentPictureIndex = (currentPictureIndex < simulatedWebcamFrames.length - 1) ? currentPictureIndex + 1 : 0;

            try { Thread.sleep(DELAY); } catch (InterruptedException ie) { throw new RuntimeException(ie); };
        }
    }

    public static final String [] simulatedWebcamFrames = {
            "images/p0.png",
            "images/p0.png",
            "images/p0.png",
            "images/p1.png",
            "images/p1.png",
            "images/p1.png",
            "images/p2.png",
            "images/p2.png",
            "images/p2.png",
            "images/p3.png",
            "images/p3.png",
            "images/p3.png",
            "images/p4.png",
            "images/p4.png",
            "images/p4.png",
            "images/p5.png",
            "images/p5.png",
            "images/p5.png"
    };
}