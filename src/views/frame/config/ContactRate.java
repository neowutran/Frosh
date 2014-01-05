package views.frame.config;

import config.Config;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by neowutran on 05/01/14.
 */
public class ContactRate implements IDisplay, ChangeListener {

    private String lifeformType;
    private SpinnerModel modelHuman = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelPig = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelChicken = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelDuck = new SpinnerNumberModel(50, 0, 100, 1);

    private JSpinner humanContactField = new JSpinner(modelHuman);
    private JSpinner pigContactField = new JSpinner(modelPig);
    private JSpinner chickenContactField = new JSpinner(modelChicken);
    private JSpinner duckContactField = new JSpinner(modelDuck);
    public ContactRate(String lifeformType){
        this.lifeformType = lifeformType;
    }

    @Override
    public void display(JPanel configPanel) {
        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));

        JLabel humanContact = new JLabel("human state");
        JLabel pigContact = new JLabel("pig contact");
        JLabel chickenContact = new JLabel("chicken contact");
        JLabel duckContact = new JLabel("duck contact");

        humanContactField.setValue(((Double)((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).get("Human")).intValue());
        duckContactField.setValue(((Double)((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).get("Duck")).intValue());
        pigContactField.setValue(((Double)((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).get("Pig")).intValue());
        chickenContactField.setValue(((Double)((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).get("Chicken")).intValue());

        humanContactField.addChangeListener(this);
        pigContactField.addChangeListener(this);
        chickenContactField.addChangeListener(this);
        duckContactField.addChangeListener(this);

        configPanel.add(humanContact);
        configPanel.add(humanContactField);
        configPanel.add(pigContact);
        configPanel.add(pigContactField);
        configPanel.add(chickenContact);
        configPanel.add(chickenContactField);
        configPanel.add(duckContact);
        configPanel.add(duckContactField);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource().equals(humanContactField)){
            ((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).put("Human", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(pigContactField)){
            ((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).put("Pig", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());

        }else if(e.getSource().equals(duckContactField)){
            ((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).put("Duck", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());

        }else if(e.getSource().equals(chickenContactField)){
            ((Map)((Map) config.Config.getConfiguration().get("contactRate")).get(this.lifeformType)).put("Chicken", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());

        }

    }
}
