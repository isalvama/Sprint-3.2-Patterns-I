package second_level.model.concrete_models.address;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.exception.InvalidAddressException;
import second_level.model.concrete_models.HousingDetails;

import static org.junit.jupiter.api.Assertions.*;

class SpainAddressTest implements WithAssertions {

    @Test
    void validateAddress_whenPassingSpainAddressWithInvalidProvince_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {new SpainAddress("Passeig del Carme", 22, "08810", "Sant Pere de Ribes", "Garraf", new HousingDetails(null, null, null));});
        assertEquals("Invalid Spanish address: province does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingSpainAddressWith4DigitsLongPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {new SpainAddress("carrer de Sants", 104, "0801",  "Barcelona", "Barcelona", new HousingDetails(null, null, null));});
        assertEquals("Invalid Spanish address: postal code must contain 5 digits", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingSpainAddressWithNonExistentBegginningPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {new SpainAddress("carrer de Sants", 104, "81010", "Barcelona", "Barcelona", new HousingDetails(null, 2, "1"));});
        assertEquals("Invalid Spanish address: postal code does not exist", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidSpainAddress_noThrowsInvalidAddressException() {
        assertDoesNotThrow(() -> {new SpainAddress("carrer Provença", 31,  "08010", "Barcelona","Barcelona",new HousingDetails(null, 2, "1"));});
        assertDoesNotThrow(() -> {new SpainAddress("Passeig del Carme", 22, "08810","Sant Pere de Ribes", "Barcelona", new HousingDetails(null, null, null));});
    }
}