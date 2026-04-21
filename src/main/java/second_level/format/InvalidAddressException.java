package second_level.format;

import java.time.LocalDateTime;

public class InvalidAddressException extends IllegalArgumentException {
    private final LocalDateTime timeStamp;
    private final Object rejectedFieldValue;
    private final String rejectedFieldName;

    public InvalidAddressException(String message, Object rejectedFieldValue, String rejectedFieldName) {
        super(message);
        this.timeStamp = LocalDateTime.now();
        this.rejectedFieldValue = rejectedFieldValue;
        this.rejectedFieldName = rejectedFieldName;
    }
}
