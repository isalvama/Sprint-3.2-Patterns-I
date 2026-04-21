package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.exception.InvalidAddressException;
import second_level.model.Address;
import second_level.model.SpanishAddress;
import second_level.model.UKAddress;
import second_level.core.validator.AddressValidator;
import second_level.countries.uk.UKAddressValidator;

import static org.junit.jupiter.api.Assertions.*;

class UKAddressValidatorTest implements WithAssertions {
    AddressValidator ukAddressValidator = new UKAddressValidator();
    SpanishAddress spanishAddress = new SpanishAddress("carrer Provença", 31, null, 2, "1", "Barcelona", "08010", "Barcelona", "Spain");
    Address addressWithOutwardOnlyPostCode = new UKAddress("High Street", 31, "SO3", "United Kingdom", null, null, null, "Oxford");
    Address addressWithOutwarOnlyAndBlankSpacePostCode = new UKAddress("High Street", 31, "AO21 ", "United Kingdom", null, null, null, "Oxford");
    Address addressWithInvalidOutwardPostCode = new UKAddress("Princes Street", 120, "E 4AD", "United Kingdom", null, 1, "B", "Edinburgh");
    Address addressWithInvalidInwardPostCode = new UKAddress("Princes Street", 120, "NW4 ATP", "United Kingdom", null, 1, "B", "Edinburgh");
    Address validAddress1 = new UKAddress("Church Lane", 2, "SN1 1AA", "United Kingdom", null, 4, "Apt 203", "Swindon");
    Address validAddress2 = new UKAddress("High Street", 31, "SO31 4NG", "United Kingdom", null, null, null, "Oxford");
    Address validAddress3 = new UKAddress("Princes Street", 120, "EH2 4AD", "United Kingdom", null, 1, "B", "Edinburgh");


    @Test
    void validateAddress_whenPassingNonUKAddress_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {ukAddressValidator.validateAddress(spanishAddress);});
        assertEquals("address is not an instance of UKAddress class", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithOutwardOnlyPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {ukAddressValidator.validateAddress(addressWithOutwardOnlyPostCode);});
        assertEquals("Invalid UK address: Postcode must be composed of 2 parts separated by a blank space", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithOutwarOnlyAndBlankSpacePostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {ukAddressValidator.validateAddress(addressWithOutwarOnlyAndBlankSpacePostCode);});
        assertEquals("Invalid UK address: Postcode must be composed of exactly 2 parts", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithInvalidOutwardPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {ukAddressValidator.validateAddress(addressWithInvalidOutwardPostCode);});
        assertEquals("Invalid UK address: First part of Postcode (outward) must be 2-4 alphanumeric characters.", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithInvalidInwardPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {ukAddressValidator.validateAddress(addressWithInvalidInwardPostCode);});
        assertEquals("Invalid UK address: Second part of Postcode (inward) must be a digit followed by two letters", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidUKAddress_noThrowsInvalidAddressException() {
        assertDoesNotThrow(() -> {ukAddressValidator.validateAddress(validAddress1);});
        assertDoesNotThrow(() -> {ukAddressValidator.validateAddress(validAddress2);});
        assertDoesNotThrow(() -> {ukAddressValidator.validateAddress(validAddress3);});

    }
}