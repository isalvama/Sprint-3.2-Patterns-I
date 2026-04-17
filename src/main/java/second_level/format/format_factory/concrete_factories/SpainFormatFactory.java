package second_level.format.format_factory.concrete_factories;

import second_level.format.format_factory.abstract_factory.FormatFactory;
import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class SpainFormatFactory implements FormatFactory {

    public class SpainFormatFactory implements FormatFactory{
        @Override
        public AddressFormatter createAdressFormatter() {
            return new SpainAdressFormatter();
        }

        @Override
        public PhoneNumberFormatter createPhoneNumberFormatter() {
            return new SpainPhoneNumberFormatter();
        }
    }
}
