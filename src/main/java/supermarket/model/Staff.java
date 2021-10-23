package supermarket.model;
import org.springframework.lang.NonNull;
public class Staff {
    private Integer staffId;
    private String staffName;
    @NonNull
    private String identity;
    @NonNull
    private String staffPhone;
    private String sex;
    private String password;
    private Character staffStatus;

    public Integer getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    @NonNull
    public String getIdentity() {
        return identity;
    }

    @NonNull
    public String getStaffPhone() {
        return staffPhone;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public Character getStaffStatus() {
        return staffStatus;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setIdentity(@NonNull String identity) {
        this.identity = identity;
    }

    public void setStaffPhone(@NonNull String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStaffStatus(Character staffStatus) {
        this.staffStatus = staffStatus;
    }
}

