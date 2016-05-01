package athens_stock.model;

import java.awt.*;

/**
 * Created by Chayut on 01-May-16.
 */
public class DAOproduct {
    private String name;
    private String type;
    private String locate;
    private int supplierId;
    private int amount;
    private double price;

    public DAOproduct(String name, String type, String locate, int supplierId, int amount, double price) {
        this.name = name;
        this.type = type;
        this.locate = locate;
        this.supplierId = supplierId;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
