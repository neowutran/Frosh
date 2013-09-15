/**
 * 
 */

package models;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import lib.Rand;
import models.disease.DiseaseModel;
import models.states.ContagiousModel;
import models.states.HealtyModel;
import models.states.StateModel;
import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class LifeformModel.
 */
public abstract class LifeformModel implements ILifeformType {

    /** The state. */
    private StateModel   state   = new HealtyModel( this );

    /** The immune. */
    private boolean      immune  = false;

    /** The disease. */
    private DiseaseModel disease = null;

    /** The column. */
    private int          column;

    /** The line. */
    private int          line;

    /**
     * Instantiates a new lifeform model.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public LifeformModel( final int column, final int line ) {
        this.column = column;
        this.line = line;
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
    public DiseaseModel getDisease( ) {
        return this.disease;
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
    public StateModel getStates( ) {
        return this.state;
    }

    /**
     * Checks if is immune.
     * 
     * @return true, if is immune
     */
    public boolean isImmune( ) {
        return this.immune;
    }

    /**
     * Next day.
     * 
     * @param neighbors
     *            the neighbors
     * @param freeSpace
     *            the free space
     */
    public void nextDay( final List<LifeformModel> neighbors,
            final List<Cardinal> freeSpace ) {
        final int move = Rand.randInt( 0, 100 );
        if( ( move > 50 ) && ( freeSpace.size( ) > 0 ) ) {
            final int cardinal = Rand.randInt( 0, freeSpace.size( ) - 1 );
            GridModel.move( freeSpace.get( cardinal ), this.column, this.line );
        }
        if( ( this.disease == null ) && !this.immune ) {
            for( int i = 0; i < neighbors.size( ); i++ ) {
                if( !( neighbors.get( i ).state instanceof ContagiousModel ) ) {
                    return;
                }
                final int infectionRate = ( ( Double ) neighbors.get( i ).disease
                        .getInfectionRate( ).get( this.getLifeformType( ) ) )
                        .intValue( );
                final int randomInt = Rand.randInt( 0, 100 );
                if( randomInt <= infectionRate ) {

                    try {
                        this.disease = neighbors.get( i ).disease.getClass( )
                                .getConstructor( LifeformModel.class )
                                .newInstance( this );
                    } catch( InstantiationException | IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException | NoSuchMethodException
                            | SecurityException e ) {
                        FroshController.LOGGER.severe( e.getStackTrace( )
                                .toString( ) );
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
    public void setDisease( final DiseaseModel disease ) {
        this.disease = disease;
    }

    /**
     * Sets the immune.
     * 
     * @param immune
     *            the new immune
     */
    public void setImmune( final boolean immune ) {
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
    public void setStates( final StateModel states ) {
        this.state = states;
    }

    /**
     * Will change grid state.
     * 
     * @return true, if successful
     */
    public boolean willChangeGridState( ) {

        if( ( this.disease != null ) && ( this.disease.getNextState( ) != null ) ) {

            return true;

        }

        return false;

    }
}
