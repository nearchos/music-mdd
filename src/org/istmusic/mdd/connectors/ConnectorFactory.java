package org.istmusic.mdd.connectors;

import org.istmusic.mw.context.model.api.EntityScopePair;
import org.istmusic.mw.context.model.api.IRepresentation;
import org.istmusic.mdd.triggers.Trigger;
import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.operators.Operator;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class ConnectorFactory
{
    public static ContextToDMC createContextToDMCConnector(
            final EntityScopePair entityScopePair,
            final IRepresentation representation,
            final DMC outputDMC,
            final Trigger trigger)
    {
        return new ContextToDMC(entityScopePair, representation, outputDMC, trigger);
    }

    public static DMCToContext createDmcToContextConnector(
            final DMC outputDMC,
            final EntityScopePair entityScopePair,
            final IRepresentation representation,
            final Trigger trigger)
    {
        return new DMCToContext(outputDMC, entityScopePair,  representation, trigger);
    }

    public static OperatorConnector createOperatorConnector(
            final DMC inputDMC,
            final DMC outputDMC,
            final Operator operator,
            final Trigger trigger)
    {
        return new OperatorConnector(inputDMC, outputDMC, operator, trigger);
    }
}