package dao;

import database.DBConnection;
import model.Admin;

import java.sql.*;

public class AdminDAO {
	public Admin loginAdmin(String username, String password) {

	    String query =
	        "SELECT * FROM admin WHERE username=? AND password=?";


	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	            con.prepareStatement(query);


	        pstmt.setString(1, username);
	        pstmt.setString(2, password);


	        ResultSet rs = pstmt.executeQuery();


	        if(rs.next()) {

	            Admin admin = new Admin();


	            admin.setAdminId(
	                rs.getInt("admin_id")
	            );

	            admin.setUsername(
	                rs.getString("username")
	            );

	            admin.setPassword(
	                rs.getString("password")
	            );


	            return admin;
	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
	// Generic Count Method
	public int getCount(String query) {

	    int count = 0;

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(query);


	        ResultSet rs =
	                pstmt.executeQuery();


	        if(rs.next()) {

	            count = rs.getInt(1);

	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return count;
	}


	// Total Donors
	public int getTotalDonors() {

	    return getCount(
	        "SELECT COUNT(*) FROM donor"
	    );

	}


	// Total Organizations
	public int getTotalOrganizations() {

	    return getCount(
	        "SELECT COUNT(*) FROM organization"
	    );

	}


	// Total Food Donations
	public int getTotalFood() {

	    return getCount(
	        "SELECT COUNT(*) FROM food"
	    );

	}


	// Available Food
	public int getAvailableFood() {

	    return getCount(
	        "SELECT COUNT(*) FROM food WHERE status='AVAILABLE'"
	    );

	}


	// Collected Food
	public int getCollectedFood() {

	    return getCount(
	        "SELECT COUNT(*) FROM food WHERE status='COLLECTED'"
	    );

	}


	// Distributed Food
	public int getDistributedFood() {

	    return getCount(
	        "SELECT COUNT(*) FROM food WHERE status='DISTRIBUTED'"
	    );

	}


	// Expired Food
	public int getExpiredFood() {

	    return getCount(
	        "SELECT COUNT(*) FROM food WHERE status='EXPIRED'"
	    );

	}


	// Total Waste Records
	public int getTotalWaste() {

	    return getCount(
	        "SELECT COUNT(*) FROM waste_management"
	    );

	}
}