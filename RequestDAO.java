package dao;

import java.sql.*;
import database.DBConnection;
public class RequestDAO {
	
	public boolean sendRequest(int foodId, int orgId) {

	    String query =
	        "INSERT INTO collection_request(food_id, org_id, status) VALUES (?, ?, 'PENDING')";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(query);

	        pstmt.setInt(1, foodId);
	        pstmt.setInt(2, orgId);

	        int rows = pstmt.executeUpdate();

	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}
	
	public ResultSet getDonorRequests(int donorId) {

	    String query =
	        "SELECT fr.request_id, f.food_name, o.org_name, fr.status " +
	        "FROM collection_request fr " +
	        "JOIN food f ON fr.food_id = f.food_id " +
	        "JOIN organization o ON fr.org_id = o.org_id " +
	        "WHERE f.donor_id = ?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(query);

	        pstmt.setInt(1, donorId);

	        return pstmt.executeQuery();

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return null;
	}
	
	public boolean acceptRequest(int requestId, int foodId) {

	    try {

	        Connection con = DBConnection.getConnection();


	        String requestQuery =
	            "UPDATE collection_request SET status='ACCEPTED' " +
	            "WHERE request_id=?";


	        PreparedStatement p1 =
	                con.prepareStatement(requestQuery);

	        p1.setInt(1, requestId);

	        p1.executeUpdate();


	        String foodQuery =
	            "UPDATE food SET status='RESERVED' " +
	            "WHERE food_id=?";


	        PreparedStatement p2 =
	                con.prepareStatement(foodQuery);

	        p2.setInt(1, foodId);


	        int rows = p2.executeUpdate();


	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}
	
	public boolean rejectRequest(int requestId) {

	    String query =
	        "UPDATE collection_request SET status='REJECTED' " +
	        "WHERE request_id=?";


	    try {

	        Connection con =
	                DBConnection.getConnection();


	        PreparedStatement pstmt =
	                con.prepareStatement(query);


	        pstmt.setInt(1, requestId);


	        int rows = pstmt.executeUpdate();


	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}

	public ResultSet getOrganizationRequests(int orgId) {

	    String query =
	        "SELECT f.food_id, f.food_name, fr.status " +
	        "FROM collection_request fr " +
	        "JOIN food f ON fr.food_id = f.food_id " +
	        "WHERE fr.org_id = ?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(query);

	        pstmt.setInt(1, orgId);

	        return pstmt.executeQuery();

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return null;
	}
	
	public ResultSet getApprovedFoods(int orgId) {

	    String query =
	        "SELECT f.food_id, f.food_name, f.status " +
	        "FROM collection_request fr " +
	        "JOIN food f ON fr.food_id = f.food_id " +
	        "WHERE fr.org_id = ? AND fr.status = 'ACCEPTED'";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(query);

	        pstmt.setInt(1, orgId);

	        return pstmt.executeQuery();

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return null;
	}
}
