package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;
import second_level.countries.uk.UKPhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

class UKPhoneValidatorTest implements WithAssertions {
    private final PhoneValidator ukPhoneValidator = new UKPhoneValidator();

    @Test
    void validatePhone_whenPassingNegativeNumber_throwsInvalidPhoneExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {ukPhoneValidator.validatePhone(-7573621822L);});
        assertEquals("Invalid UK Phone number: phone number cannot be negative", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"75644686", "7120", "79899072", "2990373", "1330976", "71288394490"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan10Digits_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {ukPhoneValidator.validatePhone(phone);});
        assertEquals("Invalid UK Phone number: phone number must have 10 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"6864468643", "9330932204", "8289907663", "7490373557", "7330976870"})
    void validatePhone_whenPassingPhoneWithInvalidFirstNumbers_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {ukPhoneValidator.validatePhone(phone);});
        assertEquals("Invalid UK phone number: phone number must start with 75, 71, 79, 77, 1, or 2", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"7764456866", "1320477217", "7189903723", "7539903737", "7730996767", "2336793455"})
    void validatePhone_whenPassingValidUKPhoneNumbers_noExceptionIsThrown(long phone) {
        assertDoesNotThrow(() -> {ukPhoneValidator.validatePhone(phone);});
    }
}