package second_level.format;

public class USAddress extends Address {
    private Integer floor;
    private String door;
    private String moreInfo;
    private String stateAbbreviation;
    private String postOffice;

    public USAddress(String streetName, int streetNumber, String postalCode, String country, String moreInfo, Integer floor, String door, String stateAbbreviation, String postOffice) {
        super(streetName, streetNumber, postalCode, country);
        this.floor = floor;
        this.door = door;
        this.moreInfo = moreInfo;
        this.stateAbbreviation = validateNotEmpty(stateAbbreviation, "stateAbbreviation");
        this.postOffice = validateNotEmpty(postOffice, "postOffice");
    }

    private static String validateNotEmpty(String field, String fieldName){
        if (field == null || field.isBlank()) throw new IllegalArgumentException("Invalid US Address: " + fieldName + " can not be null or empty");
        return field;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getDoor() {
        return door;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
}
