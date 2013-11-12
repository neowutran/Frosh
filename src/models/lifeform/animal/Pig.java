/*
 * 
 */

package models.lifeform.animal;

import models.disease.H1N1;
import models.lifeform.Animal;

/**
 * The Class PigModel.
 */
public class Pig extends Animal {

    /**
     * Instantiates a new pig model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Pig(final int column, final int line) {

        super(column, line);
    }

    public Pig(final int column, final int line, final boolean sick) {

        super(column, line);
        if (sick) {
            this.setDisease(new H1N1(this));
        }
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
