package org.istmusic.mdd.operators;

import org.istmusic.mdd.dmcs.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

/**
 * Computes the difference between two images (inserted in a 2-slot queue DMC of
 * {@link BufferedImage}s) as a percentage (output in a single-element DMC as a
 * {@link Double}).
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class ImageComparingOperator extends AbstractOperator
{
    public static final String ID = "ImageComparingOperator";
    public static final String description = "This operator is used to" +
            " compare two images that are provided as input and return their" +
            " difference when they exceed a threshold";

    public static final long TIME_TO_LIVE = 60L * 1000L; // 1 min

    private double lowerThreshold = 0.2d;

    /**
     *
     * @param lowerThreshold if the image difference is above this threshold,
     * then output the result.
     */
    public ImageComparingOperator(final double lowerThreshold)
    {
        super(ID, description);

        this.lowerThreshold = lowerThreshold;
    }

    public ImageComparingOperator()
    {
        super(ID, description);

    }
    
    public void setLowerThreshold(final double lowerThreshold){
    	
    	this.lowerThreshold = lowerThreshold;
    	
    }
    
    
    public void compute(final DMC [] inputDMCs, final DMC outputDMC)
    {
        if(inputDMCs == null || inputDMCs.length != 1)
        {
            throw new IllegalArgumentException("The input DMCs array must contain exactly one input DMC");
        }

        final DMC inputDMC = inputDMCs[0];

        if(inputDMC == null || outputDMC == null)
        {
            throw new IllegalArgumentException("The input and output DMC must be non-null");
        }

        if(inputDMC.getType() != DMC.TYPE_QUEUE)
        {
            throw new IllegalArgumentException("The input DMC must be of type " + DMC_Queue.class);
        }

        if(outputDMC.getType() != DMC.TYPE_SINGLE_ELEMENT)
        {
            throw new IllegalArgumentException("The output DMC must be of type " + DMC_SingleElement.class);
        }

        // invoke only when the input DMC is full
        if(inputDMC.isFull()) {
            final BufferedImage bufferedImage0 = (BufferedImage) inputDMC.get(0).getValue();
            final BufferedImage bufferedImage1 = (BufferedImage) inputDMC.get(1).getValue();

            final double result = compareImages(bufferedImage0, bufferedImage1);

            if(result > this.lowerThreshold)
            {
                try
                {
                    outputDMC.clear();
                    outputDMC.insert(DMCFactory.createDMC_Element(new Double(result), TIME_TO_LIVE));
                }
                catch (DMCFullException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static final double PIXEL_RANGE = 255d;

    public static double compareImages(final BufferedImage bufferedImage0, final BufferedImage bufferedImage1)
    {
        if(bufferedImage0 == null || bufferedImage1 == null)
        {
            throw new NullPointerException("Illegal null argument(s)");
        }

        final int width1 = bufferedImage0.getWidth();
        final int height1 = bufferedImage0.getHeight();
        final Raster raster1 = bufferedImage0.getData();
        final int numOfBands1 = raster1.getNumBands();

        final int width2 = bufferedImage1.getWidth();
        final int height2 = bufferedImage1.getHeight();
        final Raster raster2 = bufferedImage1.getData();
        final int numOfBands2 = raster2.getNumBands();

        if(width1 != width2 || height1 != height2 || numOfBands1 != numOfBands2)
        {
            throw new IllegalArgumentException("The dimensions of the" +
                    " arguments and their number of bands must be equal");
        }

        final double [] differenceByBand = new double[numOfBands1];
        for(int band = 0; band < numOfBands1; band++)
        {
            differenceByBand[band] = compareRasters(raster1, raster2, band);
        }

        final double maxDifference = width1 * height1 * PIXEL_RANGE;

        double overallDifference = 0;

        for(int band = 0; band < numOfBands1; band++)
        {
            final double percentageOfDifferenceByBand = differenceByBand[band] / maxDifference;
            overallDifference += percentageOfDifferenceByBand;
        }
        overallDifference /= numOfBands1;
System.out.println("overallDifference: " + overallDifference); // todo delete
        return overallDifference;
    }

    static public BufferedImage load(final String filename) {
        try {
            final File file = new File(filename);
System.out.println(file + " exists? " + file.exists()); // todo delete
            return ImageIO.read(file);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static double compareRasters(final Raster raster1, final Raster raster2, final int band)
    {
        final int width1 = raster1.getWidth();
        final int height1 = raster1.getHeight();
        final int width2 = raster2.getWidth();
        final int height2 = raster2.getHeight();

        if(width1 != width2 || height1 != height2)
        {
            throw new IllegalArgumentException("The provided rasters are not of equal dimensions");
        }

        double countingDifference = 0;

        for(int row = 0; row < height1; row++)
        {
            for(int col = 0; col < width1; col++)
            {
                final double pixel1 = raster1.getSampleDouble(col, row, band);
                final double pixel2 = raster2.getSampleDouble(col, row, band);

                final double difference = Math.abs(pixel1 - pixel2);

                countingDifference += difference;
            }
        }

        return countingDifference;
    }
}