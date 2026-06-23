package dao;

import database.DBConnection;
import model.Notification;

import java.sql.*;


public class NotificationDAO {


    // Add Notification
    public boolean addNotification(Notification notification) {

        String query =
            "INSERT INTO notification " +
            "(user_type, user_id, message, status) " +
            "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(query);


            pstmt.setString(1,
                    notification.getUserType());

            pstmt.setInt(2,
                    notification.getUserId());

            pstmt.setString(3,
                    notification.getMessage());

            pstmt.setString(4,
                    notification.getStatus());


            int rows = pstmt.executeUpdate();


            return rows > 0;


        }
        catch(Exception e) {

            e.printStackTrace();

        }


        return false;

    }



    // View Notifications
    public ResultSet getNotifications(
            String userType,
            int userId) {


        String query =
            "SELECT * FROM notification " +
            "WHERE user_type=? AND user_id=? " +
            "ORDER BY created_at DESC";


        try {

            Connection con =
                    DBConnection.getConnection();


            PreparedStatement pstmt =
                    con.prepareStatement(query);


            pstmt.setString(1, userType);

            pstmt.setInt(2, userId);


            return pstmt.executeQuery();

        }
        catch(Exception e) {

            e.printStackTrace();

        }


        return null;

    }



    // Mark Notification as Read
    public boolean markAsRead(int notificationId) {


        String query =
            "UPDATE notification " +
            "SET status='READ' " +
            "WHERE notification_id=?";


        try {

            Connection con =
                    DBConnection.getConnection();


            PreparedStatement pstmt =
                    con.prepareStatement(query);


            pstmt.setInt(1, notificationId);


            int rows =
                    pstmt.executeUpdate();


            return rows > 0;


        }
        catch(Exception e) {

            e.printStackTrace();

        }


        return false;

    }
    
    public ResultSet getAllNotifications() {

        String query =
            "SELECT * FROM notification ORDER BY created_at DESC";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(query);

            return pstmt.executeQuery();

        } 
        catch(Exception e) {

            e.printStackTrace();

        }

        return null;
    }

}