package second_level.countries.spain;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

import java.util.stream.Stream;


class SpainPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator spainPhoneNumberValidator = new SpanishPhoneValidator();
    PhoneNumberFormatter spainPhoneFormatter = new SpainPhoneNumberFormatter(spainPhoneNumberValidator);

    static Stream<Arguments> phoneProvider(){
        return Stream.of(
                Arguments.of(new Phone(789223098), "+34 789 223 098"),
        Arguments.of(new Phone(932047721), "+34 932 047 721"),
        Arguments.of(new Phone(828990372), "+34 828 990 372"),
        Arguments.of(new Phone(683990373), "+34 683 990 373")
        );
    }

    @ParameterizedTest
    @MethodSource("phoneProvider")
    void formatPhone_whenPassingSpanishValidNumbers_returnsFormattedNumber(Phone phone, String formattedNumber) {
        assertThat(spainPhoneFormatter.formatPhone(phone)).isEqualTo(formattedNumber);
    }
}