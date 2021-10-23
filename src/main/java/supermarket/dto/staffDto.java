package supermarket.dto;

public class staffDto {
    private String name;
    private String sex;
    private String identity;
    private String phoneNum;
    private String workState;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getIdentity() {
        return identity;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getWorkState() {
        return workState;
    }

    staffDto(){
        this.name=null;
        this.sex=null;
        this.identity=null;
        this.phoneNum=null;
        this.workState=null;
    }

    staffDto(String name,String sex,String identity,String phoneNum,String workState){
        this.name=name;
        this.sex=sex;
        this.identity=identity;
        this.phoneNum=phoneNum;
        this.workState=workState;
    }
}
