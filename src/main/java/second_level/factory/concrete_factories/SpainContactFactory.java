package second_level.factory.concrete_factories;

import second_level.model.contact_data.SpainContactData;
import second_level.factory.abstract_factory.ContactFactory;
import second_level.model.abstract_models.Address;
import second_level.model.abstract_models.Phone;
import second_level.model.concrete_models.HousingDetails;
import second_level.model.concrete_models.address.SpainAddress;
import second_level.model.concrete_models.phone.SpainPhone;

public class SpainContactFactory implements ContactFactory {
    private final SpainContactData contactData;
    private final HousingDetails housingDetails;

    public SpainContactFactory(String streetName, Integer streetNumber, String postalCode, String town, String province, String phoneNumber, String moreInfo, Integer floor, String door){
        this.housingDetails = new HousingDetails(moreInfo, floor, door);
        this.contactData = new SpainContactData(streetName, streetNumber, postalCode, town, province, phoneNumber);
    }

    @Override
    public Address createAddress() {
        return new SpainAddress(contactData.streetName(), contactData.streetNumber(), contactData.postalCode(), contactData.town(), contactData.province(), housingDetails);
    }

    @Override
    public Phone createPhoneNumber() {
        return new SpainPhone(contactData.phoneNumber());
    }
}
