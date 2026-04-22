package second_level.countries.uk;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

import java.util.stream.Stream;

class UKPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator ukPhoneNumberValidator = new UKPhoneValidator();
    PhoneNumberFormatter ukPhoneFormatter = new UKPhoneNumberFormatter(ukPhoneNumberValidator);

    static Stream<Arguments> phoneProvider () {
        return Stream.of(
                Arguments.of(new Phone(7764456866L), "+44 77 6445 6866"),
                Arguments.of(new Phone(1320477217), "+44 13 2047 7217"),
                Arguments.of(new Phone(7189903723L), "+44 71 8990 3723"),
                Arguments.of(new Phone(7539903737L), "44 75 3990 3737")
        );
    }

    @ParameterizedTest
    @MethodSource("phoneProvider")
    void formatPhone_whenPassingUKValidNumbers_returnsFormattedNumbers(Phone phone, String formattedNumber) {
        assertThat(ukPhoneFormatter.formatPhone(phone)).isEqualTo(formattedNumber);
    }
}