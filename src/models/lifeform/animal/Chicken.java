/**
 * @author Martini Didier
 */

package models.lifeform.animal;

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
     */
    public Chicken( final Integer column, final Integer line ) {

        this( column, line, false );
    }

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
    public Chicken( final Integer column, final Integer line, final boolean sick ) {

        super( column, line, sick );

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
