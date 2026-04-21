package second_level.format.format_factory.concrete_factories;

import second_level.format.AddressValidator;
import second_level.format.FranceAddressValidator;
import second_level.format.FrancePhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.FranceAddressFormatter;
import second_level.format.formatter.concrete_formatters.FrancePhoneNumberFormatter;

public class FranceFormatFactory implements FormatFactory {

    @Override
    public AddressFormatter createAdressFormatter() {
        AddressValidator addressValidator = new FranceAddressValidator();
        return new FranceAddressFormatter(addressValidator);
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        PhoneValidator phoneValidator = new FrancePhoneValidator();
        return new FrancePhoneNumberFormatter(phoneValidator);
    }
}
