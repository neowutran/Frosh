/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

/**
 * The Class StateModel.
 */
public abstract class State implements IState {

    /** The lifeform. */
    private Lifeform lifeform;

    /**
     * Instantiates a new state model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public State(final Lifeform lifeform) {

        this.lifeform = lifeform;
    }

    /**
     * Gets the lifeform.
     * 
     * @return the lifeform
     */
    public Lifeform getLifeform() {

        return this.lifeform;
    }

    /**
     * Sets the lifeform.
     * 
     * @param lifeform
     *            the new lifeform
     */
    public void setLifeform(final Lifeform lifeform) {

        this.lifeform = lifeform;
    }

}
