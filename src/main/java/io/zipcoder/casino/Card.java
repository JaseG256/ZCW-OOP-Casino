package io.zipcoder.casino;

public class Card {

    private Suit suit;
    private Rank rank;
    private int x;


    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        x = 0;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        String describe = "";
        int x = 5;
        if (suit.equals(Suit.SPADES)) {
            describe = rank + "\u2660 of " + suit + "\n";
        } else if (suit.equals(Suit.CLUBS)) {
            describe = rank + "\u2663 of " + suit + "\n";
        } else if (suit.equals(Suit.DIAMONDS)) {
            describe = rank + "\u2666 of " + suit + "\n";
        } else if (suit.equals(Suit.HEARTS)) {
            describe = rank + "\u2665 of " + suit + "\n";
        }
        return describe + x;
    }
}
