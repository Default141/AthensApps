/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.model;

import edu.sit.cs.db.CSDbDelegate;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

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

    public void addCustomer(JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        dbConnect();
        String addCus = "INSERT INTO SE-customer(customer_name, customer_address,customer_phone)"
                + "VALUES('" + tfName.getText() + "'" + "," + "'"
                + tfAddr.getText() + "'" + "," + "'" + tfPhone.getText()
                + "'" + ")";
        dbExecuteQuery(addCus);
        dbDisConnect();
    }

    public ArrayList<DAOsupplier> getAllSupplier(JTextField tfSearch) {
        dbConnect();
        String key = (String) tfSearch.getText();
        String re = "SELECT * FROM SE-supplier WHERE suppilier_id LIKE '%" + key + "%' OR supplier_name LIKE '%" + key + "%' OR "
                + "supplier_phone LIKE '%" + key + "%' OR supplier_status LIKE '%" + key + "%' OR supplier_address LIKE '%"
                + key + "%'";
        ArrayList<DAOsupplier> supplier = new ArrayList<DAOsupplier>();
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
        dbConnect();
        String key = (String) tfSearch.getText();
        String re = "SELECT * FROM SE-customer WHERE customer_id LIKE '%" + key + "%' OR customer_name LIKE '%" + key + "%' OR "
                + "customer_phone LIKE '%" + key + "%' OR customer_status LIKE '%" + key + "%' OR customer_address LIKE '%"
                + key + "%'";
        ArrayList<DAOcustomer> customer = new ArrayList<DAOcustomer>();
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

    public ArrayList<DAOcustomer> getStock(JTextField tfSearch) {
        dbConnect();
        String key = (String) tfSearch.getText();
        String re = "SELECT * FROM SE-product WHERE product_id LIKE '%" + key + "%' OR product_name LIKE '%" + key + "%' OR "
                + "product_phone LIKE '%" + key + "%' OR product_status LIKE '%" + key + "%' OR product_address LIKE '%"
                + key + "%'";
        ArrayList<DAOcustomer> customer = new ArrayList<DAOcustomer>();
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String no = (String) t.get("product_id");
            String name = (String) t.get("product_name");
            String supName = (String) t.get("product_supplier_id");
            String amount = (String) t.get("product_amount");
            String price = (String) t.get("product_price");
            customer.add(new DAOcustomer(no, name, supName, amount, price));
        }
        dbDisConnect();
        return customer;
        //dont forget to change supid to supname
    }

    public ArrayList<DAOblacklistC> getBlacklistC(JTextField tfSearch) {
        dbConnect();
        String key = (String) tfSearch.getText();
        String sql = "SELECT blacklist_id, customer_name, blacklist_reason " +
                "FROM `SE-blacklistC`, `SE-customer`" +
                "WHERE  WHERE blacklist_id = customer_id AND " +
                "blacklist_id LIKE '%" + key + "%' OR blacklist_reason LIKE '%" + key + "%'" +
                "OR customer_name LIKE '%" + key + "%'";
        ArrayList<DAOblacklistC> customer = new ArrayList<DAOblacklistC>();
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
        String key = (String) tfSearch.getText();
        String sql = "SELECT blacklist_id, supplier_name, blacklist_reason " +
                "FROM `SE-blacklistS`, `SE-supplier`" +
                "WHERE  WHERE blacklist_id = supplier_name AND " +
                "blacklist_id LIKE '%" + key + "%' OR blacklist_reason LIKE '%" + key + "%'" +
                "OR supplier_name LIKE '%" + key + "%'";
        ArrayList<DAOblacklistS> supplier = new ArrayList<DAOblacklistS>();
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
        System.out.println(sql);
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] item = new String[all.size()];
        int i = 0;
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            item[i++] = name;
        }
        dbDisConnect();

        return item;
    }

    public String[] selectRetailer() {
        dbConnect();
        String sql = "select supplier_name from `SE-suppiler`";
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

}
