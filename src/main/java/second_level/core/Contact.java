package second_level.core;

import second_level.factory.abstract_factory.ContactFactory;

public class Contact {
    private final ContactFactory contactFactory;

    public Contact (ContactFactory contactFactory){
        this.contactFactory = contactFactory;
    }

    public String toString(){
        return String.format("%s\n%s", contactFactory.createAddress().formatAddress(), contactFactory.createPhoneNumber().getNumber());
    }
}