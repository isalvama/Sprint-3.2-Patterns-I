package second_level.format;

public class FrancePhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new IllegalArgumentException("Phone number cannot be negative");
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new IllegalArgumentException("Phone number must have 9 digits");
        return numStr;
    }
}
