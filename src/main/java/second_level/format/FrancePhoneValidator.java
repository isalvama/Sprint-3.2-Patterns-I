package second_level.format;

public class FrancePhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new InvalidPhoneException("Invalid French Phone number: phone number cannot be negative", number);
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new InvalidPhoneException("Invalid French Phone number: phone number must have 9 digits", number);
        return numStr;
    }
}
