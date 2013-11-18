/*
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

// TODO: Auto-generated Javadoc

/**
 * The Class Contagious.
 */
public class Contagious extends State {

    /**
     * Instantiates a new contagious.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Contagious( final Lifeform lifeform ) {

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
                .setNextState( new Recovering( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getContagiousTime( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.states.State#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( this.getClass( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.states.IState#getStateName()
     */
    @Override
    public String getStateName( ) {

        return "Contagious";
    }
}
