/**
 * @author Martini Didier
 */

package models.states;

import models.Lifeform;

/**
 * The Class Sick.
 */
public class Sick extends State {

    /**
     * Instantiates a new sick.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Sick( final Lifeform lifeform ) {

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
                .setNextState( new Contagious( this.getLifeform( ) ) );
        this.getLifeform( )
                .getDisease( )
                .setDayBeforeNextState(
                        this.getLifeform( ).getDisease( ).getIncubationTime( ) );
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

        return "Sick";
    }
}
