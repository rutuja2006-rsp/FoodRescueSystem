package model;

import java.sql.Timestamp;

public class Waste {


    private int wasteId;

    private int foodId;

    private int quantityWasted;

    private String reason;

    private Timestamp wasteDate;


    // Getters and Setters


    public int getWasteId() {
        return wasteId;
    }


    public void setWasteId(int wasteId) {
        this.wasteId = wasteId;
    }


    public int getFoodId() {
        return foodId;
    }


    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }


    public int getQuantityWasted() {
        return quantityWasted;
    }


    public void setQuantityWasted(int quantityWasted) {
        this.quantityWasted = quantityWasted;
    }


    public String getReason() {
        return reason;
    }


    public void setReason(String reason) {
        this.reason = reason;
    }


    public Timestamp getWasteDate() {
        return wasteDate;
    }


    public void setWasteDate(Timestamp wasteDate) {
        this.wasteDate = wasteDate;
    }

}