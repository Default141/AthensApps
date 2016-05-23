package athens_stock.control;

import athens_stock.view.OrderItem;
import athens_stock.view.OrderWarehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chayut on 24-May-16.
 */
public class OrderWarehouseController {
    OrderWarehouse orderWarehouse;

    public OrderWarehouseController(){
        orderWarehouse = new OrderWarehouse();
        orderWarehouse.setVisible(true);
        setOrderWarehouseAction();
    }

    private void setOrderWarehouseAction(){
        orderWarehouse.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuWarehouseController menu = new MenuWarehouseController();
                orderWarehouse.dispose();
            }
        });
    }
}
