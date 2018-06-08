package io.zipcoder.casino;

public class BlackJack extends CardGames {
    int playerHand;
    int dealerHand;
    int currentBet;
    boolean playingBJ = false;
    CardDeck deck = new CardDeck();
    Player player;

    public void start() {
        playingBj = true;
    }

    public BlackJack(Player player) {

    }



while(playingBJ ==true)

    {
        Console.output("Welcome to BlackJack " + player.name + ". I am your dealer Vince and I am here to take your money!");
        currentBet = Console.numberFromString(Console.askForInput("How much would you like to bet?"));
        deck.deal();
        if (dealerHand == 21) {
            Console.output("Dealer has BlackJack! You lose!");
            loseBet(currentBet);
            currentBet = 0;
            deck.deal();
        } else if (playerHand == 21) {
            Console.output("You have BlackJack! You win!");
            winBet((currentBet * 3) / 2);
            currentBet = 0;
            deck.deal();

        }
        while (playerHand < 21) {
            String action = Console.askForInput("Dealer is showing: " + "You have " + playerHand + ". Please enter 'hit' or 'stay'.");
            if (action.equals("hit")) {
                drawCard();
                cardValue += playerHand;
                if (playerHand > 21) {
                    Console.output("You have " + playerHand + " and bust, you suck!");
                    loseBet(currentBet);
                    currentBet = 0;
                }
            } else if (action.equals("stay")) {
                break;
            }
        }
        while (dealerHand < 17 && dealerHand < 21) {
            Console.output("Dealer has " + dealerHand + " and hits.");
            drawcard();
            cardValue += dealerHand;
            if (dealerHand > 21) {
                Console.output("Dealer has " + dealerHand + " and busts, you win!");
                winBet(currentBet);
                currentBet = 0;
            } else if (dealerHand >= 17 && dealerHand < 21) {
                Console.output("Dealer has " + dealerHand + " and stands.");
            }
        }



    }

}








