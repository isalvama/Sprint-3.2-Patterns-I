package second_level.countries.us;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.formatter.AddressFormatter;
import second_level.model.Address;
import second_level.model.USAddress;
import second_level.core.validator.AddressValidator;

class USAddressFormatterTest implements WithAssertions {
    AddressValidator usAddressValidator = new USAddressValidator();
    AddressFormatter usAddressFormatter = new USAddressFormatter(usAddressValidator);
    Address address = new USAddress("Main St", 1234, "90001", "USA", null, null, null, "CA", "Los Angeles");
    Address address2 = new USAddress("Broadway Ave", 120, "60640", "usa", "B", null, "Apt 12", "IL", "Chicago");
    @Test
    void formatAddress_whenPassingUSAddressWithNullMoreInfoFloorAndDoor_returnsFormattedAddress() {
        assertThat(usAddressFormatter.formatAddress(address)).isEqualTo("""
                1234 Main St
                Los Angeles, CA 90001
                USA""");
    }

    @Test
    void formatAddress_whenPassingUSAddressWithNullMoreInfo_returnsFormattedAddress() {
        assertThat(usAddressFormatter.formatAddress(address2)).isEqualTo("""
                120 Broadway Ave Apt 12 B
                Chicago, IL 60640
                USA""");
    }
}