package supermarket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class purchaseDto {
    private Integer purchaseId;
    private String goods;
    private float price;
    private Integer amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;
    private Integer staffId;

    public purchaseDto(Integer purchaseId, String goods, Float price, Integer amount, Date purchaseDate, Integer staffId) {
        this.purchaseId=purchaseId;
        this.goods = goods;
        this.price = price;
        this.amount = amount;
        this.date = purchaseDate;
        this.staffId = staffId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}

