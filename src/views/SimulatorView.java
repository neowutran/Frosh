
package views;

import java.awt.Color;

import models.Grid;

/**
 * A graphical view of the simulation grid. This interface defines all possible
 * different views.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public interface SimulatorView {

    /**
     * Determine whether the simulation should continue to run.
     * 
     * @return true If there is more than one species alive.
     */
    boolean isViable(Grid grid);

    /**
     * Prepare for a new run.
     */
    void reset();

    /**
     * Define a color to be used for a given class of animal.
     * 
     * @param animalClass
     *            The animal's Class object.
     * @param color
     *            The color to be used for the given class.
     */
    void setColor(Class animalClass, Color color);

    void showStatus(int step);
}