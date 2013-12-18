package views;

import controllers.FroshController;
import views.frame.MenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

/**
 * Created by neowutran on 14/12/13.
 */
public class Frame extends JDialog {

    private JMenuBar menuBar = new MenuBar();
    private JPanel panel = new JPanel();
    private GridView grid = new GridView();

    public GridView getGrid() {
        return grid;
    }

    public Frame(){

        this.setSize(500,500);



        JFrame.setDefaultLookAndFeelDecorated(true);
     //   this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);
        this.setContentPane(panel);



        this.grid = new GridView( );
        grid.setColor(models.lifeform.animal.Chicken.class, java.awt.Color.ORANGE);
        grid.setColor(models.lifeform.animal.Duck.class, java.awt.Color.RED);
        grid.setColor(models.lifeform.animal.Pig.class, java.awt.Color.YELLOW);
        grid.setColor(models.lifeform.Human.class, java.awt.Color.BLUE);


        panel.add(grid, BorderLayout.CENTER);
        panel.add(menuBar, BorderLayout.NORTH);

        this.setVisible(true);
        this.panel.requestFocus();

    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

            FroshController.getInstance().exit();
        }

    }

}
