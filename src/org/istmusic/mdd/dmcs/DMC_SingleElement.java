package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMC_SingleElement extends AbstractDMC
{
    private DMC_Element element = null;

    DMC_SingleElement(final long timeToLive)
    {
        super(1, TYPE_SINGLE_ELEMENT, timeToLive);
    }

    public boolean isEmpty()
    {
        return this.element == null || this.element.isExpired();
    }

    public boolean isFull()
    {
        return !isEmpty();
    }

    public void clear()
    {
        this.element = null;
    }

    public void insert(DMC_Element element) throws DMCFullException
    {
//        if(isFull())
//        {
//            throw new DMCFullException();
//        }
//
        this.element = element;
    }

    public DMC_Element extract() throws DMCEmptyException
    {
        if(isEmpty())
        {
            throw new DMCEmptyException();
        }

        final DMC_Element temp = this.element;
        this.element = null;

        return temp;
    }

    public DMC_Element get(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= 1)
        {
            throw new IndexOutOfBoundsException();
        }

        return element != null && element.isExpired() ? null : element;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + (isEmpty() ? "Empty" : element.getValue().toString());
    }
}