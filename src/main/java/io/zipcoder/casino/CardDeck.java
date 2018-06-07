package io.zipcoder.casino;
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
}
