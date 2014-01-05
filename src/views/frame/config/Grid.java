
package views.frame.config;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Grid implements IDisplay, ActionListener, ChangeListener {

    private final SpinnerModel      modelHuman                    = new SpinnerNumberModel(
                                                                          50,
                                                                          0,
                                                                          100,
                                                                          1);
    private final SpinnerModel      modelAnimal                   = new SpinnerNumberModel(
                                                                          50,
                                                                          0,
                                                                          100,
                                                                          1);
    private final SpinnerModel      modelInfected                 = new SpinnerNumberModel(
                                                                          50,
                                                                          0,
                                                                          100,
                                                                          1);
    private final JSpinner          chanceOfHumanPopulateSpinner  = new JSpinner(
                                                                          this.modelHuman);
    private final JSpinner          chanceOfAnimalPopulateSpinner = new JSpinner(
                                                                          this.modelAnimal);
    private final JSpinner          chanceOfInfectedAnimalSpinner = new JSpinner(
                                                                          this.modelInfected);
    private final JTextField        widthField                    = new JTextField();
    private final JTextField        heightField                   = new JTextField();
    private final String[]          moveType                      = {
            "Horizontal - vertical - diagonal", "Diagonal",
            "Horizontal - vertical"                              };
    private final JComboBox<String> moveTypeField                 = new JComboBox<>(
                                                                          this.moveType);

    @Override
    public void actionPerformed(final ActionEvent e) {

        if (e.getSource().equals(this.widthField)) {
            ((Map) config.Config.getConfiguration().get("grid")).put("width",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        } else if (e.getSource().equals(this.heightField)) {
            ((Map) config.Config.getConfiguration().get("grid")).put("height",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        } else if (e.getSource().equals(this.moveTypeField)) {
            ((Map) config.Config.getConfiguration().get("grid")).put("gridUse",
                    Double.valueOf((((JComboBox) e.getSource()))
                            .getSelectedIndex()));
        }
    }

    @Override
    public void display(final JPanel configPanel) {

        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        final JLabel width = new JLabel("width");
        final JLabel height = new JLabel("height");
        final JLabel chanceOfHumanPopulate = new JLabel(
                "chance of human populate");
        final JLabel chanceOfAnimalPopulate = new JLabel(
                "chance of animal populate");
        final JLabel chanceOfInfectedAnimal = new JLabel(
                "chance of infected animal");
        final JLabel move = new JLabel("move type");
        this.chanceOfAnimalPopulateSpinner
                .setValue(((Double) ((Map) config.Config.getConfiguration()
                        .get("grid")).get("chanceOfAnimalPopulate")).intValue());
        this.chanceOfHumanPopulateSpinner
                .setValue(((Double) ((Map) config.Config.getConfiguration()
                        .get("grid")).get("chanceOfHumanPopulate")).intValue());
        this.chanceOfInfectedAnimalSpinner
                .setValue(((Double) ((Map) config.Config.getConfiguration()
                        .get("grid")).get("chanceOfInfectedAnimal")).intValue());
        this.widthField.setText(String.valueOf(((Double) ((Map) config.Config
                .getConfiguration().get("grid")).get("width")).intValue()));
        this.heightField.setText(String.valueOf(((Double) ((Map) config.Config
                .getConfiguration().get("grid")).get("height")).intValue()));
        this.moveTypeField.setSelectedIndex(((Double) ((Map) config.Config
                .getConfiguration().get("grid")).get("gridUse")).intValue());
        this.chanceOfAnimalPopulateSpinner.addChangeListener(this);
        this.chanceOfHumanPopulateSpinner.addChangeListener(this);
        this.chanceOfInfectedAnimalSpinner.addChangeListener(this);
        this.widthField.addActionListener(this);
        this.heightField.addActionListener(this);
        this.moveTypeField.addActionListener(this);
        configPanel.add(chanceOfHumanPopulate);
        configPanel.add(this.chanceOfHumanPopulateSpinner);
        configPanel.add(chanceOfAnimalPopulate);
        configPanel.add(this.chanceOfAnimalPopulateSpinner);
        configPanel.add(chanceOfInfectedAnimal);
        configPanel.add(this.chanceOfInfectedAnimalSpinner);
        configPanel.add(width);
        configPanel.add(this.widthField);
        configPanel.add(height);
        configPanel.add(this.heightField);
        configPanel.add(move);
        configPanel.add(this.moveTypeField);
    }

    @Override
    public void stateChanged(final ChangeEvent e) {

        if (e.getSource().equals(this.chanceOfAnimalPopulateSpinner)) {
            ((Map) config.Config.getConfiguration().get("grid")).put(
                    "chanceOfAnimalPopulate", ((Integer) (((JSpinner) e
                            .getSource())).getValue()).doubleValue());
        } else if (e.getSource().equals(this.chanceOfHumanPopulateSpinner)) {
            ((Map) config.Config.getConfiguration().get("grid")).put(
                    "chanceOfHumanPopulate", ((Integer) (((JSpinner) e
                            .getSource())).getValue()).doubleValue());
        } else if (e.getSource().equals(this.chanceOfInfectedAnimalSpinner)) {
            ((Map) config.Config.getConfiguration().get("grid")).put(
                    "chanceOfInfectedAnimal", ((Integer) (((JSpinner) e
                            .getSource())).getValue()).doubleValue());
        }
    }
}
