package org.istmusic.mdd.operators;

import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.triggers.Trigger;

/**
 * Abstracts an operator which is used to take input from some DMCs and
 * generate output to another DMC.
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public interface Operator
{
    public String getID();

    public String getDescription();

    public void compute(final DMC [] inputDMCs, final DMC outputDMC);
}