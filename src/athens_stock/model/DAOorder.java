package athens_stock.model;

/**
 * Created by Chayut on 01-May-16.
 */
public class DAOorder {
    private int id;
    private String name;
    private String  customerId;
    private int amount;
    private double price;
    private String date;
    private String status;

    public DAOorder(int id, String name, String customerId, int amount, String status) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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
