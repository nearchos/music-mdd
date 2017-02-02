package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMCEmptyException extends Exception
{
    public DMCEmptyException()
    {
        super("DMC is already empty");
    }
}