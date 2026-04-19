package second_level.format.formatter.concrete_formatters;

import second_level.format.SpanishPhoneValidator;
import second_level.format.PhoneValidator;
import second_level.format.formatter.abstract_formatter.PhoneNumberFormatter;

public class SpainPhoneNumberFormatter implements PhoneNumberFormatter {
    private final PhoneValidator spanishPhoneValidator;

    public SpainPhoneNumberFormatter () {
        spanishPhoneValidator = new SpanishPhoneValidator();
    }

    @Override
    public String formatPhone(long number) {
        String numStr = spanishPhoneValidator.validatePhone(number);
        return String.format("+34 %s %s %s", numStr.substring(0, 3), numStr.substring(3, 6), numStr.substring(6, 9));
    }
}
