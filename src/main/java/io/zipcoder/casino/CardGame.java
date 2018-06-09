package io.zipcoder.casino;

public abstract class CardGame implements Game, Gamble {

    int playerHand;
    int dealerHand;
    int currentBet;
    Player player;
    CardDeck deck;

    public CardGame(Player player) {

        this.player = player;
        this.deck = new CardDeck();

    }


    public abstract int drawCard();

    public abstract void stand();

    public abstract void startGame();

    public abstract void endGame();

    public abstract void declareWinner();

    public abstract void bet(int currentBet);

    public abstract void winBet();

    public abstract void loseBet(Player player);


}
