package second_level.countries.spain;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

class SpanishPhoneValidatorTest implements WithAssertions {
    private final PhoneValidator spanishPhoneValidator = new SpanishPhoneValidator();


    @Test
    void validatePhone_whenPassingNegativeNumber_throwsInvalidPhoneExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {spanishPhoneValidator.validatePhone(-678335628);});
        assertEquals("Invalid Spanish Phone number: phone number cannot be negative", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource ({"38900924245", "1099923", "7783327273", "904184", "83395665682"})
    void validatePhone_whenPassingPhoneWithLessThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(long number) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {spanishPhoneValidator.validatePhone(number);});
        assertEquals("Invalid Spanish Phone number: phone number must have 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource ({"389009242", "109992384", "292774998", "433904184", "533956656"})
    void validatePhone_whenPassingPhoneWithInvalidFirstDigit_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {spanishPhoneValidator.validatePhone(phone);});
        assertEquals("Invalid Spanish phone number: number must start with 6, 7, 8, or 9", exception.getMessage());
    }

    @Test
    void validatePhone_whenPassingValidSpanishPhone_noExceptionIsThrown() {
        assertDoesNotThrow(() -> {spanishPhoneValidator.validatePhone(686445686);});
        assertDoesNotThrow(() -> {spanishPhoneValidator.validatePhone(832002672);});
    }
}