package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnAddOrderItemAction extends AbstractAction {

    DBMethod db = new DBMethod();
    JComboBox<String> cbbItem1, cbbItem2, cbbItem3, cbbItem4, cbbcus;
    JSpinner spItem1, spItem2, spItem3, spItem4;
    
    public btnAddOrderItemAction(JComboBox<String> cbbItem1, JComboBox<String> cbbItem2, JComboBox<String> cbbItem3, JComboBox<String> cbbItem4, 
            JComboBox<String> cbbcus, JSpinner spItem1, JSpinner spItem2, JSpinner spItem3, JSpinner spItem4){
        this.cbbItem1 = cbbItem1;
        this.cbbItem2 = cbbItem2;
        this.cbbItem3 = cbbItem3;
        this.cbbItem4 = cbbItem4;
        this.cbbcus = cbbcus;
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
                 boolean success = db.addOrderItem(cbbItem1, cbbItem2, cbbItem3, cbbItem4, cbbcus, 
                spItem1, spItem2, spItem3, spItem4);
                if(success)JOptionPane.showMessageDialog(null,"Order Item Successful","Message",JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null,"Please select your Item","Message",JOptionPane.INFORMATION_MESSAGE);
                setSelectionDefault();
            }
    }
    
     private void setSelectionDefault(){
        cbbItem1.setSelectedIndex(0);
        cbbItem2.setSelectedIndex(0);
        cbbItem3.setSelectedIndex(0);
        cbbItem4.setSelectedIndex(0);
        cbbcus.setSelectedIndex(0);
        spItem1.setValue(0);
        spItem2.setValue(0);
        spItem3.setValue(0);
        spItem4.setValue(0);
    }
}
