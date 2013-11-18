/**
 * @author Martini Didier
 */

package models.lifeform;

import models.Lifeform;

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
    public Human( final Integer column, final Integer line ) {

        super( column, line );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( this.getClass( ) );

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
