package second_level.model.concrete_models.address;

import second_level.exception.InvalidAddressException;
import second_level.model.abstract_models.Address;
import second_level.model.concrete_models.HousingDetails;

public class FranceAddress extends Address {
    private final String town;

    public FranceAddress(String streetName, int streetNumber, String postalCode, String town, HousingDetails housingDetails) {
        super(streetName, streetNumber, postalCode, "France", housingDetails);
        this.town = validateNotEmpty(town, "town");
        ensureIsValid();
    }

    @Override
    protected void ensureIsValid() {
        if (!this.getPostalCode().matches("[0-9]{5}")) throw new InvalidAddressException("Invalid French address: postal code must be exactly 5 numbers", this.getPostalCode(), "postalCode");
    }

    public String formatAddress() {
        return String.format("%s%s %s\n%s %s\n%s", buildOptionalLine(), this.getStreetNumber(), this.getStreetName(),
                this.getPostalCode(), this.town.toUpperCase(), this.getCountry().toUpperCase());
    }

    private String buildOptionalLine(){
        if (this.getHousingDetails().floor() != null || this.getHousingDetails().door() != null || this.getHousingDetails().moreInfo() != null) {
            return this.getHousingDetails().format() + ", ";
        } else {
            return "";
        }
    }
}
