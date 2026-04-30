package second_level.model.concrete_models.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.exception.InvalidPhoneException;
import static org.junit.jupiter.api.Assertions.*;

class FrancePhoneTest {
    @ParameterizedTest
    @CsvSource({"-627362182", "68644686", "9320", "82899072", "399037344789", "1330976361"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(String phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new FrancePhone(phone);});
        assertEquals("Invalid French Phone number: phone number must have 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"686445686", "932047721", "828990372", "383990373", "133099676"})
    void validatePhone_whenPassingValidFrenchPhone_noExceptionIsThrown(String phone) {
        assertDoesNotThrow(() -> {new FrancePhone(phone);});
    }
}