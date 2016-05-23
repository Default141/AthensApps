package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * Created by Chayut on 24-May-16.
 */
public class btnCancelOrder extends AbstractAction {
    private JTable table;
    private JButton btnSearch;
    DBMethod db = new DBMethod();

    public btnCancelOrder(JTable table, JButton btnSearch) {
        this.table = table;
        this.btnSearch = btnSearch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean isSelect;
            int orderId = 0;
            if (table.getValueAt(i, 0) == null) {
                isSelect = false;
                continue;
            } else {
                isSelect = (Boolean) table.getValueAt(i, 0);
                orderId = (Integer) table.getValueAt(i, 1);
            }
            if (isSelect) {
                int answer = JOptionPane.showConfirmDialog(null, "Confirm Cancel.", "Cancel order", YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    db.cancelOrder(orderId);
                }
            }
        }
        btnSearch.doClick();
    }
}
