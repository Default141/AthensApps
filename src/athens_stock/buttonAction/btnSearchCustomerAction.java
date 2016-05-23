package athens_stock.buttonAction;

import athens_stock.model.DAOcustomer;
import athens_stock.model.DAOsupplier;
import athens_stock.model.DBMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Chayut on 24-May-16.
 */
public class btnSearchCustomerAction extends AbstractAction {

    JTextField tfSearch;
    DBMethod db = new DBMethod();
    DefaultTableModel tableModel;

    public btnSearchCustomerAction(String name, JTextField tfSearch, DefaultTableModel tableModel) {
        super(name);
        this.tfSearch = tfSearch;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<DAOcustomer> customers = db.getAllCustomer(tfSearch);;
        int line = 0;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
            line = 0;
        }

        for (DAOcustomer customer : customers) {
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(customer.getId(), line, 0);
            tableModel.setValueAt(customer.getName(), line, 1);
            tableModel.setValueAt(customer.getPhone(), line, 2);
            tableModel.setValueAt(customer.getAddress(), line, 3);
            line = line + 1;
        }
    }
}
