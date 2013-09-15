/*
 * 
 */

package models.states;

import models.LifeformModel;

// TODO: Auto-generated Javadoc
/**
 * The Class SickModel.
 */
public class SickModel extends StateModel {

    /**
     * Instantiates a new sick model.
     * 
     * @param lifeform
     *            the lifeform
     */
    public SickModel( final LifeformModel lifeform ) {
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
                .setNextState( new ContagiousModel( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getIncubationTime( ) );
    }
}
