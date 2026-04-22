package second_level.countries.uk;

import second_level.core.validator.AddressValidator;
import second_level.core.validator.PhoneValidator;
import second_level.core.factory.FormatFactory;
import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;

public class UKFormatFactory implements FormatFactory {
    @Override
    public AddressFormatter createAddressFormatter() {
        AddressValidator ukAddressValidator = new UKAddressValidator();
        return new UKAddressFormatter(ukAddressValidator);
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        PhoneValidator phoneValidator = new UKPhoneValidator();
        return new UKPhoneNumberFormatter(phoneValidator);
    }
}
