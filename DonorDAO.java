package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Donor;

import java.sql.*;

public class DonorDAO {
	public boolean registerDonor(Donor donor) {

	    String checkQuery = 
	        "SELECT email FROM donor WHERE email = ?";

	    String insertQuery =
	        "INSERT INTO donor(name,email,phone,address,city,pincode,password) VALUES(?,?,?,?,?,?,?)";


	    try {
	        Connection con = DBConnection.getConnection();

	        // Email check
	        PreparedStatement checkStmt =
	            con.prepareStatement(checkQuery);

	        checkStmt.setString(1, donor.getEmail());

	        ResultSet rs = checkStmt.executeQuery();

	        if(rs.next()) {
	            return false;
	        }


	        // Register donor
	        PreparedStatement pstmt =
	            con.prepareStatement(insertQuery);

	        pstmt.setString(1, donor.getName());
	        pstmt.setString(2, donor.getEmail());
	        pstmt.setString(3, donor.getPhone());
	        pstmt.setString(4, donor.getAddress());
	        pstmt.setString(5, donor.getCity());
	        pstmt.setString(6, donor.getPincode());
	        pstmt.setString(7, donor.getPassword());


	        int rows = pstmt.executeUpdate();

	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}
	
	public Donor loginDonor(String email, String password) {

	    String query =
	        "SELECT * FROM donor WHERE email=? AND password=?";


	    try {

	        Connection con =
	            DBConnection.getConnection();

	        PreparedStatement pstmt =
	            con.prepareStatement(query);


	        pstmt.setString(1, email);
	        pstmt.setString(2, password);


	        ResultSet rs =
	            pstmt.executeQuery();


	        if(rs.next()) {

	            Donor donor = new Donor();

	            donor.setDonorId(
	                rs.getInt("donor_id")
	            );

	            donor.setName(
	                rs.getString("name")
	            );

	            donor.setEmail(
	                rs.getString("email")
	            );

	            donor.setPhone(
	                rs.getString("phone")
	            );

	            donor.setAddress(
	                rs.getString("address")
	            );

	            donor.setCity(
	                rs.getString("city")
	            );

	            donor.setPincode(
	                rs.getString("pincode")
	            );


	            return donor;
	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
	public Donor getDonorById(int id) {

	    String query =
	        "SELECT * FROM donor WHERE donor_id=?";


	    try {

	        Connection con =
	            DBConnection.getConnection();


	        PreparedStatement pstmt =
	            con.prepareStatement(query);

	        pstmt.setInt(1, id);


	        ResultSet rs =
	            pstmt.executeQuery();


	        if(rs.next()) {

	            Donor donor = new Donor();

	            donor.setDonorId(
	                rs.getInt("donor_id")
	            );

	            donor.setName(
	                rs.getString("name")
	            );

	            donor.setEmail(
	                rs.getString("email")
	            );

	            donor.setPhone(
	                rs.getString("phone")
	            );

	            donor.setAddress(
	                rs.getString("address")
	            );

	            donor.setCity(
	                rs.getString("city")
	            );

	            donor.setPincode(
	                rs.getString("pincode")
	            );


	            return donor;
	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
	public ResultSet getAllDonors() {

	    String query =
	        "SELECT * FROM donor";

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