package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {



    @Test
    public void setNameTest() {
        Player player = new Player();
        String expected = "Jason";
        player.setName("Jason");
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getName() {
        Player player = new Player();
        String expected = "Jason";
        player.setName("Jason");
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getBankroll() {
    }

    @Test
    public void addToBankroll() {
    }

    @Test
    public void subtractFromBankroll() {
    }

    @Test
    public void setScore() {
    }

    @Test
    public void getScore() {
    }

}