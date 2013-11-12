/*
 * @author Martini Didier
 */

package models.states;

import models.Grid;
import models.Lifeform;
import models.Stats;

/**
 * The Class DeadModel.
 */
public class Dead extends State {

    /**
     * Instantiates a new dead model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Dead(final Lifeform lifeform) {

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
        final Lifeform[][] grid = Grid.getGrid();
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
