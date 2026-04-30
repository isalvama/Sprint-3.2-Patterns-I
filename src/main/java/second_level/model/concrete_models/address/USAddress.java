package second_level.model.concrete_models.address;

import second_level.exception.InvalidAddressException;
import second_level.model.abstract_models.Address;
import second_level.model.concrete_models.HousingDetails;

import java.util.List;

public class USAddress extends Address {
    private static final List<String> STATE_ABBREVIATIONS = List.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" );

    private final String stateAbbreviation;
    private final String postOffice;

    public USAddress(String streetName, int streetNumber, String postalCode, HousingDetails housingDetails, String stateAbbreviation, String postOffice) {
        super(streetName, streetNumber, postalCode, "USA", housingDetails);
        this.stateAbbreviation = validateNotEmpty(stateAbbreviation, "stateAbbreviation");
        this.postOffice = validateNotEmpty(postOffice, "postOffice");
        ensureIsValid();
    }

    @Override
    protected void ensureIsValid() {
        if (!validateStateAbbreviation()) throw new InvalidAddressException("Invalid US address: the entered state abbreviation does not exist", this.stateAbbreviation, "stateAbbreviation");
        if (!(this.getPostalCode().matches("^[0-9]{5}")))
            throw new InvalidAddressException("Invalid US address: ZIP code must be composed of exactly 5 numbers", this.getPostalCode(), "postalCode");
    }

    private boolean validateStateAbbreviation () {
        return STATE_ABBREVIATIONS.stream().anyMatch(
                sa -> sa.equalsIgnoreCase(this.stateAbbreviation)
        );
    }

    @Override
    public String formatAddress() {
        return String.format("%s %s%s\n%s, %s %s\n%s", this.getStreetNumber(), this.getStreetName(), buildOptionalLine(),
                this.getPostOffice(), this.getStateAbbreviation().toUpperCase(), this.getPostalCode(), this.getCountry().toUpperCase());
    }

    private String buildOptionalLine(){
        if (this.getHousingDetails().moreInfo() != null || this.getHousingDetails().door() != null || this.getHousingDetails().floor() != null ) {
            return " " + this.getHousingDetails().format();
        } else {
            return "";
        }
    }

    public String getPostOffice() {
        return postOffice;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
}
