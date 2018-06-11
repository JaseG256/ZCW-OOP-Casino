package io.zipcoder.casino;


public class Casino {

    private Player player;
    private String choice;
    private String numberOfPlayers;
    private boolean isPlaying = false;

    public void startCasino() {

        System.out.println("Welcome to Eugene's Casino, Where Your Money is OUR Money!");

//        numberOfPlayers = Console.askForInput("How many players?");
        Player player = new Player();
        player.setName(Console.askForInput("What is your name?"));
        Console.output("Hello " + player.getName() + ". Your bankroll is: $" + player.getBankroll());

//        if ("2".equalsIgnoreCase(numberOfPlayers)) {
//            Player playerTwo = new Player();
//            playerTwo.setName(Console.askForInput("What is your name, player two?"));
//        }

        do {
            System.out.println("Which game would you like to play? ");
            System.out.println("1: BlackJack");
            System.out.println("2: Baccarat");
            choice = Console.askForInput("3: Craps");
            GameFactory.getGame(choice, player);
            String play = Console.askForInput("Would you like to keep playing in the Casino? Y/N ");
            Console.output("Your bankroll is $" + player.getBankroll());

            if ("y".equalsIgnoreCase(play)) {
                isPlaying = true;
            } else if ("n".equalsIgnoreCase(play)) {
                isPlaying = false;
            }

        } while (isPlaying);
    }

}


//    public static void main(String[] args) {
//
//        CardDeck cardDeck = new CardDeck();
//        cardDeck.getDeck();
//        cardDeck.shuffle();
//        cardDeck.getDeck();
//        System.out.println(cardDeck.draw());
//        cardDeck.deal(2);
//        Casino cas = new Casino();
//        cas.startCasino();
//    }
