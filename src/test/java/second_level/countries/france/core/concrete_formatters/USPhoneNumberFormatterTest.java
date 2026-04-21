package second_level.countries.france.core.concrete_formatters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.countries.us.USPhoneNumberFormatter;
import second_level.core.validator.PhoneValidator;
import second_level.countries.us.USPhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;


class USPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator usPhoneNumberValidator = new USPhoneValidator();
    PhoneNumberFormatter usPhoneFormatter = new USPhoneNumberFormatter(usPhoneNumberValidator);

    @ParameterizedTest

    @CsvSource({"176445686, +1 176 445 686", "132047721, +1 132 047 721", "118990372, +1 118 990 372", "153990373, +1 153 990 373"})
    void formatAddress_whenPassingUSValidNumbers_returnsFormattedNumber(long number, String formattedNumber) {
        assertThat(usPhoneFormatter.formatPhone(number)).isEqualTo(formattedNumber);
    }
}