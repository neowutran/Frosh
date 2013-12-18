package views.frame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Created by neowutran on 15/12/13.
 */
public class TreeConfig extends JTree implements TreeSelectionListener {

    private DefaultMutableTreeNode moveRate = new DefaultMutableTreeNode("moveRate");
    private DefaultMutableTreeNode contactRate = new DefaultMutableTreeNode("contactRate");
    private DefaultMutableTreeNode contactRateHuman = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode contactRateDuck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode contactRateChicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode contactRatePig = new DefaultMutableTreeNode("pig");
    private DefaultMutableTreeNode disease = new DefaultMutableTreeNode("disease");
    private DefaultMutableTreeNode h1n1 = new DefaultMutableTreeNode("H1N1");
    private DefaultMutableTreeNode h5n1 = new DefaultMutableTreeNode("H5N1");
    private DefaultMutableTreeNode grid = new DefaultMutableTreeNode("grid");
    private DefaultMutableTreeNode controller = new DefaultMutableTreeNode("controller");
    private DefaultMutableTreeNode view = new DefaultMutableTreeNode("view");
    private DefaultMutableTreeNode lifeform = new DefaultMutableTreeNode("lifeform");
    private DefaultMutableTreeNode diseaseState = new DefaultMutableTreeNode("diseaseState");
    private DefaultMutableTreeNode h1n1Human = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode h1n1Duck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode h1n1Chicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode h1n1Pig = new DefaultMutableTreeNode("pig");
    private DefaultMutableTreeNode h5n1Human = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode h5n1Duck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode h5n1Chicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode h5n1Pig = new DefaultMutableTreeNode("pig");



    public TreeConfig(DefaultMutableTreeNode top){
        super(top);
        top.add(moveRate);
        contactRate.add(contactRateHuman);
        contactRate.add(contactRateDuck);
        contactRate.add(contactRateChicken);
        contactRate.add(contactRatePig);
        top.add(contactRate);
        h1n1.add(h1n1Human);
        h1n1.add(h1n1Duck);
        h1n1.add(h1n1Chicken);
        h1n1.add(h1n1Pig);
        h5n1.add(h5n1Pig);
        h5n1.add(h5n1Human);
        h5n1.add(h5n1Chicken);
        h5n1.add(h5n1Duck);
        disease.add(h1n1);
        disease.add(h5n1);
        top.add(disease);
        top.add(grid);
        top.add(controller);
        view.add(lifeform);
        view.add(diseaseState);
        top.add(view);
        this.addTreeSelectionListener(this);


    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        if(e.getSource().equals(moveRate)){
            ((Config)this.getParent()).displayMoveRate();
        }else if(e.getSource().equals(contactRateChicken)){
            ((Config)this.getParent()).displayContactRateChicken();

        }else if(e.getSource().equals(contactRateDuck)){
            ((Config)this.getParent()).displayContactRateDuck();

        }else if(e.getSource().equals(contactRateHuman)){
            ((Config)this.getParent()).displayContactRateHuman();

        }else if(e.getSource().equals(contactRatePig)){
            ((Config)this.getParent()).displayContactRatePig();

        }else if(e.getSource().equals(h1n1Chicken)){
            ((Config)this.getParent()).displayH1n1Chicken();

        }else if(e.getSource().equals(h1n1Duck)){
            ((Config)this.getParent()).displayH1n1Duck();

        }else if(e.getSource().equals(h1n1Human)){
            ((Config)this.getParent()).displayH1n1Human();

        }else if(e.getSource().equals(h1n1Pig)){
            ((Config)this.getParent()).displayH1n1Pig();

        }else if(e.getSource().equals(h5n1Chicken)){
            ((Config)this.getParent()).displayH5n1Chicken();

        }else if(e.getSource().equals(h5n1Duck)){
            ((Config)this.getParent()).displayH5n1Duck();

        }else if(e.getSource().equals(h5n1Human)){
            ((Config)this.getParent()).displayH5n1Human();

        }else if(e.getSource().equals(h5n1Pig)){
            ((Config)this.getParent()).displayH5n1Pig();

        }else if(e.getSource().equals(grid)){
            ((Config)this.getParent()).displayGrid();

        }else if(e.getSource().equals(controller)){
            ((Config)this.getParent()).displayController();

        }else if(e.getSource().equals(lifeform)){
            ((Config)this.getParent()).displayLifeform();

        }else if(e.getSource().equals(diseaseState)){
            ((Config)this.getParent()).displayDiseaseState();

        }
    }
}
