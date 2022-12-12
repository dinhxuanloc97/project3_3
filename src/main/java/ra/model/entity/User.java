package ra.model.entity;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private boolean userStatus;
    private boolean permisson = false;

    public User() {
    }

    public User(int userId, String userName, String password, String fullName, String address, String email, String phoneNumber, Date dateOfBirth, boolean userStatus, boolean permisson) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.userStatus = userStatus;
        this.permisson = permisson;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isPermisson() {
        return permisson;
    }

    public void setPermisson(boolean permisson) {
        this.permisson = permisson;
    }
}
