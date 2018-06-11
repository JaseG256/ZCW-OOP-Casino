package io.zipcoder.casino;

public interface Gamble {

     void setCurrentBet(int bet);

     void winBet(int currentBet);

     void loseBet(int currentBet);
     
}