
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The GraphView provides a view of two populations of actors in the field as a
 * line graph over time. In its current version, it can only plot exactly two
 * different classes of animals. If further animals are introduced, they will
 * not currently be displayed.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class GraphView {

    /**
     * Nested class: a component to display the graph.
     */
    class GraphPanel extends JComponent {

        /**
         * 
         */
        private static final long   serialVersionUID = 1L;
        private static final double SCALE_FACTOR     = 0.8;
        // An internal image buffer that is used for painting. For
        // actual display, this image buffer is then copied to screen.
        private final BufferedImage graphImage;
        private int                 lastVal1, lastVal2;
        private int                 yMax;

        /**
         * Create a new, empty GraphPanel.
         */
        public GraphPanel(final int width, final int height, final int startMax) {

            this.graphImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            this.clearImage();
            this.lastVal1 = height;
            this.lastVal2 = height;
            this.yMax = startMax;
        }

        /**
         * Clear the image on this panel.
         */
        public void clearImage() {

            final Graphics g = this.graphImage.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.graphImage.getWidth(),
                    this.graphImage.getHeight());
            this.repaint();
        }

        /**
         * Tell the layout manager how big we would like to be. (This method
         * gets called by layout managers for placing the components.)
         * 
         * @return The preferred dimension for this component.
         */
        @Override
        public Dimension getPreferredSize() {

            return new Dimension(this.graphImage.getWidth(),
                    this.graphImage.getHeight());
        }

        /**
         * This component is opaque.
         */
        @Override
        public boolean isOpaque() {

            return true;
        }

        /**
         * Indicate a new simulation run on this panel.
         */
        public void newRun() {

            final int height = this.graphImage.getHeight();
            final int width = this.graphImage.getWidth();
            final Graphics g = this.graphImage.getGraphics();
            g.copyArea(4, 0, width - 4, height, -4, 0);
            g.setColor(Color.BLACK);
            g.drawLine(width - 4, 0, width - 4, height);
            g.drawLine(width - 2, 0, width - 2, height);
            this.lastVal1 = height;
            this.lastVal2 = height;
            this.repaint();
        }

        /**
         * This component needs to be redisplayed. Copy the internal image to
         * screen. (This method gets called by the Swing screen painter every
         * time it wants this component displayed.)
         * 
         * @param g
         *            The graphics context that can be used to draw on this
         *            component.
         */
        @Override
        public void paintComponent(final Graphics g) {

            // g.clearRect(0, 0, size.width, size.height);
            if (this.graphImage != null) {
                g.drawImage(this.graphImage, 0, 0, null);
            }
        }

        // The following methods are redefinitions of methods
        // inherited from superclasses.
        /**
         * Cause immediate update of the panel.
         */
        public void repaintNow() {

            this.paintImmediately(0, 0, this.graphImage.getWidth(),
                    this.graphImage.getHeight());
        }

        /**
         * Scale the current graph down vertically to make more room at the top.
         */
        public void scaleDown() {

            final Graphics g = this.graphImage.getGraphics();
            final int height = this.graphImage.getHeight();
            final int width = this.graphImage.getWidth();
            final BufferedImage tmpImage = new BufferedImage(width,
                    (int) (height * GraphPanel.SCALE_FACTOR),
                    BufferedImage.TYPE_INT_RGB);
            final Graphics2D gtmp = (Graphics2D) tmpImage.getGraphics();
            gtmp.scale(1.0, GraphPanel.SCALE_FACTOR);
            gtmp.drawImage(this.graphImage, 0, 0, null);
            final int oldTop = (int) (height * (1.0 - GraphPanel.SCALE_FACTOR));
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, oldTop);
            g.drawImage(tmpImage, 0, oldTop, null);
            this.yMax = (int) (this.yMax / GraphPanel.SCALE_FACTOR);
            this.lastVal1 = oldTop
                    + (int) (this.lastVal1 * GraphPanel.SCALE_FACTOR);
            this.lastVal2 = oldTop
                    + (int) (this.lastVal2 * GraphPanel.SCALE_FACTOR);
            this.repaint();
        }

        /**
         * Dispay a new point of data.
         */
        public void update(final int step, final int a, final int b) {

            if (GraphView.this.classes.size() >= 2) {
                final Iterator<Class> it = GraphView.this.classes.iterator();
                final Class class1 = it.next();
                final Class class2 = it.next();
                final int count1 = a;
                final int count2 = b;
                final Graphics g = this.graphImage.getGraphics();
                final int height = this.graphImage.getHeight();
                final int width = this.graphImage.getWidth();
                // move graph one pixel to left
                g.copyArea(1, 0, width - 1, height, -1, 0);
                // calculate y, check whether it's out of screen. scale down if
                // necessary.
                int y = height - ((height * count1) / this.yMax) - 1;
                while (y < 0) {
                    this.scaleDown();
                    y = height - ((height * count1) / this.yMax) - 1;
                }
                g.setColor(GraphView.LIGHT_GRAY);
                g.drawLine(width - 2, y, width - 2, height);
                g.setColor(GraphView.this.colors.get(class1));
                g.drawLine(width - 3, this.lastVal1, width - 2, y);
                this.lastVal1 = y;
                y = height - ((height * count2) / this.yMax) - 1;
                while (y < 0) {
                    this.scaleDown();
                    y = height - ((height * count2) / this.yMax) - 1;
                }
                g.setColor(GraphView.LIGHT_GRAY);
                g.drawLine(width - 2, y, width - 2, height);
                g.setColor(GraphView.this.colors.get(class2));
                g.drawLine(width - 3, this.lastVal2, width - 2, y);
                this.lastVal2 = y;
                this.repaintNow();
                GraphView.stepLabel.setText("" + step);
            }
        }
    }

    private static final Color      LIGHT_GRAY = new Color(0, 0, 0, 40);
    private static JFrame           frame;
    private static GraphPanel       graph;
    private static JLabel           stepLabel;
    private static JLabel           countLabel;
    // The classes being tracked by this view
    private Set<Class>              classes;
    // A map for storing colors for participants in the simulation
    private final Map<Class, Color> colors;

    // A statistics object computing and storing simulation information
    /**
     * Constructor.
     * 
     * @param width
     *            The width of the plotter window (in pixles).
     * @param height
     *            The height of the plotter window (in pixles).
     * @param startMax
     *            The initial maximum value for the y axis.
     * @param width
     *            The second class to be plotted.
     */
    public GraphView(final int width, final int height, final int startMax) {

        this.classes = new HashSet<Class>();
        this.colors = new HashMap<Class, Color>();
        if (GraphView.frame == null) {
            GraphView.frame = this.makeFrame(width, height, startMax);
        } else {
            GraphView.graph.newRun();
        }
        // showStatus(0, null);
    }

    /**
     * Prepare the frame for the graph display.
     */
    private JFrame makeFrame(final int width, final int height,
            final int startMax) {

        final JFrame frame = new JFrame("Graph View");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        final Container contentPane = frame.getContentPane();
        GraphView.graph = new GraphPanel(width, height, startMax);
        contentPane.add(GraphView.graph, BorderLayout.CENTER);
        final JPanel bottom = new JPanel();
        bottom.add(new JLabel("Step:"));
        GraphView.stepLabel = new JLabel("");
        bottom.add(GraphView.stepLabel);
        GraphView.countLabel = new JLabel(" ");
        bottom.add(GraphView.countLabel);
        contentPane.add(bottom, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocation(20, 600);
        frame.setVisible(true);
        return frame;
    }

    /**
     * Determine whether the simulation should continue to run.
     * 
     * @return true If there is more than one species alive.
     * 
     *         public boolean isViable(Field field) { return
     *         stats.isViable(field); }
     */
    /**
     * Prepare for a new run.
     */
    public void reset() {

        GraphView.graph.newRun();
    }

    /**
     * Define a color to be used for a given class of animal.
     * 
     * @param animalClass
     *            The animal's Class object.
     * @param color
     *            The color to be used for the given class.
     */
    public void setColor(final Class animalClass, final Color color) {

        this.colors.put(animalClass, color);
        this.classes = this.colors.keySet();
    }

    // ============================================================================
    /**
     * Show the current status of the field. The status is shown by displaying a
     * line graph for two classes in the field. This view currently does not
     * work for more (or fewer) than exactly two classes. If the field contains
     * more than two different types of animal, only two of the classes will be
     * plotted.
     * 
     * @param step
     *            Which iteration step it is.
     */
    public void showStatus(final int step, final int a, final int b) {

        GraphView.graph.update(step, a, b);
    }
}
