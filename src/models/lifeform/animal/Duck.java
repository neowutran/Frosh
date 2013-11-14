/*
 *
 */

package models.lifeform.animal;

// TODO: Auto-generated Javadoc
/**
 * The Class Duck.
 */
public class Duck extends Bird {

    /**
     * Instantiates a new duck.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @param sick
     *            the sick
     */
    public Duck( final int column, final int line, final boolean sick ) {

        super( column, line, sick );

    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType( ) {

        return "Duck";
    }
}
