package second_level.countries.us;

import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

public class USPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator usPhoneValidator;

    public USPhoneNumberFormatter(PhoneValidator phoneValidator) {
        this.usPhoneValidator = phoneValidator;
    }

    @Override
    public String formatPhone(Phone phone) {
        String numStr = usPhoneValidator.validatePhone(phone.getNumber());
        return String.format("+1 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 6), numStr.substring(6, 9));
    }
}
