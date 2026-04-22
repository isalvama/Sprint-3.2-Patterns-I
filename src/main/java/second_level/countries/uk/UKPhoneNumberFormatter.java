package second_level.countries.uk;

import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

public class UKPhoneNumberFormatter implements PhoneNumberFormatter {
    public PhoneValidator ukPhoneValidator;

    public UKPhoneNumberFormatter (PhoneValidator phoneValidator) {
        this.ukPhoneValidator = phoneValidator;
    }

    @Override
    public String formatPhone(Phone phone) {
        String numStr = ukPhoneValidator.validatePhone(phone.getNumber());
        return String.format("+44 %s %s %s", numStr.substring(0, 2), numStr.substring(2, 6), numStr.substring(6, 10));
    }
}
