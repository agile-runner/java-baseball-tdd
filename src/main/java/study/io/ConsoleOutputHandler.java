package study.io;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void showMessageForUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    @Override
    public void showUmpireCall(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
            return;
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    @Override
    public void showRestartOrQuitOptions() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void showGameWinningMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
