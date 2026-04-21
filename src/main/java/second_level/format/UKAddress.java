package second_level.format;

public class UKAddress extends Address {
    private Integer floor;
    private String door;
    private String town;
    private String moreInfo;

    public UKAddress(String streetName, int streetNumber, String postalCode, String country, String moreInfo, Integer floor, String door, String town) {
        super(streetName, streetNumber, postalCode, country);
        this.floor = floor;
        this.door = door;
        this.moreInfo = moreInfo;
        this.town = validateNotEmpty(town, "town");

    }

    public Integer getFloor() {
        return floor;
    }

    public String getDoor() {
        return door;
    }

    public String getTown() {
        return town;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    private static String validateNotEmpty(String field, String fieldName){
        if (field == null || field.isBlank()) throw new IllegalArgumentException("Invalid UK Address: " + fieldName + " can not be null or empty");
        return field;
    }
}
