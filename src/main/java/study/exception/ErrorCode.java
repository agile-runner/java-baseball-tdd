package study.exception;

public enum ErrorCode {
    ;

    private final String message;
    private final String errorId;

    ErrorCode(String message, String errorId) {
        this.message = message;
        this.errorId = errorId;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorId() {
        return errorId;
    }
}
