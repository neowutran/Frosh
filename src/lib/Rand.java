/*
 * 
 */

package lib;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Rand.
 */
public class Rand {

    /**
     * Rand int.
     * 
     * @param min
     *            the min
     * @param max
     *            the max
     * @return the int
     */
    public static int randInt( final int min, final int max ) {
        // Usually this can be a field rather than a method variable
        final Random rand = new Random( );
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt( ( max - min ) + 1 ) + min;
    }
}
