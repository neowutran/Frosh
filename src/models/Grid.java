/*
 * @author Martini Didier
 */

package models;

import java.util.ArrayList;
import java.util.List;

import lib.Rand;
import models.lifeform.Human;
import models.lifeform.animal.Chicken;
import models.lifeform.animal.Duck;
import models.lifeform.animal.Pig;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class Grid.
 */
public class Grid {

    /** The grid. */
    private static Lifeform[ ][ ]      grid;

    /** The height. */
    private static int                 height;

    /** The width. */
    private static int                 width;

    /** The chance of human populate. */
    private static int                 chanceOfHumanPopulate;

    /** The change of animal populate. */
    private static int                 changeOfAnimalPopulate;

    /** The chance of infected animal. */
    private static int                 chanceOfInfectedAnimal;

    /** The config. */
    private static LinkedTreeMap<?, ?> config;

    /**
     * Find free space.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpace( final int column,
            final int line ) {

        final List<Cardinal> freeSpace = new ArrayList<>( );

        final int gridUse = ( ( Double ) Grid.config.get( "gridUse" ) )
                .intValue( );

        if( gridUse != 1 ) {
            freeSpace.addAll( Grid.findFreeSpaceNoDiagonal( column, line ) );
        }
        if( gridUse != 2 ) {
            freeSpace.addAll( Grid.findFreeSpaceDiagonal( column, line ) );
        }
        return freeSpace;
    }

    /**
     * Find free space diagonal.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpaceDiagonal( final int column,
            final int line ) {

        final List<Cardinal> freeSpace = new ArrayList<>( );

        if( Grid.grid.length > ( column + 1 ) ) {
            if( ( Grid.grid[ column ].length > ( line + 1 ) )
                    && ( Grid.grid[ column + 1 ][ line + 1 ] == null ) ) {

                freeSpace.add( Cardinal.NORTHEAST );

            }
            if( ( ( line - 1 ) >= 0 )
                    && ( Grid.grid[ column + 1 ][ line - 1 ] == null ) ) {

                freeSpace.add( Cardinal.SOUTHEAST );

            }
        }
        if( ( column - 1 ) >= 0 ) {
            if( ( Grid.grid[ column ].length > ( line + 1 ) )
                    && ( Grid.grid[ column - 1 ][ line + 1 ] == null ) ) {

                freeSpace.add( Cardinal.NORTHWEST );

            }
            if( ( ( line - 1 ) >= 0 )
                    && ( Grid.grid[ column - 1 ][ line - 1 ] == null ) ) {

                freeSpace.add( Cardinal.SOUTHWEST );

            }
        }
        return freeSpace;
    }

    /**
     * Find free space no diagonal.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpaceNoDiagonal( final int column,
            final int line ) {

        final List<Cardinal> freeSpace = new ArrayList<>( );
        if( ( Grid.grid[ column ].length > ( line + 1 ) )
                && ( Grid.grid[ column ][ line + 1 ] == null ) ) {
            freeSpace.add( Cardinal.NORTH );

        }
        if( ( ( line - 1 ) >= 0 ) && ( Grid.grid[ column ][ line - 1 ] == null ) ) {
            freeSpace.add( Cardinal.SOUTH );

        }
        if( ( Grid.grid.length > ( column + 1 ) )
                && ( Grid.grid[ column + 1 ][ line ] == null ) ) {
            freeSpace.add( Cardinal.EAST );

        }
        if( ( ( column - 1 ) >= 0 )
                && ( Grid.grid[ column - 1 ][ line ] == null ) ) {

            freeSpace.add( Cardinal.WEST );

        }
        return freeSpace;
    }

    /**
     * Find neighbor.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Lifeform> findNeighbor( final int column, final int line ) {

        final List<Lifeform> neightbors = new ArrayList<>( );

        final int gridUse = ( ( Double ) Grid.config.get( "gridUse" ) )
                .intValue( );

        if( gridUse != 1 ) {
            neightbors.addAll( Grid.findNeighborNoDiagonal( column, line ) );
        }
        if( gridUse != 2 ) {
            neightbors.addAll( Grid.findNeighborDiagonal( column, line ) );
        }

        return neightbors;
    }

    /**
     * Find neighbor diagonal.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Lifeform> findNeighborDiagonal( final int column,
            final int line ) {

        final List<Lifeform> neightbors = new ArrayList<>( );

        if( Grid.grid.length > ( column + 1 ) ) {
            if( ( Grid.grid[ column ].length > ( line + 1 ) )
                    && ( Grid.grid[ column + 1 ][ line + 1 ] != null ) ) {
                neightbors.add( Grid.grid[ column + 1 ][ line + 1 ] );

            }
            if( ( ( line - 1 ) >= 0 )
                    && ( Grid.grid[ column + 1 ][ line - 1 ] != null ) ) {
                neightbors.add( Grid.grid[ column + 1 ][ line - 1 ] );

            }
        }
        if( ( column - 1 ) >= 0 ) {
            if( ( Grid.grid[ column ].length > ( line + 1 ) )
                    && ( Grid.grid[ column - 1 ][ line + 1 ] != null ) ) {
                neightbors.add( Grid.grid[ column - 1 ][ line + 1 ] );

            }
            if( ( ( line - 1 ) >= 0 )
                    && ( Grid.grid[ column - 1 ][ line - 1 ] != null ) ) {
                neightbors.add( Grid.grid[ column - 1 ][ line - 1 ] );

            }
        }
        return neightbors;

    }

    /**
     * Find neighbor no diagonal.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Lifeform> findNeighborNoDiagonal( final int column,
            final int line ) {

        final List<Lifeform> neightbors = new ArrayList<>( );
        if( ( Grid.grid[ column ].length > ( line + 1 ) )
                && ( Grid.grid[ column ][ line + 1 ] != null ) ) {
            neightbors.add( Grid.grid[ column ][ line + 1 ] );

        }
        if( ( ( line - 1 ) >= 0 ) && ( Grid.grid[ column ][ line - 1 ] != null ) ) {
            neightbors.add( Grid.grid[ column ][ line - 1 ] );

        }
        if( ( Grid.grid.length > ( column + 1 ) )
                && ( Grid.grid[ column + 1 ][ line ] != null ) ) {
            neightbors.add( Grid.grid[ column + 1 ][ line ] );

        }
        if( ( ( column - 1 ) >= 0 )
                && ( Grid.grid[ column - 1 ][ line ] != null ) ) {
            neightbors.add( Grid.grid[ column - 1 ][ line ] );

        }
        return neightbors;
    }

    /**
     * Gets the grid.
     * 
     * @return the grid
     */
    public static Lifeform[ ][ ] getGrid( ) {

        return Grid.grid;
    }

    /**
     * Move.
     * 
     * @param cardinal
     *            the cardinal
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public static void move( final Cardinal cardinal, final int column,
            final int line ) {

        int addColumn = 0;
        int addLine = 0;
        switch( cardinal ) {
        case NORTH:
            addLine++;
            break;
        case EAST:
            addColumn++;
            break;
        case WEST:
            addColumn--;
            break;
        case SOUTH:
            addLine--;
            break;
        case NORTHEAST:
            addLine++;
            addColumn++;
            break;
        case NORTHWEST:
            addLine++;
            addColumn--;
            break;
        case SOUTHEAST:
            addLine--;
            addColumn++;
            break;
        case SOUTHWEST:
            addLine--;
            addColumn--;
            break;
        }
        Grid.grid[ column ][ line ].setColumn( column + addColumn );
        Grid.grid[ column ][ line ].setLine( line + addLine );
        Grid.grid[ column + addColumn ][ line + addLine ] = Grid.grid[ column ][ line ];
        Grid.grid[ column ][ line ] = null;
    }

    /**
     * Next day.
     */
    public static void nextDay( ) {

        for( int i = 0; i < Grid.grid.length; i++ ) {
            for( int j = 0; j < Grid.grid[ i ].length; j++ ) {
                if( Grid.grid[ i ][ j ] != null ) {
                    Grid.grid[ i ][ j ].nextDay( Grid.findNeighbor( i, j ),
                            Grid.findFreeSpace( i, j ) );
                }
            }
        }
    }

    /**
     * Instantiates a new grid.
     */
    public Grid( ) {

        Grid.config = ( LinkedTreeMap<?, ?> ) Config.getConfiguration( ).get(
                "grid" );
        Grid.height = ( ( Double ) Grid.config.get( "height" ) ).intValue( );
        Grid.width = ( ( Double ) Grid.config.get( "width" ) ).intValue( );
        Grid.chanceOfHumanPopulate = ( ( Double ) Grid.config
                .get( "chanceOfHumanPopulate" ) ).intValue( );
        Grid.changeOfAnimalPopulate = ( ( Double ) Grid.config
                .get( "chanceOfAnimalPopulate" ) ).intValue( );
        Grid.chanceOfInfectedAnimal = ( ( Double ) Grid.config
                .get( "chanceOfInfectedAnimal" ) ).intValue( );
        Grid.grid = new Lifeform[ Grid.width ][ Grid.height ];
        try {
            this.checkParams( );
        } catch( final Exception e ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }
        this.populate( );
    }

    /**
     * Check params.
     */
    private void checkParams( ) {

        if( ( Grid.chanceOfHumanPopulate < 0 )
                || ( Grid.changeOfAnimalPopulate < 0 )
                || ( ( Grid.chanceOfHumanPopulate + Grid.changeOfAnimalPopulate ) > Config
                        .getMax( ) ) ) {
            FroshController.LOGGER
                    .severe( "Invalid config file:\n $ changeOfHumanPopulate and changeOfAnimalPopulate must be > 0.\n $ changeOfHumanPopulate + changeOfAnimallPopulate must be <= 100 " );
            throw new IllegalArgumentException(
                    "Invalid config file:\n $ changeOfHumanPopulate and changeOfAnimalPopulate must be > 0.\n $ changeOfHumanPopulate + changeOfAnimallPopulate must be <= 100 " );
        }

    }

    /**
     * Checks for ended.
     * 
     * @return true, if successful
     */
    public boolean hasEnded( ) {

        for( final Lifeform[ ] element : Grid.grid ) {
            for( final Lifeform element2 : element ) {
                if( ( element2 != null ) && element2.willChangeGridState( ) ) {
                    return false;

                }
            }
        }

        return true;

    }

    /**
     * Populate.
     */
    private void populate( ) {

        for( int i = 0; i < Grid.grid.length; i++ ) {
            for( int j = 0; j < Grid.grid[ i ].length; j++ ) {
                final int result = Rand.randInt( 0, 100 );
                Lifeform lifeform = null;
                if( result <= Grid.chanceOfHumanPopulate ) {
                    lifeform = new Human( i, j );
                } else if( result <= ( Grid.chanceOfHumanPopulate + Grid.changeOfAnimalPopulate ) ) {
                    final int animal = Rand.randInt( 0, 2 );
                    final int sick = Rand.randInt( 0, 100 );
                    boolean isSick = false;
                    if( sick <= Grid.chanceOfInfectedAnimal ) {
                        isSick = true;
                    }
                    switch( animal ) {
                    case 0:
                        lifeform = new Chicken( i, j, isSick );
                        break;
                    case 1:
                        lifeform = new Pig( i, j, isSick );
                        break;
                    case 2:
                        lifeform = new Duck( i, j, isSick );
                        break;
                    }

                }
                Grid.grid[ i ][ j ] = lifeform;
            }
        }
    }
}
