package second_level.format.formatter.concrete_formatters;

import second_level.format.Address;
import second_level.format.AddressValidator;
import second_level.format.SpanishAddress;
import second_level.format.formatter.abstract_formatter.AddressFormatter;

public class SpainAddressFormatter implements AddressFormatter {
    private final AddressValidator addressValidator;

    public SpainAddressFormatter (AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public String formatAddress(Address address) {
        addressValidator.validateAddress(address);
        if (!(address instanceof SpanishAddress spanishAddress)) throw new IllegalArgumentException("address is not of SpanishAddress class");
        return String.format("%s, %s%s\n%s %s %s\n%s", spanishAddress.getStreetName(), spanishAddress.getStreetNumber(), buildOptionalLine(spanishAddress),
                spanishAddress.getPostalCode(), spanishAddress.getTown(), spanishAddress.getProvince().toUpperCase(), spanishAddress.getCountry().toUpperCase());
    }

    private String buildOptionalLine(SpanishAddress address){
        StringBuilder stringBuilder = new StringBuilder();
        appendIfPresent(stringBuilder, address.getMoreInfo());
        appendIfPresent(stringBuilder, String.valueOf(address.getFloor()));
        appendIfPresent(stringBuilder, address.getDoor());

        return stringBuilder.toString();
    }

    private void appendIfPresent (StringBuilder stringBuilder, String addressAttribute){
        if (addressAttribute != null && !addressAttribute.equals("null")) {
            stringBuilder.append(" ").append(addressAttribute);
        }
    }
}
