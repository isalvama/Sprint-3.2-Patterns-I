package second_level.format;

public class SpanishPhoneValidator implements PhoneValidator {
    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new IllegalArgumentException("Phone number cannot be negative");
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new IllegalArgumentException("Phone number must have 9 digits");
        if (numStr.charAt(0) < 6 || numStr.charAt(0) > 9) throw new IllegalArgumentException("Invalid Spanish phone number: number must start with 6, 7, 8, or 9");
        return numStr;
    }
}
