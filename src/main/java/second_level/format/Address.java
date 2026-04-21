package second_level.format;

import java.util.Objects;

public class Address {
    private String streetName;
    private int streetNumber;
    private String postalCode;
    private String country;//

    public Address (String streetName, int streetNumber, String postalCode, String country){
        if (streetName.isEmpty()) throw new IllegalArgumentException("Invalid address: street name can not be empty");
        if (streetNumber < 0) throw new IllegalArgumentException("Invalid address: street number can not be negative");
        if (postalCode.isEmpty()) throw new IllegalArgumentException("Invalid address: postal code can not be empty");
        if (country.isEmpty()) throw new IllegalArgumentException("Invalid address: country can not be empty");
        this.streetName = Objects.requireNonNull(streetName, "street name can not be null");
        this.streetNumber = streetNumber;
        this.postalCode = Objects.requireNonNull(postalCode, "postal code can not be null");
        this.country = Objects.requireNonNull(country, "country can not be null");
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getCountry() {
        return country;
    }
}
