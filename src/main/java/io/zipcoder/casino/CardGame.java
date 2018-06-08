package io.zipcoder.casino;

public abstract class CardGame implements Game, Gamble {

    int playerHand;
    int dealerHand;
    int currentBet;
    Player player;
    CardDeck deck;

    public CardGame(Player player) {

        this.player = player;
        this.deck = new deck();

    }


    public int drawCard() {


    }

    public void stand() {

    }

    void startGame();

    void endGame();

    void declareWinner();

    void bet(int currentBet) {

    }
    void winBet() {

    }
    void loseBet(Player player) {

    }



