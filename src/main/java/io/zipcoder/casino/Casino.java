package io.zipcoder.casino;


public class Casino {

    private Player player;
    private String choice;
    //GameFactory gf;

//    public void startCasino() {
//        do {
//            System.out.println("Welcome to the Zip Code Casino!");
//            System.out.println("Which game would you like to play? :");
//            System.out.println("1: BlackJack");
//            System.out.println("2: Baccarat");
//            System.out.println("3: Craps");
//
//            if () {
//
//            }
//        }
//    }

    public static void main(String[] args) {

        CardDeck cardDeck = new CardDeck();
        cardDeck.getDeck();
        cardDeck.shuffle();
        cardDeck.getDeck();
        System.out.println(cardDeck.draw());
        cardDeck.deal(2);
    }
}
