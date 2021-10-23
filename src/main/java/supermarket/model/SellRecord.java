package supermarket.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.NonNull;
import java.util.Date;
public class SellRecord {
    private Integer sellId;
    @NonNull
    private Integer staffId;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sellDate;

    public SellRecord(Integer sellId, int staffId, Date sellDate) {
        this.sellId=sellId;
        this.staffId=staffId;
        this.sellDate=sellDate;
    }

    public Integer getSellId() {
        return sellId;
    }

    @NonNull
    public Integer getStaffId() {
        return staffId;
    }

    @NonNull
    public Date getSellDate() {
        return sellDate;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public void setStaffId(@NonNull Integer staffId) {
        this.staffId = staffId;
    }

    public void setSellDate(@NonNull Date sellDate) {
        this.sellDate = sellDate;
    }
}
