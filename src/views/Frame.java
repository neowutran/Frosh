
package views;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import views.frame.MenuBar;
import controllers.FroshController;

public class Frame extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JMenuBar    menuBar          = new MenuBar();
    private final JPanel      panel            = new JPanel();
    private GridView          grid             = new GridView();

    public Frame() {

        this.setSize(500, 500);
        JFrame.setDefaultLookAndFeelDecorated(true);
        // this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.panel.setLayout(new BorderLayout());
        this.panel.setFocusable(true);
        this.setContentPane(this.panel);
        this.grid = new GridView();
        this.grid.setColor(models.lifeform.animal.Chicken.class,
                java.awt.Color.ORANGE);
        this.grid.setColor(models.lifeform.animal.Duck.class,
                java.awt.Color.RED);
        this.grid.setColor(models.lifeform.animal.Pig.class,
                java.awt.Color.YELLOW);
        this.grid.setColor(models.lifeform.Human.class, java.awt.Color.BLUE);
        this.panel.add(this.grid, BorderLayout.CENTER);
        this.panel.add(this.menuBar, BorderLayout.NORTH);
        this.setVisible(true);
        this.panel.requestFocus();
    }

    public GridView getGrid() {

        return this.grid;
    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            FroshController.getInstance().exit();
        }
    }
}
