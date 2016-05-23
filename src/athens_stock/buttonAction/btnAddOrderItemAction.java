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

    @Override
    public void actionPerformed(ActionEvent e) {
        //INSERT INTO `SE-order`(`order_id`, `order_name`, `order_customer_id`, `order_amount`, `order_price`, `order_date`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
        db.addOrderItem(cbbItem1, cbbItem2, cbbItem3, cbbItem4,
                spItem1, spItem2, spItem3, spItem4);

    }
}
