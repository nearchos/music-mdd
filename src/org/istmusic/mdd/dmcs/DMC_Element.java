package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMC_Element
{
    private final Object value;
    private final long timeToLive;
    private final long timestamp;

    DMC_Element(final Object value, final long timeToLive)
    {
        this.value = value;
        this.timeToLive = timeToLive;
        this.timestamp = System.currentTimeMillis();
    }

    public Object getValue()
    {
        return value;
    }

    long getRemainingTimeToLive()
    {
        return timeToLive - (System.currentTimeMillis() - timestamp);
    }

    public boolean isExpired()
    {
        /*
         * Value -1 means never expire. See DMC#LIVE_FOREVER.
         */
        if(timeToLive == -1)
        {
            return false;
        }
        else
        {
            return System.currentTimeMillis() - timeToLive > timestamp;
        }
    }
}