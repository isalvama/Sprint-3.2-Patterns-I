package second_level.format;

import java.util.Objects;

public class SpanishAddress extends Address{
    private String moreInfo;
    private Integer floor;
    private String door;
    private String town;
    private String province;
    private String country;

    public SpanishAddress(String streetName, Integer streetNumber, String moreInfo, Integer floor, String door, String town, String postalCode, String province, String country) {
        super(streetName, streetNumber, postalCode, country);
        this.moreInfo = moreInfo;
        this.floor = floor;
        this.door = door;
        this.town = validateNotEmpty(town, "town");
        this.province = validateNotEmpty(province, "province");
        this.country = validateNotEmpty(country, "country");
    }

    public String getMoreInfo() {
        return moreInfo;
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

    @Override
    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    private static String validateNotEmpty(String field, String fieldName){
        if (field == null || field.isBlank()) throw new IllegalArgumentException("Invalid Spanish Address: " + fieldName + " can not be null or empty");
        return field;
    }
}
