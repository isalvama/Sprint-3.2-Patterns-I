package second_level;

public class CommonRules {
    public static ValidationRule<String> notEmpty(String fieldName) {
        return value -> {
            if (value == null || value.isBlank()) throw new IllegalArgumentException(fieldName + " can not be empty");
        };
    }

    public static ValidationRule<String> matchRegex(String regexPattern, String errorMessage) {
        return value -> {
            if (!value.matches(regexPattern)) throw new IllegalArgumentException(errorMessage);
        };
    }
}
