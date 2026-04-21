package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.exception.InvalidAddressException;
import second_level.model.Address;
import second_level.model.FranceAddress;
import second_level.model.SpanishAddress;
import second_level.core.validator.AddressValidator;
import second_level.countries.spain.SpainAddressValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SpainAddressValidatorTest implements WithAssertions {
    AddressValidator spainAddressValidator = new SpainAddressValidator();
    Address frenchAddress = new FranceAddress("rue de la marine", 12, "09000", "France", null, null, null, "Marseille");
    SpanishAddress spanishAddress = new SpanishAddress("Passeig del Carme", 22, null, null, null, "Sant Pere de Ribes", "08810", "Garraf", "Spain");
    SpanishAddress spanishAddress2 = new SpanishAddress("carrer de Sants", 104, null, null, null, "Barcelona", "0801", "Barcelona", "Spain");
    SpanishAddress spanishAddress3 = new SpanishAddress("carrer de Sants", 104, null, null, null, "Barcelona", "81010", "Barcelona", "Spain");
    SpanishAddress validAddress1 = new SpanishAddress("carrer Provença", 31, null, 2, "1", "Barcelona", "08010", "Barcelona", "Spain");
    SpanishAddress validAddress2 = new SpanishAddress("Passeig del Carme", 22, null, null, null, "Sant Pere de Ribes", "08810", "Barcelona", "Spain");



    @Test
    void validateAddress_whenPassingNonSpanishAddress_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {spainAddressValidator.validateAddress(frenchAddress);});
        assertEquals("Invalid address: address is not an instance of SpanishAddress class", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingSpainAddressWithInvalidProvince_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {spainAddressValidator.validateAddress(spanishAddress);});
        assertEquals("Invalid Spanish address: province does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingSpainAddressWith4DigitsLongPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {spainAddressValidator.validateAddress(spanishAddress2);});
        assertEquals("Invalid Spanish address: postal code must contain 5 digits", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingSpainAddressWithNonExistentBeggingPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {spainAddressValidator.validateAddress(spanishAddress3);});
        assertEquals("Invalid Spanish address: postal code does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidSpainAddress_noThrowsInvalidAddressException() {
        assertDoesNotThrow(() -> {spainAddressValidator.validateAddress(validAddress1);});
        assertDoesNotThrow(() -> {spainAddressValidator.validateAddress(validAddress2);});
    }
}