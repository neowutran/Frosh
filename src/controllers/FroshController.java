/*
 * @author Martini Didier
 */

package controllers;

import com.google.gson.internal.LinkedTreeMap;
import config.Config;
import models.Grid;
import views.View;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * The Class FroshController.
 */
public class FroshController {

    /**
     * The grid model.
     */
    private final Grid gridModel;

    /**
     * The grid.
     */
    private final View grid;

    /**
     * The Constant LOGGER.
     */
    public static final Logger LOGGER = Logger.getLogger("Frosh");

    /**
     * Instantiates a new frosh controller.
     */
    public FroshController() {

        this.loggingConfig();
        this.gridModel = new Grid();
        this.grid = new View();

    }

    /**
     * Next day of the game.
     */
    public void nextDay() {

        Grid.nextDay();
        this.grid.show();
    }

    /**
     * Run the game.
     */
    public void run() {

        this.grid.show();
        while (!this.gridModel.hasEnded()) {
            try {
                Thread.sleep(((Double) ((LinkedTreeMap<?, ?>) Config
                        .getConfiguration().get("controller"))
                        .get("msBeforeNextDay")).intValue());
            } catch (final InterruptedException e) {
                FroshController.LOGGER.severe(java.util.Arrays.toString(e.getStackTrace()));
            }
            this.nextDay();

        }
    }

    /**
     * Logging config.
     */
    private void loggingConfig() {

        FroshController.LOGGER.setLevel(Level.INFO);
        final XMLFormatter xmlFormatter = new XMLFormatter();
        FileHandler logFile = null;
        try {
            logFile = new FileHandler("log.xml");
        } catch (SecurityException | IOException e) {

            FroshController.LOGGER.severe(java.util.Arrays.toString(e.getStackTrace()));
        }

        if (logFile != null) {
            logFile.setFormatter(xmlFormatter);
        }
        FroshController.LOGGER.addHandler(logFile);

    }
}
