package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGame implements Game, Gamble {

    protected ArrayList<Card> playerHand;
    protected ArrayList<Card> playerTwoHand;
    protected ArrayList<Card> dealerHand;
    protected Player player;
    protected Player playerTwo;
    protected CardDeck deck;
    protected int currentBet;

    public CardGame(Player player) {
        this.player = player;
        this.deck = new CardDeck();
        this.playerHand = new ArrayList<Card>();
        this.dealerHand = new ArrayList<Card>();
    }

    public CardGame(Player player, Player playerTwo) {
        this.player = player;
        this.playerTwo = playerTwo;
        this.deck = new CardDeck();
        this.playerHand = new ArrayList<Card>();
        this.playerTwoHand = new ArrayList<Card>();
        this.dealerHand = new ArrayList<Card>();
    }

    public abstract void dealToPlayerHand(int amountOfCards);

    public abstract void startGame();

    public abstract void endGame();

//    public abstract void declareWinner();



}
