package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnAddOrderItemAction extends AbstractAction {

    DBMethod db = new DBMethod();
    JComboBox<String> cbbItem1, cbbItem2, cbbItem3, cbbItem4;
    JSpinner spItem1, spItem2, spItem3, spItem4;
    
    public btnAddOrderItemAction(JComboBox<String> cbbItem1, JComboBox<String> cbbItem2, JComboBox<String> cbbItem3, JComboBox<String> cbbItem4,
            JSpinner spItem1, JSpinner spItem2, JSpinner spItem3, JSpinner spItem4){
        this.cbbItem1 = cbbItem1;
        this.cbbItem2 = cbbItem2;
        this.cbbItem3 = cbbItem3;
        this.cbbItem4 = cbbItem4;
        this.spItem1 = spItem1;
        this.spItem2 = spItem2;
        this.spItem3 = spItem3;
        this.spItem4 = spItem4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //INSERT INTO `SE-order`(`order_id`, `order_name`, `order_customer_id`, `order_amount`, `order_price`, `order_date`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure","Message",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                 db.addOrderItem(cbbItem1, cbbItem2, cbbItem3, cbbItem4,
                spItem1, spItem2, spItem3, spItem4);
                JOptionPane.showMessageDialog(null,"Order Item Successful","Message",JOptionPane.INFORMATION_MESSAGE);
            }
    }
}
