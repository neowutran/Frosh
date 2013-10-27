/*
 * 
 */

package models.lifeform;

import models.LifeformModel;

/**
 * The Class AnimalModel.
 */
public abstract class AnimalModel extends LifeformModel {

    /**
     * Instantiates a new animal model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public AnimalModel(final int column, final int line) {

        super(column, line);
    }
}
