package dao;

import database.DBConnection;
import model.Waste;

import java.sql.*;


public class WasteDAO {


    public boolean addWaste(Waste waste) {


        try {


            Connection con = DBConnection.getConnection();


            // Insert waste details
            String query =
            	    "INSERT INTO food_waste " +
            	    "(food_id, quantity_wasted, reason, waste_date) " +
            	    "VALUES (?, ?, ?, ?)";


            PreparedStatement pstmt =
                    con.prepareStatement(query);


            pstmt.setInt(
                    1,
                    waste.getFoodId()
            );


            pstmt.setInt(
                    2,
                    waste.getQuantityWasted()
            );


            pstmt.setString(
                    3,
                    waste.getReason()
            );


            pstmt.setTimestamp(
                    4,
                    waste.getWasteDate()
            );


            int rows = pstmt.executeUpdate();


            if(rows > 0) {


                // Update food status
                String updateQuery =
                    "UPDATE food SET status='WASTED' " +
                    "WHERE food_id=?";


                PreparedStatement updateStmt =
                        con.prepareStatement(updateQuery);


                updateStmt.setInt(
                        1,
                        waste.getFoodId()
                );


                updateStmt.executeUpdate();


                return true;
            }


        }
        catch(Exception e) {


            e.printStackTrace();


        }


        return false;

    }
    
    public ResultSet getAllWasteRecords() {

        String query =
            "SELECT * FROM food_waste";
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