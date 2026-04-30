package second_level.factory.concrete_factories;

import second_level.model.contact_data.USContactData;
import second_level.factory.abstract_factory.ContactFactory;
import second_level.model.abstract_models.Address;
import second_level.model.abstract_models.Phone;
import second_level.model.concrete_models.*;
import second_level.model.concrete_models.address.USAddress;
import second_level.model.concrete_models.phone.USPhone;

public class USContactFactory implements ContactFactory {
    private final USContactData contactData;
    private final HousingDetails housingDetails;

    public USContactFactory(String streetName, int streetNumber, String postalCode, String stateAbbreviation, String postOffice, String moreInfo, Integer floor, String door, String phoneNumber){
        this.housingDetails = new HousingDetails(moreInfo, floor, door);
        this.contactData = new USContactData(streetName, streetNumber, postalCode, stateAbbreviation, postOffice, phoneNumber);
    }

    @Override
    public Address createAddress() {
        return new USAddress(contactData.streetName(), contactData.streetNumber(), contactData.postalCode(), housingDetails, contactData.stateAbbreviation(), contactData.postOffice());
    }

    @Override
    public Phone createPhoneNumber() {
        return new USPhone(contactData.phoneNumber());
    }
}
