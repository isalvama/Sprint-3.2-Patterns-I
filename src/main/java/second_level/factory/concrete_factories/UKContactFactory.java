package second_level.factory.concrete_factories;

import second_level.model.contact_data.UKContactData;
import second_level.factory.abstract_factory.ContactFactory;
import second_level.model.abstract_models.Address;
import second_level.model.abstract_models.Phone;
import second_level.model.concrete_models.*;
import second_level.model.concrete_models.address.UKAddress;
import second_level.model.concrete_models.phone.UKPhone;

public class UKContactFactory implements ContactFactory {
    private final UKContactData contactData;
    private final HousingDetails housingDetails;

    public UKContactFactory(String streetName, int streetNumber, String postalCode, String town, String moreInfo, Integer floor, String door, String phoneNumber){
        this.housingDetails = new HousingDetails(moreInfo, floor, door);
        this.contactData = new UKContactData(streetName, streetNumber, postalCode, town, phoneNumber);
    }

    @Override
    public Address createAddress() {
        return new UKAddress(contactData.streetName(), contactData.streetNumber(), contactData.postalCode(), housingDetails, contactData.town());
    }

    @Override
    public Phone createPhoneNumber() {
        return new UKPhone(contactData.phoneNumber());
    }
}
