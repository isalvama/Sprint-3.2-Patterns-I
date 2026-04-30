package second_level.factory.abstract_factory;

import second_level.model.abstract_models.Address;
import second_level.model.abstract_models.Phone;

public interface ContactFactory {
     Address createAddress();
     Phone createPhoneNumber();
}
