package views.frame;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by neowutran on 15/12/13.
 */
public class Config extends JDialog {
    private JTree tree = new JTree();

    public Config(){

        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("Configuration");
        tree = new TreeConfig(top);

        this.setSize(500,500);


        JFrame.setDefaultLookAndFeelDecorated(true);
        //   this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout());
        contentPane.add(tree);
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
    }

    public void displayContactRateChicken() {
    }

    public void displayContactRateDuck() {
    }

    public void displayContactRateHuman() {
    }

    public void displayContactRatePig() {
    }

    public void displayH1n1Chicken() {
    }

    public void displayH1n1Duck() {
    }

    public void displayH1n1Human() {
    }

    public void displayH1n1Pig() {
    }

    public void displayH5n1Chicken() {
    }

    public void displayH5n1Duck() {
    }

    public void displayH5n1Human() {
    }

    public void displayH5n1Pig() {
    }

    public void displayGrid() {
    }

    public void displayController() {
    }

    public void displayLifeform() {
    }

    public void displayDiseaseState() {
    }
}
