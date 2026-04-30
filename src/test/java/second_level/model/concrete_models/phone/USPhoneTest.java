package second_level.model.concrete_models.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.exception.InvalidPhoneException;

import static org.junit.jupiter.api.Assertions.*;

class USPhoneTest {

    @ParameterizedTest
    @CsvSource({"-757362182", "1564468", "1120", "1989907255", "1990373", "1330976", "11288394490"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(String phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new USPhone(phone);});
        assertEquals("Invalid US Phone Number: phone number must only contain 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"686446864", "933093220", "828990766", "749037355", "333097687"})
    void validatePhone_whenPassingPhoneWithInvalidFirstNumbers_throwsInvalidPhoneExceptionWithExpectedMessage(String phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new USPhone(phone);});
        assertEquals("Invalid US Phone Number: phone number must start with 2, 3, 4, 5, 6, 7, 8, or 9", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"176445686", "132047721", "118990372", "153990373", "173099676", "133679345"})
    void validatePhone_whenPassingValidUSPhoneNumbers_noExceptionIsThrown(String phone) {
        assertDoesNotThrow(() -> {new USPhone(phone);});
    }

}