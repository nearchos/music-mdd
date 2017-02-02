package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
abstract public class AbstractDMC implements DMC
{
    private final int size;
    private final int type;
    private final long timeToLive;

    /**
     * @param size the max size of the DMC data structure.
     * @param type the type of the DMC
     * @param timeToLive the time before an element is invalidated in
     * milliseconds (special value -1 means it never expires)
     */
    AbstractDMC(final int size, final int type, final long timeToLive)
    {
        this.size = size;
        this.type = type;
        this.timeToLive = timeToLive;
    }

    public int getSize()
    {
        return size;
    }

    public int getType()
    {
        return type;
    }

    public long getTimeToLive()
    {
        return timeToLive;
    }
    
    public Object[] getAllValues(){
        
    	//ToDo: To be manually implemented
    	return null;
    	
    }

    
}