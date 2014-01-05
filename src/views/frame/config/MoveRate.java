package views.frame.config;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Map;

/**
 * Created by neowutran on 05/01/14.
 */
public class MoveRate implements IDisplay, ChangeListener {

    private SpinnerModel modelHuman = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelDuck = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelPig = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelChicken = new SpinnerNumberModel(50, 0, 100, 1);

    private JSpinner humanSpinner = new JSpinner(modelHuman);
    private JSpinner duckSpinner = new JSpinner(modelDuck);
    private JSpinner pigSpinner = new JSpinner(modelPig);
    private JSpinner chickenSpinner = new JSpinner(modelChicken);

    @Override
    public void display(JPanel configPanel) {
        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));

        JLabel human = new JLabel("human");
        JLabel duck = new JLabel("duck");
        JLabel pig = new JLabel("pig");
        JLabel chicken = new JLabel("chicken");

        humanSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("moveRate")).get("Human")).intValue());
        duckSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("moveRate")).get("Duck")).intValue());
        pigSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("moveRate")).get("Pig")).intValue());
        chickenSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("moveRate")).get("Chicken")).intValue());

        humanSpinner.addChangeListener(this);
        duckSpinner.addChangeListener(this);
        pigSpinner.addChangeListener(this);
        chickenSpinner.addChangeListener(this);

        configPanel.add(human);
        configPanel.add(humanSpinner);
        configPanel.add(duck);
        configPanel.add(duckSpinner);
        configPanel.add(pig);
        configPanel.add(pigSpinner);
        configPanel.add(chicken);
        configPanel.add(chickenSpinner);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource().equals(humanSpinner)){
            ((Map) config.Config.getConfiguration().get("moveRate")).put("Human", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(duckSpinner)){
            ((Map) config.Config.getConfiguration().get("moveRate")).put("Duck", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(pigSpinner)){
            ((Map) config.Config.getConfiguration().get("moveRate")).put("Pig", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(chickenSpinner)){
            ((Map) config.Config.getConfiguration().get("moveRate")).put("Chicken", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }

    }
}
