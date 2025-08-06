package study;

import java.util.Random;

public class Computer {

    public int[] generateRandomNumber() {
        Random random = new Random();
        int random1 = random.nextInt(9) + 1;
        int random2 = 0;
        int random3 = 0;
        while (true) {
            random2 = random.nextInt(9) + 1;
            if (random2 != random1) {
                break;
            }
        }

        while (true) {
            random3 = random.nextInt(9) + 1;
            if ((random3 != random1) && (random3 != random2)) {
                break;
            }
        }

        return new int[] {random1, random2, random3};
    }

}
