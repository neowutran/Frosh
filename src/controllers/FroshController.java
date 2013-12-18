/**
 * @author Martini Didier
 */

package controllers;

import java.io.IOException;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import models.Grid;
import models.Stats;
import models.TheEnd;
import views.Frame;
import views.GridView;
import views.View;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;

import javax.swing.*;

/**
 * The Class FroshController.
 */
public class FroshController {

    public Grid getGridModel() {
        return gridModel;
    }

    /** The grid model. */
    private  Grid         gridModel = new Grid();

    /** The grid. */
    private  Frame frame = new Frame();
    private Thread theEnd = new TheEnd();

    private int step;

    public Boolean getStop() {
        return stop;
    }

    private Boolean stop = false;


    public Boolean getKill() {
        return kill;
    }

    private Boolean kill = false;



    /** The instance. */
    private static FroshController         instance = null;

    /** The Constant LOGGER. */
    public static final java.util.logging.Logger LOGGER   = java.util.logging.Logger
            .getLogger( "Frosh" );

    /**
     * Gets the single instance of MiniProjectController.
     *
     * @return single instance of MiniProjectController
     */
    public static FroshController getInstance( ) {
        if( FroshController.instance == null ) {
            FroshController.instance = new FroshController( );
        }
        return FroshController.instance;
    }

    /**
     * Instantiates a new mini project controller.
     */
    protected FroshController( ) {
        this.loggingConfig( );
        this.frame.setVisible(true);
       // this.grid = new View( );

    }

    public void rerun(){
        kill = true;
        theEnd = new TheEnd();
        kill = false;
        stop = false;
        Stats.setDead(0);
        //grid = new View();
        step = 0;
        this.gridModel = new Grid( );
        theEnd.start();

    }

    public void exit(){
        stop = false;
        kill = true;
        frame.dispose();

        //TODO rechercher pourquoi il y a une frame invisible qui existe
        java.awt.Frame[] frameAWT = java.awt.Frame.getFrames();
        frameAWT[0].dispose();

    }

    public void pause(){
       stop = true;
    }

    public void resume(){
       stop = false;

    }

    /**
     * Logging config.
     */
    private void loggingConfig( ) {

        FroshController.LOGGER.setLevel( java.util.logging.Level.INFO );
        final java.util.logging.XMLFormatter xmlFormatter = new java.util.logging.XMLFormatter( );
        java.util.logging.FileHandler logFile = null;
        try {
            logFile = new java.util.logging.FileHandler( "log.xml" );
        } catch( SecurityException | java.io.IOException e ) {

            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }

        if( logFile != null ) {
            logFile.setFormatter( xmlFormatter );
        }
        FroshController.LOGGER.addHandler( logFile );

    }

    /**
     * Next day.
     */
    public synchronized void nextDay( ) {

        frame.getGrid().showStatus(step);
        step++;
        Grid.nextDay( );
      //  this.grid.show( );
    }

}
