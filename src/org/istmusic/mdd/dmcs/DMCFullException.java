package org.istmusic.mdd.dmcs;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class DMCFullException extends Exception
{
    public DMCFullException()
    {
        super("DMC is already full");
    }
}