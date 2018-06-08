package io.zipcoder.casino;

public class Card {

    private Suit suit;
    private Rank rank;
    private boolean isPrivate = false;

    public Card() {
        this.isPrivate = true;
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
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
        if (!isPrivate) {
            String describe = "";
            if (suit.equals(Suit.SPADES)) {
                describe = rank + "\u2660 of " + suit;
            } else if (suit.equals(Suit.CLUBS)) {
                describe = rank + "\u2663 of " + suit;
            } else if (suit.equals(Suit.DIAMONDS)) {
                describe = rank + "\u2666 of " + suit;
            } else if (suit.equals(Suit.HEARTS)) {
                describe = rank + "\u2665 of " + suit;
            }
            return describe;
        } else {
            return "PRIVATE";
        }
    }
}
