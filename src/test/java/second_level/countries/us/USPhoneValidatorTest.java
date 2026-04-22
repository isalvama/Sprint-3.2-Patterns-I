package second_level.countries.us;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second_level.core.exception.InvalidPhoneException;
import second_level.core.validator.PhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

class USPhoneValidatorTest implements WithAssertions {
    private final PhoneValidator usPhoneValidator = new USPhoneValidator();

    public String validatePhone(long number) throws InvalidPhoneException {
        if (number < 0) throw new InvalidPhoneException("Invalid US Phone Number: phone number can not be negative", number);
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new InvalidPhoneException("Invalid US Phone Number: phone number must have 9 digits", number);
        if (numStr.charAt(0) != '1') throw new InvalidPhoneException("Invalid US Phone Number: phone number must start with 2, 3, 4, 5, 6, 7, 8, or 9", number);
        return numStr;
    }

    @Test
    void validatePhone_whenPassingNegativeNumber_throwsInvalidPhoneExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {usPhoneValidator.validatePhone(-757362182);});
        assertEquals("Invalid US Phone Number: phone number can not be negative", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1564468", "1120", "1989907255", "1990373", "1330976", "11288394490"})
    void validatePhone_whenPassingPhoneWithLessOrMoreThan9Digits_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {usPhoneValidator.validatePhone(phone);});
        assertEquals("Invalid US Phone Number: phone number must have 9 digits", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"686446864", "933093220", "828990766", "749037355", "333097687"})
    void validatePhone_whenPassingPhoneWithInvalidFirstNumbers_throwsInvalidPhoneExceptionWithExpectedMessage(long phone) {
        IllegalArgumentException exception = assertThrows(InvalidPhoneException.class, () -> {usPhoneValidator.validatePhone(phone);});
        assertEquals("Invalid US Phone Number: phone number must start with 2, 3, 4, 5, 6, 7, 8, or 9", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"176445686", "132047721", "118990372", "153990373", "173099676", "133679345"})
    void validatePhone_whenPassingValidUSPhoneNumbers_noExceptionIsThrown(long phone) {
        assertDoesNotThrow(() -> {usPhoneValidator.validatePhone(phone);});
    }
}

