/*
 *
 */

package models.lifeform;

import models.Lifeform;

/**
 * The Class AnimalModel.
 */
public abstract class Animal extends Lifeform {

    /**
     * Instantiates a new animal model.
     *
     * @param column the column
     * @param line   the line
     */
    public Animal(final int column, final int line) {

        super(column, line);
    }
}
