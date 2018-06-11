package io.zipcoder.casino;
import java.util.Random;

public class Die {

    private Random randomGenerator;
    private int value;

    public Die() {
        randomGenerator = new Random();
        value = 1;
    }

    public int getValue() {
        return value;
    }

    public int toss() {
        int value = randomGenerator.nextInt(6) + 1;
        return value;
    }

}
