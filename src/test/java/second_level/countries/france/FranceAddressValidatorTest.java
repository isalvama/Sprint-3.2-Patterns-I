package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.exception.InvalidAddressException;
import second_level.model.Address;
import second_level.model.FranceAddress;
import second_level.model.UKAddress;
import second_level.core.validator.AddressValidator;

import static org.junit.jupiter.api.Assertions.*;

class FranceAddressValidatorTest implements WithAssertions {
    private final AddressValidator franceAddressValidator = new FranceAddressValidator();
    private final Address ukAddress = new UKAddress("Church Lane", 2, "SN1 1AA", "United Kingdom", null, 4, "Apt 203", "Swindon");
    private final Address addressWith4DigitPostalCode = new FranceAddress("Rue De L'Exposition", 24, "7507", "France", null, null, null, "paris");
    private final Address addressWithPostalCodeContainingLetter = new FranceAddress("Rue de la marine", 97, "3EFW9", "France", null, null, null, "Biarritz");
    private final Address validAddress1 = new FranceAddress("Rue De L'Exposition", 24, "75070", "France", null, null, null, "paris");
    private final Address validAddress2 = new FranceAddress("Rue De Saint-André D'Ornay", 76, "85000", "France", null, 2, "Apt 25", "La Roche-Sur-Lyon");

    @Test
    void validateAddress_whenPassingNonFrenchAddress_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {franceAddressValidator.validateAddress(ukAddress);});
        assertEquals("address is not an instance of FranceAddress class", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingFrenchAddressWith4DigitPostalCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {franceAddressValidator.validateAddress(addressWith4DigitPostalCode);});
        assertEquals("Invalid French address: postal code must be exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingFrenchAddressWithPostalCodeContainingLetter_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {franceAddressValidator.validateAddress(addressWithPostalCodeContainingLetter);});
        assertEquals("Invalid French address: postal code must be exactly 5 numbers", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidFrenchAddress_noExceptionIsThrown() {
        assertDoesNotThrow(() -> {franceAddressValidator.validateAddress(validAddress1);});
        assertDoesNotThrow(() -> {franceAddressValidator.validateAddress(validAddress2);});
    }
}