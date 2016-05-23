package athens_stock.buttonAction;

import athens_stock.model.DAOproduct;
import athens_stock.model.DBMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnSaleSearchStockAction extends AbstractAction {

    DBMethod db = new DBMethod();
    JTextField key;
    ComboBoxModel<String> comboBoxModel;
    DefaultTableModel tableModel;

    public btnSaleSearchStockAction(String buttonText, JTextField key, ComboBoxModel<String> comboBoxModel, DefaultTableModel tableModel) {
        super(buttonText);
        this.key = key;
        this.tableModel = tableModel;
        this.comboBoxModel = comboBoxModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<DAOproduct> products = db.getStock(key);
        int line = 0;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
            line = 0;
        }

        for (DAOproduct product : products) {
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(product.getName(), line, 0);

            String supName = db.getSupplierNameByID(product.getSupplierId());
            tableModel.setValueAt(supName, line, 1);
            tableModel.setValueAt(product.getAmount(), line, 2);
            tableModel.setValueAt(product.getPrice(), line, 3);
            line = line + 1;
        }
    }
}
