package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.ChinaAddressFormatter;
import second_level.format.formatter.concrete_formatters.ChinaPhoneNumberFormatter;

public class ChinaFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAdressFormatter() {
        return new ChinaAddressFormatter();
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        return new ChinaPhoneNumberFormatter();
    }
}
