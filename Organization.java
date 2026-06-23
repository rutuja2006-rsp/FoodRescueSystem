package model;

public class Organization {

    private int orgId;
    private String orgName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String pincode;
    private String password;


    public Organization() {
    }


    public Organization(int orgId, String orgName, String email,
                        String phone, String address,
                        String city, String pincode,
                        String password) {

        this.orgId = orgId;
        this.orgName = orgName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.password = password;
    }


    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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