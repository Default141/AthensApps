package athens_stock.control;

import athens_stock.view.Customer;
import athens_stock.view.Supplier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chayut on 24-May-16.
 */
public class CustomerController {
    private Customer customer;

    public CustomerController(){
        customer = new Customer();
        customer.setVisible(true);
        setCustomerAction();
    }

    private void setCustomerAction(){
        customer.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                customer.dispose();
            }
        });
    }
}
