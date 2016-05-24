package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * Created by Chayut on 24-May-16.
 */

public class btnDeliverAction extends AbstractAction {
    private JTable table;
    private JButton btnSearch;
    DBMethod db = new DBMethod();

    public btnDeliverAction(JTable table, JButton btnSearch) {
        this.table = table;
        this.btnSearch = btnSearch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean isSelect;
            int orderId = 0;
            int amount = 0;
            String product = "";
            if (table.getValueAt(i, 0) == null) {
                isSelect = false;
                continue;
            } else {
                isSelect = (Boolean) table.getValueAt(i, 0);
                orderId = (Integer) table.getValueAt(i, 1);
                amount = (Integer) table.getValueAt(i, 3);
                product = (String) table.getValueAt(i, 2);
            }

            System.out.println(isSelect);
            if (isSelect) {
                int answer = JOptionPane.showConfirmDialog(null, "Confirm Delivered.", "Delivered", YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    db.deliver(orderId, amount, product);
                }
            }
        }
        btnSearch.doClick();
    }
}
