package athens_stock.model;

/**
 * Created by Chayut on 01-May-16.
 */
public class DAOblacklist {
    private String id;
    private String reason;

    public DAOblacklist(String id, String reason) {
        this.id = id;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
