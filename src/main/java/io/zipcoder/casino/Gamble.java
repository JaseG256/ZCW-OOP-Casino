package io.zipcoder.casino;

public interface Gamble {



     int currentBet;

     void bet(int);
     void winBet(Player);
     void loseBet(Player);



}