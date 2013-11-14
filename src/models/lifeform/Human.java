/*
 *
 */

package models.lifeform;

import models.Lifeform;

// TODO: Auto-generated Javadoc
/**
 * The Class Human.
 */
public class Human extends Lifeform {

    /**
     * Instantiates a new human.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Human( final int column, final int line ) {

        super( column, line );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType( ) {

        return "Human";
    }
}
