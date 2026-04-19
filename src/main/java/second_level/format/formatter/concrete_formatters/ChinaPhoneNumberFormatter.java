package second_level.format.formatter.concrete_formatters;

import second_level.format.ChinaPhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class ChinaPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator chinaPhoneValidator;

    public ChinaPhoneNumberFormatter () {
        this.chinaPhoneValidator = new ChinaPhoneValidator();
    }

    @Override
    public String formatPhone(long number) {
        String numStr = chinaPhoneValidator.validatePhone(number);
        return String.format("+86 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 7), numStr.substring(7, 11));
    }
}
