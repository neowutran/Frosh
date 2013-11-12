/*
 * 
 */

package models.lifeform.animal;

/**
 * The Class DuckModel.
 */
public class Duck extends Bird {

    /**
     * Instantiates a new duck model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Duck(final int column, final int line) {

        super(column, line);
    }

    public Duck(final int column, final int line, final boolean sick) {

        super(column, line, sick);

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
