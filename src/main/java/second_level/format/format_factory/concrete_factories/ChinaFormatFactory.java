package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class ChinaFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAdressFormatter() {
        return new ChinaAdressFormatter();
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        return new ChinaPhoneNumberFormatter();
    }
}
