package second_level.format.formatter.concrete_formatters;

import second_level.format.PhoneValidator;
import second_level.format.UKPhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class UKPhoneNumberFormatter implements PhoneNumberFormatter {
    public PhoneValidator ukPhoneValidator;

    public UKPhoneNumberFormatter () {
        this.ukPhoneValidator = new UKPhoneValidator();
    }

    @Override
    public String formatPhone(long number) {
        String numStr = ukPhoneValidator.validatePhone(number);
        return String.format("+44 %s %s %s", numStr.substring(0, 2), numStr.substring(2, 6), numStr.substring(6, 10));
    }
}
