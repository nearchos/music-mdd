package io.github.nearchos;

import org.istmusic.mw.context.model.api.IEntity;
import org.istmusic.mw.context.model.api.IRepresentation;
import org.istmusic.mw.context.model.api.IScope;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.SingleProvidedContextTypePluginMetadata;

public class SimulatedWebcamPluginMetadata extends SingleProvidedContextTypePluginMetadata {

    public static final IEntity ENTITY_WEBCAM = Factory.createEntity("http://www.ist-music.eu/Ontology_v0_1.xml#concept.entitytype.webcam");
    public static final IScope SCOPE_IMAGE_CAPTURE = Factory.createScope("http://www.ist-music.eu/Ontology_v0_1.xml#concept.contextscope.abstract.image_captured");
    public static final IRepresentation REPRESENTATION_BUFFERED_IMAGE = Factory.createRepresentation("http://www.ist-music.eu/Ontology_v0_1.xml#representation.environment.BufferedImage");

    SimulatedWebcamPluginMetadata() {
        super(ENTITY_WEBCAM, SCOPE_IMAGE_CAPTURE);
    }
}