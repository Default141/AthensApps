package athens_stock.buttonAction;

import athens_stock.model.DAOcustomer;
import athens_stock.model.DAOorder;
import athens_stock.model.DBMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Chayut on 24-May-16.
 */
public class btnSearchOrderAction extends AbstractAction {
    DBMethod db = new DBMethod();
    DefaultTableModel tableModel;

    public btnSearchOrderAction(DefaultTableModel tableModel) {
        super("Search");
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<DAOorder> orders = db.getAllOrder();

        int line = 0;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
            line = 0;
        }

        for (DAOorder order : orders) {
            tableModel.addRow(new Object[0]);
            tableModel.setValueAt(order.getId(), line, 1);
            tableModel.setValueAt(order.getName(), line, 2);
            tableModel.setValueAt(order.getAmount(), line, 3);
            tableModel.setValueAt(order.getStatus(), line, 4);
            line = line + 1;
        }
    }
}
