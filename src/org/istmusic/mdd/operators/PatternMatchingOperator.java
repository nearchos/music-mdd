package org.istmusic.mdd.operators;

import org.istmusic.mdd.dmcs.*;

/**
 * Examines a list of patterns (trainings, passed via a queue DMC of {@link String}s) for similarity to a given string
 * (query).
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class PatternMatchingOperator extends AbstractOperator
{
    public static final String ID = "PatternMatchingOperator";
    public static final String description = "This operator is used to" +
            " compare a list of string patterns (training) with a given pattern (query)" +
            " and identify close matches";

    public static final double LOWEST_SIMILARITY_THRESHOLD = 0.8; // 80%
    public static final long TIME_TO_LIVE = -1; // output DMC TTL

    private String [] trainings;

    /**
     *
     * @param trainings contains the set of strings to match the input against.
     */
    public PatternMatchingOperator(final String [] trainings)
    {
        super(ID, description);

        this.trainings = trainings;
    }

    public PatternMatchingOperator()
    {
        super(ID, description);

    }
    
    public void setTrainings(final String [] trainings){
    	
    	this.trainings = trainings;
    	
    }
    
    public void compute(final DMC [] inputDMCs, final DMC outputDMC) {

        if(inputDMCs == null || inputDMCs.length != 2) {
            throw new IllegalArgumentException("The input DMCs array must contain exactly two input DMCs");
        }

        final DMC indoorPositionInputDMC = inputDMCs[0];
        final DMC userActivityInputDMC = inputDMCs[1];

        if(indoorPositionInputDMC == null || userActivityInputDMC == null || outputDMC == null) {
            throw new IllegalArgumentException("The input and output DMCs must be non-null");
        }

        if(indoorPositionInputDMC.getType() != DMC.TYPE_QUEUE) {
            throw new IllegalArgumentException("The input DMC must be of type " + DMC_Queue.class);
        }

        if(userActivityInputDMC.getType() != DMC.TYPE_SINGLE_ELEMENT) {
            throw new IllegalArgumentException("The input DMC must be of type " + DMC_SingleElement.class);
        }

        if(outputDMC.getType() != DMC.TYPE_SINGLE_ELEMENT) {
            throw new IllegalArgumentException("The output DMC must be of type " + DMC_SingleElement.class);
        }

        // when invoked, it is guaranteed that the input DMC is full
        final int size = indoorPositionInputDMC.getSize();
        final String currentPoi = (String) indoorPositionInputDMC.get(size - 1).getValue(); // last POI
        final StringBuilder pattern = new StringBuilder();
        for(int i = 0; i < size; i++) {
            pattern.append(indoorPositionInputDMC.get(i).getValue());
        }

        final PatternMatch patternMatch = findBestMatch(trainings, pattern.toString());

        if(patternMatch.similarity > LOWEST_SIMILARITY_THRESHOLD) {
            try {
                outputDMC.clear();
                outputDMC.insert(DMCFactory.createDMC_Element(patternMatch.pattern, TIME_TO_LIVE));
            } catch (DMCFullException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private PatternMatch findBestMatch(final String [] trainings, final String queryPattern) {
        // todo
        return null;
    }

    private class PatternMatch {
        private final String pattern;
        private final double similarity; // from 0.0 to 1.0 where 0 is no similarity at all and 1.0 is identical match

        PatternMatch(final String pattern, final double similarity) {
            this.pattern = pattern;
            this.similarity = similarity;
        }

        public String getPattern() {
            return pattern;
        }

        public double getSimilarity() {
            return similarity;
        }
    }
}