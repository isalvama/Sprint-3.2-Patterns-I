package second_level.countries.us;

import second_level.model.Address;
import second_level.core.validator.AddressValidator;
import second_level.core.exception.InvalidAddressException;
import second_level.model.USAddress;

import java.util.List;

public class USAddressValidator implements AddressValidator {
    private static final List<String> STATE_ABBREVIATIONS = List.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" );

    @Override
    public Address validateAddress(Address address) {
        if (!(address instanceof USAddress usAddress))
            throw new InvalidAddressException("address is not an instance of USAddress class", address.getClass().getSimpleName(), "fieldType");
        if (!validateStateAbbreviation(usAddress)) throw new InvalidAddressException("Invalid US address: the entered state abbreviation does not exist", usAddress.getStateAbbreviation(), "stateAbbreviation");
        if (!(address.getPostalCode().matches("^[0-9]{5}")))
            throw new InvalidAddressException("Invalid US address: ZIP code must be composed of exactly 5 numbers", usAddress.getPostalCode(), "postalCode");
        return address;
    }

    private boolean validateStateAbbreviation (USAddress usAddress) {
        return STATE_ABBREVIATIONS.stream().anyMatch(
                sa -> sa.equalsIgnoreCase(usAddress.getStateAbbreviation())
        );
    }
}