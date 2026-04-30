package second_level.model.concrete_models.address;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.exception.InvalidAddressException;
import second_level.model.concrete_models.HousingDetails;

import static org.junit.jupiter.api.Assertions.*;

class USAddressTest implements WithAssertions {

    @Test
    void validateAddress_whenPassingUSAddressWithInvalidStateAbbreviation_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new USAddress("Main St", 1234, "90001", new HousingDetails(null, null, null), "IS", "Los Angeles");
        });
        assertEquals("Invalid US address: the entered state abbreviation does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUSAddressWith4DigitZipCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new USAddress("Cox Rd", 969, "2805", new HousingDetails(null, null, null), "NC", "Gastonia");
        });
        assertEquals("Invalid US address: ZIP code must be composed of exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUSAddressWithZipCodeContainingLetters_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new USAddress("Cox Rd", 969, "28S5W", new HousingDetails("Apt 25", 2, null), "NC", "Gastonia");
        });
        assertEquals("Invalid US address: ZIP code must be composed of exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidUSAddress_doesNotThrowException() {
        assertDoesNotThrow(() -> {new USAddress("Main St", 1234, "90001", new HousingDetails(null, null, null), "CA", "Los Angeles");});
        assertDoesNotThrow(() -> {new USAddress("Broadway Ave", 120, "60640", new HousingDetails("B", null, "Apt 12") , "IL", "Chicago");});
    }
}