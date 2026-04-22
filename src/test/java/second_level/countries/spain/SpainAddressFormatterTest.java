package second_level.countries.spain;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.model.SpanishAddress;
import second_level.core.validator.AddressValidator;

class SpainAddressFormatterTest implements WithAssertions {
    AddressValidator spanishAddressValidator = new SpainAddressValidator();
    SpainAddressFormatter spanishAddressFormatter = new SpainAddressFormatter(spanishAddressValidator);
    SpanishAddress address1 = new SpanishAddress("carrer Provença", 31, null, 2, "1", "Barcelona", "08010", "Barcelona", "Spain");
    SpanishAddress address2 = new SpanishAddress("Passeig del Carme", 22, null, null, null, "Sant Pere de Ribes", "08810", "Barcelona", "Spain");


    @Test
    void formatAddress_whenPassingSpanishAddressWithNullMoreInfo_returnsFormattedAddress() {
        assertThat(spanishAddressFormatter.formatAddress(address1)).isEqualTo("""
                carrer Provença, 31 2 1
                08010 Barcelona BARCELONA
                SPAIN""");
    }

    @Test
    void formatAddress_whenPassingSpanishAddressWithNullMoreInfoFloorAndDoor_returnsFormattedAddress() {
        assertThat(spanishAddressFormatter.formatAddress(address2)).isEqualTo("""
                Passeig del Carme, 22
                08810 Sant Pere de Ribes BARCELONA
                SPAIN""");
    }

}