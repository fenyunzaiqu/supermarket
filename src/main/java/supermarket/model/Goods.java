package supermarket.model;
import org.springframework.lang.NonNull;

public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String brand;
    @NonNull
    private Float price;
    private Integer amount;
    private Character goodStatus;//状态
    private String unit;//单位

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getBrand() {
        return brand;
    }

    @NonNull
    public Float getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public Character getGoodStatus() {
        return goodStatus;
    }

    public String getUnit() {
        return unit;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(@NonNull Float price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
