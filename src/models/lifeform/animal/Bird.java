
package models.lifeform.animal;

import models.disease.H5N1;
import models.lifeform.Animal;

// TODO: Auto-generated Javadoc
/**
 * The Class Bird.
 */
public abstract class Bird extends Animal {

    /**
     * Instantiates a new bird.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Bird( final int column, final int line ) {

        super( column, line );
    }

    /**
     * Instantiates a new bird.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @param sick
     *            the sick
     */
    public Bird( final int column, final int line, final boolean sick ) {

        super( column, line );
        if( sick ) {
            this.setDisease( new H5N1( this ) );
        }
    }

}
