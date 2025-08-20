package study;

import study.exception.GameException;
import study.io.ConsoleInputHandler;
import study.io.ConsoleOutputHandler;
import study.io.InputHandler;
import study.io.OutputHandler;

import static study.exception.ErrorCode.SELECTION_INVALID_OPTION;

public class JavaBaseball {
    public static final int TARGET_COUNT = 3;
    public static final int GAME_RESTART = 1;
    public static final int GAME_END = 2;

    private int[] targets;

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
    }

    public void run() {
        initialize();

        while (isInProgress()) {
            int[] pitch = askUserForDigits();
            int strikeCount = requestUmpireCallFor(pitch);

            checkAndProcessGameWin(strikeCount);
        }
    }

    private void initialize() {
        gameStatus = GameStatus.IN_PROGRESS;
        targets = computer.generateRandomNumber();
    }

    private boolean isInProgress() {
        return gameStatus == GameStatus.IN_PROGRESS;
    }

    private int[] askUserForDigits() {
        outputHandler.showMessageForUserInput();
        return inputHandler.getDigitsFromUser();
    }

    private int requestUmpireCallFor(int[] guess) {
        int ballCount = umpire.inquireBallCount(guess, targets);
        int strikeCount = umpire.inquireStrikeCount(guess, targets);

        outputHandler.showUmpireCall(ballCount, strikeCount);
        return strikeCount;
    }

    private void checkAndProcessGameWin(int strikeCount) {
        if (strikeCount == TARGET_COUNT) {
            outputHandler.showGameWinningMessage();
            outputHandler.showRestartOrQuitOptions();
            handleRestartOrQuit();
        }
    }

    private void handleRestartOrQuit() {
        int selection = inputHandler.getSelectionFromUser();

        if (selection == GAME_END) {
            gameStatus = GameStatus.END;
            return;
        }
        if (selection == GAME_RESTART) {
            targets = computer.generateRandomNumber();
            return;
        }
        throw new GameException(SELECTION_INVALID_OPTION);
    }
}
