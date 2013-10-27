/*
 * 
 */

package models.lifeform;

import models.LifeformModel;

/**
 * The Class HumanModel.
 */
public class HumanModel extends LifeformModel {

    /**
     * Instantiates a new human model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public HumanModel(final int column, final int line) {

        super(column, line);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.ILifeformType#getLifeformType()
     */
    @Override
    public String getLifeformType() {

        return "Human";
    }
}
