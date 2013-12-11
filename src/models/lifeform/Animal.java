/**
 * @author Martini Didier
 */

package models.lifeform;

import models.Lifeform;

/**
 * The Class Animal.
 */
public abstract class Animal extends Lifeform {

    /**
     * Instantiates a new animal.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Animal( final Integer column, final Integer line ) {

        super( column, line );
    }
}
