package io.zipcoder.casino;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> dealerHand = new ArrayList<Card>();
    private int currentBet;
    private boolean playingBJ = false;
    private boolean playingHands = true;
    private boolean askToPlayAgain = false;
    private CardDeck deck = new CardDeck();
    private static Player player;
    static String name;
    static String choice;

    public BlackJack() {
        this.player = new Player("Eugene");
    }

    public void start() {
        playingBJ = true;
        this.deck.shuffle();
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

    private void setPlayingHands(boolean bool) {
        this.playingHands = bool;
    }

    private String getPlayerHand() {
        return Arrays.toString(this.playerHand.toArray());
    }

    private String getDealerHand() {
        return Arrays.toString(this.dealerHand.toArray());
    }

    private String showDealerHand() {
        Card[] filteredArray = this.dealerHand.toArray(new Card[this.dealerHand.size()]);
        filteredArray[0] = new Card();
        return Arrays.toString(filteredArray);
    }


    private int getCurrentBet() {
        return this.currentBet;
    }

    private void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    private void setAskToPlayAgain(boolean bool) {
        this.askToPlayAgain = bool;
    }

    private void resetHands() {
        this.playerHand = new ArrayList<Card>();
        this.dealerHand = new ArrayList<Card>();
    }
    private void startHands() {
        this.deck = new CardDeck();
        this.deck.shuffle();
        resetHands();
        dealToPlayerHand(2);
        dealToDealerHand(2);
    }

    private void startNextHand() {
        setCurrentBet(0);
        setAskToPlayAgain(true);
        setPlayingHands(false);
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
            totalScore += getCardValue(hand.get(i));
        }
        return totalScore;
    }

    public void startGame() {
        start();
        Console.output("Starting BlackJack...");
        while (playingBJ) {
            while (askToPlayAgain) {
                String answer = Console.askForInput("Would you like to play again? (Y/N)");
                if (answer.equals("y")) {
                    setPlayingHands(true);
                    setAskToPlayAgain(false);
                } else {
                    setPlayingHands(false);
                    setAskToPlayAgain(false);
                }
            }
            while (playingHands) {
                int bet = Console.numberFromString(Console.askForInput("Starting bet amount: "));
                setCurrentBet(bet);
                startHands();

                Console.output(getPlayerHand());

                if (calcHand(dealerHand) == 21) {
                    Console.output("Dealer has BlackJack! You lose!");
                    player.subtractFromBankroll(currentBet);
                    startNextHand();
                } else if (calcHand(playerHand) == 21) {
                    Console.output("You have BlackJack! You win!");
                    player.addToBankroll((currentBet * 3) / 2);
                    startNextHand();
                }

                int stay = 0;
                while ((calcHand(playerHand) <= 21 && calcHand(dealerHand) <= 21) && stay < 2) {
                    stay = 0;
                    String action = Console.askForInput("Hit or Stay? (H/S)");

                    if (action.equals("h")) {
                        dealToPlayerHand(1);
                    }

                    if (action.equals("s")) {
                        stay++;
                    }

                    if (calcHand(dealerHand) < 17) {
                        dealToDealerHand(1);
                    } else {
                        stay++;
                    }

                    Console.output("Player Hand: " + getPlayerHand());
                    Console.output("Dealer Hand: " + showDealerHand());
                }

                if (calcHand(playerHand) == calcHand(dealerHand)) {
                    Console.output("It's a tie!");
                    Console.output("Player Hand: " + getPlayerHand() + ", " + calcHand(playerHand));
                    startNextHand();
                } else if (calcHand(playerHand) > 21) {
                    Console.output("Dealer wins! You bust.");
                    Console.output("Player Hand: " + getPlayerHand() + ", " + calcHand(playerHand));
                    startNextHand();
                } else if (calcHand(dealerHand) > 21) {
                    Console.output("You win! Dealer bust.");
                    Console.output("Dealer Hand: " + getDealerHand() + ", " + calcHand(dealerHand));
                    startNextHand();
                } else if (calcHand(playerHand) > calcHand(dealerHand)) {
                    Console.output("Player has higher hand.");
                    Console.output("Player Hand: " + getPlayerHand() + ", " + calcHand(playerHand));
                    startNextHand();
                } else if (calcHand(dealerHand) > calcHand(playerHand)) {
                    Console.output("Dealer has higher hand.");
                    Console.output("Player Hand: " + getDealerHand() + ", " + calcHand(playerHand));
                    startNextHand();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Eugene's Casino, where your money is OUR money!");
        System.out.println("What's your name?");
        Scanner scan = new Scanner(System.in);
        Player play = new Player(name);
       // player.setName(name);
        System.out.println("Welcome " + name + "! Which game would you like to play?");
        System.out.println("1: BlackJack");
        System.out.println("2: Baccarat");
        System.out.println("3: Craps");
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            BlackJack bj = new BlackJack();
            bj.startGame();
        } else {
            System.out.println("This game is not available. Please choose again");
        }

    }
}








