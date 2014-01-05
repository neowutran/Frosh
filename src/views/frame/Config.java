
package views.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import views.frame.config.ContactRate;
import views.frame.config.Controller;
import views.frame.config.Disease;
import views.frame.config.Grid;
import views.frame.config.MoveRate;

public class Config extends JDialog implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JTree             tree             = new JTree();
    private final JPanel      configPanel      = new JPanel();

    public Config() {

        final DefaultMutableTreeNode top = new DefaultMutableTreeNode(
                "Configuration");
        this.tree = new TreeConfig(top, this);
        this.setSize(500, 500);
        JFrame.setDefaultLookAndFeelDecorated(true);
        // this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Frosh");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(this.tree, BorderLayout.WEST);
        contentPane.add(this.configPanel, BorderLayout.CENTER);
        this.setContentPane(contentPane);
        this.setVisible(true);
        contentPane.requestFocus();
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

    }

    public void displayContactRateChicken() {

        new ContactRate("Chicken").display(this.configPanel);
    }

    public void displayContactRateDuck() {

        new ContactRate("Duck").display(this.configPanel);
    }

    public void displayContactRateHuman() {

        new ContactRate("Human").display(this.configPanel);
    }

    public void displayContactRatePig() {

        new ContactRate("Pig").display(this.configPanel);
    }

    public void displayController() {

        new Controller().display(this.configPanel);
    }

    public void displayGrid() {

        new Grid().display(this.configPanel);
    }

    public void displayH1n1Chicken() {

        new Disease("H1N1", "Chicken").display(this.configPanel);
    }

    public void displayH1n1Duck() {

        new Disease("H1N1", "Duck").display(this.configPanel);
    }

    public void displayH1n1Human() {

        new Disease("H1N1", "Human").display(this.configPanel);
    }

    public void displayH1n1Pig() {

        new Disease("H1N1", "Pig").display(this.configPanel);
    }

    public void displayH5n1Chicken() {

        new Disease("H5N1", "Chicken").display(this.configPanel);
    }

    public void displayH5n1Duck() {

        new Disease("H5N1", "Duck").display(this.configPanel);
    }

    public void displayH5n1Human() {

        new Disease("H5N1", "Human").display(this.configPanel);
    }

    public void displayH5n1Pig() {

        new Disease("H5N1", "Pig").display(this.configPanel);
    }

    public void displayMoveRate() {

        new MoveRate().display(this.configPanel);
    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
        }
    }
}
