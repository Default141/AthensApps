/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.model;

import edu.sit.cs.db.CSDbDelegate;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 * @author lullaby
 */
public class DBMethod {

    private CSDbDelegate db;

    public DBMethod() {
        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G4", "csc105_2014", "csc105");
    }

    public void dbConnect() {
        System.out.println(db.connect());
    }

    public void dbDisConnect() {
        db.disconnect();
    }

    public void dbExecuteQuery(String sql) {
        db.executeQuery(sql);
    }


    public ArrayList<DAOsupplier> getAllSupplier(JTextField tfSearch) {
        dbConnect();
        ArrayList<DAOsupplier> supplier = new ArrayList<DAOsupplier>();
        String key = (String) tfSearch.getText();
        if(!checkInjection(key)){
            dbDisConnect();
            return supplier;
        }
        String re = "SELECT * FROM SE-supplier WHERE suppilier_id LIKE '%" + key + "%' OR supplier_name LIKE '%" + key + "%' OR "
                + "supplier_phone LIKE '%" + key + "%' OR supplier_status LIKE '%" + key + "%' OR supplier_address LIKE '%"
                + key + "%'";
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String no = (String) t.get("supplier_id");
            String name = (String) t.get("supplier_name");
            String phone = (String) t.get("supplier_phone");
            String status = (String) t.get("supplier_status");
            String address = (String) t.get("supplier_address");
            supplier.add(new DAOsupplier(no, name, phone, status, address));
        }
        dbDisConnect();
        return supplier;
    }

    public ArrayList<DAOcustomer> getAllCustomer(JTextField tfSearch) {
         ArrayList<DAOcustomer> customer = new ArrayList<DAOcustomer>();
        dbConnect();
        String key =  tfSearch.getText();
        if(!checkInjection(key)){
            dbDisConnect();
            return customer;
        }
        String re = "SELECT * FROM SE-customer WHERE customer_id LIKE '%" + key + "%' OR customer_name LIKE '%" + key + "%' OR "
                + "customer_phone LIKE '%" + key + "%' OR customer_status LIKE '%" + key + "%' OR customer_address LIKE '%"
                + key + "%'";
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String no = (String) t.get("customer_id");
            String name = (String) t.get("customer_name");
            String phone = (String) t.get("customer_phone");
            String status = (String) t.get("customer_status");
            String address = (String) t.get("customer_address");
            customer.add(new DAOcustomer(no, name, phone, status, address));
        }
        dbDisConnect();
        return customer;
    }

    public void addSupplier(JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        dbConnect();
        String name = tfName.getText();
        String address = tfAddr.getText();
        String phone = tfPhone.getText();
        if(!(checkInjection(name) && checkInjection(address) && checkInjection(phone))){
            dbDisConnect();
            return;
        }
        String addSup = "INSERT INTO `SE-supplier`(`supplier_name`, `supplier_address`,`supplier_phone`)"
                + "VALUES('" + name + "'" + "," + "'"
                + address + "'" + "," + "'" + phone
                + "'" + ")";
        dbExecuteQuery(addSup);
        dbDisConnect();
    }

    public void addOrderItem(JComboBox<String> cbbItem1, JComboBox<String> cbbItem2, JComboBox<String> cbbItem3, JComboBox<String> cbbItem4,
                             JSpinner spItem1, JSpinner spItem2, JSpinner spItem3, JSpinner spItem4) {
        dbConnect();

        String item1 = (String) cbbItem1.getSelectedItem();
        String item2 = (String) cbbItem2.getSelectedItem();
        String item3 = (String) cbbItem3.getSelectedItem();
        String item4 = (String) cbbItem4.getSelectedItem();

        String amount1 = (String) spItem1.getValue();
        String amount2 = (String) spItem2.getValue();
        String amount3 = (String) spItem3.getValue();
        String amount4 = (String) spItem4.getValue();

        if (!item1.isEmpty()) {
            String sql = "INSERT INTO `SE-order`(`order_name`, `order_amount`) " +
                    "VALUES (" + item1 + ", " + amount1 + " )";
            System.out.println("item1");
            dbExecuteQuery(sql);
        }

        if (!item2.isEmpty()) {
            String sql = "INSERT INTO `SE-order`(`order_name`, `order_amount`) " +
                    "VALUES (" + item2 + ", " + amount2 + " )";
            System.out.println("item2");
            dbExecuteQuery(sql);
        }

        if (!item3.isEmpty()) {
            String sql = "INSERT INTO `SE-order`(`order_name`, `order_amount`) " +
                    "VALUES (" + item3 + ", " + amount3 + " )";
            System.out.println("item3");
            dbExecuteQuery(sql);
        }

        if (!item4.isEmpty()) {
            String sql = "INSERT INTO `SE-order`(`order_name`, `order_amount`) " +
                    "VALUES (" + item4 + ", " + amount4 + " )";
            System.out.println("item4");
            dbExecuteQuery(sql);
        }

        dbDisConnect();
    }

    public ArrayList<DAOproduct> getStock(JTextField tfSearch, String ptype) {
        dbConnect();
        ArrayList<DAOproduct> product = new ArrayList<DAOproduct>();
        String key = (String) tfSearch.getText().trim();
        if(!checkInjection(key)){
            dbDisConnect();
            return product;
        }
        String re;
        if(key.length() > 0){
            re = "SELECT * FROM `SE-product` WHERE product_type = '"+ ptype + "' and (product_id LIKE '%" + key + "%' OR product_name LIKE '%" + key + "%' OR "
                    + "product_status LIKE '%" + key + "%' OR product_locate LIKE '%"
                    + key + "%')";
        }
        else{
            re = "SELECT * FROM `SE-product` WHERE product_type = '"+ ptype +"'";
        }
        System.out.println(re);
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            String type = (String) t.get("product_type");
            String locate = (String) t.get("product_locate");
            int supplierId = Integer.parseInt(t.get("product_supplier_id")+"");
            int amount = Integer.parseInt(t.get("product_amount")+"");
            double price = Double.parseDouble(t.get("product_price")+"");
            product.add(new DAOproduct(name, type, locate, supplierId, amount, price));
        }

        dbDisConnect();
        return product;
        //dont forget to change supid to supname
    }

    public void addCustomer(JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        dbConnect();
        String name = tfName.getText();
        String address = tfAddr.getText();
        String phone = tfPhone.getText();
        if(!(checkInjection(name) && checkInjection(address) && checkInjection(phone))){
            dbDisConnect();
            return;
        }
        String addCus = "INSERT INTO `SE-customer`(`id`, `customer_name`, `customer_address`, `customer_phone`)"
                + "VALUES('" + name + "'" + "," + "'"
                + address + "'" + "," + "'" + phone
                + "'" + ")";
        dbExecuteQuery(addCus);
        dbDisConnect();
    }

    public String[] comboType() {
        dbConnect();
        String sql = "select distinct product_type from `SE-product`";
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] item = new String[all.size()];
        int i = 0;
        for (HashMap t : all) {
            String name = (String) t.get("product_type");
            item[i++] = name;
        }
        dbDisConnect();
        return item;
    }

    public ArrayList<DAOblacklistC> getBlacklistC(JTextField tfSearch) {
        dbConnect();
        ArrayList<DAOblacklistC> customer = new ArrayList<DAOblacklistC>();
        String key = (String) tfSearch.getText();
        if(!checkInjection(key)){
            dbDisConnect();
            return customer;
        }
        String sql = "SELECT blacklist_id, customer_name, blacklist_reason " +
                "FROM `SE-blacklistC`, `SE-customer`" +
                "WHERE  WHERE blacklist_id = customer_id AND " +
                "blacklist_id LIKE '%" + key + "%' OR blacklist_reason LIKE '%" + key + "%'" +
                "OR customer_name LIKE '%" + key + "%'";
        ArrayList<HashMap> all = db.queryRows(sql);
        for (HashMap t : all) {
            String no = (String) t.get("blacklist_id");
            String name = (String) t.get("customer_name");
            String re = (String) t.get("blacklist_reason");
            customer.add(new DAOblacklistC(no, re));
        }
        dbDisConnect();
        return customer;
    }

    public ArrayList<DAOblacklistS> getBlacklistS(JTextField tfSearch) {
        dbConnect();
        ArrayList<DAOblacklistS> supplier = new ArrayList<DAOblacklistS>();
        String key = (String) tfSearch.getText();
        if(!checkInjection(key)){
            dbDisConnect();
            return supplier;
        }
        String sql = "SELECT blacklist_id, supplier_name, blacklist_reason " +
                "FROM `SE-blacklistS`, `SE-supplier`" +
                "WHERE  WHERE blacklist_id = supplier_name AND " +
                "blacklist_id LIKE '%" + key + "%' OR blacklist_reason LIKE '%" + key + "%'" +
                "OR supplier_name LIKE '%" + key + "%'";
        ArrayList<HashMap> all = db.queryRows(sql);
        for (HashMap t : all) {
            String no = (String) t.get("blacklist_id");
            String name = (String) t.get("customer_name");
            String re = (String) t.get("blacklist_reason");
            supplier.add(new DAOblacklistS(no, re));
        }
        dbDisConnect();
        return supplier;
    }

    public String[] itemCombo() {
        dbConnect();
        String sql = "select product_name from `SE-product`";
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] item = new String[all.size()+1];
        int i = 1;
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            item[i++] = name;
        }
        dbDisConnect();

        return item;
    }

    public String[] retailerCombo() {
        dbConnect();
        String sql = "select supplier_name from `SE-supplier`";
        System.out.println(sql);
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] supplier = new String[all.size()];
        int i = 0;
        for (HashMap t : all) {
            String name = (String) t.get("supplier_name");
            supplier[i++] = name;
        }
        dbDisConnect();

        return supplier;
    }
    
    public boolean checkInjection(String check){
        String pattern = "^(((select)|(insert)|(update)|(delete))\\s+\\w+)|(select\\s*\\*\\s*\\w*)";
        check = check.toLowerCase().trim();
        if(check.matches(pattern)) return false;
        else{
            return true;
        }
    }

    public String getSupplierNameByID(int id) {
        String supplierName = "";
        dbConnect();
        String sql = "select supplier_name from `SE-supplier` where supplier_id = " + id;
        ArrayList<HashMap> all = db.queryRows(sql);
        for (HashMap t : all) {
            supplierName = (String) t.get("supplier_name");
        }
        dbDisConnect();
        return supplierName;
    }

}
