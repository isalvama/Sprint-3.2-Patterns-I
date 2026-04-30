package second_level.model.concrete_models.phone;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.exception.InvalidPhoneException;

import static org.junit.jupiter.api.Assertions.*;

class UKPhoneTest {

    @ParameterizedTest
    @CsvSource({"-7573621822L", "75644686", "7120", "79899072", "2990373", "1330976", "71288394490"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan10Digits_throwsInvalidPhoneExceptionWithExpectedMessage(String phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new UKPhone(phone);});
        assertEquals("Invalid UK Phone Number: phone number must only contain 10 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"6864468643", "9330932204", "8289907663", "7490373557", "7330976870"})
    void validatePhone_whenPassingPhoneWithInvalidFirstNumbers_throwsInvalidPhoneExceptionWithExpectedMessage(String phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {new UKPhone(phone);});
        assertEquals("Invalid UK Phone Number: phone number must start with 75, 71, 79, 77, 1, or 2", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"7764456866", "1320477217", "7189903723", "7539903737", "7730996767", "2336793455"})
    void validatePhone_whenPassingValidUKPhoneNumbers_noExceptionIsThrown(String phone) {
        assertDoesNotThrow(() -> {new UKPhone(phone);});
    }
}