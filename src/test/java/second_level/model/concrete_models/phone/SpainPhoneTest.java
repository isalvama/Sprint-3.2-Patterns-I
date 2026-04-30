package second_level.model.concrete_models.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.exception.InvalidPhoneException;

import static org.junit.jupiter.api.Assertions.*;

class SpainPhoneTest {

    @ParameterizedTest
    @CsvSource({"-678335628", "38900924245", "1099923", "7783327273", "904184", "83395665682"})
    void validatePhone_whenPassingPhoneWithLessThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(String number) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new SpainPhone(number);});
        assertEquals("Invalid Spanish Phone Number: phone number must only contain 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource ({"389009242", "109992384", "292774998", "433904184", "533956656"})
    void validatePhone_whenPassingPhoneWithInvalidFirstDigit_throwsInvalidPhoneExceptionWithExpectedMessage(String number) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new SpainPhone(number);});
        assertEquals("Invalid Spanish Phone Number: phone number must start with 6, 7, 8, or 9", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource ({"686445686", "832002672"})
    void validatePhone_whenPassingValidSpanishPhone_noExceptionIsThrown(String number) {
        assertDoesNotThrow(() -> {new SpainPhone(number);});
    }

}