package athens_stock.buttonAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Chayut on 24-May-16.
 */
public class btnFrameAToFrameBAction extends AbstractAction {

    JFrame frameA, frameB;

    public btnFrameAToFrameBAction(JFrame frameA, JFrame frameB) {
        this.frameA = frameA;
        this.frameB = frameB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameB.setVisible(true);
        frameA.dispose();
    }
}
