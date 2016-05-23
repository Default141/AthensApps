package athens_stock.view;

import athens_stock.buttonAction.btnAddCustomerAction;
import athens_stock.model.DBMethod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by lullaby on 5/24/2016 AD.
 */
public class NewProduct extends JFrame {
    JFrame test;
    DefaultTableModel model;

    public NewProduct() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }
    public void setJFrame(JFrame f) {
        test = f;
    }

    public JFrame getJFrame() {
        return this.test;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {

        athensPic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lbAddCus = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbLoca = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfPType = new javax.swing.JTextField();
        tfLoca = new javax.swing.JTextField();
        lbsuppiler = new javax.swing.JLabel();
        cbbsuppiler = new javax.swing.JComboBox<>();
        tfAmount = new javax.swing.JTextField();
        lbAmount = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        lbPrice = new javax.swing.JLabel();

        Action btnAddCusAction = new btnAddCustomerAction("Add New Customer", tfName, tfLoca, tfPType);

        
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cbbsuppiler.setModel(new javax.swing.DefaultComboBoxModel(new DBMethod().retailerCombo()));
        btnAddProduct = new javax.swing.JButton(btnAddCusAction);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        athensPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/athens_stock/res/athens.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("Stock Management System");

        btnBack.setText("Home");

        lbAddCus.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbAddCus.setText("Add new Product");

        lbName.setText("Product name :");

        lbType.setText("Product type :");
        lbsuppiler.setText("Supplier :");
        lbAmount.setText("Amount :");
        lbPrice.setText("Price :");

        btnAddProduct.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnAddProduct.setText("Add");

        lbLoca.setText("Product zone :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(152, 152, 152))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbName)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(tfName))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbType)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(tfPType))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbLoca)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                                                .addComponent(tfLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbsuppiler)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(cbbsuppiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbAmount)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(tfAmount))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbPrice)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(tfPrice))
                                                        )
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addComponent(btnAddProduct))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(athensPic))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(52, 52, 52)
                                                                .addComponent(btnBack)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(lbAddCus)))))
                                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbAddCus)
                                                .addGap(41, 41, 41)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(20, 20, 20)
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbName)
                                                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbType)
                                                        .addComponent(tfPType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbLoca)
                                                        .addComponent(tfLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbsuppiler)
                                                        .addComponent(cbbsuppiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbAmount)
                                                        .addComponent(tfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbPrice)
                                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addComponent(btnAddProduct)
                                                .addContainerGap(145, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(athensPic, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnBack)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       MenuWarehouse wareHouse = new MenuWarehouse();
       this.dispose();
       wareHouse.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JLabel athensPic;
    private javax.swing.JLabel lbLoca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbAddCus;
    private javax.swing.JLabel lbName;
    private javax.swing.JTextField tfLoca;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPType;
    private javax.swing.JLabel lbsuppiler;
    private javax.swing.JComboBox cbbsuppiler;
    private javax.swing.JTextField tfAmount;
    private javax.swing.JLabel lbAmount;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JLabel lbPrice;
    // End of variables declaration//GEN-END:variables


}