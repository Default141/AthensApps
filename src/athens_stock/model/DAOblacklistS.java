/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athens_stock.model;

/**
 *
 * @author lullaby
 */
public class DAOblacklistS {
    private String id;
    private String reason;
    
    public DAOblacklistS(String id, String reason){
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
