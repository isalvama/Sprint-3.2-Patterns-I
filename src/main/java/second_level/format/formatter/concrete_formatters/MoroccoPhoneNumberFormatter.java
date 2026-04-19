package second_level.format.formatter.concrete_formatters;

import second_level.format.MoroccanPhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class MoroccoPhoneNumberFormatter implements PhoneNumberFormatter {
    PhoneValidator moroccanPhoneValidator;

    public MoroccoPhoneNumberFormatter() {
        this.moroccanPhoneValidator = new MoroccanPhoneValidator();
    }

    @Override
    public String formatPhone(long number) {
        String numStr = moroccanPhoneValidator.validatePhone(number);
        return String.format("+212 %s %s %s %s %s", numStr.charAt(0), numStr.substring(1, 3), numStr.substring(3, 6), numStr.substring(6, 9), numStr.substring(9, 11));
    }
}
