/*
 *
 */

package models.lifeform.animal;

// TODO: Auto-generated Javadoc
/**
 * The Class Chicken.
 */
public class Chicken extends Bird {

    /**
     * Instantiates a new chicken.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @param sick
     *            the sick
     */
    public Chicken( final int column, final int line, final boolean sick ) {

        super( column, line, sick );

    }

    /*
     * 
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */

    @Override
    public String getLifeformType( ) {

        return "Chicken";
    }
}
