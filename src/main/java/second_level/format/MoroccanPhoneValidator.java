package second_level.format;

public class MoroccanPhoneValidator implements PhoneValidator{

    @Override
    public String validatePhone(long number) {
        if (number < 0) throw new IllegalArgumentException("Phone number cannot be negative");
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new IllegalArgumentException("Phone number must have 9 digits");
        if (numStr.charAt(0) != 6 && numStr.charAt(0) != 5) throw new IllegalArgumentException("Invalid Moroccan phone number: number must start with 5 or 6");
        return numStr;
    }
}
