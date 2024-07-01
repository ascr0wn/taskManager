package model;

public class Registration {
    private long phoneNum;
    private String name;
    private String email;
    private String password;

    public Registration() {

    }

    public Registration(long phoneNum, String name, String email, String password) {
        this.phoneNum = phoneNum;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
