package study.exception;

public class GameException extends RuntimeException {

    public GameException() {
    }

    public GameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

    public GameException(String message) {
        super(message);
    }
}
