package model;

import java.sql.Timestamp;

public class Food {

    private int foodId;
    private int donorId;

    private String foodName;
    private String category;
    private String foodType;

    private int quantity;
    private String unit;

    private Timestamp preparationTime;
    private Timestamp expiryTime;

    private String address;
    private String city;
    private String pincode;

    private String status;


    public Food() {
    }


    public Food(int foodId, int donorId, String foodName,
                String category, String foodType,
                int quantity, String unit,
                Timestamp preparationTime,
                Timestamp expiryTime,
                String address, String city,
                String pincode, String status) {

        this.foodId = foodId;
        this.donorId = donorId;
        this.foodName = foodName;
        this.category = category;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.preparationTime = preparationTime;
        this.expiryTime = expiryTime;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.status = status;
    }


    // Getters & Setters

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Timestamp getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Timestamp preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Timestamp getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Timestamp expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}