/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.control;

import athens_stock.view.AddCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lullaby
 */
public class AddCustomerController {
    private AddCustomer addcustomer;
    
    public AddCustomerController(){
        addcustomer = new AddCustomer();
        addcustomer.setVisible(true);
        setAddCustomerAction();
    }
    
    private void setAddCustomerAction(){
        addcustomer.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                addcustomer.dispose();
            }
        });
    }
}
