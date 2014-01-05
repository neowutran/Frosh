
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

public class MoveRate implements IDisplay, ChangeListener {

    private final SpinnerModel modelHuman     = new SpinnerNumberModel(50, 0,
                                                      100, 1);
    private final SpinnerModel modelDuck      = new SpinnerNumberModel(50, 0,
                                                      100, 1);
    private final SpinnerModel modelPig       = new SpinnerNumberModel(50, 0,
                                                      100, 1);
    private final SpinnerModel modelChicken   = new SpinnerNumberModel(50, 0,
                                                      100, 1);
    private final JSpinner     humanSpinner   = new JSpinner(this.modelHuman);
    private final JSpinner     duckSpinner    = new JSpinner(this.modelDuck);
    private final JSpinner     pigSpinner     = new JSpinner(this.modelPig);
    private final JSpinner     chickenSpinner = new JSpinner(this.modelChicken);

    @Override
    public void display(final JPanel configPanel) {

        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        final JLabel human = new JLabel("human");
        final JLabel duck = new JLabel("duck");
        final JLabel pig = new JLabel("pig");
        final JLabel chicken = new JLabel("chicken");
        this.humanSpinner.setValue(((Double) ((Map) config.Config
                .getConfiguration().get("moveRate")).get("Human")).intValue());
        this.duckSpinner.setValue(((Double) ((Map) config.Config
                .getConfiguration().get("moveRate")).get("Duck")).intValue());
        this.pigSpinner.setValue(((Double) ((Map) config.Config
                .getConfiguration().get("moveRate")).get("Pig")).intValue());
        this.chickenSpinner
                .setValue(((Double) ((Map) config.Config.getConfiguration()
                        .get("moveRate")).get("Chicken")).intValue());
        this.humanSpinner.addChangeListener(this);
        this.duckSpinner.addChangeListener(this);
        this.pigSpinner.addChangeListener(this);
        this.chickenSpinner.addChangeListener(this);
        configPanel.add(human);
        configPanel.add(this.humanSpinner);
        configPanel.add(duck);
        configPanel.add(this.duckSpinner);
        configPanel.add(pig);
        configPanel.add(this.pigSpinner);
        configPanel.add(chicken);
        configPanel.add(this.chickenSpinner);
    }

    @Override
    public void stateChanged(final ChangeEvent e) {

        if (e.getSource().equals(this.humanSpinner)) {
            ((Map) config.Config.getConfiguration().get("moveRate")).put(
                    "Human",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.duckSpinner)) {
            ((Map) config.Config.getConfiguration().get("moveRate")).put(
                    "Duck", ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.pigSpinner)) {
            ((Map) config.Config.getConfiguration().get("moveRate")).put("Pig",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.chickenSpinner)) {
            ((Map) config.Config.getConfiguration().get("moveRate")).put(
                    "Chicken", ((Integer) (((JSpinner) e.getSource()))
                            .getValue()).doubleValue());
        }
    }
}
