package second_level.format;

public class UKAddressValidator implements AddressValidator {

    @Override
    public Address validateAddress(Address address) {
        if (!(address instanceof UKAddress ukAddress))
            throw new InvalidAddressException("address is not an instance of UKAddress class", address.getClass().getSimpleName(), "fieldType");
        validatePostalCode(ukAddress);
        return address;
    }

    private void validatePostalCode(UKAddress address) {
        if (!address.getPostalCode().contains(" "))
            throw new InvalidAddressException("Invalid UK address: Postcode must be composed of 2 parts separated by a blank space", address.getPostalCode(), "postalCode");
        String[] postalCodeParts = address.getPostalCode().split(" ");
        if (postalCodeParts.length != 2)
            throw new InvalidAddressException("Invalid UK address: Postcode must be composed of exactly 2 parts", address.getPostalCode(), "postalCode");
        String outward = postalCodeParts[0];
        String inward = postalCodeParts[1];
        if (!outward.matches("^[a-zA-Z0-9]{2,4}$")) {
            throw new InvalidAddressException("Invalid UK address: First part of Postcode (outward) must be 2-4 alphanumeric characters.", address.getPostalCode(), "postalCode");
        }
        if (!inward.matches("^[0-9][a-zA-Z]{2}$")) {
            throw new InvalidAddressException("Invalid UK address: Second part of Postcode (inward) must be a digit followed by two letters", address.getPostalCode(), "postalCode");
        }
    }
}

