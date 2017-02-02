package org.istmusic.mdd.connectors;

import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.triggers.Trigger;
import org.istmusic.mdd.operators.Operator;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class SingleDMCToSingleDMCOperator implements Connector
{
    private final DMC fromDmc;
    private final DMC toDmc;
    private final Operator operator;
    private final Trigger trigger;

    SingleDMCToSingleDMCOperator(
            final DMC fromDmc,
            final DMC toDmc,
            final Operator operator,
            final Trigger trigger)
    {
        super();

        this.fromDmc = fromDmc;
        this.toDmc = toDmc;
        this.operator = operator;
        this.trigger = trigger;
    }

    public DMC getFromDmc()
    {
        return fromDmc;
    }

    public DMC getToDmc()
    {
        return toDmc;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public Trigger getTrigger()
    {
        return trigger;
    }
}