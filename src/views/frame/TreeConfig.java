package views.frame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Created by neowutran on 15/12/13.
 */
public class TreeConfig extends JTree implements TreeSelectionListener {

    private DefaultMutableTreeNode moveRate = new DefaultMutableTreeNode("moveRate");
    private DefaultMutableTreeNode contactRateHuman = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode contactRateDuck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode contactRateChicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode contactRatePig = new DefaultMutableTreeNode("pig");
    private DefaultMutableTreeNode grid = new DefaultMutableTreeNode("grid");
    private DefaultMutableTreeNode controller = new DefaultMutableTreeNode("controller");
    private DefaultMutableTreeNode h1n1Human = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode h1n1Duck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode h1n1Chicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode h1n1Pig = new DefaultMutableTreeNode("pig");
    private DefaultMutableTreeNode h5n1Human = new DefaultMutableTreeNode("human");
    private DefaultMutableTreeNode h5n1Duck = new DefaultMutableTreeNode("duck");
    private DefaultMutableTreeNode h5n1Chicken = new DefaultMutableTreeNode("chicken");
    private DefaultMutableTreeNode h5n1Pig = new DefaultMutableTreeNode("pig");
    private Config parent;


    public TreeConfig(DefaultMutableTreeNode top, Config parent){
        super(top);
        this.parent = parent;
        top.add(moveRate);
        DefaultMutableTreeNode contactRate = new DefaultMutableTreeNode("contactRate");
        contactRate.add(contactRateHuman);
        contactRate.add(contactRateDuck);
        contactRate.add(contactRateChicken);
        contactRate.add(contactRatePig);
        top.add(contactRate);
        DefaultMutableTreeNode h1n1 = new DefaultMutableTreeNode("H1N1");
        h1n1.add(h1n1Human);
        h1n1.add(h1n1Duck);
        h1n1.add(h1n1Chicken);
        h1n1.add(h1n1Pig);
        DefaultMutableTreeNode h5n1 = new DefaultMutableTreeNode("H5N1");
        h5n1.add(h5n1Pig);
        h5n1.add(h5n1Human);
        h5n1.add(h5n1Chicken);
        h5n1.add(h5n1Duck);
        DefaultMutableTreeNode disease = new DefaultMutableTreeNode("disease");
        disease.add(h1n1);
        disease.add(h5n1);
        top.add(disease);
        top.add(grid);
        top.add(controller);
        this.addTreeSelectionListener(this);


    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        if(e.getPath().toString().equals(Arrays.toString(moveRate.getPath()))){
            this.parent.displayMoveRate();

        }else if(e.getPath().toString().equals(Arrays.toString(contactRateChicken.getPath()))){
            this.parent.displayContactRateChicken();

        }else if(e.getPath().toString().equals(Arrays.toString(contactRateDuck.getPath()))){
            this.parent.displayContactRateDuck();

        }else if(e.getPath().toString().equals(Arrays.toString(contactRateHuman.getPath()))){
            this.parent.displayContactRateHuman();

        }else if(e.getPath().toString().equals(Arrays.toString(contactRatePig.getPath()))){
            this.parent.displayContactRatePig();

        }else if(e.getPath().toString().equals(Arrays.toString(h1n1Chicken.getPath()))){
            this.parent.displayH1n1Chicken();

        }else if(e.getPath().toString().equals(Arrays.toString(h1n1Duck.getPath()))){
            this.parent.displayH1n1Duck();

        }else if(e.getPath().toString().equals(Arrays.toString(h1n1Human.getPath()))){
            this.parent.displayH1n1Human();

        }else if(e.getPath().toString().equals(Arrays.toString(h1n1Pig.getPath()))){
            this.parent.displayH1n1Pig();

        }else if(e.getPath().toString().equals(Arrays.toString(h5n1Chicken.getPath()))){
            this.parent.displayH5n1Chicken();

        }else if(e.getPath().toString().equals(Arrays.toString(h5n1Duck.getPath()))){
            this.parent.displayH5n1Duck();

        }else if(e.getPath().toString().equals(Arrays.toString(h5n1Human.getPath()))){
            this.parent.displayH5n1Human();

        }else if(e.getPath().toString().equals(Arrays.toString(h5n1Pig.getPath()))){
            this.parent.displayH5n1Pig();

        }else if(e.getPath().toString().equals(Arrays.toString(grid.getPath()))){
            this.parent.displayGrid();

        }else if(e.getPath().toString().equals(Arrays.toString(controller.getPath()))){
            this.parent.displayController();

        }
    }
}
