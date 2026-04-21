package second_level.countries.spain;

import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;

public class SpainPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator spanishPhoneValidator;

    public SpainPhoneNumberFormatter (PhoneValidator phoneValidator) {
        spanishPhoneValidator = phoneValidator;
    }

    @Override
    public String formatPhone(long number) {
        String numStr = spanishPhoneValidator.validatePhone(number);
        return String.format("+34 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 6), numStr.substring(6, 9));
    }
}
