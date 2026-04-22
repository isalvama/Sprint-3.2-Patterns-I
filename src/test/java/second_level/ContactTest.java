package second_level;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.factory.FormatFactory;
import second_level.countries.france.FranceFormatFactory;
import second_level.countries.spain.SpainFormatFactory;
import second_level.countries.uk.UKFormatFactory;
import second_level.countries.us.USFormatFactory;
import second_level.model.*;


class ContactTest implements WithAssertions {

    static FormatFactory franceFormatFactory = new FranceFormatFactory();
    static FormatFactory ukFormatFactory = new UKFormatFactory();
    static FormatFactory spainFormatFactory = new SpainFormatFactory();
    static FormatFactory usFormatFactory = new USFormatFactory();

    static final Contact contactFrance = new Contact(franceFormatFactory);
    static final Contact contactUK = new Contact(ukFormatFactory);
    static final Contact contactSpain = new Contact(spainFormatFactory);
    static final Contact contactUS = new Contact(usFormatFactory);

    Address frenchAddress = new FranceAddress("Rue De Saint-André D'Ornay", 76, "85000", "France", null, 2, "Apt 25", "La Roche-Sur-Lyon");
    Address spanishAddress = new SpanishAddress("Passeig del Carme", 22, null, null, null, "Sant Pere de Ribes", "08810", "Barcelona", "Spain");
    Address ukAddress = new UKAddress("Princes Street", 120, "EH2 4AD", "United Kingdom", null, 1, "B", "Edinburgh");
    Address usAddress = new USAddress("Broadway Ave", 120, "60640", "usa", "B", null, "Apt 12", "IL", "Chicago");

    Phone frenchPhone = new Phone(133099676);
    Phone spanishPhone = new Phone(932047721);
    Phone ukPhone = new Phone(7764456866L);
    Phone usPhone = new Phone(176445686);

    @Test
    void franceFormatFactoryFormatAddress_whenPassingFrenchAddress_returnsFormattedAddress() {
        assertThat(contactFrance.formatAddress(frenchAddress)).isEqualTo("""
                2 Apt 25, 76 Rue De Saint-André D'Ornay
                85000 LA ROCHE-SUR-LYON
                FRANCE""");
    }

    @Test
    void franceFormatFactoryFormatPhone_whenPassingFrenchValidNumber_returnsFormattedNumber() {
        assertThat(contactFrance.formatPhone(frenchPhone)).isEqualTo("+33 1 33 09 96 76");
    }

    @Test
    void spanishFormatFactoryFormatAddress_whenPassingSpanishAddress_returnsFormattedAddress() {
        assertThat(contactSpain.formatAddress(spanishAddress)).isEqualTo("""
                Passeig del Carme, 22
                08810 Sant Pere de Ribes BARCELONA
                SPAIN""");
    }

    @Test
    void spanishFormatFactoryFormatPhone_whenPassingSpanishNumber_returnsFormattedNumber() {
        assertThat(contactSpain.formatPhone(spanishPhone)).isEqualTo("+34 932 047 721");
    }

    @Test
    void ukFormatFactoryFormatAddress_whenPassingUKAddress_returnsFormattedAddress() {
        assertThat(contactUK.formatAddress(ukAddress)).isEqualTo("""
                1 B 120 Princes Street
                EDINBURGH
                EH2 4AD
                UNITED KINGDOM""");
    }

    @Test
    void ukFormatFactoryFormatPhone_whenPassingUKPhone_returnsFormattedPhone() {
        assertThat(contactUK.formatPhone(ukPhone)).isEqualTo("+44 77 6445 6866");
    }

    @Test
    void usFormatFactoryFormatAddress_whenPassingUSAddress_returnsFormattedAddress() {
        assertThat(contactUS.formatAddress(usAddress)).isEqualTo("""
                120 Broadway Ave Apt 12 B
                Chicago, IL 60640
                USA""");
    }

    @Test
    void usFormatFactoryFormatPhone_whenPassingUSPhone_returnsFormattedPhone() {
        assertThat(contactUS.formatPhone(usPhone)).isEqualTo("+1 176 445 686");
    }

}