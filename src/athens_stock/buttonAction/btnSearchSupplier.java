package athens_stock.buttonAction;

import athens_stock.model.DAOsupplier;
import athens_stock.model.DBMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnSearchSupplier extends AbstractAction {

    DBMethod db = new DBMethod();
    JTextField key;
    DefaultTableModel tableModel;

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<DAOsupplier> suppliers = db.getAllSupplier(key);
        int line = 0;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
            line = 0;
        }

        for (DAOsupplier supplier : suppliers) {
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(supplier.getId(), line, 0);
            tableModel.setValueAt(supplier.getName(), line, 1);
            tableModel.setValueAt(supplier.getPhone(), line, 2);
            tableModel.setValueAt(supplier.getStatus(), line, 3);
            tableModel.setValueAt(supplier.getAddress(), line, 4);
            line = line + 1;
        }
    }
}
