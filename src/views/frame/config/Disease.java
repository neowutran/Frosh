
package views.frame.config;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Disease implements IDisplay, ActionListener, ChangeListener {

    private final String       diseaseType;
    private final String       lifeformType;
    private final SpinnerModel modelMortality        = new SpinnerNumberModel(
                                                             50, 0, 100, 1);
    private final SpinnerModel modelHuman            = new SpinnerNumberModel(
                                                             50, 0, 100, 1);
    private final SpinnerModel modelPig              = new SpinnerNumberModel(
                                                             50, 0, 100, 1);
    private final SpinnerModel modelDuck             = new SpinnerNumberModel(
                                                             50, 0, 100, 1);
    private final SpinnerModel modelChicken          = new SpinnerNumberModel(
                                                             50, 0, 100, 1);
    private final JTextField   incubationTimeField   = new JTextField();
    private final JTextField   recoveryTimeField     = new JTextField();
    private final JTextField   contagiousTimeField   = new JTextField();
    private final JSpinner     mortalityField        = new JSpinner(
                                                             this.modelMortality);
    private final JSpinner     infectionHumanField   = new JSpinner(
                                                             this.modelHuman);
    private final JSpinner     infectionPigField     = new JSpinner(
                                                             this.modelPig);
    private final JSpinner     infectionChickenField = new JSpinner(
                                                             this.modelChicken);
    private final JSpinner     infectionDuckField    = new JSpinner(
                                                             this.modelDuck);

    public Disease(final String diseaseType, final String lifeformType) {

        this.diseaseType = diseaseType;
        this.lifeformType = lifeformType;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        if (e.getSource().equals(this.incubationTimeField)) {
            ((Map) ((Map) ((Map) config.Config.getConfiguration()
                    .get("disease")).get(this.diseaseType))
                    .get(this.lifeformType)).put("incubationTime",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        } else if (e.getSource().equals(this.recoveryTimeField)) {
            ((Map) ((Map) ((Map) config.Config.getConfiguration()
                    .get("disease")).get(this.diseaseType))
                    .get(this.lifeformType)).put("recoveryTime",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        } else if (e.getSource().equals(this.contagiousTimeField)) {
            ((Map) ((Map) ((Map) config.Config.getConfiguration()
                    .get("disease")).get(this.diseaseType))
                    .get(this.lifeformType)).put("contagiousTime",
                    Double.valueOf((((JTextField) e.getSource())).getText()));
        }
    }

    @Override
    public void display(final JPanel configPanel) {

        configPanel.removeAll();
        configPanel.setLayout(new GridLayout(0, 2));
        final JLabel incubationTime = new JLabel("incubation time");
        final JLabel mortality = new JLabel("mortality");
        final JLabel infectionHuman = new JLabel("infection human");
        final JLabel infectionPig = new JLabel("infection pig");
        final JLabel infectionDuck = new JLabel("infection duck");
        final JLabel infectionChicken = new JLabel("infection chicken");
        final JLabel recoveryTime = new JLabel("recovery time");
        final JLabel contagiousTime = new JLabel("contagious time");
        this.incubationTimeField.setText(String
                .valueOf(((Double) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("incubationTime")).intValue()));
        this.recoveryTimeField.setText(String
                .valueOf(((Double) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("recoveryTime")).intValue()));
        this.contagiousTimeField.setText(String
                .valueOf(((Double) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("contagiousTime")).intValue()));
        this.mortalityField
                .setValue(((Double) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("mortality")).intValue());
        this.infectionHumanField
                .setValue(((Double) ((Map) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("infectionRate")).get("Human")).intValue());
        this.infectionPigField
                .setValue(((Double) ((Map) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("infectionRate")).get("Pig")).intValue());
        this.infectionChickenField
                .setValue(((Double) ((Map) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("infectionRate")).get("Chicken")).intValue());
        this.infectionDuckField
                .setValue(((Double) ((Map) ((Map) ((Map) ((Map) config.Config
                        .getConfiguration().get("disease"))
                        .get(this.diseaseType)).get(this.lifeformType))
                        .get("infectionRate")).get("Duck")).intValue());
        this.incubationTimeField.addActionListener(this);
        this.recoveryTimeField.addActionListener(this);
        this.contagiousTimeField.addActionListener(this);
        this.mortalityField.addChangeListener(this);
        this.infectionChickenField.addChangeListener(this);
        this.infectionDuckField.addChangeListener(this);
        this.infectionHumanField.addChangeListener(this);
        this.infectionPigField.addChangeListener(this);
        configPanel.add(incubationTime);
        configPanel.add(this.incubationTimeField);
        configPanel.add(mortality);
        configPanel.add(this.mortalityField);
        configPanel.add(infectionHuman);
        configPanel.add(this.infectionHumanField);
        configPanel.add(infectionChicken);
        configPanel.add(this.infectionChickenField);
        configPanel.add(infectionDuck);
        configPanel.add(this.infectionDuckField);
        configPanel.add(infectionPig);
        configPanel.add(this.infectionPigField);
        configPanel.add(recoveryTime);
        configPanel.add(this.recoveryTimeField);
        configPanel.add(contagiousTime);
        configPanel.add(this.contagiousTimeField);
    }

    @Override
    public void stateChanged(final ChangeEvent e) {

        if (e.getSource().equals(this.mortalityField)) {
            ((Map) ((Map) ((Map) config.Config.getConfiguration()
                    .get("disease")).get(this.diseaseType))
                    .get(this.lifeformType)).put("mortality",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.infectionChickenField)) {
            ((Map) ((Map) ((Map) ((Map) config.Config.getConfiguration().get(
                    "disease")).get(this.diseaseType)).get(this.lifeformType))
                    .get("infectionRate")).put("Chicken",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.infectionDuckField)) {
            ((Map) ((Map) ((Map) ((Map) config.Config.getConfiguration().get(
                    "disease")).get(this.diseaseType)).get(this.lifeformType))
                    .get("infectionRate")).put("Duck",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.infectionHumanField)) {
            ((Map) ((Map) ((Map) ((Map) config.Config.getConfiguration().get(
                    "disease")).get(this.diseaseType)).get(this.lifeformType))
                    .get("infectionRate")).put("Human",
                    ((Integer) (((JSpinner) e.getSource())).getValue())
                            .doubleValue());
        } else if (e.getSource().equals(this.infectionPigField)) {
            ((Map) ((Map) ((Map) ((Map) config.Config.getConfiguration().get(
                    "disease")).get(this.diseaseType)).get(this.lifeformType))
                    .get("infectionRate")).put("Pig", ((Integer) (((JSpinner) e
                    .getSource())).getValue()).doubleValue());
        }
    }
}
