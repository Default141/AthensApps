package athens_stock.model;

/**
 * Created by Chayut on 01-May-16.
 */
public class DAOorder {
    private int id;
    private String name;
    private int customerId;
    private int amount;
    private double price;
    private String date;

    public DAOorder(int id, String name, int customerId, int amount, double price, String date) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
