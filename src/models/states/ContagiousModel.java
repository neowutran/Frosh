/*
 * 
 */

package models.states;

import models.LifeformModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContagiousModel.
 */
public class ContagiousModel extends StateModel {

    /**
     * Instantiates a new contagious model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public ContagiousModel( final LifeformModel lifeform ) {
        super( lifeform );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {

        this.getLifeform( ).getDisease( )
                .setNextState( new RecoveringModel( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getContagiousTime( ) );
    }
}
