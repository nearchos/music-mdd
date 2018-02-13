package org.istmusic.mdd.dmcs;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMC_Queue extends AbstractDMC
{
    private final LinkedList linkedList = new LinkedList();

    DMC_Queue(final int size, final long timeToLive)
    {
        super(size, TYPE_QUEUE, timeToLive);
    }

    /**
     * Removes expired elements.
     */
    synchronized private void refresh()
    {
        Iterator iterator = linkedList.iterator();
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
        return linkedList.isEmpty();
    }

    synchronized public boolean isFull()
    {
        refresh();
        return linkedList.size() >= getSize();
    }

    public void clear()
    {
        linkedList.clear();
    }

    synchronized public void insert(DMC_Element element) throws DMCFullException
    {
//        if(isFull())
//        {
//            throw new DMCFullException();
//        }

        refresh();
        linkedList.addFirst(element);
        while (linkedList.size() > getSize()) {
            linkedList.removeLast();
        }
    }

    synchronized public DMC_Element extract() throws DMCEmptyException
    {
        if(isEmpty())
        {
            throw new DMCEmptyException();
        }

        return (DMC_Element) linkedList.removeLast();
    }

    public DMC_Element get(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= getSize())
        {
            throw new IndexOutOfBoundsException();
        }

        DMC_Element element = (DMC_Element) linkedList.get(index);

        return element != null && element.isExpired() ? null : element;
    }

    @Override
    public String toString() {
        return "DMC_Queue: " + linkedList;
    }
}