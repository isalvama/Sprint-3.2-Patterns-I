package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

class FrancePhoneValidatorTest implements WithAssertions {
    private final PhoneValidator francePhoneValidator = new FrancePhoneValidator();

    @Test
    void validatePhone_whenPassingNegativeNumber_throwsInvalidPhoneExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {francePhoneValidator.validatePhone(-627362182);});
        assertEquals("Invalid French Phone number: phone number cannot be negative", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"68644686", "9320", "82899072", "399037344789", "1330976361"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {francePhoneValidator.validatePhone(phone);});
        assertEquals("Invalid French Phone number: phone number must have 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"686445686", "932047721", "828990372", "383990373", "133099676"})
    void validatePhone_whenPassingValidFrenchPhone_noExceptionIsThrown(long phone) {
        assertDoesNotThrow(() -> {francePhoneValidator.validatePhone(phone);});
    }
}