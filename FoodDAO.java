package dao;

import database.DBConnection;
import model.Food;

import java.sql.*;

public class FoodDAO {
	public boolean addFood(Food food) {

	    String query = "INSERT INTO food "
	            + "(donor_id, food_name, category, food_type, quantity, unit, "
	            + "preparation_time, expiry_time, address, city, pincode, status) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(query);


	        pstmt.setInt(1, food.getDonorId());

	        pstmt.setString(2, food.getFoodName());

	        pstmt.setString(3, food.getCategory());

	        pstmt.setString(4, food.getFoodType());

	        pstmt.setInt(5, food.getQuantity());

	        pstmt.setString(6, food.getUnit());

	        pstmt.setTimestamp(7, food.getPreparationTime());

	        pstmt.setTimestamp(8, food.getExpiryTime());

	        pstmt.setString(9, food.getAddress());

	        pstmt.setString(10, food.getCity());

	        pstmt.setString(11, food.getPincode());

	        // Default status
	        pstmt.setString(12, "AVAILABLE");


	        int rows = pstmt.executeUpdate();


	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }


	    return false;
	}
	
	public ResultSet getDonorFoods(int donorId) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	            "SELECT food_name, category, quantity, unit, expiry_time, status "
	          + "FROM food WHERE donor_id = ?";

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
	
	public ResultSet getAvailableFood() {

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	            "SELECT food_id, food_name, quantity, unit, city, expiry_time, status "
	          + "FROM food WHERE status = 'AVAILABLE'";


	        PreparedStatement pstmt =
	                con.prepareStatement(query);


	        return pstmt.executeQuery();

	    }

	    catch(Exception e) {

	        e.printStackTrace();

	    }

	    return null;
	}
	
	public boolean markCollected(int foodId) {

	    String query =
	        "UPDATE food SET status='COLLECTED' WHERE food_id=?";

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(query);

	        pstmt.setInt(1, foodId);

	        return pstmt.executeUpdate() > 0;

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	
	public void checkExpiredFood() {

	    try {

	        Connection con = DBConnection.getConnection();


	        // Find all expired available foods
	        String selectQuery =
	            "SELECT food_id, quantity " +
	            "FROM food " +
	            "WHERE expiry_time < NOW() " +
	            "AND status IN ('AVAILABLE', 'RESERVED', 'COLLECTED')";


	        PreparedStatement selectStmt =
	                con.prepareStatement(selectQuery);

	        ResultSet rs =
	                selectStmt.executeQuery();


	        while(rs.next()) {


	            int foodId = rs.getInt("food_id");

	            int quantity =
	                    rs.getInt("quantity");


	            System.out.println(
	                "Expired food found: " + foodId
	            );


	            // Update food status
	            String updateFood =
	            		"UPDATE food SET status='EXPIRED' WHERE food_id=?";

	            PreparedStatement updateStmt =
	                    con.prepareStatement(updateFood);


	            updateStmt.setInt(1, foodId);


	            updateStmt.executeUpdate();


	            // Add entry into waste_management
	            String wasteQuery =
	            	    "INSERT INTO food_waste " +
	            	    "(food_id, waste_quantity, reason, waste_date) " +
	            	    "VALUES (?, ?, ?, NOW())";

	            PreparedStatement wasteStmt =
	                    con.prepareStatement(wasteQuery);


	            wasteStmt.setInt(1, foodId);

	            wasteStmt.setInt(
	                    2,
	                    quantity
	            );


	            wasteStmt.setString(
	                    3,
	                    "Food expired automatically"
	            );


	            int rows = wasteStmt.executeUpdate();

	            System.out.println(
	                "Waste inserted rows: " + rows
	            );

	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	}
	
	public ResultSet getAllFood() {

	    String query =
	            "SELECT * FROM food";

	    try {

	        Connection con =
	                DBConnection.getConnection();


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