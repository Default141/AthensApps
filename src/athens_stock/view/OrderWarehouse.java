package athens_stock.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by lullaby on 5/23/2016 AD.
 */
public class OrderWarehouse extends JFrame {
    JFrame test;
    DefaultTableModel model;

    public OrderWarehouse(){
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    public void setJFrame(JFrame f) {
        test = f;
    }

    public JFrame getJFrame() {
        return this.test;
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }

    public static void main(String[] args){
        OrderWarehouse o = new OrderWarehouse();
        o.setVisible(true);
    }

    private void initComponents() {
        athensPic = new javax.swing.JLabel();
        lbStockManage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbView = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        athensPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/athens_stock/res/athens.jpg"))); // NOI18N

        lbStockManage.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        lbStockManage.setText("Stock Management System");

        btnBack.setText("Home");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        " ","OrderID", "Product name", "Amount", "Status"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnCancel.setText("Cancel");
        btnUpdate.setText("Delivered");

        lbView.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbView.setText("View Order(s)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(athensPic)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbStockManage))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(31, 31, 31)
                                                                .addComponent(btnBack)
                                                                .addGap(70, 70, 70)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                                        .addComponent(lbView)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(50, 50, 50)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(77, 77, 77)
                                                .addComponent(btnCancel)))

                                .addContainerGap(135, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbStockManage)
                                        .addComponent(athensPic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBack)
                                        .addComponent(lbView))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancel)
                                .addGap(22, 22, 22)
                                        .addComponent(btnUpdate))
                                        .addGap(33, 33, 33)


                        )
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void setHomeAction(ActionListener action){
        btnBack.addActionListener(action);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel athensPic;
    private javax.swing.JLabel lbStockManage;
    private javax.swing.JLabel lbView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
