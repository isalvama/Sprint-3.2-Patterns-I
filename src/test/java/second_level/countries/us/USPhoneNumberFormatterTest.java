package second_level.countries.us;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

import java.util.stream.Stream;


class USPhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator usPhoneNumberValidator = new USPhoneValidator();
    PhoneNumberFormatter usPhoneFormatter = new USPhoneNumberFormatter(usPhoneNumberValidator);

    static Stream<Arguments> phoneProvider () {
        return Stream.of(
          Arguments.of(new Phone(176445686), "+1 176 445 686"),
                Arguments.of(new Phone(132047721), "+1 132 047 721"),
                Arguments.of(new Phone(118990372), "+1 118 990 372"),
                Arguments.of(new Phone(153990373), "+1 153 990 373")
                );
    }

    @ParameterizedTest
    @MethodSource("phoneProvider")
    void formatPhone_whenPassingUSValidNumbers_returnsFormattedNumber(Phone phone, String formattedNumber) {
        assertThat(usPhoneFormatter.formatPhone(phone)).isEqualTo(formattedNumber);
    }
}