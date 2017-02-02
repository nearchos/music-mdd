package org.istmusic.mdd.connectors;

import org.istmusic.mw.context.model.api.IRepresentation;
import org.istmusic.mw.context.model.api.IEntity;
import org.istmusic.mw.context.model.api.IScope;
import org.istmusic.mw.context.model.api.EntityScopePair;
import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.triggers.Trigger;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMCToContext implements Connector
{
    private final DMC dmc;
    private final EntityScopePair entityScopePair;
    private final IRepresentation representation;
    private final Trigger trigger;

    DMCToContext(final DMC dmc,
            final EntityScopePair entityScopePair,
            final IRepresentation representation,
            final Trigger trigger)
    {
        super();

        this.dmc = dmc;
        this.entityScopePair = entityScopePair;
        this.representation = representation;
        this.trigger = trigger;
    }

    public DMC getDmc()
    {
        return dmc;
    }

    public EntityScopePair getEntityScopePair()
    {
        return entityScopePair;
    }

    public IEntity getEntity()
    {
        return entityScopePair.getEntity();
    }

    public IScope getScope()
    {
        return entityScopePair.getScope();
    }

    public IRepresentation getRepresentation()
    {
        return representation;
    }

    public Trigger getTrigger()
    {
        return trigger;
    }
}