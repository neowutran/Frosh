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
    private JMenuItem pause = new JMenuItem("pause");
    private JMenuItem resume = new JMenuItem("resume");
    private JMenuItem exit = new JMenuItem("exit");
    private JMenuItem config = new JMenuItem("config");
    private JDialog configFrame;

    public MenuBar(){

        start.addActionListener(this);
        pause.addActionListener(this);
        resume.addActionListener(this);
        exit.addActionListener(this);
        config.addActionListener(this);
        this.add(start);
        this.add(pause);
        this.add(resume);
        this.add(exit);
        this.add(config);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){

            case "exit":
                FroshController.getInstance().exit();
                break;
            case "resume":
                FroshController.getInstance().resume();
                break;
            case "pause":
                FroshController.getInstance().pause();
                break;
            case "start":
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
