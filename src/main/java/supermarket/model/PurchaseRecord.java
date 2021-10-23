package supermarket.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PurchaseRecord
{
    private Integer purchaseId;
    private Integer staffId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date purchaseDate;
    private Integer goodsId;
    private Float price;
    private Integer amount;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
