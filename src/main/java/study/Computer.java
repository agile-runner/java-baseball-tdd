package study;

import java.util.Random;

public class Computer {

    public int[] generateRandomNumber() {
        Random random = new Random();
        int random1 = random.nextInt(9) + 1;

        int random2 = random.nextInt(9) + 1;
        while (random2 == random1) {
            random2 = random.nextInt(9) + 1;
        }

        int random3 = random.nextInt(9) + 1;
        while ((random3 == random1) || (random3 == random2)) {
            random3 = random.nextInt(9) + 1;
        }

        return new int[]{random1, random2, random3};
    }

}
