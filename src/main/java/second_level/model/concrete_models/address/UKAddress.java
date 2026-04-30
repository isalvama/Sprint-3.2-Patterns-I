package second_level.model.concrete_models.address;

import second_level.exception.InvalidAddressException;
import second_level.model.abstract_models.Address;
import second_level.model.concrete_models.HousingDetails;

public class UKAddress extends Address {
    private final String town;

    public UKAddress(String streetName, int streetNumber, String postalCode, HousingDetails housingDetails, String town) {
        super(streetName, streetNumber, postalCode, "UK", housingDetails);
        this.town = validateNotEmpty(town, "town");
        ensureIsValid();
    }

    @Override
    protected void ensureIsValid() {
        validatePostalCode();
    }
    private void validatePostalCode() {
        if (!this.getPostalCode().contains(" "))
            throw new InvalidAddressException("Invalid UK address: Postcode must be composed of 2 parts separated by a blank space", this.getPostalCode(), "postalCode");
        String[] postalCodeParts = this.getPostalCode().split(" ");
        if (postalCodeParts.length != 2)
            throw new InvalidAddressException("Invalid UK address: Postcode must be composed of exactly 2 parts", this.getPostalCode(), "postalCode");
        String outward = postalCodeParts[0];
        String inward = postalCodeParts[1];
        if (!outward.matches("^[a-zA-Z0-9]{2,4}$")) {
            throw new InvalidAddressException("Invalid UK address: First part of Postcode (outward) must be 2-4 alphanumeric characters.", this.getPostalCode(), "postalCode");
        }
        if (!inward.matches("^[0-9][a-zA-Z]{2}$")) {
            throw new InvalidAddressException("Invalid UK address: Second part of Postcode (inward) must be a digit followed by two letters", this.getPostalCode(), "postalCode");
        }
    }

    @Override
    public String formatAddress() {
        return String.format("%s%s %s\n%s\n%s\n%s", buildOptionalLine(), this.getStreetNumber(), this.getStreetName(),
                this.town.toUpperCase(), this.getPostalCode(), this.getCountry().toUpperCase());
    }

    private String buildOptionalLine(){
        if (this.getHousingDetails().moreInfo() != null || this.getHousingDetails().door() != null || this.getHousingDetails().floor() != null ) {
            return this.getHousingDetails().format() + " ";
        } else {
            return "";
        }
    }

    public String getTown() {
        return town;
    }
}
