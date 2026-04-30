package second_level.model.abstract_models;

import second_level.exception.InvalidAddressException;
import second_level.model.concrete_models.HousingDetails;

import java.util.Objects;

public abstract class Address {
    private final String streetName;
    private final int streetNumber;
    private final String postalCode;
    private final String country;
    private final HousingDetails housingDetails;

    public Address (String streetName, int streetNumber, String postalCode, String country, HousingDetails housingDetails){
        if (streetNumber < 0) throw new InvalidAddressException("Invalid address: street number can not be negative", streetNumber, "streetNumber");
        this.streetName = validateNotEmpty(streetName, "streetName");
        this.streetNumber = streetNumber;
        this.postalCode = validateNotEmpty(postalCode, "postalCode");
        this.country = validateNotEmpty(country, "country");
        this.housingDetails = housingDetails;
    }

    protected static String validateNotEmpty(String field, String fieldName) {
        if (field == null || field.isBlank())
            throw new InvalidAddressException("Invalid Address: " + fieldName + " can not be null or empty", field, fieldName);
        return field;
    }

    protected abstract void ensureIsValid();

    public abstract String formatAddress();

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber && Objects.equals(streetName, address.streetName) && Objects.equals(postalCode, address.postalCode) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postalCode, country);
    }

    public HousingDetails getHousingDetails() {
        return housingDetails;
    }
}
