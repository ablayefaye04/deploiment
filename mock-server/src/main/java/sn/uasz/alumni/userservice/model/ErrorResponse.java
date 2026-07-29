package sn.uasz.alumni.userservice.model;

import java.time.OffsetDateTime;

public class ErrorResponse {
    private OffsetDateTime timestamp;
    private int status;
    private String message;
    private String path;

    public ErrorResponse(int status, String message, String path) {
        this.timestamp = OffsetDateTime.now();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public OffsetDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
}
