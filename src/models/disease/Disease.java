/*
 * @author Martini Didier
 */

package models.disease;

import java.lang.reflect.InvocationTargetException;

import lib.Rand;
import models.Lifeform;
import models.states.Dead;
import models.states.Sick;
import models.states.State;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class Disease.
 */
public abstract class Disease implements IDiseaseType, Cloneable {

    /** The infection rate. */
    private LinkedTreeMap<?, ?> infectionRate;

    /** The carrier. */
    private Lifeform            carrier = null;

    /**
     * Gets the carrier.
     * 
     * @return the carrier
     */
    public Lifeform getCarrier( ) {
        return this.carrier;
    }

    /**
     * Sets the carrier.
     * 
     * @param carrier
     *            the new carrier
     */
    public void setCarrier( Lifeform carrier ) {
        this.carrier = carrier;
        this.nextState.setLifeform( carrier );
    }

    /** The incubation time. */
    private int     incubationTime;

    /** The mortality. */
    private int     mortality;

    /** The recovery time. */
    private int     recoveryTime;

    /** The contagious time. */
    private int     contagiousTime;

    /** The next state. */
    private State   nextState          = null;

    /** The day before next state. */
    private Integer dayBeforeNextState = null;

    /**
     * Instantiates a new disease.
     * 
     * @param carrier
     *            the carrier
     */
    public Disease( final Lifeform carrier ) {

        this.carrier = carrier;
        final LinkedTreeMap<?, ?> config = ( LinkedTreeMap<?, ?> ) Config
                .getConfiguration( ).get( "disease" );
        this.incubationTime = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) config
                .get( this.getDiseaseType( ) ) ).get( this.carrier
                .getLifeformType( ) ) ).get( "incubationTime" ) ).intValue( );
        this.mortality = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) config
                .get( this.getDiseaseType( ) ) ).get( this.carrier
                .getLifeformType( ) ) ).get( "mortality" ) ).intValue( );
        this.infectionRate = ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) config
                .get( this.getDiseaseType( ) ) ).get( this.carrier
                .getLifeformType( ) ) ).get( "infectionRate" );
        this.recoveryTime = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) config
                .get( this.getDiseaseType( ) ) ).get( this.carrier
                .getLifeformType( ) ) ).get( "recoveryTime" ) ).intValue( );
        this.contagiousTime = ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) config
                .get( this.getDiseaseType( ) ) ).get( this.carrier
                .getLifeformType( ) ) ).get( "contagiousTime" ) ).intValue( );
        this.dayBeforeNextState = 0;
        this.nextState = new Sick( this.carrier );
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
    protected <T extends Disease> Object clone( Class subclass )
            throws CloneNotSupportedException {
        T disease = null;
        try {

            disease = ( T ) subclass.getConstructor( Lifeform.class )
                    .newInstance( this.carrier );

            disease.setDayBeforeNextState( this.dayBeforeNextState );
            disease.setNextState( ( State ) this.nextState.clone( ) );

        } catch( InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }

        return disease;
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

        final Disease disease = ( Disease ) o;

        return ( this.contagiousTime == disease.contagiousTime )
                && ( this.incubationTime == disease.incubationTime )
                && ( this.mortality == disease.mortality )
                && ( this.recoveryTime == disease.recoveryTime )
                && this.carrier.equals( disease.carrier )
                && this.dayBeforeNextState.equals( disease.dayBeforeNextState )
                && this.infectionRate.equals( disease.infectionRate )
                && this.nextState.equals( disease.nextState );

    }

    /**
     * Gets the contagious time.
     * 
     * @return the contagious time
     */
    public int getContagiousTime( ) {

        return this.contagiousTime;
    }

    /**
     * Gets the day before next state.
     * 
     * @return the day before next state
     */
    public Integer getDayBeforeNextState( ) {

        return this.dayBeforeNextState;
    }

    /**
     * Gets the incubation time.
     * 
     * @return the incubation time
     */
    public int getIncubationTime( ) {

        return this.incubationTime;
    }

    /**
     * Gets the infection rate.
     * 
     * @return the infection rate
     */
    public LinkedTreeMap<?, ?> getInfectionRate( ) {

        return this.infectionRate;
    }

    /**
     * Gets the mortality.
     * 
     * @return the mortality
     */
    public int getMortality( ) {

        return this.mortality;
    }

    /**
     * Gets the next state.
     * 
     * @return the next state
     */
    public State getNextState( ) {

        return this.nextState;
    }

    /**
     * Gets the recovery time.
     * 
     * @return the recovery time
     */
    public int getRecoveryTime( ) {

        return this.recoveryTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int result = this.infectionRate.hashCode( );
        result = ( 31 * result ) + this.carrier.hashCode( );
        result = ( 31 * result ) + this.incubationTime;
        result = ( 31 * result ) + this.mortality;
        result = ( 31 * result ) + this.recoveryTime;
        result = ( 31 * result ) + this.contagiousTime;
        result = ( 31 * result ) + this.nextState.hashCode( );
        result = ( 31 * result ) + this.dayBeforeNextState.hashCode( );
        return result;
    }

    /**
     * Next day.
     */
    public void nextDay( ) {

        if( this.carrier.getStates( ).getStateName( ).equals( "Dead" )
                || ( this.nextState == null ) ) {
            return;
        }
        if( this.dayBeforeNextState == 0 ) {
            if( this.carrier.getStates( ).getStateName( ).equals( "Sick" )
                    || this.carrier.getStates( ).getStateName( )
                            .equals( "Contagious" ) ) {
                final int result = Rand.randInt( 0, 100 );
                if( result <= this.mortality ) {
                    this.carrier.setStates( new Dead( this.carrier ) );
                    this.carrier.getStates( ).apply( );
                    return;
                }
            }
            this.carrier.setStates( this.nextState );
            this.carrier.getStates( ).apply( );
            return;
        }
        this.dayBeforeNextState--;
    }

    /**
     * Sets the contagious time.
     * 
     * @param contagiousTime
     *            the new contagious time
     */
    public void setContagiousTime( final int contagiousTime ) {

        this.contagiousTime = contagiousTime;
    }

    /**
     * Sets the day before next state.
     * 
     * @param dayBeforeNextState
     *            the new day before next state
     */
    public void setDayBeforeNextState( final Integer dayBeforeNextState ) {

        this.dayBeforeNextState = dayBeforeNextState;
    }

    /**
     * Sets the incubation time.
     * 
     * @param incubationTime
     *            the new incubation time
     */
    public void setIncubationTime( final int incubationTime ) {

        this.incubationTime = incubationTime;
    }

    /**
     * Sets the infection rate.
     * 
     * @param infectionRate
     *            the infection rate
     */
    public void setInfectionRate( final LinkedTreeMap<?, ?> infectionRate ) {

        this.infectionRate = infectionRate;
    }

    /**
     * Sets the mortality.
     * 
     * @param mortality
     *            the new mortality
     */
    public void setMortality( final int mortality ) {

        this.mortality = mortality;
    }

    /**
     * Sets the next state.
     * 
     * @param nextState
     *            the new next state
     */
    public void setNextState( final State nextState ) {

        this.nextState = nextState;
    }

    /**
     * Sets the recovery time.
     * 
     * @param recoveryTime
     *            the new recovery time
     */
    public void setRecoveryTime( final int recoveryTime ) {

        this.recoveryTime = recoveryTime;
    }
}
