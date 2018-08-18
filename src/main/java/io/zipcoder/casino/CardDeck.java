package io.zipcoder.casino;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class CardDeck {

    private Card card;
    private List<Card> deck = new ArrayList<Card>(52);
    private Random rand = new Random();

    public CardDeck() {

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
    }

    public List<Card> getDeck() {
        System.out.println(deck.toString());
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(deck, rand);
    }

    public Card[] deal(int numOfCards) {
        Card[] cards = new Card[numOfCards];
        Collections.shuffle(deck, rand);
        for (int i = 0; i < numOfCards; i++) {
            cards[i] = deck.remove(0);
            System.out.println(deck.remove(0));
        }
        return cards;
    }

    public Card draw() {
        if (deck.isEmpty()) {
            new CardDeck();
        }
        return deck.remove(0);
    }
}
