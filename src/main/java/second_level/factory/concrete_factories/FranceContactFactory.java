package second_level.factory.concrete_factories;

import second_level.model.contact_data.FranceContactData;
import second_level.factory.abstract_factory.ContactFactory;
import second_level.model.abstract_models.Address;
import second_level.model.abstract_models.Phone;
import second_level.model.concrete_models.address.FranceAddress;
import second_level.model.concrete_models.phone.FrancePhone;
import second_level.model.concrete_models.HousingDetails;

public class FranceContactFactory implements ContactFactory {
    private final FranceContactData contactData;
    private final HousingDetails housingDetails;

    public FranceContactFactory(String streetName, int streetNumber, String postalCode, String town, String moreInfo, Integer floor, String door, String phoneNumber){
        this.housingDetails = new HousingDetails(moreInfo, floor, door);
        this.contactData = new FranceContactData(streetName, streetNumber, postalCode, town, phoneNumber);
    }

    @Override
    public Address createAddress() {
        return new FranceAddress(contactData.streetName(), contactData.streetNumber(), contactData.postalCode(), contactData.town(), housingDetails);
    }

    @Override
    public Phone createPhoneNumber() {
        return new FrancePhone(contactData.phoneNumber());
    }
}

