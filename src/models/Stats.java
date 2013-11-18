/*
 * @author Martini Didier
 */

package models;

// TODO: Auto-generated Javadoc

/**
 * The Class Stats.
 */
public final class Stats {

    /** The dead. */
    private static int dead = 0;

    /**
     * Gets the dead.
     * 
     * @return the dead
     */
    public static int getDead( ) {

        return Stats.dead;
    }

    /**
     * Sets the dead.
     * 
     * @param dead
     *            the new dead
     */
    public static void setDead( final int dead ) {

        Stats.dead = dead;

    }

    /**
     * Instantiates a new stats.
     */
    private Stats( ) {

    }

}
