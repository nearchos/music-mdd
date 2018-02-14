package io.github.nearchos;

import org.istmusic.mdd.example.mdd.MotionDetectorPlugin;
import org.istmusic.mdd.example.plain.PlainMotionDetectorPlugin;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.events.IContextListener;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.IContextPlugin;

public class Simulation {

    public static final IEntity ENTITY_MOTION_DETECTED = Factory.createEntity("#concept.entitytype.abstract.motion_detected");

    public static final IScope SCOPE_TRUE_FALSE_FLAG = Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag");
    public static final IScope SCOPE_MOTION_DETECTED = Factory.createScope("#concept.contextscope.abstract.motion_detected");

    public static void main(String[] args) throws Exception {
        final SimulatedContextAccess simulatedContextAccess = new SimulatedContextAccess();

        // create the 3 plug-ins
        final SimulatedWebcamPlugin simulatedWebcamPlugin = new SimulatedWebcamPlugin();
        final MotionDetectorPlugin generatedMotionDetectorPlugin = new MotionDetectorPlugin();
        final PlainMotionDetectorPlugin plainMotionDetectorPlugin = new PlainMotionDetectorPlugin();
        System.out.println("*** PLUG-IN INFO (Webcam plugin simulating a camera capture every second) ***");
        printPluginInfo(simulatedWebcamPlugin);
        System.out.println("*** PLUG-IN INFO (The MDD-created plug-in processing consecutive camera frames) ***");
        printPluginInfo(generatedMotionDetectorPlugin);
        System.out.println("*** PLUG-IN INFO (The equivalent, manually-created plug-in processing consecutive camera frames) ***");
        printPluginInfo(plainMotionDetectorPlugin);
        System.out.println();

        simulatedContextAccess.addContextListener(ENTITY_MOTION_DETECTED, SCOPE_MOTION_DETECTED, new IContextListener() {
            @Override
            public void contextChanged(ContextChangedEvent contextChangedEvent) {
                final IContextElement [] contextElements = contextChangedEvent.getContextElements();
                for(final IContextElement contextElement : contextElements) {
                    final IContextData contextData = contextElement.getContextData();
                    final Boolean motionDetected = (Boolean) contextData.getValue(SCOPE_TRUE_FALSE_FLAG).getValue();
                    System.out.println(contextElement.getSource() + " -> listening ... " + (motionDetected ? "MOTION!" : ""));
                }
            }
        });
        simulatedContextAccess.register(simulatedWebcamPlugin);
        simulatedContextAccess.register(generatedMotionDetectorPlugin);
        simulatedContextAccess.register(plainMotionDetectorPlugin);

        simulatedWebcamPlugin.activate();
        generatedMotionDetectorPlugin.activate();
        plainMotionDetectorPlugin.activate();
    }

    private static void printPluginInfo(IContextPlugin contextPlugin) {
        System.out.println("Plugin id: " + contextPlugin.getID());
//        final EntityScopePair [] monitoredEntityScopePairs = contextPlugin.getMetadata().getMonitoredEntityScopePairs();
//        System.out.println("Monitored EntityScopePairs: " + Arrays.toString(monitoredEntityScopePairs));
//        final EntityScopePair [] requiredEntityScopePairs = contextPlugin.getMetadata().getRequiredEntityScopePairs();
//        System.out.println("Required EntityScopePairs: " + Arrays.toString(requiredEntityScopePairs));
    }
}