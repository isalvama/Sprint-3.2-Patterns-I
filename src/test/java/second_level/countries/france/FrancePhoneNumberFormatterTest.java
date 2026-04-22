package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import second_level.core.validator.PhoneValidator;
import second_level.core.formatter.PhoneNumberFormatter;
import second_level.model.Phone;

import java.util.stream.Stream;

class FrancePhoneNumberFormatterTest implements WithAssertions {
    PhoneValidator francePhoneNumberValidator = new FrancePhoneValidator();
    PhoneNumberFormatter francePhoneFormatter = new FrancePhoneNumberFormatter(francePhoneNumberValidator);

    static Stream<Arguments> phoneProvider() {
        return Stream.of(
                Arguments.of(new Phone(686445686), "+33 6 86 44 56 86"),
                Arguments.of(new Phone(932047721), "+33 9 32 04 77 21"),
                Arguments.of(new Phone(828990372), "+33 8 28 99 03 72"),
                Arguments.of(new Phone(383990373), "+33 3 83 99 03 73"),
                Arguments.of(new Phone(133099676), "+33 1 33 09 96 76")
        );
    }
    @ParameterizedTest
    @MethodSource("phoneProvider")
    void formatPhone_whenPassingFrenchValidNumbers_returnsFormattedNumber(Phone phone, String formattedNumber) {
        assertThat(francePhoneFormatter.formatPhone(phone)).isEqualTo(formattedNumber);
    }
}