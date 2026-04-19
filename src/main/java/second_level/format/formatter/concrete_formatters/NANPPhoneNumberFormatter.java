package second_level.format.formatter.concrete_formatters;

import second_level.format.NANPPhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class NANPPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator nanpPhoneValidator;

    public NANPPhoneNumberFormatter () {
        this.nanpPhoneValidator = new NANPPhoneValidator();
    }

    @Override
    public String formatPhone(long number) {
        String numStr = nanpPhoneValidator.validatePhone(number);
        return String.format("+1 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 6), numStr.substring(6, 9));
    }
}
