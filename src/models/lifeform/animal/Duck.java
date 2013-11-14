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
    public Duck( final Integer column, final Integer line, final boolean sick ) {

        super( column, line, sick );

    }

    /**
     * Instantiates a new duck.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Duck( final Integer column, final Integer line ) {
        this( column, line, false );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( Duck.class );

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
