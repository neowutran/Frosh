/*
 *
 */

package models.lifeform;

import models.Lifeform;

/**
 * The Class HumanModel.
 */
public class Human extends Lifeform {

    /**
     * Instantiates a new human model.
     *
     * @param column the column
     * @param line   the line
     */
    public Human(final int column, final int line) {

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
