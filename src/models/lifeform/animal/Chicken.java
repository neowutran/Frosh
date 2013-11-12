/*
 * 
 */

package models.lifeform.animal;


/**
 * The Class ChickenModel.
 */
public class Chicken extends Bird {

    /**
     * Instantiates a new chicken model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Chicken(final int column, final int line) {

        super(column, line);
    }

    public Chicken(final int column, final int line, final boolean sick) {

        super(column, line, sick);

    }

    /*
     * 
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */

    @Override
    public String getLifeformType() {

        return "Chicken";
    }
}
