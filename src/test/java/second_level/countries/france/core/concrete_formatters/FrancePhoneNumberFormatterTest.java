package second_level.countries.france.core.concrete_formatters;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.countries.france.FrancePhoneNumberFormatter;
import second_level.countries.france.FrancePhoneValidator;
import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;

class FrancePhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator francePhoneNumberValidator = new FrancePhoneValidator();
    PhoneNumberFormatter francePhoneFormatter = new FrancePhoneNumberFormatter(francePhoneNumberValidator);

    @ParameterizedTest
    @CsvSource({"686445686, +33 6 86 44 56 86", "932047721, +33 9 32 04 77 21", "828990372, +33 8 28 99 03 72", "383990373, +33 3 83 99 03 73", "133099676, +33 1 33 09 96 76"})
    void formatAddress_whenPassingFrenchValidNumbers_returnsFormattedNumber(long number, String formattedNumber) {
        assertThat(francePhoneFormatter.formatPhone(number)).isEqualTo(formattedNumber);
    }
}