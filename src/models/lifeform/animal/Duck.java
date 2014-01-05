/**
 * @author Martini Didier
 */

package models.lifeform.animal;

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
     */
    public Duck(final Integer column, final Integer line) {

        this(column, line, false);
    }

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
    public Duck(final Integer column, final Integer line, final boolean sick) {

        super(column, line, sick);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone(this.getClass());
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType() {

        return "Duck";
    }
}
