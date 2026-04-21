package second_level.format.format_factory.concrete_factories;

import second_level.format.AddressValidator;
import second_level.format.PhoneValidator;
import second_level.format.UKAddressValidator;
import second_level.format.UKPhoneValidator;
import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.UKAddressFormatter;
import second_level.format.formatter.concrete_formatters.UKPhoneNumberFormatter;

public class UKFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAdressFormatter() {
        AddressValidator ukAddressValidator = new UKAddressValidator();
        return new UKAddressFormatter(ukAddressValidator);
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        PhoneValidator phoneValidator = new UKPhoneValidator();
        return new UKPhoneNumberFormatter(phoneValidator);
    }
}
