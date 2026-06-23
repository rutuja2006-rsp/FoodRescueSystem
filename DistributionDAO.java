package dao;

import database.DBConnection;
import model.Distribution;

import java.sql.*;


public class DistributionDAO {


    public boolean addDistribution(Distribution distribution) {


        try {


            Connection con = DBConnection.getConnection();


            // Insert distribution details
            String query =
            		"INSERT INTO distribution(food_id, org_id, people_served, quantity_distributed, location, distribution_date) VALUES (?, ?, ?, ?, ?, ?)";


            PreparedStatement pstmt =
                    con.prepareStatement(query);


            pstmt.setInt(1,
                    distribution.getFoodId());


            pstmt.setInt(2,
                    distribution.getOrganizationId());


            pstmt.setInt(3,
                    distribution.getPeopleServed());


            pstmt.setInt(4,
                    distribution.getQuantityDistributed());


            pstmt.setString(5,
                    distribution.getLocation());


            pstmt.setTimestamp(6,
                    distribution.getDistributionDate());


            int rows = pstmt.executeUpdate();


            if(rows > 0) {


                // Update food status
                String updateQuery =
                    "UPDATE food SET status='DISTRIBUTED' " +
                    "WHERE food_id=?";


                PreparedStatement updateStmt =
                        con.prepareStatement(updateQuery);


                updateStmt.setInt(
                        1,
                        distribution.getFoodId()
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

}