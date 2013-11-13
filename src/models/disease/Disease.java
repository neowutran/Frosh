/*
 * @author Martini Didier
 */

package models.disease;

import com.google.gson.internal.LinkedTreeMap;
import config.Config;
import lib.Rand;
import models.Lifeform;
import models.states.Dead;
import models.states.Sick;
import models.states.State;

/**
 * The Class DiseaseModel.
 */
public abstract class Disease implements IDiseaseType {

    /**
     * The infection rate.
     */
    private LinkedTreeMap<?, ?> infectionRate;
    /**
     * The carrier.
     */
    private Lifeform carrier = null;
    /**
     * The incubation time.
     */
    private int incubationTime;
    /**
     * The mortality.
     */
    private int mortality;
    /**
     * The recovery time.
     */
    private int recoveryTime;
    /**
     * The contagious time.
     */
    private int contagiousTime;
    /**
     * The next state.
     */
    private State nextState = null;
    /**
     * The day before next state.
     */
    private Integer dayBeforeNextState = null;

    /**
     * Instantiates a new disease model.
     *
     * @param carrier the carrier
     */
    public Disease(final Lifeform carrier) {

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
        this.nextState = new Sick(this.carrier);
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
     * Sets the contagious time.
     *
     * @param contagiousTime the new contagious time
     */
    public void setContagiousTime(final int contagiousTime) {

        this.contagiousTime = contagiousTime;
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
     * Sets the day before next state.
     *
     * @param dayBeforeNextState the new day before next state
     */
    public void setDayBeforeNextState(final Integer dayBeforeNextState) {

        this.dayBeforeNextState = dayBeforeNextState;
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
     * Sets the incubation time.
     *
     * @param incubationTime the new incubation time
     */
    public void setIncubationTime(final int incubationTime) {

        this.incubationTime = incubationTime;
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
     * Sets the infection rate.
     *
     * @param infectionRate the infection rate
     */
    public void setInfectionRate(final LinkedTreeMap<?, ?> infectionRate) {

        this.infectionRate = infectionRate;
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
     * Sets the mortality.
     *
     * @param mortality the new mortality
     */
    public void setMortality(final int mortality) {

        this.mortality = mortality;
    }

    /**
     * Gets the next state.
     *
     * @return the next state
     */
    public State getNextState() {

        return this.nextState;
    }

    /**
     * Sets the next state.
     *
     * @param nextState the new next state
     */
    public void setNextState(final State nextState) {

        this.nextState = nextState;
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
     * Sets the recovery time.
     *
     * @param recoveryTime the new recovery time
     */
    public void setRecoveryTime(final int recoveryTime) {

        this.recoveryTime = recoveryTime;
    }

    /**
     * Next day.
     */
    public void nextDay() {

        if ((this.carrier.getStates().getStateName().equals("Dead"))
                || (this.nextState == null)) {
            return;
        }
        if (this.dayBeforeNextState == 0) {
            if ((this.carrier.getStates().getStateName().equals("Sick"))
                    || (this.carrier.getStates().getStateName()
                    .equals("Contagious"))) {
                final int result = Rand.randInt(0, 100);
                if (result <= this.mortality) {
                    this.carrier.setStates(new Dead(this.carrier));
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

    @Override
    public int hashCode() {

        int result = infectionRate.hashCode();
        result = 31 * result + carrier.hashCode();
        result = 31 * result + this.incubationTime;
        result = 31 * result + mortality;
        result = 31 * result + recoveryTime;
        result = 31 * result + contagiousTime;
        result = 31 * result + nextState.hashCode();
        result = 31 * result + dayBeforeNextState.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        return contagiousTime == disease.contagiousTime && incubationTime == disease.incubationTime && mortality == disease.mortality && recoveryTime == disease.recoveryTime && carrier.equals(disease.carrier) && dayBeforeNextState.equals(disease.dayBeforeNextState) && infectionRate.equals(disease.infectionRate) && nextState.equals(disease.nextState);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        //TODO
        return super.clone();
    }
}
