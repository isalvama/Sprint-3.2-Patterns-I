package second_level.format;

public class UKPhoneValidator implements PhoneValidator{
    @Override
    public String validatePhone(long number) {
        String numStr = String.valueOf(number);
        if (numStr.length() != 10) throw new IllegalArgumentException("Phone number must have 10 digits");
        if ((!numStr.startsWith("75")) && (!numStr.startsWith("71")) && (!numStr.startsWith("79")) && (!numStr.startsWith("1")) && (!numStr.startsWith("2"))) throw new IllegalArgumentException("Invalid UK phone number: number must start with 75, 71, 79, 1, or 2");
        return numStr;
    }
}
