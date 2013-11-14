/*
 * @author Martini Didier
 */

package models;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import lib.Rand;
import models.disease.Disease;
import models.states.Healty;
import models.states.State;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class Lifeform.
 */
public abstract class Lifeform implements ILifeformType, Cloneable {

    /** The state. */
    private State         state   = new Healty( this );

    /** The immune. */
    private List<Disease> immune  = new ArrayList<>( );

    /** The disease. */
    private Disease       disease = null;

    /** The column. */
    private Integer       column;

    /** The line. */
    private Integer       line;

    /**
     * Instantiates a new lifeform.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public Lifeform( final Integer column, final Integer line ) {

        this.column = column;
        this.line = line;

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
    protected <T extends Lifeform> Object clone( Class subclass )
            throws CloneNotSupportedException {

        T lifeform = null;
        try {

            Constructor c = subclass.getConstructor( Integer.class,
                    Integer.class );
            lifeform = ( T ) c.newInstance( this.column, this.line );

            lifeform.setImmune( new ArrayList<>( this.getImmune( ) ) );

            if( this.getDisease( ) != null ) {
                lifeform.setDisease( ( Disease ) this.getDisease( ).clone( ) );
            }

            lifeform.setStates( ( State ) this.getStates( ).clone( ) );

        } catch( NoSuchMethodException | InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );

        }

        if( lifeform.getDisease( ) != null ) {
            lifeform.getDisease( ).setCarrier( lifeform );
        }
        lifeform.getStates( ).setLifeform( lifeform );

        return lifeform;
    }

    /**
     * Contact.
     * 
     * @param lifeform
     *            the lifeform
     * @return true, if successful
     */
    private boolean contact( final Lifeform lifeform ) {

        final int contactRate = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) Config
                .getConfiguration( ).get( "contactRate" ) ).get( this
                .getLifeformType( ) ) ).get( lifeform.getLifeformType( ) ) )
                .intValue( );
        final int contact = Rand.randInt( 0, 100 );
        return contact <= contactRate;

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

        final models.Lifeform lifeform = ( models.Lifeform ) o;

        return ( this.column == lifeform.column )
                && ( this.line == lifeform.line )
                && !( this.disease != null ? !this.disease
                        .equals( lifeform.disease ) : lifeform.disease != null )
                && this.immune.equals( lifeform.immune )
                && this.state.equals( lifeform.state );

    }

    /**
     * Gets the column.
     * 
     * @return the column
     */
    public int getColumn( ) {

        return this.column;
    }

    /**
     * Gets the disease.
     * 
     * @return the disease
     */
    public Disease getDisease( ) {

        return this.disease;
    }

    /**
     * Gets the immune.
     * 
     * @return the immune
     */
    public List<Disease> getImmune( ) {

        return this.immune;
    }

    /**
     * Gets the line.
     * 
     * @return the line
     */
    public int getLine( ) {

        return this.line;
    }

    /**
     * Gets the states.
     * 
     * @return the states
     */
    public State getStates( ) {

        return this.state;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int result = this.state.hashCode( );
        result = ( 31 * result ) + this.immune.hashCode( );
        result = ( 31 * result )
                + ( this.disease != null ? this.disease.hashCode( ) : 0 );
        result = ( 31 * result ) + this.column;
        result = ( 31 * result ) + this.line;
        return result;
    }

    /**
     * Checks if is immune.
     * 
     * @param disease
     *            the disease
     * @return true, if is immune
     */
    public boolean isImmune( final Disease disease ) {

        if( this.immune.isEmpty( ) ) {
            return false;
        }

        boolean isImmune = false;
        for( final models.disease.Disease anImmune : this.immune ) {

            if( disease.getClass( ) == anImmune.getClass( ) ) {
                isImmune = true;
            }
        }

        return isImmune;
    }

    /**
     * Move.
     * 
     * @return true, if successful
     */
    private boolean move( ) {

        final int moveRate = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) Config
                .getConfiguration( ).get( "moveRate" ) ).get( this
                .getLifeformType( ) ) ).intValue( );
        final int move = Rand.randInt( 0, 100 );
        return move <= moveRate;

    }

    /**
     * Next day.
     * 
     * @param neighbors
     *            the neighbors
     * @param freeSpace
     *            the free space
     */
    public void nextDay( final List<Lifeform> neighbors,
            final List<Cardinal> freeSpace ) {

        if( this.move( ) && ( freeSpace.size( ) > 0 ) ) {
            final int cardinal = Rand.randInt( 0, freeSpace.size( ) - 1 );
            Grid.move( freeSpace.get( cardinal ), this.column, this.line );
        }
        if( this.disease == null ) {
            for( final models.Lifeform neighbor : neighbors ) {

                if( !this.contact( neighbor ) ) {
                    return;
                }

                if( !neighbor.state.getStateName( ).equals( "Contagious" ) ) {
                    return;
                }
                final int infectionRate = ( ( Double ) neighbor.disease
                        .getInfectionRate( ).get( this.getLifeformType( ) ) )
                        .intValue( );
                final int randomInt = lib.Rand.randInt( 0, 100 );
                if( ( randomInt <= infectionRate )
                        && !this.isImmune( neighbor.disease ) ) {

                    try {
                        this.disease = neighbor.disease.getClass( )
                                .getConstructor( Lifeform.class )
                                .newInstance( this );
                    } catch( InstantiationException | IllegalAccessException
                            | IllegalArgumentException
                            | java.lang.reflect.InvocationTargetException
                            | NoSuchMethodException | SecurityException e ) {
                        controllers.FroshController.LOGGER
                                .severe( java.util.Arrays.toString( e
                                        .getStackTrace( ) ) );
                    }

                    return;
                }
            }
        }

        if( this.disease != null ) {
            this.disease.nextDay( );
        }
    }

    /**
     * Sets the column.
     * 
     * @param column
     *            the new column
     */
    public void setColumn( final int column ) {

        this.column = column;
    }

    /**
     * Sets the disease.
     * 
     * @param disease
     *            the new disease
     */
    public void setDisease( final Disease disease ) {

        this.disease = disease;
    }

    /**
     * Sets the immune.
     * 
     * @param immune
     *            the new immune
     */
    public void setImmune( final List<Disease> immune ) {

        this.immune = immune;
    }

    /**
     * Sets the line.
     * 
     * @param line
     *            the new line
     */
    public void setLine( final int line ) {

        this.line = line;
    }

    /**
     * Sets the states.
     * 
     * @param states
     *            the new states
     */
    public void setStates( final State states ) {

        this.state = states;
    }

    /**
     * Will change grid state.
     * 
     * @return true, if successful
     */
    public boolean willChangeGridState( ) {

        return ( this.disease != null )
                && ( this.disease.getNextState( ) != null );

    }
}
