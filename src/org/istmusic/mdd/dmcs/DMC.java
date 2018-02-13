package org.istmusic.mdd.dmcs;

/**
 * Data Management Container (DMC).
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public interface DMC
{
    public static final int TYPE_SINGLE_ELEMENT = 0x0010;
    public static final int TYPE_QUEUE          = 0x0020;
    public static final int TYPE_STACK          = 0x0030;
    public static final int TYPE_SET            = 0x0040;

    public static final long LIVE_FOREVER = -1L;

    public int getSize();

    public int getType();

    /**
     * Returns an integer indicating the time in milliseconds before an item is
     * removed or invalidated. This value is applied to the contained elements
     * to maintain their freshness.
     *
     * @return an integer corresponding to the time-to-live
     */
    public long getTimeToLive();

    public boolean isEmpty();

    public boolean isFull();

    public void clear();

    /**
     * Different semantics based on the actual type of the DMC.
     *
     * @param element the element which is inserted to the DMC
     * @throws DMCFullException when full
     */
    public void insert(final DMC_Element element)
            throws DMCFullException;

    /**
     * Different semantics based on the actual type of the DMC.
     *
     * @return true if and only if the  underlying DMC is altered (e.g. true
     * when extracting an element from a set, false when the set was empty
     * already adding an existing one).
     * @throws DMCEmptyException when empty
     */
    public DMC_Element extract()
            throws DMCEmptyException;

    /**
     * Different semantics based on the actual type of the DMC. One common
     * semantic is that the retrieved element (if any) is not removed from the
     * data structure. In practice, you can assume that invoking this method
     * does not have any effect on the underlying data.structure.
     *
     * @param index the index corresponding to the location of the item to be
     * retrieved
     * @return the item indicated by the index or <code>null</code> if the
     * indicated location is either empty or its item is expired
     * @throws IndexOutOfBoundsException if the specified index is outside the
     * bounds of the implemented data structure
     */
    public DMC_Element get(final int index)
            throws IndexOutOfBoundsException;
}