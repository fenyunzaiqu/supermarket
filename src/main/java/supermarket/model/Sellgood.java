package supermarket.model;
import org.springframework.lang.NonNull;
public class Sellgood {
    private Integer sellId;
    private Integer goodsId;
    private Float price;
    private Integer amount;

    public Integer getSellId() {
        return sellId;
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

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
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
