package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.MoroccoAddressFormatter;
import second_level.format.formatter.concrete_formatters.MoroccoPhoneNumberFormatter;

public class MoroccoFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAdressFormatter() {
        return new MoroccoAddressFormatter();
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        return new MoroccoPhoneNumberFormatter();
    }
}
