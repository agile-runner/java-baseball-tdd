package study;

import study.io.ConsoleInputHandler;
import study.io.ConsoleOutputHandler;
import study.io.InputHandler;
import study.io.OutputHandler;

public class JavaBaseball {
    public static final int TARGET_COUNT = 3;
    public static final int GAME_RESTART = 1;
    public static final int GAME_END = 2;

    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private Computer computer;
    private Umpire umpire;
    private GameStatus gameStatus;

    public JavaBaseball() {
        this.inputHandler = new ConsoleInputHandler();
        this.outputHandler = new ConsoleOutputHandler();
        this.computer = new Computer();
        this.umpire = new Umpire();
        this.gameStatus = GameStatus.END;
    }

    public void run() {
        gameStatus = GameStatus.IN_PROGRESS;
        int[] targets = computer.generateRandomNumber();

        while (gameStatus == GameStatus.IN_PROGRESS) {
            outputHandler.showMessageForUserInput();
            int[] userInputs = inputHandler.getDigitsFromUser();

            int ballCount = umpire.inquireBallCount(userInputs, targets);
            int strikeCount = umpire.inquireStrikeCount(userInputs, targets);

            outputHandler.showUmpireCall(ballCount, strikeCount);

            if (strikeCount == TARGET_COUNT) {
                outputHandler.showGameWinningMessage();
                outputHandler.showRestartOrQuitOptions();

                int selection = inputHandler.getSelectionFromUser();
                if (selection == GAME_END) {
                    gameStatus = GameStatus.END;
                    continue;
                }
                if (selection == GAME_RESTART) {
                    targets = computer.generateRandomNumber();
                    continue;
                }
                throw new IllegalArgumentException("사용자 입력은 1과 2만 가능합니다.");
            }
        }
    }
}
