/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.control;

import athens_stock.view.Supplier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Burin
 */
public class SupplierController {
    private Supplier supplier;
    
    public SupplierController(){
        supplier = new Supplier();
        supplier.setVisible(true);
        setSupplierAction();
    }
    
    private void setSupplierAction(){
        supplier.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                supplier.dispose();
            }
        });
    }
}