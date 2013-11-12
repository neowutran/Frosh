/*
 * @author Martini Didier
 */

package models;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import lib.Rand;
import models.disease.Disease;
import models.states.Healty;
import models.states.State;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.FroshController;

/**
 * The Class LifeformModel.
 */
public abstract class Lifeform implements ILifeformType {

    /** The state. */
    private State         state   = new Healty(this);

    /** The immune. */
    private List<Disease> immune  = new ArrayList<Disease>();

    /** The disease. */
    private Disease       disease = null;

    /** The column. */
    private int                column;

    /** The line. */
    private int                line;

    /**
     * Instantiates a new lifeform model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Lifeform(final int column, final int line) {

        this.column = column;
        this.line = line;

    }

    /**
     * Gets the column.
     * 
     * @return the column
     */
    public int getColumn() {

        return this.column;
    }

    /**
     * Gets the disease.
     * 
     * @return the disease
     */
    public Disease getDisease() {

        return this.disease;
    }

    /**
     * Gets the immune.
     * 
     * @return the immune
     */
    public List<Disease> getImmune() {

        return this.immune;
    }

    /**
     * Gets the line.
     * 
     * @return the line
     */
    public int getLine() {

        return this.line;
    }

    /**
     * Gets the states.
     * 
     * @return the states
     */
    public State getStates() {

        return this.state;
    }

    /**
     * Checks if is immune.
     * 
     * @param disease
     *            the disease
     * @return true, if is immune
     */
    public boolean isImmune(final Disease disease) {

        if (this.immune.isEmpty()) {
            return false;
        }

        boolean isImmune = false;
        for (int i = 0; i < this.immune.size(); i++) {

            if (disease.getClass() == this.immune.get(i).getClass()) {
                isImmune = true;
            }
        }

        return isImmune;
    }

    /**
     * Next day.
     * 
     * @param neighbors
     *            the neighbors
     * @param freeSpace
     *            the free space
     */
    public void nextDay(final List<Lifeform> neighbors,
            final List<Cardinal> freeSpace) {

        if (this.move() && (freeSpace.size() > 0)) {
            final int cardinal = Rand.randInt(0, freeSpace.size() - 1);
            Grid.move(freeSpace.get(cardinal), this.column, this.line);
        }
        if ((this.disease == null)) {
            for (int i = 0; i < neighbors.size(); i++) {

                if (!this.contact(neighbors.get(i))) {
                    return;
                }

                if (!(neighbors.get(i).state.getStateName()
                        .equals("Contagious"))) {
                    return;
                }
                final int infectionRate = ((Double) neighbors.get(i).disease
                        .getInfectionRate().get(this.getLifeformType()))
                        .intValue();
                final int randomInt = Rand.randInt(0, 100);
                if ((randomInt <= infectionRate)
                        && !this.isImmune(neighbors.get(i).disease)) {

                    try {
                        this.disease = neighbors.get(i).disease.getClass()
                                .getConstructor(Lifeform.class)
                                .newInstance(this);
                    } catch (InstantiationException | IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException | NoSuchMethodException
                            | SecurityException e) {
                        FroshController.LOGGER.severe(e.getStackTrace()
                                .toString());
                    }

                    return;
                }
            }
        }

        if (this.disease != null) {
            this.disease.nextDay();
        }
    }

    /**
     * Sets the column.
     * 
     * @param column
     *            the new column
     */
    public void setColumn(final int column) {

        this.column = column;
    }

    /**
     * Sets the disease.
     * 
     * @param disease
     *            the new disease
     */
    public void setDisease(final Disease disease) {

        this.disease = disease;
    }

    /**
     * Sets the immune.
     * 
     * @param immune
     *            the new immune
     */
    public void setImmune(final List<Disease> immune) {

        this.immune = immune;
    }

    /**
     * Sets the line.
     * 
     * @param line
     *            the new line
     */
    public void setLine(final int line) {

        this.line = line;
    }

    /**
     * Sets the states.
     * 
     * @param states
     *            the new states
     */
    public void setStates(final State states) {

        this.state = states;
    }

    /**
     * Will change grid state.
     * 
     * @return true, if successful
     */
    public boolean willChangeGridState() {

        if ((this.disease != null) && (this.disease.getNextState() != null)) {

            return true;

        }

        return false;

    }

    /**
     * Contact.
     * 
     * @param lifeform
     *            the lifeform
     * @return true, if successful
     */
    private boolean contact(final Lifeform lifeform) {

        final int contactRate = ((Double) ((LinkedTreeMap<?, ?>) ((LinkedTreeMap<?, ?>) Config
                .getConfiguration().get("contactRate")).get(this
                .getLifeformType())).get(lifeform.getLifeformType()))
                .intValue();
        final int contact = Rand.randInt(0, 100);
        if (contact <= contactRate) {
            return true;
        }
        return false;

    }

    /**
     * Move.
     * 
     * @return true, if successful
     */
    private boolean move() {

        final int moveRate = ((Double) ((LinkedTreeMap<?, ?>) Config
                .getConfiguration().get("moveRate"))
                .get(this.getLifeformType())).intValue();
        final int move = Rand.randInt(0, 100);
        if (move <= moveRate) {
            return true;
        }
        return false;

    }

}
