/*
 * 
 */

package models.lifeform.animal;

import models.lifeform.AnimalModel;

/**
 * The Class PigModel.
 */
public class PigModel extends AnimalModel {

    /**
     * Instantiates a new pig model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public PigModel(final int column, final int line) {

        super(column, line);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType() {

        return "Pig";
    }
}
