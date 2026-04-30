package second_level.model.concrete_models.address;

import second_level.exception.InvalidAddressException;
import second_level.model.abstract_models.Address;
import second_level.model.concrete_models.HousingDetails;
import second_level.model.concrete_models.SpanishProvince;

public class SpainAddress extends Address {

    private final String town;
    private final String province;

    public SpainAddress(String streetName, Integer streetNumber, String postalCode, String town, String province, HousingDetails housingDetails) {
        super(streetName, streetNumber, postalCode, "Spain", housingDetails);
        this.town = validateNotEmpty(town, "town");
        this.province = validateNotEmpty(province, "province");
        ensureIsValid();
    }

    @Override
    protected void ensureIsValid() {
        if (!validateProvinceName()) throw new InvalidAddressException("Invalid Spanish address: province does not exist", this.province, "province");
        validatePostalCode();
    }

    private void validatePostalCode(){
        if (!this.getPostalCode().matches("[0-9]{5}")) throw new InvalidAddressException("Invalid Spanish address: postal code must contain 5 digits", this.getPostalCode(), "postalCode");
        if (Integer.parseInt(this.getPostalCode().substring(0, 2)) > 52) throw new InvalidAddressException("Invalid Spanish address: postal code does not exist", this.getPostalCode(), "postalCode");
    }

    private boolean validateProvinceName() {
        return SpanishProvince.isValid(this.province);
    }

    @Override
    public String formatAddress() {
        return String.format("%s, %s%s\n%s %s %s\n%s", this.getStreetName(), this.getStreetNumber(), buildOptionalLine(),
                this.getPostalCode(), this.town, this.province.toUpperCase(), this.getCountry().toUpperCase());
    }

    private String buildOptionalLine(){
        if (this.getHousingDetails() != null) {
            return " " + this.getHousingDetails().format();
        } else {
            return "";
        }
    }

    public String getTown() {
        return town;
    }

    public String getProvince() {
        return province;
    }
}
