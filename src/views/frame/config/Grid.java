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
public class Grid implements IDisplay, ActionListener, ChangeListener{

    private SpinnerModel modelHuman = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelAnimal = new SpinnerNumberModel(50, 0, 100, 1);
    private SpinnerModel modelInfected = new SpinnerNumberModel(50, 0, 100, 1);
    private JSpinner chanceOfHumanPopulateSpinner = new JSpinner(modelHuman);
    private JSpinner chanceOfAnimalPopulateSpinner = new JSpinner(modelAnimal);
    private JSpinner chanceOfInfectedAnimalSpinner = new JSpinner(modelInfected);
    private JTextField widthField = new JTextField();
    private JTextField heightField = new JTextField();
    private String[] moveType = { "Horizontal - vertical - diagonal" , "Diagonal", "Horizontal - vertical" };
    private JComboBox<String> moveTypeField = new JComboBox<>(moveType);

    @Override
    public void display(JPanel configPanel) {
        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        JLabel width = new JLabel("width");
        JLabel height = new JLabel("height");
        JLabel chanceOfHumanPopulate = new JLabel("chance of human populate");
        JLabel chanceOfAnimalPopulate = new JLabel("chance of animal populate");
        JLabel chanceOfInfectedAnimal = new JLabel("chance of infected animal");
        JLabel move = new JLabel("move type");

        chanceOfAnimalPopulateSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("chanceOfAnimalPopulate")).intValue());
        chanceOfHumanPopulateSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("chanceOfHumanPopulate")).intValue());
        chanceOfInfectedAnimalSpinner.setValue(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("chanceOfInfectedAnimal")).intValue());

        widthField.setText(String.valueOf(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("width")).intValue()));
        heightField.setText(String.valueOf(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("height")).intValue()));
        moveTypeField.setSelectedIndex(((Double) ((Map) config.Config.getConfiguration().get("grid")).get("gridUse")).intValue());

        chanceOfAnimalPopulateSpinner.addChangeListener(this);
        chanceOfHumanPopulateSpinner.addChangeListener(this);
        chanceOfInfectedAnimalSpinner.addChangeListener(this);
        widthField.addActionListener(this);
        heightField.addActionListener(this);
        moveTypeField.addActionListener(this);

        configPanel.add(chanceOfHumanPopulate);
        configPanel.add(chanceOfHumanPopulateSpinner);
        configPanel.add(chanceOfAnimalPopulate);
        configPanel.add(chanceOfAnimalPopulateSpinner);
        configPanel.add(chanceOfInfectedAnimal);
        configPanel.add(chanceOfInfectedAnimalSpinner);
        configPanel.add(width);
        configPanel.add(widthField);
        configPanel.add(height);
        configPanel.add(heightField);
        configPanel.add(move);
        configPanel.add(moveTypeField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(widthField)){
            ((Map) config.Config.getConfiguration().get("grid")).put("width", Double.valueOf((String) (((JTextField) e.getSource())).getText()));
        }else if(e.getSource().equals(heightField)){
            ((Map) config.Config.getConfiguration().get("grid")).put("height", Double.valueOf((String) (((JTextField) e.getSource())).getText()));
        }else if(e.getSource().equals(moveTypeField)){
            ((Map) config.Config.getConfiguration().get("grid")).put("gridUse", Double.valueOf((((JComboBox) e.getSource())).getSelectedIndex()));
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource().equals(chanceOfAnimalPopulateSpinner)){
            ((Map) config.Config.getConfiguration().get("grid")).put("chanceOfAnimalPopulate", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(chanceOfHumanPopulateSpinner)){
            ((Map) config.Config.getConfiguration().get("grid")).put("chanceOfHumanPopulate", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());
        }else if(e.getSource().equals(chanceOfInfectedAnimalSpinner)){
            ((Map) config.Config.getConfiguration().get("grid")).put("chanceOfInfectedAnimal", ((Integer) (((JSpinner) e.getSource())).getValue()).doubleValue());

        }

    }
}
