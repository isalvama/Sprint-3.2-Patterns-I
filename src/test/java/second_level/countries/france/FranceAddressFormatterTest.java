package second_level.countries.france;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.formatter.AddressFormatter;
import second_level.model.Address;
import second_level.model.FranceAddress;
import second_level.core.validator.AddressValidator;

class FranceAddressFormatterTest implements WithAssertions {
    AddressValidator franceAddressValidator = new FranceAddressValidator();
    AddressFormatter franceAddressFormatter = new FranceAddressFormatter(franceAddressValidator);
    Address address = new FranceAddress("Rue De L'Exposition", 24, "75007", "France", null, null, null, "paris");
    Address address2 = new FranceAddress("Rue De Saint-André D'Ornay", 76, "85000", "France", null, 2, "Apt 25", "La Roche-Sur-Lyon");
    @Test
    void formatAddress_whenPassingFrenchAddressWithNullMoreInfoFloorAndDoor_returnsFormattedAddress() {
        assertThat(franceAddressFormatter.formatAddress(address)).isEqualTo("""
                24 Rue De L'Exposition
                75007 PARIS
                FRANCE""");
    }

    @Test
    void formatAddress_whenPassingFrenchAddressWithNullMoreInfo_returnsFormattedAddress() {
        assertThat(franceAddressFormatter.formatAddress(address2)).isEqualTo("""
                2 Apt 25, 76 Rue De Saint-André D'Ornay
                85000 LA ROCHE-SUR-LYON
                FRANCE""");
    }
}