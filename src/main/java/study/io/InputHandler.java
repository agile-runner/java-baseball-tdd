package study.io;

import java.util.Scanner;

public interface InputHandler {
    int[] getDigitsFromUser();
    int[] getDigitsFromUser(Scanner scanner);
    int getSelectionFromUser();
}
