package io.zipcoder.casino;

public class BlackJack extends CardGames implements Gamble, Game{
    int playerHand;
    int dealerHand;
    int currentBet;
    boolean playingBJ = false;
    CardDeck deck = new CardDeck();
    Player player;

    public void start() {
        playingBj = true;
    }

public BlackJack(Player player){

}



while(playingBJ ==true)

    {
        currentBet =  Console.numberFromString(Console.askForInput("How much would you like to bet?"));
        deck.deal();
        if (dealerHand == 21) {
            Console.output("Dealer has BlackJack! You lose!");
            loseBet(currentBet);
            currentBet = 0;
        } else if (playerHand == 21) {
            Console.output("Dealer has BlackJack! You lose!");
            winBet(currentBet);
            currentBet = 0;
        }






        String action = Console.askForInput("Do you want to hit or stay?");

        if (action.equals("hit")) {

        }
        if (action.equals("stay"))


    }


}
