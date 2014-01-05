package views.frame.config;

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
public class Disease implements IDisplay, ActionListener, ChangeListener{

    private String diseaseType;
    private String lifeformType;


    SpinnerModel modelMortality = new SpinnerNumberModel(50, 0, 100, 1);
    SpinnerModel modelHuman = new SpinnerNumberModel(50, 0, 100, 1);
    SpinnerModel modelPig = new SpinnerNumberModel(50, 0, 100, 1);
    SpinnerModel modelDuck = new SpinnerNumberModel(50, 0, 100, 1);
    SpinnerModel modelChicken = new SpinnerNumberModel(50, 0, 100, 1);

    JTextField incubationTimeField = new JTextField();
    JTextField recoveryTimeField = new JTextField();
    JTextField contagiousTimeField = new JTextField();
    JSpinner mortalityField = new JSpinner(modelMortality);
    JSpinner infectionHumanField = new JSpinner(modelHuman);
    JSpinner infectionPigField = new JSpinner(modelPig);
    JSpinner infectionChickenField = new JSpinner(modelChicken);
    JSpinner infectionDuckField = new JSpinner(modelDuck);

    public Disease(String diseaseType, String lifeformType){
        this.diseaseType = diseaseType;
        this.lifeformType = lifeformType;
    }

    @Override
    public void display(JPanel configPanel) {
        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));

        JLabel incubationTime = new JLabel("incubation time");
        JLabel mortality = new JLabel("mortality");
        JLabel infectionHuman = new JLabel("infection human");
        JLabel infectionPig = new JLabel("infection pig");
        JLabel infectionDuck = new JLabel("infection duck");
        JLabel infectionChicken = new JLabel("infection chicken");
        JLabel recoveryTime = new JLabel("recovery time");
        JLabel contagiousTime = new JLabel("contagious time");


        incubationTimeField.setText(String.valueOf(((Double) ((Map) ((Map) ((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("incubationTime")).intValue()));
        recoveryTimeField.setText(String.valueOf(((Double) ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("recoveryTime")).intValue()));
        contagiousTimeField.setText(String.valueOf(((Double) ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("contagiousTime")).intValue()));
        mortalityField.setValue(((Double) ((Map) ((Map) ((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("mortality")).intValue());
        infectionHumanField.setValue(((Double) ((Map) ((Map) ((Map) ((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).get("Human")).intValue());
        infectionPigField.setValue(((Double)((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).get("Pig")).intValue());
        infectionChickenField.setValue(((Double)((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).get("Chicken")).intValue());
        infectionDuckField.setValue(((Double)((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).get("Duck")).intValue());

        incubationTimeField.addActionListener(this);
        recoveryTimeField.addActionListener(this);
        contagiousTimeField.addActionListener(this);
        mortalityField.addChangeListener(this);
        infectionChickenField.addChangeListener(this);
        infectionDuckField.addChangeListener(this);
        infectionHumanField.addChangeListener(this);
        infectionPigField.addChangeListener(this);

        configPanel.add(incubationTime);
        configPanel.add(incubationTimeField);
        configPanel.add(mortality);
        configPanel.add(mortalityField);
        configPanel.add(infectionHuman);
        configPanel.add(infectionHumanField);
        configPanel.add(infectionChicken);
        configPanel.add(infectionChickenField);
        configPanel.add(infectionDuck);
        configPanel.add(infectionDuckField);
        configPanel.add(infectionPig);
        configPanel.add(infectionPigField);
        configPanel.add(recoveryTime);
        configPanel.add(recoveryTimeField);
        configPanel.add(contagiousTime);
        configPanel.add(contagiousTimeField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(incubationTimeField)){
            ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).put("incubationTime", Double.valueOf((String) (((JTextField) e.getSource())).getText()));
        }else if(e.getSource().equals(recoveryTimeField)){
            ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).put("recoveryTime", Double.valueOf((String) (((JTextField) e.getSource())).getText()));
        }else if(e.getSource().equals(contagiousTimeField)){
            ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).put("contagiousTime", Double.valueOf((String) (((JTextField) e.getSource())).getText()));

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource().equals(mortalityField)){
            ((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).put("mortality", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(infectionChickenField)){
            ((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).put("Chicken", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(infectionDuckField)){
            ((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).put("Duck", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(infectionHumanField)){
            ((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).put("Human", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(infectionPigField)){
            ((Map)((Map)((Map)((Map) config.Config.getConfiguration().get("disease")).get(this.diseaseType)).get(this.lifeformType)).get("infectionRate")).put("Pig", ((Integer)(((JSpinner)e.getSource())).getValue()).doubleValue());
        }
    }
}
