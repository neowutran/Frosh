
package views.frame;

import java.util.Arrays;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by neowutran on 15/12/13.
 */
public class TreeConfig extends JTree implements TreeSelectionListener {

    /**
     * 
     */
    private static final long            serialVersionUID   = 1L;
    private final DefaultMutableTreeNode moveRate           = new DefaultMutableTreeNode(
                                                                    "moveRate");
    private final DefaultMutableTreeNode contactRateHuman   = new DefaultMutableTreeNode(
                                                                    "human");
    private final DefaultMutableTreeNode contactRateDuck    = new DefaultMutableTreeNode(
                                                                    "duck");
    private final DefaultMutableTreeNode contactRateChicken = new DefaultMutableTreeNode(
                                                                    "chicken");
    private final DefaultMutableTreeNode contactRatePig     = new DefaultMutableTreeNode(
                                                                    "pig");
    private final DefaultMutableTreeNode grid               = new DefaultMutableTreeNode(
                                                                    "grid");
    private final DefaultMutableTreeNode controller         = new DefaultMutableTreeNode(
                                                                    "controller");
    private final DefaultMutableTreeNode h1n1Human          = new DefaultMutableTreeNode(
                                                                    "human");
    private final DefaultMutableTreeNode h1n1Duck           = new DefaultMutableTreeNode(
                                                                    "duck");
    private final DefaultMutableTreeNode h1n1Chicken        = new DefaultMutableTreeNode(
                                                                    "chicken");
    private final DefaultMutableTreeNode h1n1Pig            = new DefaultMutableTreeNode(
                                                                    "pig");
    private final DefaultMutableTreeNode h5n1Human          = new DefaultMutableTreeNode(
                                                                    "human");
    private final DefaultMutableTreeNode h5n1Duck           = new DefaultMutableTreeNode(
                                                                    "duck");
    private final DefaultMutableTreeNode h5n1Chicken        = new DefaultMutableTreeNode(
                                                                    "chicken");
    private final DefaultMutableTreeNode h5n1Pig            = new DefaultMutableTreeNode(
                                                                    "pig");
    private final Config                 parent;

    public TreeConfig(final DefaultMutableTreeNode top, final Config parent) {

        super(top);
        this.parent = parent;
        top.add(this.moveRate);
        final DefaultMutableTreeNode contactRate = new DefaultMutableTreeNode(
                "contactRate");
        contactRate.add(this.contactRateHuman);
        contactRate.add(this.contactRateDuck);
        contactRate.add(this.contactRateChicken);
        contactRate.add(this.contactRatePig);
        top.add(contactRate);
        final DefaultMutableTreeNode h1n1 = new DefaultMutableTreeNode("H1N1");
        h1n1.add(this.h1n1Human);
        h1n1.add(this.h1n1Duck);
        h1n1.add(this.h1n1Chicken);
        h1n1.add(this.h1n1Pig);
        final DefaultMutableTreeNode h5n1 = new DefaultMutableTreeNode("H5N1");
        h5n1.add(this.h5n1Pig);
        h5n1.add(this.h5n1Human);
        h5n1.add(this.h5n1Chicken);
        h5n1.add(this.h5n1Duck);
        final DefaultMutableTreeNode disease = new DefaultMutableTreeNode(
                "disease");
        disease.add(h1n1);
        disease.add(h5n1);
        top.add(disease);
        top.add(this.grid);
        top.add(this.controller);
        this.addTreeSelectionListener(this);
    }

    @Override
    public void valueChanged(final TreeSelectionEvent e) {

        if (e.getPath().toString()
                .equals(Arrays.toString(this.moveRate.getPath()))) {
            this.parent.displayMoveRate();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.contactRateChicken.getPath()))) {
            this.parent.displayContactRateChicken();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.contactRateDuck.getPath()))) {
            this.parent.displayContactRateDuck();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.contactRateHuman.getPath()))) {
            this.parent.displayContactRateHuman();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.contactRatePig.getPath()))) {
            this.parent.displayContactRatePig();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h1n1Chicken.getPath()))) {
            this.parent.displayH1n1Chicken();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h1n1Duck.getPath()))) {
            this.parent.displayH1n1Duck();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h1n1Human.getPath()))) {
            this.parent.displayH1n1Human();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h1n1Pig.getPath()))) {
            this.parent.displayH1n1Pig();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h5n1Chicken.getPath()))) {
            this.parent.displayH5n1Chicken();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h5n1Duck.getPath()))) {
            this.parent.displayH5n1Duck();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h5n1Human.getPath()))) {
            this.parent.displayH5n1Human();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.h5n1Pig.getPath()))) {
            this.parent.displayH5n1Pig();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.grid.getPath()))) {
            this.parent.displayGrid();
        } else if (e.getPath().toString()
                .equals(Arrays.toString(this.controller.getPath()))) {
            this.parent.displayController();
        }
    }
}
