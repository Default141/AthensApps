/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.view;

import athens_stock.buttonAction.btnFrameAToFrameBAction;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author lullaby
 */
public class MenuWarehouse extends JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    JFrame test;

    public MenuWarehouse() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args){
        MenuWarehouse m = new MenuWarehouse();
        m.setVisible(true);
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
        lbStockManage = new javax.swing.JLabel();
        lbWelcome = new javax.swing.JLabel();

        Action btnCheckStockAction = new btnFrameAToFrameBAction(this, new CheckStockWarehouse());
        btnCheckStock = new javax.swing.JButton(btnCheckStockAction);

        Action btnAddAmountAction = new btnFrameAToFrameBAction(this, new AddNewProduct());
        btnAddAmount = new javax.swing.JButton(btnAddAmountAction);

        Action btnAddProductAction = new btnFrameAToFrameBAction(this, new AddNewProduct());
        btnAddProduct = new javax.swing.JButton(btnAddProductAction);

        Action btnOrderAction = new btnFrameAToFrameBAction(this, new OrderWarehouse());
        btnOrder = new javax.swing.JButton(btnOrderAction);

        lbWarehouse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        athensPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/athens_stock/res/athens.jpg"))); // NOI18N

        lbStockManage.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        lbStockManage.setText("Stock Management System");

        lbWelcome.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbWelcome.setText("Welcome to Stock Management System !");

        btnCheckStock.setFont(new java.awt.Font("Lucida Grande", 0, 38)); // NOI18N
        btnCheckStock.setText("Check Stock");


        btnAddAmount.setFont(new java.awt.Font("Lucida Grande", 0, 42)); // NOI18N
        btnAddAmount.setText("Add item amount");


        btnAddProduct.setFont(new java.awt.Font("Lucida Grande", 0, 42)); // NOI18N
        btnAddProduct.setText("Add new product");


        btnOrder.setFont(new java.awt.Font("Lucida Grande", 0, 42)); // NOI18N
        btnOrder.setText("View Order");



        lbWarehouse.setFont(new java.awt.Font("Lucida Grande", 0, 42)); // NOI18N
        lbWarehouse.setText("Warehouse");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbWelcome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(athensPic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbStockManage))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lbWarehouse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnAddAmount))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnCheckStock))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(btnAddProduct))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(btnOrder))    )
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(athensPic)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbStockManage)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbWelcome)
                .addGap(32, 32, 32)
                .addComponent(lbWarehouse)
                .addGap(60, 60, 60)
                .addComponent(btnCheckStock)
                .addGap(60, 60, 60)
                .addComponent(btnAddAmount)
                    .addGap(60, 60, 60)
                    .addComponent(btnAddProduct)
                    .addGap(60, 60, 60)
                    .addComponent(btnOrder)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckStock;
    private javax.swing.JButton btnAddAmount;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel athensPic;
    private javax.swing.JLabel lbStockManage;
    private javax.swing.JLabel lbWarehouse;
    private javax.swing.JLabel lbWelcome;
    // End of variables declaration//GEN-END:variables
}
