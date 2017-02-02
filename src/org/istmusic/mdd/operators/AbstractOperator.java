package org.istmusic.mdd.operators;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
abstract public class AbstractOperator implements Operator
{
    private final String ID;
    private final String description;

    AbstractOperator(
            final String ID,
            final String description)
    {
        this.ID = ID;
        this.description = description;
    }

    public String getID()
    {
        return ID;
    }

    public String getDescription()
    {
        return description;
    }
}