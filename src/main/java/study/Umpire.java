package study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

    public int ball(int[] userInputs, int[] targets) {
        Set<Integer> userInputDigits = new HashSet<>();
        Set<Integer> targetDigits = new HashSet<>();

        Arrays.stream(userInputs).forEach(userInputDigits::add);
        Arrays.stream(targets).forEach(targetDigits::add);

        targetDigits.retainAll(userInputDigits);
        return targetDigits.size() - strike(userInputs, targets);
    }

}
