package second_level.countries.spain;

import second_level.core.validator.AddressValidator;
import second_level.core.validator.PhoneValidator;
import second_level.core.factory.FormatFactory;
import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;

public class SpainFormatFactory implements FormatFactory{

        @Override
        public AddressFormatter createAdressFormatter() {
            AddressValidator addressValidator = new SpainAddressValidator();
            return new SpainAddressFormatter(addressValidator);
        }

        @Override
        public PhoneNumberFormatter createPhoneNumberFormatter() {
            PhoneValidator phoneValidator = new SpanishPhoneValidator();
            return new SpainPhoneNumberFormatter(phoneValidator);
        }
    }
