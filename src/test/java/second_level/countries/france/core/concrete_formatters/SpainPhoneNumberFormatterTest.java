package second_level.countries.france.core.concrete_formatters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.countries.spain.SpainPhoneNumberFormatter;
import second_level.core.validator.PhoneValidator;
import second_level.countries.spain.SpanishPhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;


class SpainPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator spainPhoneNumberValidator = new SpanishPhoneValidator();
    PhoneNumberFormatter spainPhoneFormatter = new SpainPhoneNumberFormatter(spainPhoneNumberValidator);

    @ParameterizedTest
    @CsvSource({"789223098, +34 789 223 098", "932047721, +34 932 047 721", "828990372, +34 828 990 372", "683990373, +34 683 990 373"})
    void formatAddress_whenPassingFrenchValidNumbers_returnsFormattedNumber(long number, String formattedNumber) {
        assertThat(spainPhoneFormatter.formatPhone(number)).isEqualTo(formattedNumber);
    }
}