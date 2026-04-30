package second_level.model.concrete_models;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record HousingDetails(String moreInfo, Integer floor, String door) {
    public String format(){
        return Stream.of(moreInfo, String.valueOf(floor), door)
                .filter(s -> s != null && !s.isBlank() && !s.equals("null"))
                .collect(Collectors.joining(" "));
    }
}
