package io.github.nearchos;

import org.istmusic.mdd.example.mdd.MotionDetectorPlugin;
import org.istmusic.mdd.example.plain.PlainMotionDetectorPlugin;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.events.IContextListener;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.IContextPlugin;

import java.util.Vector;

public class Simulation {

    public static final IEntity ENTITY_MOTION_DETECTED = Factory.createEntity("#concept.entitytype.abstract.motion_detected");

    public static final IScope SCOPE_TRUE_FALSE_FLAG = Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag");
    public static final IScope SCOPE_MOTION_DETECTED = Factory.createScope("#concept.contextscope.abstract.motion_detected");

    public static void main(String[] args) throws Exception {
        // provides a simulated harness in place of the context middleware
        System.out.println("Creating simulated context access (experiment harness)");
        final SimulatedContextAccess simulatedContextAccess = new SimulatedContextAccess();

        // load the plugins of which the full class name is specified in the args
        final Vector<IContextPlugin> contextPlugins = new Vector<>();
        for(final String arg : args) {
            final Class clazz = Class.forName(arg);
            final IContextPlugin contextPlugin = (IContextPlugin) clazz.newInstance();
            contextPlugins.add(contextPlugin);
            System.out.println("Loading and registering plugin: " + contextPlugin.getID());
            simulatedContextAccess.register(contextPlugin);
        }

        // register a dummy listener to receive the events
        System.out.println("Registering a simulated context listener");
        simulatedContextAccess.addContextListener(ENTITY_MOTION_DETECTED, SCOPE_MOTION_DETECTED, contextChangedEvent -> {
            final IContextElement [] contextElements = contextChangedEvent.getContextElements();
            for(final IContextElement contextElement : contextElements) {
                final IContextData contextData = contextElement.getContextData();
                final Boolean motionDetected = (Boolean) contextData.getValue(SCOPE_TRUE_FALSE_FLAG).getValue();
                System.out.println(contextElement.getSource() + " -> listening ... " + (motionDetected ? "MOTION!" : ""));
            }
        });

        System.out.println("Starting simulation (activating all plugins)");

        for(final IContextPlugin contextPlugin : contextPlugins) {
            contextPlugin.activate();
        }

        System.out.println();
    }
}