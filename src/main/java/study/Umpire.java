package study;

import java.util.stream.IntStream;

public class Umpire {

    public int strike(int[] userInputs, int[] targets) {
        if (userInputs.length != targets.length) {
            throw new RuntimeException();
        }

        return (int) IntStream.range(0, userInputs.length)
                .filter(i -> userInputs[i] == targets[i])
                .count();
    }
}
