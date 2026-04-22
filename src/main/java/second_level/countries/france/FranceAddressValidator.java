package second_level.countries.france;

import second_level.core.exception.InvalidAddressException;
import second_level.model.Address;
import second_level.model.FranceAddress;
import second_level.core.validator.AddressValidator;

public class FranceAddressValidator implements AddressValidator {

    @Override
    public Address validateAddress(Address address) {
        if (!(address instanceof FranceAddress frenchAddress)) throw new InvalidAddressException("address is not an instance of FranceAddress class", address.getClass().getSimpleName(), "addressType");
        if (!frenchAddress.getPostalCode().matches("[0-9]{5}")) throw new InvalidAddressException("Invalid French address: postal code must be exactly 5 numbers", frenchAddress.getPostalCode(), "postalCode");
        return address;
    }
}

