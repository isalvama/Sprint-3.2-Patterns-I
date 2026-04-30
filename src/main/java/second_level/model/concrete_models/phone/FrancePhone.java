package second_level.model.concrete_models.phone;

import second_level.exception.InvalidPhoneException;
import second_level.model.abstract_models.Phone;

public final class FrancePhone extends Phone {

    public FrancePhone(String number) {
        super(number);
    }

    @Override
    protected void validate(String number) {
        if (!number.matches("[0-9]{9}")) throw new InvalidPhoneException("Invalid French Phone Number: phone number must only contain 9 digits", number);
    }

    @Override
    protected String format(String number) {
        return String.format("+33 %s %s %s %s %s", number.charAt(0), number.substring(1, 3), number.substring(3, 5), number.substring(5, 7), number.substring(7, 9));
    }
}
