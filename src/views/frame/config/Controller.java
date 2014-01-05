
package views.frame.config;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller implements IDisplay, ActionListener {

    private final JTextField msBeforeNextRoundField = new JTextField();

    @Override
    public void actionPerformed(final ActionEvent e) {

        if (e.getSource().equals(this.msBeforeNextRoundField)) {
            ((Map) config.Config.getConfiguration().get("controller")).put(
                    "msBeforeNextDay",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        }
    }

    @Override
    public void display(final JPanel configPanel) {

        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        final JLabel msBeforeNextRound = new JLabel("ms before next round");
        this.msBeforeNextRoundField
                .setText(String.valueOf((((Double) ((Map) config.Config
                        .getConfiguration().get("controller"))
                        .get("msBeforeNextDay")).intValue())));
        this.msBeforeNextRoundField.addActionListener(this);
        configPanel.add(msBeforeNextRound);
        configPanel.add(this.msBeforeNextRoundField);
    }
}
