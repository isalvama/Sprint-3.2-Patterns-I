package second_level.format.formatter.concrete_formatters;

import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class USPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator usPhoneValidator;

    public USPhoneNumberFormatter(PhoneValidator phoneValidator) {
        this.usPhoneValidator = phoneValidator;
    }

    @Override
    public String formatPhone(long number) {
        String numStr = usPhoneValidator.validatePhone(number);
        return String.format("+1 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 6), numStr.substring(6, 9));
    }
}
