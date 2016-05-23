package athens_stock.buttonAction;

import athens_stock.model.DBMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Created by Chayut on 23-May-16.
 */
public class btnAddNewProductAction extends AbstractAction {
    DBMethod db = new DBMethod();
    JTextField tfName;
    JTextField tfType;
    JTextField tfLocate;
    JComboBox cbbSupplier;
    JTextField tfAmount;
    JTextField tfPrice;

    public btnAddNewProductAction(JTextField tfName, JTextField tfType, JTextField tfLocate, JComboBox cbbSupplier, JTextField tfAmount, JTextField tfPrice) {
        this.tfName = tfName;
        this.tfType = tfType;
        this.tfLocate = tfLocate;
        this.cbbSupplier = cbbSupplier;
        this.tfAmount = tfAmount;
        this.tfPrice = tfPrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int answer = JOptionPane.showConfirmDialog(null, "Confirm Add new customer", "Add new customer?", YES_NO_OPTION);
        if (answer == YES_OPTION) {
            if (db.addProduct(tfName, tfType, tfLocate, cbbSupplier, tfAmount, tfPrice)) {
                JOptionPane.showMessageDialog(null, "Add new product Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                tfName.setText("");
                tfType.setText("");
                tfLocate.setText("");
                tfAmount.setText("");
                tfPrice.setText("");
                cbbSupplier.setSelectedIndex(0);
            }
        }

    }
}
