/*
 * 
 */

package models.states;

import models.GridModel;
import models.LifeformModel;

// TODO: Auto-generated Javadoc
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
    public DeadModel( final LifeformModel lifeform ) {
        super( lifeform );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {
        this.getLifeform( ).getDisease( ).setNextState( null );
        this.getLifeform( ).getDisease( ).setDayBeforeNextState( null );
        final LifeformModel[ ][ ] grid = GridModel.getGrid( );
        grid[ this.getLifeform( ).getColumn( ) ][ this.getLifeform( ).getLine( ) ] = null;
        this.setLifeform( null );
    }
}
