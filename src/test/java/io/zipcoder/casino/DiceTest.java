package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

    @Test
    public void getSum1(){
        Dice dice = new Dice(2);
        int expected = 6;
        int actual = dice.getSum();
        Assert.assertEquals(expected, actual, 6);
    }

    @Test
    public void getSum2(){
        Dice dice = new Dice(5);
        int expected = 13;
        int actual = dice.getSum();
        Assert.assertEquals(expected, actual, 12);
    }

    @Test
    public void getEach1(){
        Dice dice = new Dice(2);
        int expected = 3;
        int actual = dice.getEach()[1];
        Assert.assertEquals(expected, actual, 3);
    }

    @Test
    public void getEach2(){
        Dice dice = new Dice(6);
        int expected = 3;
        int actual = dice.getEach()[3];
        Assert.assertEquals(expected, actual, 3);
    }
}
