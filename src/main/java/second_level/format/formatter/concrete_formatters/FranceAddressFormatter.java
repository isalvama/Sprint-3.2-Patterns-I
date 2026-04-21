package second_level.format.formatter.concrete_formatters;

import second_level.format.*;
import second_level.format.formatter.abstract_formatter.AddressFormatter;

public class FranceAddressFormatter implements AddressFormatter {
    private final AddressValidator addressValidator;

    public FranceAddressFormatter (AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public String formatAddress(Address address) {
        addressValidator.validateAddress(address);
        if (!(address instanceof FranceAddress frenchAddress)) throw new IllegalArgumentException("address is not of FranceAddress class");
        return String.format("%s%s %s\n%s %s\n%s", buildOptionalLine(frenchAddress), frenchAddress.getStreetNumber(), frenchAddress.getStreetName(),
                frenchAddress.getPostalCode(), frenchAddress.getTown().toUpperCase(), frenchAddress.getCountry().toUpperCase());
    }

    private String buildOptionalLine(FranceAddress address){
        StringBuilder stringBuilder = new StringBuilder();
        appendIfPresent(stringBuilder, address.getMoreInfo(), false);
        appendIfPresent(stringBuilder, String.valueOf(address.getFloor()), false);
        appendIfPresent(stringBuilder, address.getDoor(), true);

        return stringBuilder.toString();
    }

    private void appendIfPresent (StringBuilder stringBuilder, String addressAttribute, boolean isLast){
        if (addressAttribute != null && !addressAttribute.equals("null")) {
            stringBuilder.append(addressAttribute).append(isLast ? ", " : " ");
        }
    }
}