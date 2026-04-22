package second_level.countries.france;

import second_level.core.validator.AddressValidator;
import second_level.core.validator.PhoneValidator;
import second_level.core.factory.FormatFactory;
import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;

public class FranceFormatFactory implements FormatFactory {

    @Override
    public AddressFormatter createAddressFormatter() {
        AddressValidator addressValidator = new FranceAddressValidator();
        return new FranceAddressFormatter(addressValidator);
    }

    @Override
    public PhoneNumberFormatter createPhoneNumberFormatter() {
        PhoneValidator phoneValidator = new FrancePhoneValidator();
        return new FrancePhoneNumberFormatter(phoneValidator);
    }
}
