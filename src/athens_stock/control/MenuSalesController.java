/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.control;

import athens_stock.view.CheckStockSales;
import athens_stock.view.MenuSales;
import athens_stock.view.OrderItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Burin
 */
public class MenuSalesController {
    private MenuSales menusale;
    
    public MenuSalesController(){
        menusale = new MenuSales();
        menusale.setVisible(true);
        setMenuSalesAction();
    }
    
    private void setMenuSalesAction(){
        menusale.setCheckStockAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CheckStockSalesController checkstock = new CheckStockSalesController();
                menusale.dispose();
            }
        });
        menusale.setSupplierAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               CustomerController cuustomer = new CustomerController();
                menusale.dispose(); 
            }
        });
        menusale.setOrderItemAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OrderItemController order = new OrderItemController();
                menusale.dispose();
            }
        });
        menusale.setAddCustomerAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddCustomerController customer = new AddCustomerController();
                menusale.dispose();
            }
        });
        
        
    }
    
    public static void main(String[] args){
        new MenuSalesController();
    }
    
    
    
}
