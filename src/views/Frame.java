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
    private JPanel panelMenu = new JPanel();

    public Frame(){

        this.setSize(500,500);


        JFrame.setDefaultLookAndFeelDecorated(true);
     //   this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        this.setContentPane(contentPane);
        this.panelMenu.add(menuBar);
        this.panelMenu.setFocusable(true);
        this.add(this.panelMenu);
        this.setVisible(true);
        this.panelMenu.requestFocus();

    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

            FroshController.getInstance().exit();
        }

    }

}
