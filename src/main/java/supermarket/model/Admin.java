package supermarket.model;

import java.util.Date;

public class Admin {
    private Integer adminID;
    private String adminName;
    private String adminPassword;
    //private String token;
    private Date createTime;

    public Integer getAdminID(){
        return adminID;
    }
    public String getAdminName(){
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    /*public String getToken() {
        return token;
    }*/

    public Date getCreateTime() {
        return createTime;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /*
    public void setToken(String token) {
        this.token = token;
    }
    */

    Admin(Integer adminID, String adminPassword, String adminName, Date createTime)
    {
        this.adminID=adminID;
        this.adminPassword=adminPassword;
        this.adminName=adminName;
        this.createTime=createTime;
        //this.token=token;
    }

}
