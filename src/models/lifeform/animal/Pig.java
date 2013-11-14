/*
 *
 */

package models.lifeform.animal;

import models.disease.H1N1;
import models.lifeform.Animal;

// TODO: Auto-generated Javadoc
/**
 * The Class Pig.
 */
public class Pig extends Animal {

    /**
     * Instantiates a new pig.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @param sick
     *            the sick
     */
    public Pig( final Integer column, final Integer line, final boolean sick ) {

        super( column, line );
        if( sick ) {
            this.setDisease( new H1N1( this ) );
        }
    }

    /**
     * Instantiates a new pig.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Pig( final Integer column, final Integer line ) {
        this( column, line, false );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( Pig.class );

    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType( ) {

        return "Pig";
    }
}
