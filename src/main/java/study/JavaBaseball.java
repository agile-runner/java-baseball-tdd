package study;

import study.io.ConsoleInputHandler;
import study.io.ConsoleOutputHandler;
import study.io.InputHandler;
import study.io.OutputHandler;

public class JavaBaseball {
    public static final int TARGET_COUNT = 3;
    public static final int GAME_RESTART = 1;
    public static final int GAME_END = 2;

    // TODO: 전역변수가 최선의 선택일까? 다시 한 번 확인하기
    private int[] targets;
    private int ballCount;
    private int strikeCount;

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
            requestUmpireCallFor(pitch);

            checkAndProcessGameWin();
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

    private void requestUmpireCallFor(int[] guess) {
        ballCount = umpire.inquireBallCount(guess, targets);
        strikeCount = umpire.inquireStrikeCount(guess, targets);

        outputHandler.showUmpireCall(ballCount, strikeCount);
    }

    private void checkAndProcessGameWin() {
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
        throw new IllegalArgumentException("사용자는 주어진 옵션만 선택 가능합니다.");
    }
}
