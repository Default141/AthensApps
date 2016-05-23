package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnAddCustomerAction extends AbstractAction {

    DBMethod db = new DBMethod();
    JTextField tfName, tfAddr, tfPhone;

    public btnAddCustomerAction(String name, JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        super(name);
        this.tfName = tfName;
        this.tfAddr = tfAddr;
        this.tfPhone = tfPhone;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //INSERT INTO `SE-customer`(`id`, `customer_name`, `customer_address`, `customer_phone`, `customer_status`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
        //db.addCustomer(tfName, tfAddr, tfPhone);
    }
}
