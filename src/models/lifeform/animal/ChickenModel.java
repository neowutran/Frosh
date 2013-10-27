/*
 * 
 */

package models.lifeform.animal;

import models.lifeform.AnimalModel;

/**
 * The Class ChickenModel.
 */
public class ChickenModel extends AnimalModel {

    /**
     * Instantiates a new chicken model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public ChickenModel(final int column, final int line) {

        super(column, line);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType() {

        return "Chicken";
    }
}
