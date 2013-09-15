/*
 * 
 */

package models.states;

import models.LifeformModel;

// TODO: Auto-generated Javadoc
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
    public HealtyModel( final LifeformModel lifeform ) {
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
        this.getLifeform( ).setImmune( true );

    }
}
