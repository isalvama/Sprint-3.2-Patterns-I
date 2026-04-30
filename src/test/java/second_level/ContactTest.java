package second_level;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import second_level.core.Contact;
import second_level.factory.abstract_factory.ContactFactory;
import second_level.factory.concrete_factories.FranceContactFactory;
import second_level.factory.concrete_factories.SpainContactFactory;
import second_level.factory.concrete_factories.UKContactFactory;
import second_level.factory.concrete_factories.USContactFactory;


class ContactTest implements WithAssertions {

    @Test
    void contactSpainToString_whenPassingValidSpanishAddressAndPhone_returnsFormattedContactData() {
        ContactFactory spainFactory = new SpainContactFactory("Carrer Major", 34, "08001", "Barcelona", "Barcelona", "623456789", null, 2, "3");
        Contact contactSpain = new Contact(spainFactory);

        assertThat(contactSpain.toString()).isEqualTo("Carrer Major, 34 2 3\n" +
                "08001 Barcelona BARCELONA\n" +
                "SPAIN\n" +
                "+34 623 456 789");
    }


    @Test
    void contactSpainToString_whenPassingValidSpanishAddressWithoutHousingDetailsAndPhone_returnsFormattedContactData() {
        ContactFactory spainFactory = new SpainContactFactory("Passeig del Carme", 22, "08810", "Sant Pere de Ribes", "Barcelona", "932047721", null, null, null);
        Contact contactSpain = new Contact(spainFactory);

        assertThat(contactSpain.toString()).isEqualTo("Passeig del Carme, 22 \n" +
                "08810 Sant Pere de Ribes BARCELONA\n" +
                "SPAIN\n" +
                "+34 932 047 721");
    }

    @Test
    void contactFranceToString_whenPassingValidFrenchAddressAndPhone_returnsFormattedContactData() {
        ContactFactory franceFactory = new FranceContactFactory("Rue De Saint-André D'Ornay", 76, "85000", "France", null, 2, "Apt 25", "133099676");
        Contact contactSpain = new Contact(franceFactory);

        assertThat(contactSpain.toString()).isEqualTo("2 Apt 25, 76 Rue De Saint-André D'Ornay\n" +
                "85000 FRANCE\n" +
                "FRANCE\n" +
                "+33 1 33 09 96 76");
    }

    @Test
    void contactFranceToString_whenPassingValidFrenchAddressWithoutHousingDetailsAndPhone_returnsFormattedContactData() {
        ContactFactory franceFactory = new FranceContactFactory("Rue De L'Exposition", 24, "75007", "Paris", null, null, null, "686445686");
        Contact contactSpain = new Contact(franceFactory);

        assertThat(contactSpain.toString()).isEqualTo("24 Rue De L'Exposition\n" +
                "75007 PARIS\n" +
                "FRANCE\n" +
                "+33 6 86 44 56 86");
    }

    @Test
    void contactUKToString_whenPassingValidUKAddressAndPhone_returnsFormattedContactData() {
        ContactFactory UKFactory = new UKContactFactory("Princes Street", 120, "EH2 4AD", "Edinburgh", null, 1, "B", "1539903734");
        Contact contactSpain = new Contact(UKFactory);

        assertThat(contactSpain.toString()).isEqualTo("1 B 120 Princes Street\n" +
                "EDINBURGH\n" +
                "EH2 4AD\n" +
                "UK\n" +
                "+44 15 3990 3734");
    }

    @Test
    void contactUKToString_whenPassingValidUKAddressWithoutHousingDetailsAndPhone_returnsFormattedContactData() {
        ContactFactory UKFactory = new UKContactFactory("High Street", 31, "SO31 4NG", "Oxford", null, null, null, "7764456866");
        Contact contactSpain = new Contact(UKFactory);

        assertThat(contactSpain.toString()).isEqualTo("31 High Street\n" +
                "OXFORD\n" +
                "SO31 4NG\n" +
                "UK\n" +
                "+44 77 6445 6866");
    }

    @Test
    void contactUSToString_whenPassingValidUSAddressAndPhone_returnsFormattedContactData() {
        ContactFactory USFactory = new USContactFactory("Broadway Ave", 120, "60640", "IL", "Chicago", null, null, "Apt 12", "176445686");
        Contact contactSpain = new Contact(USFactory);

        assertThat(contactSpain.toString()).isEqualTo("120 Broadway Ave Apt 12\n" +
                "Chicago, IL 60640\n" +
                "USA\n" +
                "+1 176 445 686");
    }

    @Test
    void contactUSToString_whenPassingValidUSAddressWithoutHousingDetailsAndPhone_returnsFormattedContactData() {
        ContactFactory USFactory = new USContactFactory("Main St", 1234, "90001", "CA", "Los Angeles", null, null, null, "176445686");
        Contact contactSpain = new Contact(USFactory);

        assertThat(contactSpain.toString()).isEqualTo("1234 Main St\n" +
                "Los Angeles, CA 90001\n" +
                "USA\n" +
                "+1 176 445 686");
    }
}