package model;

import java.sql.Timestamp;

public class Notification {


    private int notificationId;

    private String userType;

    private int userId;

    private String message;

    private String status;

    private Timestamp createdAt;


    // Getters and Setters


    public int getNotificationId() {
        return notificationId;
    }


    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }


    public String getUserType() {
        return userType;
    }


    public void setUserType(String userType) {
        this.userType = userType;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}