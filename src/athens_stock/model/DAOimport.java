package athens_stock.model;

/**
 * Created by Chayut on 01-May-16.
 */
public class DAOimport {
    private int id;
    private String name;
    private int amount;
    private double price;
    private String date;

    public DAOimport(int id, String name, int amount, double price, String date) {
        this.id = id;
        this.name = name;
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
