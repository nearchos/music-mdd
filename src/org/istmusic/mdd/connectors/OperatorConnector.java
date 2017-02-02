package org.istmusic.mdd.connectors;

import org.istmusic.mdd.triggers.Trigger;
import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.operators.Operator;

/**
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class OperatorConnector implements Connector
{
    private final DMC inputDMC;
    private final DMC outputDMC;
    private final Operator operator;
    private final Trigger trigger;

    OperatorConnector(final DMC inputDMC,
                      final DMC outputDMC,
                      final Operator operator,
                      final Trigger trigger)
    {
        super();

        this.inputDMC = inputDMC;
        this.outputDMC = outputDMC;
        this.operator = operator;
        this.trigger = trigger;
    }

    public DMC getInputDMC()
    {
        return inputDMC;
    }

    public DMC getOutputDMC()
    {
        return outputDMC;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public Trigger getTrigger()
    {
        return trigger;
    }
}