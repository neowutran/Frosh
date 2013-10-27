/*
 * @author Martini Didier
 */

package models.states;

import models.GridModel;
import models.LifeformModel;
import models.Stats;

/**
 * The Class DeadModel.
 */
public class DeadModel extends StateModel {

    /**
     * Instantiates a new dead model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public DeadModel(final LifeformModel lifeform) {

        super(lifeform);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply() {

        Stats.setDead(Stats.getDead() + 1);
        this.getLifeform().getDisease().setNextState(null);
        this.getLifeform().getDisease().setDayBeforeNextState(null);
        final LifeformModel[][] grid = GridModel.getGrid();
        grid[this.getLifeform().getColumn()][this.getLifeform().getLine()] = null;
        this.setLifeform(null);
    }

    /**
     * Gets the state name.
     * 
     * @return the state name
     */
    @Override
    public String getStateName() {

        return "Dead";
    }
}
