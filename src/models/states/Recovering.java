/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

import java.util.ArrayList;

/**
 * The Class RecoveringModel.
 */
public class Recovering extends State {

    /**
     * Instantiates a new recovering model.
     *
     * @param lifeform the lifeform
     */
    public Recovering(final Lifeform lifeform) {

        super(lifeform);
    }

    /*
     * (non-Javadoc)
     *
     * @see models.States.IState#apply()
     */
    @Override
    public void apply() {

        final ArrayList<State> states = new ArrayList<>();
        states.add(new Healty(this.getLifeform()));
        this.getLifeform().getDisease()
                .setNextState(new Healty(this.getLifeform()));
        this.getLifeform()
                .getDisease()
                .setDayBeforeNextState(
                        this.getLifeform().getDisease().getRecoveryTime());
    }

    /**
     * Gets the state name.
     *
     * @return the state name
     */
    @Override
    public String getStateName() {

        return "Recovering";
    }
}
