package views.frame;


import views.frame.config.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

/**
 * Created by neowutran on 15/12/13.
 */
public class Config extends JDialog implements ActionListener{
    private JTree tree = new JTree();
    private JPanel configPanel = new JPanel();

    public Config(){

        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("Configuration");
        tree = new TreeConfig(top, this);

        this.setSize(500,500);


        JFrame.setDefaultLookAndFeelDecorated(true);
        //   this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(tree, BorderLayout.WEST);
        contentPane.add(configPanel,BorderLayout.CENTER);
        this.setContentPane(contentPane);
        this.setVisible(true);
        contentPane.requestFocus();
    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {

            this.dispose();

        }

    }


    public void displayMoveRate() {

        new MoveRate().display(configPanel);

    }

    public void displayContactRateChicken() {
        new ContactRate("Chicken").display(configPanel);
    }

    public void displayContactRateDuck() {
        new ContactRate("Duck").display(configPanel);
    }

    public void displayContactRateHuman() {
        new ContactRate("Human").display(configPanel);
    }

    public void displayContactRatePig() {
        new ContactRate("Pig").display(configPanel);
    }

    public void displayH1n1Chicken() {
        new Disease("H1N1", "Chicken").display(configPanel);
    }

    public void displayH1n1Duck() {
        new Disease("H1N1", "Duck").display(configPanel);
    }

    public void displayH1n1Human() {
        new Disease("H1N1", "Human").display(configPanel);
    }

    public void displayH1n1Pig() {
        new Disease("H1N1", "Pig").display(configPanel);
    }

    public void displayH5n1Chicken() {
        new Disease("H5N1", "Chicken").display(configPanel);
    }

    public void displayH5n1Duck() {
        new Disease("H5N1", "Duck").display(configPanel);
    }

    public void displayH5n1Human() {
        new Disease("H5N1", "Human").display(configPanel);
    }

    public void displayH5n1Pig() {
        new Disease("H5N1", "Pig").display(configPanel);
    }

    public void displayGrid() {
        new Grid().display(configPanel);

    }

    public void displayController() {

        new Controller().display(configPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
