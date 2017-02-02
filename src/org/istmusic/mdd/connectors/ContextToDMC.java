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
public class ContextToDMC implements Connector
{
    private final EntityScopePair entityScopePair;
    private final IRepresentation representation;
    private final DMC dmc;
    private final Trigger trigger;

    ContextToDMC(final EntityScopePair entityScopePair,
            final IRepresentation representation,
            final DMC dmc,
            final Trigger trigger)
    {
        super();

        this.entityScopePair = entityScopePair;
        this.representation = representation;
        this.dmc = dmc;
        this.trigger = trigger;
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

    public DMC getDmc()
    {
        return dmc;
    }

    public Trigger getTrigger()
    {
        return trigger;
    }
}