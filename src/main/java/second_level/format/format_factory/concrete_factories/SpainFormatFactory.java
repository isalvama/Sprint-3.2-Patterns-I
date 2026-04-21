package second_level.format.format_factory.concrete_factories;

import second_level.format.*;
import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;
import second_level.format.formatter.concrete_formatters.SpainAddressFormatter;
import second_level.format.formatter.concrete_formatters.SpainPhoneNumberFormatter;

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
