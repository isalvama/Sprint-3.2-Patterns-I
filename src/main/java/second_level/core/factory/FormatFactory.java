package second_level.core.factory;

import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;

public interface FormatFactory {
     AddressFormatter createAddressFormatter();
     PhoneNumberFormatter createPhoneNumberFormatter();
}
