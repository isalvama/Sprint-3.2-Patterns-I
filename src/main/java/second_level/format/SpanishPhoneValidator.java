package second_level.format;

public class SpanishPhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number){
        if (number < 0) throw new InvalidPhoneException("Invalid Spanish Phone number: phone number cannot be negative", number);
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new InvalidPhoneException("Invalid Spanish Phone number: phone number must have 9 digits", number);
        if (Integer.parseInt(numStr.substring(0,1)) < 6 || Integer.parseInt(numStr.substring(0,1)) > 9) throw new InvalidPhoneException("Invalid Spanish phone number: number must start with 6, 7, 8, or 9", number);
        return numStr;
    }
}
