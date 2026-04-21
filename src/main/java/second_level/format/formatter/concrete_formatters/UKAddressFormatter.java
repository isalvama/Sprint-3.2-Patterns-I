package second_level.format.formatter.concrete_formatters;


import second_level.format.Address;
import second_level.format.AddressValidator;
import second_level.format.UKAddress;
import second_level.format.formatter.abstract_formatter.AddressFormatter;

public class UKAddressFormatter implements AddressFormatter {
    private final AddressValidator addressValidator;

    public UKAddressFormatter (AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }

    @Override
    public String formatAddress(Address address) {
        addressValidator.validateAddress(address);
        if (!(address instanceof UKAddress ukAddress)) throw new IllegalArgumentException("address is not of UKAddress class");
        return String.format("%s%s %s\n%s\n%s\n%s", buildOptionalLine(ukAddress), ukAddress.getStreetNumber(), ukAddress.getStreetName(),
                ukAddress.getTown().toUpperCase(), ukAddress.getPostalCode(), ukAddress.getCountry().toUpperCase());
    }

    private String buildOptionalLine(UKAddress address){
        StringBuilder stringBuilder = new StringBuilder();
        appendIfPresent(stringBuilder, address.getMoreInfo());
        appendIfPresent(stringBuilder, String.valueOf(address.getFloor()));
        appendIfPresent(stringBuilder, address.getDoor());

        return stringBuilder.toString();
    }

    private void appendIfPresent (StringBuilder stringBuilder, String addressAttribute){
        if (addressAttribute != null && !addressAttribute.equals("null")) {
            stringBuilder.append(addressAttribute).append(" ");
        }
    }
}