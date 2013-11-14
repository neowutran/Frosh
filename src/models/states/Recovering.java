/*
 * @author Martini Didier
 */

package models.states;

import java.util.ArrayList;

import models.Lifeform;

// TODO: Auto-generated Javadoc
/**
 * The Class Recovering.
 */
public class Recovering extends State {

    /**
     * Instantiates a new recovering.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Recovering( final Lifeform lifeform ) {

        super( lifeform );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {

        final ArrayList<State> states = new ArrayList<>( );
        states.add( new Healty( this.getLifeform( ) ) );
        this.getLifeform( ).getDisease( )
                .setNextState( new Healty( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getRecoveryTime( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.states.IState#getStateName()
     */
    @Override
    public String getStateName( ) {

        return "Recovering";
    }
}
