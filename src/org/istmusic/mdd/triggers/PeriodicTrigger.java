package org.istmusic.mdd.triggers;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class PeriodicTrigger implements Trigger
{
    final long interval;

    public PeriodicTrigger(final long interval)
    {
        this.interval = interval;
    }

    /**
     * @return a long representation of the trigger interval in milliseconds
     */
    public long getInterval()
    {
        return interval;
    }
}