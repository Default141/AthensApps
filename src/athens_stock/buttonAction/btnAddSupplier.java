package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnAddSupplier extends AbstractAction {

    DBMethod db = new DBMethod();
    JTextField tfName, tfAddr, tfPhone;

    public btnAddSupplier(String buttonText, JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        super(buttonText);
        this.tfName = tfName;
        this.tfAddr = tfAddr;
        this.tfPhone = tfPhone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        db.addSupplier(tfName, tfAddr, tfPhone);
    }
}
