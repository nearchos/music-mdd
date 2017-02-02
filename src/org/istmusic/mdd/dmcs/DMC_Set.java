package org.istmusic.mdd.dmcs;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMC_Set extends AbstractDMC
{
    private final Set set = new HashSet();

    DMC_Set(final int size, final long timeToLive)
    {
        super(size, TYPE_SET, timeToLive);
    }

    /**
     * Removes expired elements.
     */
    synchronized private void refresh()
    {
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            DMC_Element element = (DMC_Element) iterator.next();
            if(element.isExpired())
            {
                iterator.remove();
            }
        }
    }

    synchronized public boolean isEmpty()
    {
        refresh();
        return set.isEmpty();
    }

    synchronized public boolean isFull()
    {
        refresh();
        return set.size() >= getSize();
    }

    public void clear()
    {
        set.clear();
    }

    synchronized public void insert(DMC_Element element) throws DMCFullException
    {
        if(isFull())
        {
            throw new DMCFullException();
        }

        set.add(element);
    }

    synchronized public DMC_Element extract() throws DMCEmptyException
    {
        if(isEmpty())
        {
            throw new DMCEmptyException();
        }

        final Iterator iterator = set.iterator();
        final DMC_Element lastElement = (DMC_Element) iterator.next();
        iterator.remove();

        return lastElement;
    }

    public DMC_Element get(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= getSize())
        {
            throw new IndexOutOfBoundsException();
        }

        DMC_Element element = (DMC_Element) set.toArray()[index];

        return element != null && element.isExpired() ? null : element;
    }

    /*
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("DMC_Set: { ");

        final Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            DMC_Element element = (DMC_Element) iterator.next();
            stringBuilder.append(element.getValue()).append("(").append(element.getRemainingTimeToLive()).append(") ");
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public static void main(String[] args)
            throws Exception
    {
        System.out.println("Testing ...");

        DMC_Set dmcSet = new DMC_Set(4, 1000);

        System.out.println("dmcSet: " + dmcSet);

        dmcSet.insert(new DMC_Element("a", 1000L));
        dmcSet.insert(new DMC_Element("b", 2000L));
        dmcSet.insert(new DMC_Element("c", 3000L));
        dmcSet.insert(new DMC_Element("d", 4000L));

        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());

        Thread.sleep(1000);

        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());

        Thread.sleep(1000);

        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());

        Thread.sleep(1000);

        dmcSet.insert(new DMC_Element("e", 500));
        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());

        Thread.sleep(1000);

        dmcSet.insert(new DMC_Element("f", 700));
        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());

        Thread.sleep(1000);

        System.out.println("dmcSet: " + dmcSet + ", isFull: " + dmcSet.isFull());
    }
    */
}