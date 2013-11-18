/*
 * @author Martini Didier
 */

package models.states;

import models.Grid;
import models.Lifeform;
import models.Stats;

// TODO: Auto-generated Javadoc

/**
 * The Class Dead.
 */
public class Dead extends State {

    /**
     * Instantiates a new dead.
     * 
     * @param lifeform
     *            the lifeform
     */
    public Dead( final Lifeform lifeform ) {

        super( lifeform );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.States.IState#apply()
     */
    @Override
    public void apply( ) {

        Stats.setDead( Stats.getDead( ) + 1 );
        this.getLifeform( ).getDisease( ).setNextState( null );
        this.getLifeform( ).getDisease( ).setDayBeforeNextState( null );
        final Lifeform[ ][ ] grid = Grid.getGrid( );
        grid[ this.getLifeform( ).getColumn( ) ][ this.getLifeform( ).getLine( ) ] = null;
        this.setLifeform( null );
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

        return "Dead";
    }
}
