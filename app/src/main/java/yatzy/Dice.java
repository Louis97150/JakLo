package yatzy;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public Dice(int seed) {
        this.random = new Random(seed);
    }

    public int roll() {
        return random.nextInt(1, 7);
    }
}
