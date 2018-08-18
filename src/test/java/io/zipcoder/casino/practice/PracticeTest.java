package io.zipcoder.casino.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class PracticeTest {

//    @Test
//    public void largestStringTest(String input) {
//        Practice practice = new Practice();
//        String string = "Zip Code is awesome! We had a great time this year.. Hope to do it again? Maybe.";
//        int expected = 7;
//        int actual = practice.largestString(string);
//    }

    @Test
    public void swapValuesTestA() {
        Practice practice = new Practice();
        int a = 5;
        int b = 10;
        int expected = 10;
        int actual = practice.swapValuesA(a, b);
        assertEquals(expected, actual);

    }

    @Test
    public void swapValuesTestB() {
        Practice practice = new Practice();
        int a = 5;
        int b = 10;
        int expected = 5;
        int actual = practice.swapValuesB(a, b);
        assertEquals(expected, actual);

    }

}