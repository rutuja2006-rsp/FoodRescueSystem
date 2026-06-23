package model;

import java.sql.Timestamp;

public class Distribution {

    private int distributionId;

    private int foodId;

    private int organizationId;

    private int peopleServed;

    private int quantityDistributed;

    private String location;

    private Timestamp distributionDate;


    // Getters and Setters


    public int getDistributionId() {
        return distributionId;
    }


    public void setDistributionId(int distributionId) {
        this.distributionId = distributionId;
    }


    public int getFoodId() {
        return foodId;
    }


    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }


    public int getOrganizationId() {
        return organizationId;
    }


    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }


    public int getPeopleServed() {
        return peopleServed;
    }


    public void setPeopleServed(int peopleServed) {
        this.peopleServed = peopleServed;
    }


    public int getQuantityDistributed() {
        return quantityDistributed;
    }


    public void setQuantityDistributed(int quantityDistributed) {
        this.quantityDistributed = quantityDistributed;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public Timestamp getDistributionDate() {
        return distributionDate;
    }


    public void setDistributionDate(Timestamp distributionDate) {
        this.distributionDate = distributionDate;
    }

}