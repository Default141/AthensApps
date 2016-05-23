package athens_stock.control;

import athens_stock.buttonAction.btnSaleSearchStockAction;
import athens_stock.model.DBMethod;
import athens_stock.view.CheckStockSales;
import athens_stock.view.CheckStockWarehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chayut on 24-May-16.
 */
public class CheckStockWHController {
    private CheckStockWarehouse checkStockWarehouse;

    public CheckStockWHController() {
        checkStockWarehouse = new CheckStockWarehouse();
        checkStockWarehouse.setVisible(true);
        setCheckStockWHAction();
    }

    private void setCheckStockWHAction() {
        checkStockWarehouse.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                checkStockWarehouse.dispose();
            }
        });
    }

}
