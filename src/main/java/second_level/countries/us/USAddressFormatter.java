package second_level.countries.us;

import second_level.model.Address;
import second_level.core.validator.AddressValidator;
import second_level.model.USAddress;
import second_level.core.formatter.AddressFormatter;

public class USAddressFormatter implements AddressFormatter {
    private final AddressValidator addressValidator;

    public USAddressFormatter (AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public String formatAddress(Address address) {
        addressValidator.validateAddress(address);
        if (!(address instanceof USAddress usAddress)) throw new IllegalArgumentException("address is not of USAddress class");
        return String.format("%s %s%s\n%s, %s %s\n%s", usAddress.getStreetNumber(), usAddress.getStreetName(), buildOptionalLine(usAddress),
                usAddress.getPostOffice(), usAddress.getStateAbbreviation().toUpperCase(), usAddress.getPostalCode(), usAddress.getCountry().toUpperCase());
    }

    private String buildOptionalLine(USAddress address){
        StringBuilder stringBuilder = new StringBuilder();
        appendIfPresent(stringBuilder, String.valueOf(address.getFloor()));
        appendIfPresent(stringBuilder, address.getDoor());
        appendIfPresent(stringBuilder, address.getMoreInfo());
        return stringBuilder.toString();
    }

    private void appendIfPresent (StringBuilder stringBuilder, String addressAttribute){
        if (addressAttribute != null && !addressAttribute.equals("null")) {
            stringBuilder.append(" ").append(addressAttribute);
        }
    }
}