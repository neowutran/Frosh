package views.frame.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by neowutran on 05/01/14.
 */
public class Controller implements IDisplay, ActionListener {

    private JTextField msBeforeNextRoundField = new JTextField();

    @Override
    public void display(JPanel configPanel) {
        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));

        JLabel msBeforeNextRound = new JLabel("ms before next round");
        msBeforeNextRoundField.setText(String.valueOf((((Double) ((Map) config.Config.getConfiguration().get("controller")).get("msBeforeNextDay")).intValue())));
        msBeforeNextRoundField.addActionListener(this);

        configPanel.add(msBeforeNextRound);
        configPanel.add(msBeforeNextRoundField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(msBeforeNextRoundField)){
            ((Map) config.Config.getConfiguration().get("controller")).put("msBeforeNextDay", Double.valueOf((String)(((JTextField)e.getSource())).getText()));
        }
    }
}
