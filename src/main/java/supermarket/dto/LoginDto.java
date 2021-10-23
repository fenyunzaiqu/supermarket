package supermarket.dto;

public class LoginDto {
    private String token;
    private String userName;

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
