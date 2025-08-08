package study.io;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private static final int BASE_LENGTH = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int[] getDigitsFromUser() {
        String userInput = SCANNER.nextLine();
        if (userInput.length() != BASE_LENGTH) {
            throw new IllegalArgumentException("사용자 입력은 세 자리만 가능합니다.");
        }

        int[] inputs = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            char characterFromUserInput = userInput.charAt(i);
            if (!Character.isDigit(characterFromUserInput)) {
                throw new IllegalArgumentException("사용자 입력은 숫자만 가능합니다.");
            }
            inputs[i] = characterFromUserInput - '0';
        }

        return inputs;
    }

    @Override
    public int[] getDigitsFromUser(Scanner scanner) {
        String userInput = scanner.nextLine();
        if (userInput.length() != BASE_LENGTH) {
            throw new IllegalArgumentException("사용자 입력은 세 자리만 가능합니다.");
        }

        int[] inputs = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            char characterFromUserInput = userInput.charAt(i);
            if (!Character.isDigit(characterFromUserInput)) {
                throw new IllegalArgumentException("사용자 입력은 숫자만 가능합니다.");
            }
            inputs[i] = characterFromUserInput - '0';
        }

        return inputs;
    }

}