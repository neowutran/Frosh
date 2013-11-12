
package models.lifeform.animal;

import models.disease.H5N1;
import models.lifeform.Animal;

public abstract class Bird extends Animal {

    public Bird(final int column, final int line) {

        super(column, line);
    }

    public Bird(final int column, final int line, final boolean sick) {

        super(column, line);
        if (sick) {
            this.setDisease(new H5N1(this));
        }
    }

}
