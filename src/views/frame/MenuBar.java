package views.frame;

import controllers.FroshController;
import models.FroshRuntimeException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by neowutran on 14/12/13.
 */
public class MenuBar extends JMenuBar implements ActionListener {

    private JMenuItem start = new JMenuItem("start");
    private JMenuItem state = new JMenuItem("pause");
    private JMenuItem config = new JMenuItem("config");
    private JDialog configFrame;

    public MenuBar(){

        start.addActionListener(this);
        state.addActionListener(this);
        config.addActionListener(this);
        state.setVisible(false);
        this.add(start);
        this.add(config);
        this.add(state);


    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){

            case "resume":
                state.setText("pause");
                FroshController.getInstance().resume();
                break;
            case "pause":
                state.setText("resume");
                FroshController.getInstance().pause();
                break;
            case "restart":
            case "start":
                start.setText("restart");
                state.setText("pause");
                state.setVisible(true);
                FroshController.getInstance().rerun();
                break;
            case "config":
                configFrame = new Config();
                break;
            default:
                throw new FroshRuntimeException("this event doesn't exist:"+event.getActionCommand());

        }
    }
}
