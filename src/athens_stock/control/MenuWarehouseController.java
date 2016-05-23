package athens_stock.control;

import athens_stock.view.MenuSales;
import athens_stock.view.MenuWarehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chayut on 24-May-16.
 */
public class MenuWarehouseController {
    private MenuWarehouse menuWarehouse;

    public MenuWarehouseController(){
        menuWarehouse = new MenuWarehouse();
        menuWarehouse.setVisible(true);
        setMenuSalesAction();
    }

    private void setMenuSalesAction(){
        menuWarehouse.setCheckStockAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CheckStockWHController checkstock = new CheckStockWHController();
                menuWarehouse.dispose();
            }
        });
        menuWarehouse.setAddAmountAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddAmountController amount = new AddAmountController();
                menuWarehouse.dispose();
            }
        });
        menuWarehouse.setNewProductAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                NewProductController product = new NewProductController();
                menuWarehouse.dispose();
            }
        });
        menuWarehouse.setViewOrderAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOrderController order = new ViewOrderController();
                menuWarehouse.dispose();
            }
        });


    }

    public static void main(String[] args){
        new MenuSalesController();
    }


}
