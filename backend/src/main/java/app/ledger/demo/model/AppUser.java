package app.ledger.demo.model;

import javax.persistence.*;

public class AppUser {

    String userId;
    String username;
    String password;
    String confirmPassword;

    public AppUser() {

    }

    public AppUser(String userId, String userName) {
        this.userId = userId;
        this.username = userName;
    }

    public AppUser(String userId, String userName, String encryptedPassword) {
        this.userId = userId;
        this.username = userName;
        this.password = encryptedPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return this.username + "/" + this.password;
    }

}
