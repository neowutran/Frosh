
package views.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import models.FroshRuntimeException;
import controllers.FroshController;

public class MenuBar extends JMenuBar implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JMenuItem   start            = new JMenuItem("start");
    private final JMenuItem   state            = new JMenuItem("pause");
    private final JMenuItem   config           = new JMenuItem("config");
    private JDialog           configFrame;

    public MenuBar() {

        this.start.addActionListener(this);
        this.state.addActionListener(this);
        this.config.addActionListener(this);
        this.state.setVisible(false);
        this.add(this.start);
        this.add(this.config);
        this.add(this.state);
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        switch (event.getActionCommand()) {
            case "resume":
                this.state.setText("pause");
                FroshController.getInstance().resume();
                break;
            case "pause":
                this.state.setText("resume");
                FroshController.getInstance().pause();
                break;
            case "restart":
            case "start":
                this.start.setText("restart");
                this.state.setText("pause");
                this.state.setVisible(true);
                FroshController.getInstance().rerun();
                break;
            case "config":
                this.configFrame = new Config();
                break;
            default:
                throw new FroshRuntimeException("this event doesn't exist:"
                        + event.getActionCommand());
        }
    }
}
