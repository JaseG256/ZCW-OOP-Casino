package io.zipcoder.casino;

public class Main {

    public static void main(String[] args){
//        Dice dice = new Dice(2);
//        Console.output(dice.getSum());
//        Console.output(dice.getSum());
//        Console.output(dice.getSum());
//        Casino casino =  new Casino();
//        casino.startCasino();
          CardDeck cardDeck = new CardDeck();
          cardDeck.deal(2);
          for (Card card : cardDeck.getDeck()) {
              card.getRank();
          }


    }

}
