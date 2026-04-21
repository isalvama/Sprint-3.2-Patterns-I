package second_level.countries.uk;

import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;

public class UKPhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number) {
        String numStr = String.valueOf(number);
        if (number < 0) throw new InvalidPhoneException("Invalid UK Phone number: phone number cannot be negative", number);
        if (numStr.length() != 10) throw new InvalidPhoneException("Invalid UK Phone number: phone number must have 10 digits", number);
        if ((!numStr.startsWith("75")) && (!numStr.startsWith("71")) && (!numStr.startsWith("79")) && (!numStr.startsWith("77")) && (!numStr.startsWith("1")) && (!numStr.startsWith("2"))) throw new InvalidPhoneException("Invalid UK phone number: phone number must start with 75, 71, 79, 77, 1, or 2", number);
        return numStr;
    }
}
