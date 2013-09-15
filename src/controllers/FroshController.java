/*
 * 
 */

package controllers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import models.GridModel;
import views.Grid;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;

// TODO: Auto-generated Javadoc
/**
 * The Class FroshController.
 */
public class FroshController {

    /** The grid model. */
    private final GridModel    gridModel;

    /** The grid. */
    private final Grid         grid;

    /** The Constant LOGGER. */
    public static final Logger LOGGER = Logger.getLogger( "Frosh" );

    /**
     * Instantiates a new frosh controller.
     */
    public FroshController( ) {

        this.loggingConfig( );
        this.gridModel = new GridModel( );
        this.grid = new Grid( );

    }

    /**
     * Logging config.
     */
    private void loggingConfig( ) {

        FroshController.LOGGER.setLevel( Level.INFO );
        final XMLFormatter xmlFormatter = new XMLFormatter( );
        FileHandler logFile = null;
        try {
            logFile = new FileHandler( "log.xml" );
        } catch( SecurityException | IOException e ) {

            FroshController.LOGGER.severe( e.getStackTrace( ).toString( ) );
        }
        logFile.setFormatter( xmlFormatter );
        FroshController.LOGGER.addHandler( logFile );

    }

    /**
     * Next day.
     */
    public void nextDay( ) {
        GridModel.nextDay( );
        this.grid.show( );
    }

    /**
     * Run.
     */
    public void run( ) {
        this.grid.show( );
        while( !this.gridModel.hasEnded( ) ) {
            try {
                Thread.sleep( ( ( Double ) ( ( LinkedTreeMap<?, ?> ) Config
                        .getConfiguration( ).get( "controller" ) )
                        .get( "msBeforeNextDay" ) ).intValue( ) );
            } catch( final InterruptedException e ) {
                FroshController.LOGGER.severe( e.getStackTrace( ).toString( ) );
            }
            this.nextDay( );

        }
    }
}