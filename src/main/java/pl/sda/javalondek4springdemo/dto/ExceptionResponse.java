package pl.sda.javalondek4springdemo.dto;

import java.time.LocalDate;

public final class ExceptionResponse {

    private LocalDate timestamp;

    private int responseStatus;

    private String error;

    private String message;

    private String path;

    public ExceptionResponse(LocalDate timestamp, int responseStatus, String error, String message, String path) {
        this.timestamp = timestamp;
        this.responseStatus = responseStatus;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timestamp=" + timestamp +
                ", responseStatus=" + responseStatus +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}