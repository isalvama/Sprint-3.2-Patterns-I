package second_level.format;

public class ChinaPhoneValidator implements PhoneValidator {

    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new IllegalArgumentException("Phone number cannot be negative");
        String numStr = String.valueOf(number);
        if (numStr.length() != 11) throw new IllegalArgumentException("Phone number must have 11 digits");
        if (numStr.charAt(0) != 1) throw new IllegalArgumentException("Invalid Chinese phone number: number must start with 1");
        if (numStr.charAt(0) < 3 || numStr.charAt(0) > 9) throw new IllegalArgumentException("Invalid Chinese phone number: second digit must range from 3 to 9");
        return numStr;
    }
}
