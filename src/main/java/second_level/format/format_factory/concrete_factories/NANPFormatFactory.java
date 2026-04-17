package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.NANPAddressFormatter;
import second_level.format.formatter.concrete_formatters.NANPPhoneNumberFormatter;

public class NANPFormatFactory implements FormatFactory {

    @Override
    public AddressFormatter createAdressFormatter() {
        return new NANPAddressFormatter();
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        return new NANPPhoneNumberFormatter();
    }
}
