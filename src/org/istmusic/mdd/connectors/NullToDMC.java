package org.istmusic.mdd.connectors;

import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.triggers.Trigger;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class NullToDMC implements Connector
{
    private final DMC dmc;
    private final Trigger trigger;

    NullToDMC(final DMC dmc, final Trigger trigger)
    {
        super();

        this.dmc = dmc;
        this.trigger = trigger;
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