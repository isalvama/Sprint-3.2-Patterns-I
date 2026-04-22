package second_level.countries.uk;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.model.Address;
import second_level.model.UKAddress;
import second_level.core.validator.AddressValidator;

class UKAddressFormatterTest implements WithAssertions {
    AddressValidator ukAddressValidator = new UKAddressValidator();
    UKAddressFormatter ukAddressFormatter = new UKAddressFormatter(ukAddressValidator);
    Address address = new UKAddress("High Street", 31, "SO31 4NG", "United Kingdom", null, null, null, "Oxford");
    Address address2 = new UKAddress("Princes Street", 120, "EH2 4AD", "United Kingdom", null, 1, "B", "Edinburgh");

    @Test
    void formatAddress_whenPassingUKAddressWithNullMoreInfoFloorAndDoor_returnsFormattedAddress() {
        assertThat(ukAddressFormatter.formatAddress(address)).isEqualTo("""
                31 High Street
                OXFORD
                SO31 4NG
                UNITED KINGDOM""");
    }

    @Test
    void formatAddress_whenPassingUKAddressWithNullMoreInfo_returnsFormattedAddress() {
        assertThat(ukAddressFormatter.formatAddress(address2)).isEqualTo("""
                1 B 120 Princes Street
                EDINBURGH
                EH2 4AD
                UNITED KINGDOM""");
    }
}