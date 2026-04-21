package second_level.format.format_factory.concrete_factories;

import second_level.format.AddressValidator;
import second_level.format.USPhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.USAddressValidator;
import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.USAddressFormatter;
import second_level.format.formatter.concrete_formatters.USPhoneNumberFormatter;

public class USFormatFactory implements FormatFactory {

    @Override
    public AddressFormatter createAdressFormatter() {
        AddressValidator addressValidator = new USAddressValidator();
        return new USAddressFormatter(addressValidator);
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        PhoneValidator phoneValidator = new USPhoneValidator();
        return new USPhoneNumberFormatter(phoneValidator);
    }
}
