/*
 * @author Martini Didier
 */

package models.disease;

import lib.Rand;
import models.LifeformModel;
import models.states.ContagiousModel;
import models.states.DeadModel;
import models.states.SickModel;
import models.states.StateModel;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;

/**
 * The Class DiseaseModel.
 */
public abstract class DiseaseModel implements IDiseaseType {

    /** The infection rate. */
    private LinkedTreeMap<?, ?> infectionRate;

    /** The carrier. */
    private LifeformModel       carrier            = null;

    /** The incubation time. */
    private int                 incubationTime;

    /** The mortality. */
    private int                 mortality;

    /** The recovery time. */
    private int                 recoveryTime;

    /** The contagious time. */
    private int                 contagiousTime;

    /** The next state. */
    private StateModel          nextState          = null;

    /** The day before next state. */
    private Integer             dayBeforeNextState = null;

    /**
     * Instantiates a new disease model.
     * 
     * @param carrier
     *            the carrier
     */
    public DiseaseModel(final LifeformModel carrier) {

        this.carrier = carrier;
        final LinkedTreeMap<?, ?> config = (LinkedTreeMap<?, ?>) Config
                .getConfiguration().get("disease");
        this.incubationTime = ((Double) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) config
                .get(this.getDiseaseType()))
                .get(this.carrier.getLifeformType())).get("incubationTime"))
                .intValue();
        this.mortality = ((Double) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) config
                .get(this.getDiseaseType()))
                .get(this.carrier.getLifeformType())).get("mortality"))
                .intValue();
        this.infectionRate = (LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) config
                .get(this.getDiseaseType()))
                .get(this.carrier.getLifeformType())).get("infectionRate");
        this.recoveryTime = ((Double) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) config
                .get(this.getDiseaseType()))
                .get(this.carrier.getLifeformType())).get("recoveryTime"))
                .intValue();
        this.contagiousTime = ((Double) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) config
                .get(this.getDiseaseType()))
                .get(this.carrier.getLifeformType())).get("contagiousTime"))
                .intValue();
        this.dayBeforeNextState = 0;
        this.nextState = new SickModel(this.carrier);
    }

    /**
     * Gets the contagious time.
     * 
     * @return the contagious time
     */
    public int getContagiousTime() {

        return this.contagiousTime;
    }

    /**
     * Gets the day before next state.
     * 
     * @return the day before next state
     */
    public Integer getDayBeforeNextState() {

        return this.dayBeforeNextState;
    }

    /**
     * Gets the incubation time.
     * 
     * @return the incubation time
     */
    public int getIncubationTime() {

        return this.incubationTime;
    }

    /**
     * Gets the infection rate.
     * 
     * @return the infection rate
     */
    public LinkedTreeMap<?, ?> getInfectionRate() {

        return this.infectionRate;
    }

    /**
     * Gets the mortality.
     * 
     * @return the mortality
     */
    public int getMortality() {

        return this.mortality;
    }

    /**
     * Gets the next state.
     * 
     * @return the next state
     */
    public StateModel getNextState() {

        return this.nextState;
    }

    /**
     * Gets the recovery time.
     * 
     * @return the recovery time
     */
    public int getRecoveryTime() {

        return this.recoveryTime;
    }

    /**
     * Next day.
     */
    public void nextDay() {

        if ((this.carrier.getStates() instanceof DeadModel)
                || (this.nextState == null)) {
            return;
        }
        if (this.dayBeforeNextState == 0) {
            if ((this.carrier.getStates() instanceof SickModel)
                    || (this.carrier.getStates() instanceof ContagiousModel)) {
                final int result = Rand.randInt(0, 100);
                if (result <= this.mortality) {
                    this.carrier.setStates(new DeadModel(this.carrier));
                    this.carrier.getStates().apply();
                    return;
                }
            }
            this.carrier.setStates(this.nextState);
            this.carrier.getStates().apply();
            return;
        }
        this.dayBeforeNextState--;
    }

    /**
     * Sets the contagious time.
     * 
     * @param contagiousTime
     *            the new contagious time
     */
    public void setContagiousTime(final int contagiousTime) {

        this.contagiousTime = contagiousTime;
    }

    /**
     * Sets the day before next state.
     * 
     * @param dayBeforeNextState
     *            the new day before next state
     */
    public void setDayBeforeNextState(final Integer dayBeforeNextState) {

        this.dayBeforeNextState = dayBeforeNextState;
    }

    /**
     * Sets the incubation time.
     * 
     * @param incubationTime
     *            the new incubation time
     */
    public void setIncubationTime(final int incubationTime) {

        this.incubationTime = incubationTime;
    }

    /**
     * Sets the infection rate.
     * 
     * @param infectionRate
     *            the infection rate
     */
    public void setInfectionRate(final LinkedTreeMap<?, ?> infectionRate) {

        this.infectionRate = infectionRate;
    }

    /**
     * Sets the mortality.
     * 
     * @param mortality
     *            the new mortality
     */
    public void setMortality(final int mortality) {

        this.mortality = mortality;
    }

    /**
     * Sets the next state.
     * 
     * @param nextState
     *            the new next state
     */
    public void setNextState(final StateModel nextState) {

        this.nextState = nextState;
    }

    /**
     * Sets the recovery time.
     * 
     * @param recoveryTime
     *            the new recovery time
     */
    public void setRecoveryTime(final int recoveryTime) {

        this.recoveryTime = recoveryTime;
    }
}
