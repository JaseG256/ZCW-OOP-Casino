package io.zipcoder.casino;
import java.util.ArrayList;

public class BlackJack {
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> dealerHand = new ArrayList<Card>();
    private int currentBet;
    private boolean playingBJ = false;
    private CardDeck deck = new CardDeck();
    private Player player;

    public BlackJack() {
        Player player = new Player("Eugene");
    }

    public void start() {
        playingBJ = true;

    }

    private void dealToPlayerHand(int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            this.playerHand.add(deck.draw());
        }
    }

    private void dealToDealerHand(int amountOfCards) {
        for (int i = 0; i < amountOfCards; i++) {
            this.dealerHand.add(deck.draw());
        }
    }

    private void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    private int getCardValue(Card card) {
        Rank rank = card.getRank();
        int calcValue = 0;
        switch(rank) {
            case ACE:
                calcValue = 1;
                break;
            case TWO:
                calcValue = 2;
                break;
            case THREE:
                calcValue = 3;
                break;
            case FOUR:
                calcValue = 4;
                break;
            case FIVE:
                calcValue = 5;
                break;
            case SIX:
                calcValue = 6;
                break;
            case SEVEN:
                calcValue = 7;
                break;
            case EIGHT:
                calcValue = 8;
                break;
            case NINE:
                calcValue = 9;
                break;
            case TEN:
                calcValue = 10;
                break;
            case JACK:
            case QUEEN:
            case KING:
                calcValue = 10;
                break;
        }
        return calcValue;
    }

    private int calcHand(ArrayList<Card> hand) {
        int totalScore = 0;
        for (int i = 0; i < hand.size(); i++) {
            totalScore = getCardValue(hand.get(i));
        }
        return totalScore;
    }

    public void startGame() {
        while(playingBJ)
        {
            Console.output("Welcome to BlackJack " + player.getName() + ". I am your dealer Vince and I am here to take your money!");
            int bet = Console.numberFromString(Console.askForInput("How much would you like to bet?"));
            setCurrentBet(bet);
            dealToPlayerHand(2);
            dealToDealerHand(2);
            if (calcHand(dealerHand) == 21) {
                Console.output("Dealer has BlackJack! You lose!");
                player.subtractFromBankroll(currentBet);
                currentBet = 0;
                deck.draw();
            } else if (calcHand(playerHand) == 21) {
                Console.output("You have BlackJack! You win!");
                winBet((currentBet * 3) / 2);
                currentBet = 0;
                deck.deal();

            }
            while (calcHand(playerHand) < 21) {
                String action = Console.askForInput("Dealer is showing: " + "You have " + playerHand + ". Please enter 'hit' or 'stay'.");
                if (action.equals("hit")) {
                    drawCard();
                    cardValue += playerHand;
                    if (calcHand(playerHand) > 21) {
                        Console.output("You have " + playerHand + " and bust, you suck!");
                        loseBet(currentBet);
                        currentBet = 0;
                    }
                } else if (action.equals("stay")) {
                    break;
                }
            }
            while (calcHand(dealerHand) < 17 && calcHand(dealerHand) < 21) {
                Console.output("Dealer has " + dealerHand + " and hits.");
                drawcard();
                cardValue += dealerHand;
                if (calcHand(dealerHand > 21) {
                    Console.output("Dealer has " + dealerHand + " and busts, you win!");
                    winBet(currentBet);
                    currentBet = 0;
                } else if (dealerHand >= 17 && dealerHand < 21) {
                    Console.output("Dealer has " + dealerHand + " and stands.");
                }
            }
        }
    }
}








