package second_level.countries.france;

import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;

public class FrancePhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new InvalidPhoneException("Invalid French Phone number: phone number cannot be negative", number);
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new InvalidPhoneException("Invalid French Phone number: phone number must have 9 digits", number);
        return numStr;
    }
}
