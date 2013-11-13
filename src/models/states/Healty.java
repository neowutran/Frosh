/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;
import models.disease.Disease;

import java.util.List;

/**
 * The Class HealtyModel.
 */
public class Healty extends State {

    /**
     * Instantiates a new healty model.
     *
     * @param lifeform the lifeform
     */
    public Healty(final Lifeform lifeform) {

        super(lifeform);
    }

    /*
     * (non-Javadoc)
     *
     * @see models.States.IState#apply()
     */
    @Override
    public void apply() {

        this.getLifeform().getDisease().setNextState(null);
        this.getLifeform().getDisease().setDayBeforeNextState(null);
        final List<Disease> immune = this.getLifeform().getImmune();
        immune.add(this.getLifeform().getDisease());
        this.getLifeform().setImmune(immune);
        this.getLifeform().setDisease(null);

    }

    /**
     * Gets the state name.
     *
     * @return the state name
     */
    @Override
    public String getStateName() {

        return "Healty";
    }
}
