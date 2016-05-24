/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.buttonAction;

import athens_stock.model.DBMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author Burin
 */
public class btnAddAmount implements ActionListener{
    DBMethod db = new DBMethod();
    JComboBox<String> cbbItem1, cbbItem2, cbbItem3;
    JSpinner spItem1, spItem2, spItem3;
    
    public btnAddAmount(JComboBox<String> cbbItem1, JComboBox<String> cbbItem2, JComboBox<String> cbbItem3,
            JSpinner spItem1, JSpinner spItem2, JSpinner spItem3){
        this.cbbItem1 = cbbItem1;
        this.cbbItem2 = cbbItem2;
        this.cbbItem3 = cbbItem3;
        this.spItem1 = spItem1;
        this.spItem2 = spItem2;
        this.spItem3 = spItem3;
    }

    public void actionPerformed(ActionEvent e) {
        //INSERT INTO `SE-order`(`order_id`, `order_name`, `order_customer_id`, `order_amount`, `order_price`, `order_date`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure","Message",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                DBMethod db = new DBMethod();  
                int amount1 = 0;
                int amount2 = 0;
                int amount3 = 0;
                int success = 0;
                if(cbbItem1.getSelectedItem() != null){
                    success++;
                   amount1 = db.getAmoumt(cbbItem1) + (Integer)spItem1.getValue();
                   if((Integer)spItem1.getValue() > 0) db.updateAmount(amount1, cbbItem1);
                   else{ 
                       JOptionPane.showMessageDialog(null, "Please fill amount in line 1", "Message", JOptionPane.INFORMATION_MESSAGE);
                       success--;
                   }
                }
                if(cbbItem2.getSelectedItem()  != null){
                    success++;
                   amount2 = db.getAmoumt(cbbItem2) + (Integer)spItem2.getValue();
                   if((Integer)spItem2.getValue() > 0) db.updateAmount(amount2, cbbItem2);
                   else{
                       JOptionPane.showMessageDialog(null, "Please fill amount in line 2", "Message", JOptionPane.INFORMATION_MESSAGE);
                       success--;
                   }
                }
                if(cbbItem3.getSelectedItem()  != null){
                    success++;
                   amount3= db.getAmoumt(cbbItem3) + (Integer)spItem3.getValue();
                   if((Integer)spItem3.getValue() > 0) db.updateAmount(amount3, cbbItem3);
                   else{
                       JOptionPane.showMessageDialog(null, "Please fill amount in line 3", "Message", JOptionPane.INFORMATION_MESSAGE);
                       success--;
                   }
                }
                if(success > 0) JOptionPane.showMessageDialog(null, "Add Amount Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null, "Please select product", "Message", JOptionPane.INFORMATION_MESSAGE);
                setSelectionDefault();
            }
        
    }
    
     private void setSelectionDefault(){
        cbbItem1.setSelectedIndex(0);
        cbbItem2.setSelectedIndex(0);
        cbbItem3.setSelectedIndex(0);
        spItem1.setValue(0);
        spItem2.setValue(0);
        spItem3.setValue(0);
    }
    
    
}
