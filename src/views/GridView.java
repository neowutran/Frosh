
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Grid;
import models.Lifeform;

/**
 * A graphical view of the simulation grid. The view displays a colored
 * rectangle for each location representing its contents. Colors for each type
 * of species can be defined using the setColor method.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class GridView extends JPanel implements SimulatorView {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Provide a graphical view of a rectangular field. This is a nested class
     * (a class defined inside a class) which defines a custom component for the
     * user interface. This component displays the field. This is rather
     * advanced GUI stuff - you can ignore this for your project if you like.
     */
    private class FieldView extends JPanel {

        /**
         * 
         */
        private static final long serialVersionUID         = 1L;
        private final int         GRID_VIEW_SCALING_FACTOR = 6;
        private final int         gridWidth, gridHeight;
        private int               xScale, yScale;
        Dimension                 size;
        private Graphics          g;
        private Image             fieldImage;

        /**
         * Create a new FieldView component.
         */
        public FieldView(final int height, final int width) {

            this.gridHeight = height;
            this.gridWidth = width;
            this.size = new Dimension(0, 0);
        }

        /**
         * Paint on grid location on this field in a given color.
         */
        public void drawMark(final int x, final int y, final Color color) {

            this.g.setColor(color);
            this.g.fillRect(x * this.xScale, y * this.yScale, this.xScale - 1,
                    this.yScale - 1);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         */
        @Override
        public Dimension getPreferredSize() {

            return new Dimension(
                    this.gridWidth * this.GRID_VIEW_SCALING_FACTOR,
                    this.gridHeight * this.GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * The field view component needs to be redisplayed. Copy the internal
         * image to screen.
         */
        @Override
        public void paintComponent(final Graphics g) {

            if (this.fieldImage != null) {
                final Dimension currentSize = this.getSize();
                if (this.size.equals(currentSize)) {
                    g.drawImage(this.fieldImage, 0, 0, null);
                } else {
                    // Rescale the previous image.
                    g.drawImage(this.fieldImage, 0, 0, currentSize.width,
                            currentSize.height, null);
                }
            }
        }

        /**
         * Prepare for a new round of painting. Since the component may be
         * resized, compute the scaling factor again.
         */
        public void preparePaint() {

            if (!this.size.equals(this.getSize())) { // if the size has
                                                     // changed...
                this.size = this.getSize();
                this.fieldImage = GridView.this.fieldView.createImage(
                        this.size.width, this.size.height);
                this.g = this.fieldImage.getGraphics();
                this.xScale = this.size.width / this.gridWidth;
                if (this.xScale < 1) {
                    this.xScale = this.GRID_VIEW_SCALING_FACTOR;
                }
                this.yScale = this.size.height / this.gridHeight;
                if (this.yScale < 1) {
                    this.yScale = this.GRID_VIEW_SCALING_FACTOR;
                }
            }
        }
    }

    // Colors used for empty locations.
    private static final Color      EMPTY_COLOR       = Color.white;
    // Color used for objects that have no defined color.
    private static final Color      UNKNOWN_COLOR     = Color.gray;
    private final String            STEP_PREFIX       = "Step: ";
    private final String            POPULATION_PREFIX = "Population: ";
    private final JLabel            stepLabel, population;
    private final FieldView         fieldView;
    // A map for storing colors for participants in the simulation
    private final Map<Class, Color> colors;

    public GridView() {

        super(new BorderLayout());
        this.colors = new HashMap<>();
        this.stepLabel = new JLabel(this.STEP_PREFIX, SwingConstants.CENTER);
        this.population = new JLabel(this.POPULATION_PREFIX,
                SwingConstants.CENTER);
        Grid.getGrid();
        this.fieldView = new FieldView(Grid.getGrid().length,
                Grid.getGrid()[0].length);
        this.add(this.stepLabel, BorderLayout.NORTH);
        this.add(this.fieldView, BorderLayout.CENTER);
        this.add(this.population, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * @return The color to be used for a given class of animal.
     */
    private Color getColor(final Class animalClass) {

        final Color col = this.colors.get(animalClass);
        if (col == null) {
            // no color defined for this class
            return GridView.UNKNOWN_COLOR;
        } else {
            return col;
        }
    }

    /**
     * Determine whether the simulation should continue to run.
     * 
     * @return true If there is more than one species alive.
     */
    @Override
    public boolean isViable(final Grid grid) {

        return grid.hasEnded();
    }

    /**
     * Prepare for a new run.
     */
    @Override
    public void reset() {

    }

    /**
     * Define a color to be used for a given class of animal.
     * 
     * @param animalClass
     *            The animal's Class object.
     * @param color
     *            The color to be used for the given class.
     */
    @Override
    public void setColor(final Class animalClass, final Color color) {

        this.colors.put(animalClass, color);
    }

    @Override
    public void showStatus(final int step) {

        if (!this.isVisible()) {
            this.setVisible(true);
        }
        this.stepLabel.setText(this.STEP_PREFIX + step);
        final Lifeform[][] grid = Grid.getGrid();
        this.fieldView.preparePaint();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                final Object animal = grid[row][col];
                if (animal != null) {
                    this.fieldView.drawMark(col, row,
                            this.getColor(animal.getClass()));
                } else {
                    this.fieldView.drawMark(col, row, GridView.EMPTY_COLOR);
                }
            }
        }
        this.population.setText(this.POPULATION_PREFIX);
        this.fieldView.repaint();
    }
}
