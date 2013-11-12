/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

/**
 * The Class ContagiousModel.
 */
public class Contagious extends State {

    /**
     * Instantiates a new contagious model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Contagious(final Lifeform lifeform) {

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
                .setNextState(new Recovering(this.getLifeform()));
        this.getLifeform()
                .getDisease()
                .setDayBeforeNextState(
                        this.getLifeform().getDisease().getContagiousTime());
    }

    /**
     * Gets the state name.
     * 
     * @return the state name
     */
    @Override
    public String getStateName() {

        return "Contagious";
    }
}
