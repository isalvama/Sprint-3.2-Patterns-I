package second_level.countries.france.core.concrete_formatters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.countries.uk.UKPhoneNumberFormatter;
import second_level.core.validator.PhoneValidator;
import second_level.countries.uk.UKPhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;

class UKPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator ukPhoneNumberValidator = new UKPhoneValidator();
    PhoneNumberFormatter ukPhoneFormatter = new UKPhoneNumberFormatter(ukPhoneNumberValidator);

    @ParameterizedTest
    @CsvSource({"7764456866, +44 77 6445 6866", "1320477217, +44 13 2047 7217", "7189903723, +44 71 8990 3723", "7539903737, +44 75 3990 3737"})
    void formatAddress_whenPassingUKValidNumbers_returnsFormattedNumber(long number, String formattedNumber) {
        assertThat(ukPhoneFormatter.formatPhone(number)).isEqualTo(formattedNumber);
    }
}