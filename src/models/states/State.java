/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

/**
 * The Class StateModel.
 */
public abstract class State implements IState {

    /**
     * The lifeform.
     */
    private Lifeform lifeform;

    /**
     * Instantiates a new state model.
     *
     * @param lifeform the lifeform
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
     * @param lifeform the new lifeform
     */
    public void setLifeform(final Lifeform lifeform) {

        this.lifeform = lifeform;
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final models.states.State state = (models.states.State) o;

        return lifeform.equals(state.lifeform);

    }

    @Override
    public int hashCode() {

        return lifeform.hashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        //TODO
        return super.clone();
    }
}
