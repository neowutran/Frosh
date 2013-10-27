/*
 * @author Martini Didier
 */

package models;

import java.util.ArrayList;
import java.util.List;

import lib.Rand;
import models.disease.H1N1Model;
import models.disease.H5N1Model;
import models.lifeform.HumanModel;
import models.lifeform.animal.ChickenModel;
import models.lifeform.animal.DuckModel;
import models.lifeform.animal.PigModel;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.FroshController;

/**
 * The Class GridModel.
 */
public class GridModel {

    /** The grid. */
    private static LifeformModel[][]   grid;

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
     * Gets the grid.
     * 
     * @return the grid
     */
    public static LifeformModel[][] getGrid() {

        return GridModel.grid;
    }

    /**
     * Move a lifeform.
     * 
     * @param cardinal
     *            the cardinal
     * @param column
     *            the column
     * @param line
     *            the line
     */
    public static void move(final Cardinal cardinal, final int column,
            final int line) {

        int addColumn = 0;
        int addLine = 0;
        switch (cardinal) {
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
        GridModel.grid[column][line].setColumn(column + addColumn);
        GridModel.grid[column][line].setLine(line + addLine);
        GridModel.grid[column + addColumn][line + addLine] = GridModel.grid[column][line];
        GridModel.grid[column][line] = null;
    }

    /**
     * Next day of the game.
     */
    public static void nextDay() {

        for (int i = 0; i < GridModel.grid.length; i++) {
            for (int j = 0; j < GridModel.grid[i].length; j++) {
                if (GridModel.grid[i][j] != null) {
                    GridModel.grid[i][j].nextDay(GridModel.findNeighbor(i, j),
                            GridModel.findFreeSpace(i, j));
                }
            }
        }
    }

    /**
     * Find free space in the grid.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpace(final int column, final int line) {

        final List<Cardinal> freeSpace = new ArrayList<Cardinal>();

        final int gridUse = ((Double) GridModel.config.get("gridUse"))
                .intValue();

        if (gridUse != 1) {
            freeSpace.addAll(GridModel.findFreeSpaceNoDiagonal(column, line));
        }
        if (gridUse != 2) {
            freeSpace.addAll(GridModel.findFreeSpaceDiagonal(column, line));
        }
        return freeSpace;
    }

    /**
     * Find free space diagonal in the grid.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpaceDiagonal(final int column,
            final int line) {

        final List<Cardinal> freeSpace = new ArrayList<Cardinal>();

        if (GridModel.grid.length > (column + 1)) {
            if ((GridModel.grid[column].length > (line + 1))
                    && (GridModel.grid[column + 1][line + 1] == null)) {

                freeSpace.add(Cardinal.NORTHEAST);

            }
            if (((line - 1) >= 0)
                    && (GridModel.grid[column + 1][line - 1] == null)) {

                freeSpace.add(Cardinal.SOUTHEAST);

            }
        }
        if ((column - 1) >= 0) {
            if ((GridModel.grid[column].length > (line + 1))
                    && (GridModel.grid[column - 1][line + 1] == null)) {

                freeSpace.add(Cardinal.NORTHWEST);

            }
            if (((line - 1) >= 0)
                    && (GridModel.grid[column - 1][line - 1] == null)) {

                freeSpace.add(Cardinal.SOUTHWEST);

            }
        }
        return freeSpace;
    }

    /**
     * Find free space without diagonal in the grid.
     * 
     * @param column
     *            the column
     * @param line
     *            the line
     * @return the list
     */
    private static List<Cardinal> findFreeSpaceNoDiagonal(final int column,
            final int line) {

        final List<Cardinal> freeSpace = new ArrayList<Cardinal>();
        if ((GridModel.grid[column].length > (line + 1))
                && (GridModel.grid[column][line + 1] == null)) {
            freeSpace.add(Cardinal.NORTH);

        }
        if (((line - 1) >= 0) && (GridModel.grid[column][line - 1] == null)) {
            freeSpace.add(Cardinal.SOUTH);

        }
        if ((GridModel.grid.length > (column + 1))
                && (GridModel.grid[column + 1][line] == null)) {
            freeSpace.add(Cardinal.EAST);

        }
        if (((column - 1) >= 0) && (GridModel.grid[column - 1][line] == null)) {

            freeSpace.add(Cardinal.WEST);

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
    private static List<LifeformModel> findNeighbor(final int column,
            final int line) {

        final List<LifeformModel> neightbors = new ArrayList<LifeformModel>();

        final int gridUse = ((Double) GridModel.config.get("gridUse"))
                .intValue();

        if (gridUse != 1) {
            neightbors.addAll(GridModel.findNeighborNoDiagonal(column, line));
        }
        if (gridUse != 2) {
            neightbors.addAll(GridModel.findNeighborDiagonal(column, line));
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
    private static List<LifeformModel> findNeighborDiagonal(final int column,
            final int line) {

        final List<LifeformModel> neightbors = new ArrayList<LifeformModel>();

        if (GridModel.grid.length > (column + 1)) {
            if ((GridModel.grid[column].length > (line + 1))
                    && (GridModel.grid[column + 1][line + 1] != null)) {
                neightbors.add(GridModel.grid[column + 1][line + 1]);

            }
            if (((line - 1) >= 0)
                    && (GridModel.grid[column + 1][line - 1] != null)) {
                neightbors.add(GridModel.grid[column + 1][line - 1]);

            }
        }
        if ((column - 1) >= 0) {
            if ((GridModel.grid[column].length > (line + 1))
                    && (GridModel.grid[column - 1][line + 1] != null)) {
                neightbors.add(GridModel.grid[column - 1][line + 1]);

            }
            if (((line - 1) >= 0)
                    && (GridModel.grid[column - 1][line - 1] != null)) {
                neightbors.add(GridModel.grid[column - 1][line - 1]);

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
    private static List<LifeformModel> findNeighborNoDiagonal(final int column,
            final int line) {

        final List<LifeformModel> neightbors = new ArrayList<LifeformModel>();
        if ((GridModel.grid[column].length > (line + 1))
                && (GridModel.grid[column][line + 1] != null)) {
            neightbors.add(GridModel.grid[column][line + 1]);

        }
        if (((line - 1) >= 0) && (GridModel.grid[column][line - 1] != null)) {
            neightbors.add(GridModel.grid[column][line - 1]);

        }
        if ((GridModel.grid.length > (column + 1))
                && (GridModel.grid[column + 1][line] != null)) {
            neightbors.add(GridModel.grid[column + 1][line]);

        }
        if (((column - 1) >= 0) && (GridModel.grid[column - 1][line] != null)) {
            neightbors.add(GridModel.grid[column - 1][line]);

        }
        return neightbors;
    }

    /**
     * Instantiates a new grid model.
     */
    public GridModel() {

        GridModel.config = (LinkedTreeMap<?, ?>) Config.getConfiguration().get(
                "grid");
        GridModel.height = ((Double) GridModel.config.get("height")).intValue();
        GridModel.width = ((Double) GridModel.config.get("width")).intValue();
        GridModel.chanceOfHumanPopulate = ((Double) GridModel.config
                .get("chanceOfHumanPopulate")).intValue();
        GridModel.changeOfAnimalPopulate = ((Double) GridModel.config
                .get("chanceOfAnimalPopulate")).intValue();
        GridModel.chanceOfInfectedAnimal = ((Double) GridModel.config
                .get("chanceOfInfectedAnimal")).intValue();
        GridModel.grid = new LifeformModel[GridModel.width][GridModel.height];
        try {
            this.checkParams();
        } catch (final Exception e) {
            FroshController.LOGGER.severe(e.getStackTrace().toString());
        }
        this.populate();
    }

    /**
     * Checks for ended.
     * 
     * @return true, if successful
     */
    public boolean hasEnded() {

        for (final LifeformModel[] element : GridModel.grid) {
            for (final LifeformModel element2 : element) {
                if ((element2 != null) && element2.willChangeGridState()) {
                    return false;

                }
            }
        }

        return true;

    }

    /**
     * Check params.
     * 
     * @throws IllegalArgumentException
     *             the illegal argument exception
     */
    private void checkParams() {

        if ((GridModel.chanceOfHumanPopulate < 0)
                || (GridModel.changeOfAnimalPopulate < 0)
                || ((GridModel.chanceOfHumanPopulate + GridModel.changeOfAnimalPopulate) > Config
                        .getMax())) {
            FroshController.LOGGER
                    .severe("Invalid config file:\n $ changeOfHumanPopulate and changeOfAnimalPopulate must be > 0.\n $ changeOfHumanPopulate + changeOfAnimallPopulate must be <= 100 ");
            throw new IllegalArgumentException(
                    "Invalid config file:\n $ changeOfHumanPopulate and changeOfAnimalPopulate must be > 0.\n $ changeOfHumanPopulate + changeOfAnimallPopulate must be <= 100 ");
        }

    }

    /**
     * Populate the grid.
     */
    private void populate() {

        for (int i = 0; i < GridModel.grid.length; i++) {
            for (int j = 0; j < GridModel.grid[i].length; j++) {
                final int result = Rand.randInt(0, 100);
                LifeformModel lifeform = null;
                if (result <= GridModel.chanceOfHumanPopulate) {
                    lifeform = new HumanModel(i, j);
                } else if (result <= (GridModel.chanceOfHumanPopulate + GridModel.changeOfAnimalPopulate)) {
                    final int animal = Rand.randInt(0, 2);
                    switch (animal) {
                    case 0:
                        lifeform = new ChickenModel(i, j);
                        break;
                    case 1:
                        lifeform = new PigModel(i, j);
                        break;
                    case 2:
                        lifeform = new DuckModel(i, j);
                        break;
                    }

                    final int sick = Rand.randInt(0, 100);
                    if (sick <= GridModel.chanceOfInfectedAnimal) {
                        if (lifeform instanceof PigModel) {
                            lifeform.setDisease(new H1N1Model(lifeform));
                        } else if ((lifeform instanceof ChickenModel)
                                || (lifeform instanceof DuckModel)) {
                            lifeform.setDisease(new H5N1Model(lifeform));
                        }
                    }
                }
                GridModel.grid[i][j] = lifeform;
            }
        }
    }
}
