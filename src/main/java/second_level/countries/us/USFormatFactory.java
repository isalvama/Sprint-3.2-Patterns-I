package second_level.countries.us;

import second_level.core.validator.AddressValidator;
import second_level.core.validator.PhoneValidator;
import second_level.core.factory.FormatFactory;
import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;

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
