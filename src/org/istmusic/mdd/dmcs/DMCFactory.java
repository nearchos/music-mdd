package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMCFactory
{
    public static DMC_Element createDMC_Element(final Object value, final long timeToLive)
    {
        return new DMC_Element(value, timeToLive);
    }

    public static DMC_SingleElement createDMC_SingleElement(final long timeToLive)
    {
        return new DMC_SingleElement(timeToLive);
    }

    public static DMC_Queue createDMC_Queue(final int size, final long timeToLive)
    {
        return new DMC_Queue(size, timeToLive);
    }

    public static DMC_Stack createDMC_Stack(final int size, final long timeToLive)
    {
        return new DMC_Stack(size, timeToLive);
    }

    public static DMC_Set createDMC_Set(final int size, final long timeToLive)
    {
        return new DMC_Set(size, timeToLive);
    }
}