package org.istmusic.mdd.example.plain;

import org.istmusic.mw.context.model.api.EntityScopePair;
import org.istmusic.mw.context.model.api.IEntity;
import org.istmusic.mw.context.model.api.IRepresentation;
import org.istmusic.mw.context.model.api.IScope;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.IPluginMetadata;

public class PlainMotionDetectorPluginMetadata implements IPluginMetadata {

    // required
    public static final IEntity Input_WEBCAM_IMAGE_ENTITY
            = Factory.createEntity("#concept.entitytype.webcam");

    public static final IScope Input_WEBCAM_IMAGE_SCOPE
            = Factory.createScope("#concept.contextscope.abstract.image_captured");

    public static final IRepresentation Input_WEBCAM_IMAGE_REPRESENTATION
            = Factory.createRepresentation("#representation.environment.image_from_webcam");

    public static final EntityScopePair Input_WEBCAM_IMAGE_ENTITY_SCOPE_PAIR
            = new EntityScopePair(Input_WEBCAM_IMAGE_ENTITY, Input_WEBCAM_IMAGE_SCOPE);




    public static final EntityScopePair [] REQUIRED_ENTITY_SCOPE_PAIRS = {
            Input_WEBCAM_IMAGE_ENTITY_SCOPE_PAIR
    };



    // provided
    public static final IEntity Output_MOTION_DETECTED_ENTITY
            = Factory.createEntity("#concept.entitytype.abstract.motion_detected");

    public static final IScope Output_MOTION_DETECTED_SCOPE
            = Factory.createScope("#concept.contextscope.abstract.motion_detected");

    public static final IRepresentation Output_MOTION_DETECTED_REPRESENTATION
            = Factory.createRepresentation("#representation.environment.activity.motion");

    public static final EntityScopePair Output_MOTION_DETECTED_ENTITY_SCOPE_PAIR
            = new EntityScopePair(Output_MOTION_DETECTED_ENTITY, Output_MOTION_DETECTED_SCOPE);



    public static final EntityScopePair [] MONITORED_ENTITY_SCOPE_PAIRS = {
            Output_MOTION_DETECTED_ENTITY_SCOPE_PAIR
    };

    public EntityScopePair [] getRequiredEntityScopePairs()
    {
        return REQUIRED_ENTITY_SCOPE_PAIRS;
    }

    public EntityScopePair [] getMonitoredEntityScopePairs()
    {
        return MONITORED_ENTITY_SCOPE_PAIRS;
    }
}