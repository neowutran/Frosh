/*
 * @author Martini Didier
 */

package models.states;

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
     * @see models.states.State#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( Recovering.class );

    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {

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
