package io.github.nearchos;

import org.istmusic.mdd.example.MotionDetectorPlugin;
import org.istmusic.mw.context.model.api.EntityScopePair;
import org.istmusic.mw.context.model.api.IEntity;
import org.istmusic.mw.context.model.api.IRepresentation;
import org.istmusic.mw.context.model.api.IScope;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.IContextPlugin;

import java.util.Arrays;

public class HarnessMDD {

    public static final IEntity ENTITY_IMAGE_BUFFER = Factory.createEntity("#concept.contextscope.abstract.ImageBuffer");

    public static final IScope SCOPE_TRUE_FALSE_FLAG = Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag");

    public static final IRepresentation REPRESENTATION_ENVIRONMENT_BOOLEAN = Factory.createRepresentation("#representation.environment.Boolean");

    public static void main(String[] args) throws Exception {
        final SimulatedContextAccess simulatedContextAccess = new SimulatedContextAccess();

        final SimulatedWebcamPlugin simulatedWebcamPlugin = new SimulatedWebcamPlugin();
        final MotionDetectorPlugin simpleMotionDetectorPlugin = new MotionDetectorPlugin();
        System.out.println("*** PLUG-IN INFO ***");
        printPluginInfo(simulatedWebcamPlugin);
        System.out.println("*** PLUG-IN INFO ***");
        printPluginInfo(simpleMotionDetectorPlugin);

        simulatedContextAccess.register(simulatedWebcamPlugin);
        simulatedContextAccess.register(simpleMotionDetectorPlugin);

        simulatedWebcamPlugin.activate();
        simpleMotionDetectorPlugin.activate();
    }

    private static void printPluginInfo(IContextPlugin contextPlugin) {
        System.out.println("Plugin id: " + contextPlugin.getID());
        final EntityScopePair [] monitoredEntityScopePairs = contextPlugin.getMetadata().getMonitoredEntityScopePairs();
        System.out.println("Monitored EntityScopePairs: " + Arrays.toString(monitoredEntityScopePairs));
        final EntityScopePair [] requiredEntityScopePairs = contextPlugin.getMetadata().getRequiredEntityScopePairs();
        System.out.println("Required EntityScopePairs: " + Arrays.toString(requiredEntityScopePairs));
    }
}
