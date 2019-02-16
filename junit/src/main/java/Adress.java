public class Adress {
    private String city;
    private String street;
    private String numberOfBuilding;

    public Adress(String city, String street, String numberOfBuilding) {
        this.city = city;
        this.street = street;
        this.numberOfBuilding = numberOfBuilding;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(String numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }
}
