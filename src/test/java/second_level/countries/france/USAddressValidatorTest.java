package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.exception.InvalidAddressException;
import second_level.model.Address;
import second_level.model.SpanishAddress;
import second_level.model.USAddress;
import second_level.core.validator.AddressValidator;
import second_level.countries.us.USAddressValidator;

import static org.junit.jupiter.api.Assertions.*;

class USAddressValidatorTest implements WithAssertions {
    AddressValidator usAddressValidator = new USAddressValidator();
    Address spanishAddress = new SpanishAddress("carrer Provença", 31, null, 2, "1", "Barcelona", "08010", "Barcelona", "Spain");
    Address addressWithInvalidStateAbbreviation = new USAddress("Main St", 1234, "90001", "USA", null, null, null, "IS", "Los Angeles");
    Address addressWith4DigitZipCode = new USAddress("Cox Rd", 969, "2805", "USA", null, null, null, "NC", "Gastonia");
    Address addressWithZipCodeContainingLetter = new USAddress("Cox Rd", 969, "28S5W", "USA", null, null, null, "NC", "Gastonia");
    Address validAddress1 = new USAddress("Main St", 1234, "90001", "USA", null, null, null, "CA", "Los Angeles");
    Address validAddress2 = new USAddress("Broadway Ave", 120, "60640", "usa", "B", null, "Apt 12", "IL", "Chicago");

    @Test
    void validateAddress_whenPassingNonUSAddress_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {usAddressValidator.validateAddress(spanishAddress);});
        assertEquals("address is not an instance of USAddress class", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUSAddressWithInvalidStateAbbreviation_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {usAddressValidator.validateAddress(addressWithInvalidStateAbbreviation);});
        assertEquals("Invalid US address: the entered state abbreviation does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUSAddressWith4DigitZipCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {usAddressValidator.validateAddress(addressWith4DigitZipCode);});
        assertEquals("Invalid US address: ZIP code must be composed of exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUSAddressWithZipCodeContainingLetters_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {usAddressValidator.validateAddress(addressWithZipCodeContainingLetter);});
        assertEquals("Invalid US address: ZIP code must be composed of exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidUSAddress_doesNotThrowException() {
        assertDoesNotThrow(() -> {usAddressValidator.validateAddress(validAddress1);});
        assertDoesNotThrow(() -> {usAddressValidator.validateAddress(validAddress2);});
    }
}