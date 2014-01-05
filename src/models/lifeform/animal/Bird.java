/**
 * @author Martini Didier
 */

package models.lifeform.animal;

import models.disease.H5N1;
import models.lifeform.Animal;

/**
 * The Class Bird.
 */
public abstract class Bird extends Animal {

    /**
     * Instantiates a new bird.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Bird(final Integer column, final Integer line) {

        super(column, line);
    }

    /**
     * Instantiates a new bird.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @param sick
     *            the sick
     */
    public Bird(final Integer column, final Integer line, final boolean sick) {

        super(column, line);
        if (sick) {
            this.setDisease(new H5N1(this));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone(this.getClass());
    }
}
