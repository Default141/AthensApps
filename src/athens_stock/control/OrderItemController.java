/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.control;

import athens_stock.view.OrderItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Burin
 */
public class OrderItemController {
    private OrderItem orderitem;
    
    public OrderItemController(){
        orderitem = new OrderItem();
        orderitem.setVisible(true);
        setOrderItemAction();
    }
    
    private void setOrderItemAction(){
        orderitem.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                orderitem.dispose();
            }
        });
    }
    
    
}
