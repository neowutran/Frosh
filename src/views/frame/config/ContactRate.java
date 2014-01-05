
package views.frame.config;

import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ContactRate implements IDisplay, ChangeListener {

    private final String       lifeformType;
    private final SpinnerModel modelHuman          = new SpinnerNumberModel(50,
                                                           0, 100, 1);
    private final SpinnerModel modelPig            = new SpinnerNumberModel(50,
                                                           0, 100, 1);
    private final SpinnerModel modelChicken        = new SpinnerNumberModel(50,
                                                           0, 100, 1);
    private final SpinnerModel modelDuck           = new SpinnerNumberModel(50,
                                                           0, 100, 1);
    private final JSpinner     humanContactField   = new JSpinner(
                                                           this.modelHuman);
    private final JSpinner     pigContactField     = new JSpinner(this.modelPig);
    private final JSpinner     chickenContactField = new JSpinner(
                                                           this.modelChicken);
    private final JSpinner     duckContactField    = new JSpinner(
                                                           this.modelDuck);

    public ContactRate(final String lifeformType) {

        this.lifeformType = lifeformType;
    }

    @Override
    public void display(final JPanel configPanel) {

        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        final JLabel humanContact = new JLabel("human state");
        final JLabel pigContact = new JLabel("pig contact");
        final JLabel chickenContact = new JLabel("chicken contact");
        final JLabel duckContact = new JLabel("duck contact");
        this.humanContactField.setValue(((Double) ((Map) ((Map) config.Config
                .getConfiguration().get("contactRate")).get(this.lifeformType))
                .get("Human")).intValue());
        this.duckContactField.setValue(((Double) ((Map) ((Map) config.Config
                .getConfiguration().get("contactRate")).get(this.lifeformType))
                .get("Duck")).intValue());
        this.pigContactField.setValue(((Double) ((Map) ((Map) config.Config
                .getConfiguration().get("contactRate")).get(this.lifeformType))
                .get("Pig")).intValue());
        this.chickenContactField.setValue(((Double) ((Map) ((Map) config.Config
                .getConfiguration().get("contactRate")).get(this.lifeformType))
                .get("Chicken")).intValue());
        this.humanContactField.addChangeListener(this);
        this.pigContactField.addChangeListener(this);
        this.chickenContactField.addChangeListener(this);
        this.duckContactField.addChangeListener(this);
        configPanel.add(humanContact);
        configPanel.add(this.humanContactField);
        configPanel.add(pigContact);
        configPanel.add(this.pigContactField);
        configPanel.add(chickenContact);
        configPanel.add(this.chickenContactField);
        configPanel.add(duckContact);
        configPanel.add(this.duckContactField);
    }

    @Override
    public void stateChanged(final ChangeEvent e) {

        if (e.getSource().equals(this.humanContactField)) {
            ((Map) ((Map) config.Config.getConfiguration().get("contactRate"))
                    .get(this.lifeformType)).put("Human",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.pigContactField)) {
            ((Map) ((Map) config.Config.getConfiguration().get("contactRate"))
                    .get(this.lifeformType)).put("Pig",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.duckContactField)) {
            ((Map) ((Map) config.Config.getConfiguration().get("contactRate"))
                    .get(this.lifeformType)).put("Duck",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.chickenContactField)) {
            ((Map) ((Map) config.Config.getConfiguration().get("contactRate"))
                    .get(this.lifeformType)).put("Chicken",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        }
    }
}
