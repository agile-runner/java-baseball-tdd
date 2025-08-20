package study.exception;

public enum ErrorCode {
    /**
    * 입출력 관련 에러 코드
    */
    USER_INPUT_REQUIRED_THREE_DIGIT("사용자 입력은 세 자리만 가능합니다.", "IO001"),
    EACH_DIGIT_REQUIRED_UNIQUE("각 자리 숫자는 중복될 수 없습니다.", "IO002"),
    SELECTION_REQUIRED_SINGLE_DIGIT("사용자 입력은 한 자리만 가능합니다.", "IO003"),
    USER_INPUT_REQUIRED_NUMERIC_TYPE("사용자 입력은 숫자만 가능합니다.", "IO004"),

    /**
     * 게임 관련 에러 코드
     */
    SELECTION_INVALID_OPTION("사용자는 주어진 옵션만 선택 가능합니다.", "G001");

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
