package model;

public class Donor {

    private int donorId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String pincode;
    private String password;


    // Default Constructor
    public Donor() {

    }


    // Parameterized Constructor
    public Donor(int donorId, String name, String email,
                 String phone, String address,
                 String city, String pincode,
                 String password) {

        this.donorId = donorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.password = password;
    }


    // Getters and Setters

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}