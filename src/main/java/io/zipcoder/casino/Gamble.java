package io.zipcoder.casino;

public interface Gamble {



     int currentBet = 0;
     void bet(int bet);
     void winBet(int currentBet);
     void loseBet(int currentBet);




}