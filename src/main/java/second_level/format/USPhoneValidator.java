package second_level.format;

public class USPhoneValidator implements PhoneValidator{
    @Override
    public String validatePhone(long number) throws InvalidPhoneException {
        if (number < 0) throw new InvalidPhoneException("Invalid US Phone Number: phone number can not be negative", number);
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new InvalidPhoneException("Invalid US Phone Number: phone number must have 9 digits", number);
        if (numStr.charAt(0) != '1') throw new InvalidPhoneException("Invalid US Phone Number: phone number must start with 2, 3, 4, 5, 6, 7, 8, or 9", number);
        return numStr;
    }
}
