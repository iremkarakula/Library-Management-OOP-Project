package entity;

public class Address{
    private String city;
    private String street;
    private int buildingNo;

    public Address(String city, String street, int buildingNo) {
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }
}
