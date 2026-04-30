package second_level.model.concrete_models.address;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.exception.InvalidAddressException;
import second_level.model.abstract_models.Address;
import second_level.model.concrete_models.HousingDetails;

import static org.junit.jupiter.api.Assertions.*;

class UKAddressTest implements WithAssertions {

    @Test
    void validateAddress_whenPassingUKAddressWithOutwardOnlyPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new UKAddress("High Street", 31, "SO3", new HousingDetails(null, null, null), "Oxford");
        });
        assertEquals("Invalid UK address: Postcode must be composed of 2 parts separated by a blank space", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithOutwarOnlyAndBlankSpacePostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new UKAddress("High Street", 31, "AO21 ", new HousingDetails(null, null, null), "Oxford");
        });
        assertEquals("Invalid UK address: Postcode must be composed of exactly 2 parts", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithInvalidOutwardPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new UKAddress("Princes Street", 120, "E 4AD", new HousingDetails(null, 1, "B"), "Edinburgh");
        });
        assertEquals("Invalid UK address: First part of Postcode (outward) must be 2-4 alphanumeric characters.", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingUKAddressWithInvalidInwardPostCode_throwsInvalidAddressExceptionWithExpectedMessage() {
        IllegalArgumentException exception = assertThrows(InvalidAddressException.class, () -> {
            new UKAddress("Princes Street", 120, "NW4 ATP", new HousingDetails(null, 1, "B"), "Edinburgh");
        });
        assertEquals("Invalid UK address: Second part of Postcode (inward) must be a digit followed by two letters", exception.getMessage());
    }

    @Test
    void validateAddress_whenPassingValidUKAddress_noThrowsInvalidAddressException() {
        assertDoesNotThrow(() -> {
            new UKAddress("Church Lane", 2, "SN1 1AA", new HousingDetails(null, 4, "Apt 203"), "Swindon");
        });
        assertDoesNotThrow(() -> {
            new UKAddress("High Street", 31, "SO31 4NG", new HousingDetails(null, null, null), "Oxford");
        });
        assertDoesNotThrow(() -> {
                    new UKAddress("Princes Street", 120, "EH2 4AD", new HousingDetails(null, 1, "B"), "Edinburgh");
                }
        );

    }
}