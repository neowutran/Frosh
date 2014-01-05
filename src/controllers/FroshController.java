/**
 * @author Martini Didier
 */

package controllers;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;

import models.Grid;
import models.Stats;
import models.TheEnd;
import models.lifeform.Human;
import models.lifeform.animal.Pig;
import views.Frame;
import views.GraphView;

import com.google.gson.Gson;

import config.Config;
import demonstrateur.Frosh;

/**
 * The Class FroshController.
 */
public class FroshController {

    /**
     * Gets the single instance of MiniProjectController.
     * 
     * @return single instance of MiniProjectController
     */
    public static FroshController getInstance() {

        if (FroshController.instance == null) {
            FroshController.instance = new FroshController();
        }
        return FroshController.instance;
    }

    /**
     * The grid model.
     */
    private Grid                                 gridModel = new Grid();
    /**
     * The grid.
     */
    private final Frame                          frame     = new Frame();
    private Thread                               theEnd    = new TheEnd();
    /* Graph view */
    private final GraphView                      graph;
    private int                                  step;
    private Boolean                              stop      = false;
    private Boolean                              kill      = false;
    /**
     * The instance.
     */
    private static FroshController               instance  = null;
    /**
     * The Constant LOGGER.
     */
    public static final java.util.logging.Logger LOGGER    = java.util.logging.Logger
                                                                   .getLogger("Frosh");

    /**
     * Instantiates a new mini project controller.
     */
    protected FroshController() {

        this.loggingConfig();
        this.frame.setVisible(true);
        // this.grid = new View( );
        // Le graphview ne fonctionnant que pour 2 données,
        // on choisit les humains et les cochons
        this.graph = new GraphView(500, 150, 500);
        this.graph.setColor(Human.class, Color.PINK);
        this.graph.setColor(Pig.class, Color.BLUE);
    }

    public void exit() {

        this.stop = false;
        this.kill = true;
        this.frame.dispose();
        final Gson gson = new Gson();
        try {
            // Create file
            final FileWriter fstream = new FileWriter(Frosh.FOLDER
                    + Frosh.CONFIG);
            final BufferedWriter out = new BufferedWriter(fstream);
            out.write(gson.toJson(Config.getConfiguration()));
            // Close the output stream
            out.close();
        } catch (final Exception e) {// Catch exception if any
            FroshController.LOGGER.severe("Error: " + e.getMessage());
        }
        // TODO rechercher pourquoi il y a une frame invisible qui existe
        final java.awt.Frame[] frameAWT = java.awt.Frame.getFrames();
        frameAWT[0].dispose();
    }

    public Grid getGridModel() {

        return this.gridModel;
    }

    public Boolean getKill() {

        return this.kill;
    }

    public Boolean getStop() {

        return this.stop;
    }

    /**
     * Logging config.
     */
    private void loggingConfig() {

        FroshController.LOGGER.setLevel(java.util.logging.Level.INFO);
        final java.util.logging.XMLFormatter xmlFormatter = new java.util.logging.XMLFormatter();
        java.util.logging.FileHandler logFile = null;
        try {
            logFile = new java.util.logging.FileHandler("log.xml");
        } catch (SecurityException | java.io.IOException e) {
            FroshController.LOGGER.severe(java.util.Arrays.toString(e
                    .getStackTrace()));
        }
        if (logFile != null) {
            logFile.setFormatter(xmlFormatter);
        }
        FroshController.LOGGER.addHandler(logFile);
    }

    /**
     * Next day.
     */
    public synchronized void nextDay() {

        // Le graphview ne fonctionnant que pour 2 données,
        // on choisit les humains et les cochons
        final Human human = new Human(0, 0);
        final Pig pig = new Pig(0, 0);
        this.graph.showStatus(this.step, this.gridModel.countPop(human),
                this.gridModel.countPop(pig));
        this.frame.getGrid().showStatus(this.step);
        this.step++;
        Grid.nextDay();
    }

    public void pause() {

        this.stop = true;
    }

    public void rerun() {

        this.kill = true;
        while (this.theEnd.isAlive()) {
            try {
                Thread.sleep(50);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.theEnd = new TheEnd();
        this.kill = false;
        this.stop = false;
        Stats.setDead(0);
        this.step = 0;
        this.gridModel = new Grid();
        this.theEnd.start();
    }

    public void resume() {

        this.stop = false;
    }
}
