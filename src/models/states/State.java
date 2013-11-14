/*
 * @author Martini Didier
 */

package models.states;

import java.lang.reflect.InvocationTargetException;

import models.Lifeform;
import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
public abstract class State implements IState, Cloneable {

    /** The lifeform. */
    private Lifeform lifeform;

    /**
     * Instantiates a new state.
     * 
     * @param lifeform
     *            the lifeform
     */
    public State( final Lifeform lifeform ) {

        this.lifeform = lifeform;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {
        throw new CloneNotSupportedException( "A clone method is missing" );
    }

    /**
     * Clone.
     * 
     * @param <T>
     *            the generic type
     * @param subclass
     *            the subclass
     * @return the object
     * @throws CloneNotSupportedException
     *             the clone not supported exception
     */
    protected <T extends State> Object clone( Class subclass )
            throws CloneNotSupportedException {

        T state = null;
        try {

            state = ( T ) subclass.getConstructor( Lifeform.class )
                    .newInstance( this.lifeform );

        } catch( InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }
        return state;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( final Object o ) {

        if( this == o ) {
            return true;
        }
        if( ( o == null ) || ( this.getClass( ) != o.getClass( ) ) ) {
            return false;
        }

        return true;

    }

    /**
     * Gets the lifeform.
     * 
     * @return the lifeform
     */
    public Lifeform getLifeform( ) {

        return this.lifeform;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        return this.lifeform.hashCode( );
    }

    /**
     * Sets the lifeform.
     * 
     * @param lifeform
     *            the new lifeform
     */
    public void setLifeform( final Lifeform lifeform ) {

        this.lifeform = lifeform;
    }
}
