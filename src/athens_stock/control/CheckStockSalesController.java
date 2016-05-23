/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.control;

import athens_stock.buttonAction.btnSaleSearchStockAction;
import athens_stock.model.DBMethod;
import athens_stock.view.CheckStockSales;
import athens_stock.view.MenuSales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Burin
 */
public class CheckStockSalesController {
    private CheckStockSales checkstock;
    
    public CheckStockSalesController(){
        checkstock = new CheckStockSales();
        setComboType();
        checkstock.setSearchAction(new btnSaleSearchStockAction("search", checkstock.getTextFieldSearch(), checkstock.getComboBoxModel(), checkstock.getTableModel()));
        checkstock.setVisible(true);
        setCheckStockSalesAction();
    }
    
    private void setCheckStockSalesAction(){
        checkstock.setHomeAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuSalesController menu = new MenuSalesController();
                checkstock.dispose();            }
        });
    }
    
    private void setComboType(){
        String[] comboType = new DBMethod().comboType();
        checkstock.setComboBoxType(comboType);
    }
    
}
