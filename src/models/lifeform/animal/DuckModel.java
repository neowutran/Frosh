/*
 * 
 */

package models.lifeform.animal;

import models.lifeform.AnimalModel;

/**
 * The Class DuckModel.
 */
public class DuckModel extends AnimalModel {

    /**
     * Instantiates a new duck model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public DuckModel(final int column, final int line) {

        super(column, line);
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
