package second_level;

import second_level.core.factory.FormatFactory;
import second_level.core.formatter.AddressFormatter;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Address;
import second_level.model.Phone;

public class Contact {
    private PhoneNumberFormatter phoneNumberFormatter;
    private AddressFormatter addressFormatter;

    public Contact (FormatFactory formatFactory){
        this.phoneNumberFormatter = formatFactory.createPhoneNumberFormatter();
        this.addressFormatter = formatFactory.createAddressFormatter();
    }

    public String formatAddress (Address address) {
        return addressFormatter.formatAddress(address);
    }

    public String formatPhone (Phone phone) {
        return phoneNumberFormatter.formatPhone(phone);
    }
}
