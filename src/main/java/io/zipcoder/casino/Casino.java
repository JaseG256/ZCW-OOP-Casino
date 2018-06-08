package io.zipcoder.casino;


public class Casino {

    private Player player;
    private String choice;
    private Console console;
    //GameFactory gf;

    public void startCasino() {
        do {
            System.out.println("Welcome to the Zip Code Casino!");
            System.out.println("Which game would you like to play? ");
            System.out.println("1: BlackJack");
            System.out.println("2: Baccarat");
            choice = Console.askForInput("3: Craps");
            System.out.println(choice);

            if (choice.equalsIgnoreCase("1")) {
                BlackJack blackjack = new BlackJack();
                blackjack.start();

            }
        } while (false);

        }


//    public static void main(String[] args) {
//
//        CardDeck cardDeck = new CardDeck();
//        cardDeck.getDeck();
//        cardDeck.shuffle();
//        cardDeck.getDeck();
//        System.out.println(cardDeck.draw());
//        cardDeck.deal(2);
//        Casino cas = new Casino();
//        cas.startCasino();
//    }
}
