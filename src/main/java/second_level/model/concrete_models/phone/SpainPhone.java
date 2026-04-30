package second_level.model.concrete_models.phone;

import second_level.exception.InvalidPhoneException;
import second_level.model.abstract_models.Phone;

public class SpainPhone extends Phone {

    public SpainPhone (String number){
        super(number);
    }

    @Override
    protected void validate(String number) {
        if (!number.matches("[0-9]{9}")) throw new InvalidPhoneException("Invalid Spanish Phone Number: phone number must only contain 9 digits", number);
        if (Integer.parseInt(number.substring(0,1)) < 6 || Integer.parseInt(number.substring(0,1)) > 9) throw new InvalidPhoneException("Invalid Spanish Phone Number: phone number must start with 6, 7, 8, or 9", number);
    }

    @Override
    protected String format(String number) {
        return String.format("+34 %s %s %s", number.substring(0, 3), number.substring(3, 6), number.substring(6, 9));
    }
}
