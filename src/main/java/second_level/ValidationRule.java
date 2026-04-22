package second_level;

@FunctionalInterface
public interface ValidationRule <T>{
    void validate(T target) throws IllegalArgumentException;
}
