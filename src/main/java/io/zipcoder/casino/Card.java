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


    class CompareCards implements Comparable<Card>{

        public int compareTo(Card otherCard) {
            int comparison;
            if (rank.compareTo(otherCard.getRank()) == 0) {
                comparison = 0;
            } else if (rank.compareTo(otherCard.getRank()) < 0) {
                comparison = -1;
            } else {
                comparison = 1;
            }
            return comparison;
        }
    }

    @Override
    public String toString() {
        if (!isPrivate) {
            String describe = "";
            if (suit.equals(Suit.SPADES)) {
                describe = rank + " of \u2660 "; //+ suit;
            } else if (suit.equals(Suit.CLUBS)) {
                describe = rank + " of \u2663 "; //+ suit;
            } else if (suit.equals(Suit.DIAMONDS)) {
                describe = rank + " of \u2666 ";// + suit;
            } else if (suit.equals(Suit.HEARTS)) {
                describe = rank + " of \u2665 ";// + suit;
            }
            return describe;
        } else {
            return "PRIVATE";
        }
    }
}
