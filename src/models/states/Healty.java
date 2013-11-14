/*
 * @author Martini Didier
 */

package models.states;

import java.util.List;

import models.Lifeform;
import models.disease.Disease;

// TODO: Auto-generated Javadoc
/**
 * The Class Healty.
 */
public class Healty extends State {

    /**
     * Instantiates a new healty.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Healty( final Lifeform lifeform ) {

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
        final List<Disease> immune = this.getLifeform( ).getImmune( );
        immune.add( this.getLifeform( ).getDisease( ) );
        this.getLifeform( ).setImmune( immune );
        this.getLifeform( ).setDisease( null );

    }

    /*
     * (non-Javadoc)
     * 
     * @see models.states.IState#getStateName()
     */
    @Override
    public String getStateName( ) {

        return "Healty";
    }
}
