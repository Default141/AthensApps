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
        if (!checkInjection(key)) {
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
        String key = tfSearch.getText();
        if (!checkInjection(key)) {
            dbDisConnect();
            return customer;
        }
        String re = "SELECT * FROM `SE-customer` WHERE `customer_id` LIKE '%" + key + "%' OR customer_name LIKE '%" + key + "%' OR "
                + "customer_phone LIKE '%" + key + "%' OR customer_status LIKE '%" + key + "%' OR customer_address LIKE '%"
                + key + "%'";
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String id = (String) t.get("customer_id");
            String name = (String) t.get("customer_name");
            String phone = (String) t.get("customer_phone");
            String status = (String) t.get("customer_status");
            String address = (String) t.get("customer_address");
            customer.add(new DAOcustomer(id, name, address, phone, status));
        }
        dbDisConnect();
        return customer;
    }

    public ArrayList<DAOorder> getAllOrder() {
        ArrayList<DAOorder> order = new ArrayList<DAOorder>();
        dbConnect();
        String sql = "SELECT * FROM `SE-order` WHERE status = 'waiting'";

        ArrayList<HashMap> all = db.queryRows(sql);
        for (HashMap t : all) {
            int id = Integer.parseInt((String) t.get("order_id"));
            String name = (String) t.get("order_name");
            String cusid = (String) t.get("customer_id");
            int amount = Integer.parseInt((String) t.get("order_amount"));
            String status = (String) t.get("status");
            order.add(new DAOorder(id, name, cusid, amount, status));
        }
        dbDisConnect();
        return order;
    }

    public void addSupplier(JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        dbConnect();
        String name = tfName.getText();
        String address = tfAddr.getText();
        String phone = tfPhone.getText();
        if (!(checkInjection(name) && checkInjection(address) && checkInjection(phone))) {
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
    
    public int getAmoumt(JComboBox<String> cbbItem1){
        if(cbbItem1.getSelectedItem() == null) return 0;
        dbConnect();
        String sql = "SELECT * FROM `SE-product` WHERE product_name = '"+ (String)cbbItem1.getSelectedItem()+"'";
        ArrayList<HashMap> temp = db.queryRows(sql);
        System.out.println(temp.size());
        HashMap t = temp.get(0);
        System.out.println((String)t.get("product_amount"));
        int amount = Integer.parseInt((String)(t.get("product_amount")));
        dbDisConnect();
        return amount;
        
    }

    public boolean addProduct(JTextField tfName, JTextField tfType, JTextField tfLocate, JComboBox cbbSupplier,
                           JTextField tfAmount, JTextField tfPrice) {
        String name = tfName.getText();
        String type = tfType.getText();
        String locate = tfLocate.getText();
        String amount = tfAmount.getText();
        String price = tfPrice.getText();


        if (name.equals("") || type.equals("") || locate.equals("") || amount.equals("") ||
                price.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all data.", "Message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (!(checkInjection(name) && checkInjection(type) && checkInjection(locate) &&
                checkInjection(amount) && checkInjection(price))) {
            return false;
        }
        if(!(amount.matches("\\d+") && price.matches("\\d+"))){
            JOptionPane.showMessageDialog(null, "Incorrect data.", "Message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        String supplierID = ((String) cbbSupplier.getSelectedItem()).substring(0,1);
//INSERT INTO `SE-product`(`product_id`, `product_name`, `product_type`, `product_locate`, `product_supplier_id`, `product_amount`, `product_price`, `product_status`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
        dbConnect();
        String sql = "INSERT INTO `SE-product`(`product_name`, `product_type`, `product_locate`, `product_supplier_id`, `product_amount`, `product_price`) VALUES ('" +
                name + "', '" + type + "', '" + locate + "', '" + supplierID + "', '" + amount + "', '" + price + "')";
        dbExecuteQuery(sql);
        dbDisConnect();
        return true;
    }

    public boolean addOrderItem(JComboBox<String> cbbItem1, JComboBox<String> cbbItem2, JComboBox<String> cbbItem3, JComboBox<String> cbbItem4,
                                JComboBox<String> cbbcus, JSpinner spItem1, JSpinner spItem2, JSpinner spItem3, JSpinner spItem4) {
        dbConnect();

        String item1 = (String) cbbItem1.getSelectedItem();
        String item2 = (String) cbbItem2.getSelectedItem();
        String item3 = (String) cbbItem3.getSelectedItem();
        String item4 = (String) cbbItem4.getSelectedItem();
        String customerID = (String) cbbcus.getSelectedItem();
        String status = "waiting";

        int success = 0;
        int amount1 = (Integer) spItem1.getValue();
        int amount2 = (Integer) spItem2.getValue();
        int amount3 = (Integer) spItem3.getValue();
        int amount4 = (Integer) spItem4.getValue();
        if (customerID == null) {
            JOptionPane.showMessageDialog(null, "Please select Customer ID", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

        if (item1 != null) {
            String sql = "INSERT INTO `SE-order`(order_name, order_amount,status, customer_id) " +
                    "VALUES ('" + item1 + "', '" + amount1 + "' , '" + status + "' , '" + customerID + "')";
            System.out.println("item1");
            dbExecuteQuery(sql);
            success++;
        }

        if (item2 != null) {
            String sql = "INSERT INTO `SE-order`(order_name, order_amount,status, customer_id) " +
                    "VALUES ('" + item2 + "', '" + amount2 + "' , '" + status + "' , '" + customerID + "')";
            System.out.println("item2");
            dbExecuteQuery(sql);
            success++;
        }

        if (item3 != null) {
            String sql = "INSERT INTO `SE-order`(order_name, order_amount,status, customer_id) " +
                    "VALUES ('" + item3 + "', '" + amount3 + "' , '" + status + "' , '" + customerID + "')";
            System.out.println("item3");
            dbExecuteQuery(sql);
            success++;
        }

        if (item4 != null) {
            String sql = "INSERT INTO `SE-order`(order_name, order_amount,status, customer_id) " +
                    "VALUES ('" + item4 + "', '" + amount4 + "' , '" + status + "' , '" + customerID + "')";
            System.out.println("item4");
            dbExecuteQuery(sql);
            success++;
        }
        dbDisConnect();
        if (success > 0) return true;
        else return false;
    }

    public ArrayList<DAOproduct> getStock(JTextField tfSearch, String ptype) {
        dbConnect();
        ArrayList<DAOproduct> product = new ArrayList<DAOproduct>();
        String key = (String) tfSearch.getText().trim();
        if (!checkInjection(key)) {
            dbDisConnect();
            return product;
        }
        String re;
        if (key.length() > 0) {
            re = "SELECT * FROM `SE-product` WHERE product_type = '" + ptype + "' and (product_id LIKE '%" + key + "%' OR product_name LIKE '%" + key + "%' OR "
                    + "product_status LIKE '%" + key + "%' OR product_locate LIKE '%"
                    + key + "%')";
        } else {
            re = "SELECT * FROM `SE-product` WHERE product_type = '" + ptype + "'";
        }
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            String type = (String) t.get("product_type");
            String locate = (String) t.get("product_locate");
            int supplierId = Integer.parseInt(t.get("product_supplier_id") + "");
            int amount = Integer.parseInt(t.get("product_amount") + "");
            double price = Double.parseDouble(t.get("product_price") + "");
            product.add(new DAOproduct(name, type, locate, supplierId, amount, price));
        }

        dbDisConnect();
        return product;
        //dont forget to change supid to supname
    }

    public ArrayList<DAOproduct> getStockWareHouse(JTextField tfSearch, String ptype) {
        dbConnect();
        ArrayList<DAOproduct> product = new ArrayList<DAOproduct>();
        String key = (String) tfSearch.getText().trim();
        if (!checkInjection(key)) {
            dbDisConnect();
            return product;
        }
        String re;
        if (key.length() > 0) {
            re = "SELECT * FROM `SE-product` WHERE product_type = '" + ptype + "' and (product_name LIKE '%" + key + "%')";
        } else {
            re = "SELECT * FROM `SE-product` WHERE product_type = '" + ptype + "'";
        }
        ArrayList<HashMap> all = db.queryRows(re);
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            String type = (String) t.get("product_type");
            String locate = (String) t.get("product_locate");
            int supplierId = Integer.parseInt(t.get("product_supplier_id") + "");
            int amount = Integer.parseInt(t.get("product_amount") + "");
            double price = Double.parseDouble(t.get("product_price") + "");
            product.add(new DAOproduct(name, type, locate, supplierId, amount, price));
        }

        dbDisConnect();
        return product;
        //dont forget to change supid to supname
    }

    public boolean addCustomer(JTextField tfName, JTextField tfAddr, JTextField tfPhone) {
        dbConnect();
        String name = tfName.getText();
        String address = tfAddr.getText();
        String phone = tfPhone.getText();
        if (!(checkInjection(name) && checkInjection(address) && checkInjection(phone))) {
            dbDisConnect();
            return false;
        }
        String addCus = "INSERT INTO `SE-customer`(`customer_id`, `customer_name`, `customer_address`, `customer_phone`, `customer_status`)"
                + " VALUES ('" + customerIdGenerator() + "', '" + name + "', '"
                + address + "', '" + phone + "' , 'active')";
        dbExecuteQuery(addCus);
        dbDisConnect();
        return true;
    }

    public String customerIdGenerator() {

        String cusId = "";
        String sql = "SELECT MAX(id) AS MAX FROM `SE-customer`";
        ArrayList<HashMap> log = db.queryRows(sql);
        for (HashMap l : log) {
            try {
                int id = Integer.parseInt((String) l.get("MAX")) + 1;
                cusId = "c" + id;
            } catch (NumberFormatException er) {

            }
        }

        return cusId;
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
        if (!checkInjection(key)) {
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
        if (!checkInjection(key)) {
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
        String[] item = new String[all.size() + 1];
        int i = 1;
        for (HashMap t : all) {
            String name = (String) t.get("product_name");
            item[i++] = name;
        }
        dbDisConnect();

        return item;
    }

    public String[] supCombo() {
        dbConnect();
        String sql = "select `id`, `supplier_name` from `SE-supplier`";
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] sup = new String[all.size() + 1];
        int i = 1;
        for (HashMap t : all) {
            String id = (String) t.get("id");
            String name = (String) t.get("supplier_name");
            sup[i++] = id + " - " +name;
        }
        dbDisConnect();

        return sup;
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

    public boolean checkInjection(String check) {
        String pattern = "^(((select)|(insert)|(update)|(delete))\\s+\\w+)|(select\\s*\\*\\s*\\w*)";
        check = check.toLowerCase().trim();
        if (check.matches(pattern)) return false;
        else {
            return true;
        }
    }

    public String getSupplierNameByID(int id) {
        String supplierName = "";
        dbConnect();
        String sql = "select supplier_name from `SE-supplier` where id = " + id;
        ArrayList<HashMap> all = db.queryRows(sql);
        for (HashMap t : all) {
            supplierName = (String) t.get("supplier_name");
        }
        dbDisConnect();
        return supplierName;
    }

    public String[] customerIDCombo() {
        dbConnect();
        String sql = "select customer_id from `SE-customer`";
        ArrayList<HashMap> all = db.queryRows(sql);
        String[] item = new String[all.size() + 1];
        int i = 1;
        for (HashMap t : all) {
            String name = (String) t.get("customer_id");
            item[i++] = name;
        }
        dbDisConnect();

        return item;
    }

    private int getAmount(String name) {
        int amount = 0;
        String sql = "select `product_amount` from `SE-product` where `product_name`='" + name + "'";
        ArrayList<HashMap> all = db.queryRows(sql);
        int i = 1;
        for (HashMap t : all) {
            amount = Integer.parseInt((String) t.get("product_amount"));
            i++;
        }
        return amount;
    }

    public void deliver(int orderId, int amount, String product) {
        dbConnect();

        String sql = "UPDATE `SE-order` SET `status`= 'delivered' WHERE `order_id`= " + orderId;
        dbExecuteQuery(sql);

        amount = getAmount(product)-amount;

        sql = "UPDATE `SE-product` SET `product_amount`=" + amount + " WHERE `product_name`='" +product + "'";
        System.out.println(sql);
        dbExecuteQuery(sql);
        dbDisConnect();
    }

    public void cancelOrder(int orderId) {
        dbConnect();

        String sql = "UPDATE `SE-order` SET `status`= 'cancel' WHERE `order_id`= " + orderId;
        dbExecuteQuery(sql);


        dbDisConnect();
    }
    
    public void updateAmount(int amount, JComboBox<String> cbbItem1) {
        dbConnect();

        String sql = "UPDATE `SE-product` SET `product_amount`= '"+amount +"' WHERE `product_name`= '" + (String)cbbItem1.getSelectedItem()+"'";
        dbExecuteQuery(sql);

        dbDisConnect();
    }
}
