package io.zipcoder.casino;

public class GameFactory {

    public static Game getGame(String gameName, Player player) {
        gameName = Console.askForInput(gameName);

        if ("1".equalsIgnoreCase(gameName)) {
            Game black = new BlackJack(player);
            black.startGame();
            return black;
        } else if ("3".equalsIgnoreCase(gameName)) {
            Game crap = new Craps(player);
            crap.startGame();
            return crap;
        }
        return null;
    }
}
