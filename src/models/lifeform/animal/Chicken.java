/*
 *
 */

package models.lifeform.animal;

/**
 * The Class ChickenModel.
 */
public class Chicken extends Bird {

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
