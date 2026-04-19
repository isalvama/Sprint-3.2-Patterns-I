package second_level.format;

public class NANPPhoneValidator implements PhoneValidator{
    @Override
    public String validatePhone(long number) {
        String numStr = String.valueOf(number);
        if (numStr.length() != 9) throw new IllegalArgumentException("Phone number must have 9 numbers");
        if (numStr.charAt(0) == '1' || numStr.charAt(0) == '-') throw new IllegalArgumentException("Invalid NANP phone number: number must start with 2, 3, 4, 5, 6, 7, 8, or 9");
        return numStr;
    }
}
