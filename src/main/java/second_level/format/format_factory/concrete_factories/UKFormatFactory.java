package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.UKAddressFormatter;
import second_level.format.formatter.concrete_formatters.UKPhoneNumberFormatter;

public class UKFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAdressFormatter() {
        return new UKAddressFormatter();
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        return new UKPhoneNumberFormatter();
    }
}
