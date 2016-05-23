package athens_stock.view;

import athens_stock.buttonAction.btnCancelOrder;
import athens_stock.buttonAction.btnDeliverAction;
import athens_stock.buttonAction.btnSearchOrderAction;
import athens_stock.model.DBMethod;

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
    DBMethod dbMethod = new DBMethod();

    public static void main(String args[]) {
        OrderWarehouse orderItem = new OrderWarehouse();
        orderItem.setVisible(true);
    }

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

    private void initComponents() {
        athensPic = new javax.swing.JLabel();
        lbStockManage = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

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

        DefaultTableModel tModel;
        tModel = new DefaultTableModel() {

            boolean[] canEdit = new boolean[]{
                    true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };

        jTable1.setModel(tModel);

        tModel.addColumn("Select");
        tModel.addColumn("Order ID");
        tModel.addColumn("Product Name");
        tModel.addColumn("Amount");
        tModel.addColumn("Status");

        jScrollPane1.setViewportView(jTable1);

        Action action = new btnSearchOrderAction((DefaultTableModel) jTable1.getModel());
        btnSearch = new javax.swing.JButton(action);

        Action action2 = new btnDeliverAction(jTable1, btnSearch);
        btnUpdate = new javax.swing.JButton(action2);

        Action action3 = new btnCancelOrder(jTable1, btnSearch);
        btnCancel = new javax.swing.JButton(action3);

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
                                                .addGap(35, 35, 35)
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
                                                                        .addComponent(lbView)
                                                                )))
                                                .addComponent(btnSearch)

                                        )
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(140, 140, 140)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(50, 50, 50)
                                                .addComponent(btnCancel)))
                                .addContainerGap(105, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
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
                                        .addComponent(lbView)
                                        .addComponent(btnSearch)
                                )
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       MenuWarehouse wareHouse = new MenuWarehouse();
       this.dispose();
       wareHouse.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel athensPic;
    private javax.swing.JLabel lbStockManage;
    private javax.swing.JLabel lbView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JButton btnSearch;
    // End of variables declaration//GEN-END:variables
}
