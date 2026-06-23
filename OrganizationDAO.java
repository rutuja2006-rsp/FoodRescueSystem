package dao;

import database.DBConnection;
import model.Organization;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class OrganizationDAO {
	public boolean registerOrganization(Organization org) {

	    String checkQuery =
	        "SELECT email FROM organization WHERE email=?";

	    String insertQuery =
	        "INSERT INTO organization(org_name,email,phone,address,city,pincode,password) VALUES(?,?,?,?,?,?,?)";


	    try {

	        Connection con = DBConnection.getConnection();

	        // Email already exists check
	        PreparedStatement checkStmt =
	            con.prepareStatement(checkQuery);

	        checkStmt.setString(1, org.getEmail());

	        ResultSet rs = checkStmt.executeQuery();


	        if(rs.next()) {
	            return false;
	        }


	        // Insert Organization
	        PreparedStatement pstmt =
	            con.prepareStatement(insertQuery);


	        pstmt.setString(1, org.getOrgName());
	        pstmt.setString(2, org.getEmail());
	        pstmt.setString(3, org.getPhone());
	        pstmt.setString(4, org.getAddress());
	        pstmt.setString(5, org.getCity());
	        pstmt.setString(6, org.getPincode());
	        pstmt.setString(7, org.getPassword());


	        int rows = pstmt.executeUpdate();


	        return rows > 0;

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}
	public Organization loginOrganization(String email, String password) {

	    String query =
	        "SELECT * FROM organization WHERE email=? AND password=?";


	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	            con.prepareStatement(query);

	        pstmt.setString(1, email);
	        pstmt.setString(2, password);


	        ResultSet rs = pstmt.executeQuery();


	        if(rs.next()) {

	            Organization org = new Organization();

	            org.setOrgId(
	                rs.getInt("org_id")
	            );

	            org.setOrgName(
	                rs.getString("org_name")
	            );

	            org.setEmail(
	                rs.getString("email")
	            );

	            org.setPhone(
	                rs.getString("phone")
	            );

	            org.setAddress(
	                rs.getString("address")
	            );

	            org.setCity(
	                rs.getString("city")
	            );

	            org.setPincode(
	                rs.getString("pincode")
	            );


	            return org;
	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
	public Organization getOrganizationById(int id) {

	    String query =
	        "SELECT * FROM organization WHERE org_id=?";


	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	            con.prepareStatement(query);

	        pstmt.setInt(1, id);


	        ResultSet rs = pstmt.executeQuery();


	        if(rs.next()) {

	            Organization org = new Organization();


	            org.setOrgId(
	                rs.getInt("org_id")
	            );

	            org.setOrgName(
	                rs.getString("org_name")
	            );

	            org.setEmail(
	                rs.getString("email")
	            );

	            org.setPhone(
	                rs.getString("phone")
	            );

	            org.setAddress(
	                rs.getString("address")
	            );

	            org.setCity(
	                rs.getString("city")
	            );

	            org.setPincode(
	                rs.getString("pincode")
	            );


	            return org;
	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}
	
	public ResultSet getAllOrganizations() {

	    String query =
	            "SELECT * FROM organization";

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