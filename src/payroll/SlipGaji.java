package payroll;

import java.math.BigDecimal;

/**
 *
 * @author Bhagaskara
 */
public class SlipGaji {
    private String item;
    private String nama;
    private Integer quantity;
    private Integer unitprice;

    public SlipGaji(String item, String nama, Integer quantity, Integer unitprice) {
        this.item = item;
        this.nama = nama;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

    
    
    
}
