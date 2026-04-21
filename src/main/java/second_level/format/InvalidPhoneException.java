package second_level.format;
import java.time.LocalDateTime;

public class InvalidPhoneException extends IllegalArgumentException {
    private final LocalDateTime timestamp;
    private final Object rejectedFieldValue;
    private final String rejectedFieldName;

    public InvalidPhoneException(String message, Object rejectedValue) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.rejectedFieldValue = rejectedValue;
        this.rejectedFieldName = "PhoneNumber";
    }
}
