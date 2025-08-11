package study.io;

public interface OutputHandler {
    void showMessageForUserInput();
    void showUmpireCall(int ball, int strike);
    void showRestartOrQuitOptions();
    void showGameWinningMessage();
}
