package second_level.model.concrete_models.phone;

import second_level.exception.InvalidPhoneException;
import second_level.model.abstract_models.Phone;

public class USPhone extends Phone {

    public USPhone(String number) {
        super(number);
    }

    @Override
    protected void validate(String number) {
        if (!number.matches("[0-9]{9}")) throw new InvalidPhoneException("Invalid US Phone Number: phone number must only contain 9 digits", number);
        if (number.charAt(0) != '1') throw new InvalidPhoneException("Invalid US Phone Number: phone number must start with 2, 3, 4, 5, 6, 7, 8, or 9", number);
    }

    @Override
    protected String format(String number) {
        return String.format("+1 %s %s %s", number.substring(0, 3), number.substring(3, 6), number.substring(6, 9));
    }
}
