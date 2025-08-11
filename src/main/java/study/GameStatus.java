package study;

public enum GameStatus {
    IN_PROGRESS("게임 진행중"),
    END("게임 종료");

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }
}
