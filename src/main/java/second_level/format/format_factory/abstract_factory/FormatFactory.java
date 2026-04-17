package second_level.format.format_factory.abstract_factory;

import second_level.format.formatter.abstract_formatter.AddressFormatter;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public interface FormatFactory {
     AddressFormatter createAdressFormatter();
     PhoneNumberFormatter createPhoneNumberFormatter();
}
