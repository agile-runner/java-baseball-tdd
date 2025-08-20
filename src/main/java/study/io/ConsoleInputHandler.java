package study.io;

import study.exception.GameException;

import java.util.Scanner;

import static study.exception.ErrorCode.*;

public class ConsoleInputHandler implements InputHandler {
    private static final int BASE_LENGTH = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int[] getDigitsFromUser() {
        String userInput = SCANNER.nextLine();
        if (userInput.length() != BASE_LENGTH) {
            throw new GameException(USER_INPUT_REQUIRED_THREE_DIGIT);
        }
        
        int[] inputs = userInput.chars().map(unicode -> getIntegerFrom((char) unicode)).toArray();

        if ((inputs[0] == inputs[1]) || (inputs[0] == inputs[2]) || (inputs[1] == inputs[2])) {
            throw new GameException(EACH_DIGIT_REQUIRED_UNIQUE);
        }

        return inputs;
    }

    @Override
    public int[] getDigitsFromUser(Scanner scanner) {
        String userInput = scanner.nextLine();
        if (userInput.length() != BASE_LENGTH) {
            throw new GameException(USER_INPUT_REQUIRED_THREE_DIGIT);
        }

        int[] inputs = userInput.chars().map(unicode -> getIntegerFrom((char) unicode)).toArray();

        if ((inputs[0] == inputs[1]) || (inputs[0] == inputs[2]) || (inputs[1] == inputs[2])) {
            throw new GameException(EACH_DIGIT_REQUIRED_UNIQUE);
        }

        return inputs;
    }

    @Override
    public int getSelectionFromUser() {
        String userInput = SCANNER.nextLine();

        if (userInput.length() != 1) {
            throw new GameException(SELECTION_REQUIRED_SINGLE_DIGIT);
        }

        char characterFromUserInput = userInput.charAt(0);
        if (!Character.isDigit(characterFromUserInput)) {
            throw new GameException(USER_INPUT_REQUIRED_NUMERIC_TYPE);
        }

        return characterFromUserInput - '0';
    }

    private static int getIntegerFrom(char UserInputCharacter) {
        if (!Character.isDigit(UserInputCharacter)) {
            throw new GameException(USER_INPUT_REQUIRED_NUMERIC_TYPE);
        }

        return UserInputCharacter - '0';
    }
}