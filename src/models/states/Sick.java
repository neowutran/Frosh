/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

/**
 * The Class SickModel.
 */
public class Sick extends State {

    /**
     * Instantiates a new sick model.
     *
     * @param lifeform the lifeform
     */
    public Sick(final Lifeform lifeform) {

        super(lifeform);
    }

    /*
     * (non-Javadoc)
     *
     * @see models.States.IState#apply()
     */
    @Override
    public void apply() {

        this.getLifeform().getDisease()
                .setNextState(new Contagious(this.getLifeform()));
        this.getLifeform()
                .getDisease()
                .setDayBeforeNextState(
                        this.getLifeform().getDisease().getIncubationTime());
    }

    /**
     * Gets the state name.
     *
     * @return the state name
     */
    @Override
    public String getStateName() {

        return "Sick";
    }
}
