/*
 * 
 */

package models.states;

import java.util.ArrayList;

import models.LifeformModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RecoveringModel.
 */
public class RecoveringModel extends StateModel {

    /**
     * Instantiates a new recovering model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public RecoveringModel( final LifeformModel lifeform ) {
        super( lifeform );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {
        final ArrayList<StateModel> states = new ArrayList<StateModel>( );
        states.add( new HealtyModel( this.getLifeform( ) ) );
        this.getLifeform( ).getDisease( )
                .setNextState( new HealtyModel( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getRecoveryTime( ) );
    }
}
