/*
 * @author Martini Didier
 */

package models.states;

import java.util.List;

import models.LifeformModel;
import models.disease.DiseaseModel;

/**
 * The Class HealtyModel.
 */
public class HealtyModel extends StateModel {

    /**
     * Instantiates a new healty model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public HealtyModel(final LifeformModel lifeform) {

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
        final List<DiseaseModel> immune = this.getLifeform().getImmune();
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
