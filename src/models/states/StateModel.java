/*
 * @author Martini Didier
 */

package models.states;

import models.LifeformModel;

/**
 * The Class StateModel.
 */
public abstract class StateModel implements IState {

    /** The lifeform. */
    private LifeformModel lifeform;

    /**
     * Instantiates a new state model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public StateModel(final LifeformModel lifeform) {

        this.lifeform = lifeform;
    }

    /**
     * Gets the lifeform.
     * 
     * @return the lifeform
     */
    public LifeformModel getLifeform() {

        return this.lifeform;
    }

    /**
     * Sets the lifeform.
     * 
     * @param lifeform
     *            the new lifeform
     */
    public void setLifeform(final LifeformModel lifeform) {

        this.lifeform = lifeform;
    }

}
