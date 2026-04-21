package second_level.format.formatter.concrete_formatters;

import second_level.format.FrancePhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class FrancePhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator francePhoneValidator;

    public FrancePhoneNumberFormatter (PhoneValidator phoneValidator) {
        this.francePhoneValidator = phoneValidator;
    }

    @Override
    public String formatPhone(long number) {
        String numStr = francePhoneValidator.validatePhone(number);
        return String.format("+33 %s %s %s %s %s", numStr.charAt(0), numStr.substring(1, 3), numStr.substring(3, 5), numStr.substring(5, 7), numStr.substring(7, 9));
    }
}
