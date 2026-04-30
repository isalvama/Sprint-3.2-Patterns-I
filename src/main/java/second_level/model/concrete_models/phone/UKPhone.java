package second_level.model.concrete_models.phone;

import second_level.exception.InvalidPhoneException;
import second_level.model.abstract_models.Phone;

import java.util.List;

public class UKPhone extends Phone {
    private static final List<String> FIRST_VALID_NUMBERS = List.of("75", "71", "79", "77", "1", "2");

    public UKPhone(String number) {
        super(number);

    }

    @Override
    protected void validate(String number) {
        if (!number.matches("[0-9]{10}")) throw new InvalidPhoneException("Invalid UK Phone Number: phone number must only contain 10 digits", number);
        boolean fistPartIsValid = FIRST_VALID_NUMBERS.stream().anyMatch(number::startsWith);
        if (!fistPartIsValid) throw new InvalidPhoneException("Invalid UK Phone Number: phone number must start with 75, 71, 79, 77, 1, or 2", number);
    }

    @Override
    protected String format(String number) {
        return String.format("+44 %s %s %s", number.substring(0, 2), number.substring(2, 6), number.substring(6, 10));
    }
}
