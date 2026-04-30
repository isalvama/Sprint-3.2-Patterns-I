package second_level.model.concrete_models.address;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.exception.InvalidAddressException;
import second_level.model.concrete_models.HousingDetails;

import static org.junit.jupiter.api.Assertions.*;

class FranceAddressTest implements WithAssertions {

    @Test
    void validateAddress_whenPassingFrenchAddressWith4DigitPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {new FranceAddress("Rue De L'Exposition", 24, "7507", "paris", new HousingDetails(null, null, null));});
        assertEquals("Invalid French address: postal code must be exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingFrenchAddressWithPostalCodeContainingLetter_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {new FranceAddress("Rue de la marine", 97, "3EFW9", "Biarritz", new HousingDetails(null, null, null));});
        assertEquals("Invalid French address: postal code must be exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidFrenchAddress_noExceptionIsThrown() {
        assertDoesNotThrow(() -> {new FranceAddress("Rue De L'Exposition", 24, "75070", "paris", new HousingDetails(null, null, null));});
        assertDoesNotThrow(() -> {new FranceAddress("Rue De Saint-André D'Ornay", 76, "85000", "La Roche-Sur-Lyon", new HousingDetails(null, 2, "Apt 25"));});
    }
}