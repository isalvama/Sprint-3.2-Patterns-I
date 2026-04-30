package second_level.model.abstract_models;

import second_level.exception.InvalidPhoneException;

import java.util.Objects;

public abstract class Phone {
    protected final String number;

    public Phone (String number) {
        validateNotEmptyPhone(number);
        validate(number);
        this.number = format(number);
    }

    private void validateNotEmptyPhone(String number){
        if (number == null || number.isBlank()) throw new InvalidPhoneException("Invalid Phone Number: phone number can not be null or empty", number);
    }

    protected abstract void validate(String number);

    protected abstract String format(String number);

    public String getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
