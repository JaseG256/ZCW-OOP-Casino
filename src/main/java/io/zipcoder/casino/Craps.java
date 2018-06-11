package io.zipcoder.casino;

public class Craps implements Game, Gamble {

    private Dice dice;
    private Player player;
    private int point;
    private int sixEightBet;
    private int crapsBet;
    private int currentBet;
    private boolean isPlaying;
    private boolean askToPlayAgain;
    private boolean pointIsMet = false;

    public Craps(Player player) {
        this.player = player;
        dice = new Dice(2);
        currentBet = 0;
        isPlaying = true;
    }

    public int getSixEightBet() { return this.sixEightBet; }

    public void setSixEightBet(int amount) { this.sixEightBet = amount; }

    public int getPoint() { return this.point; }

    public int getCrapsBet() { return this.crapsBet; }

    public void setCrapsBet(int amount) { this.crapsBet = amount; }

    public void setIsPlaying(boolean bool) { this.isPlaying = bool; }

    public void setAskToPlayAgain(boolean askToPlayAgain) { this.askToPlayAgain = askToPlayAgain; }

    public void setPointIsMet(boolean bool) { this.pointIsMet = bool; }

    public int getCurrentBet() {
        return this.currentBet;
    }

    public void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    public void winBet(int winnings) {
        player.addToBankroll(winnings);
    }

    public void loseBet(int losings) {
        player.subtractFromBankroll(losings);
    }

    public int comeOutRoll(int currentBet) {
        point = dice.getSum();
        if (point == 2 || point == 3 || point == 12) {
            Console.output("Roll Again");
            comeOutRoll(currentBet);
        } else if (point == 7 || point == 11) {
            Console.output("You win!");
            winBet(currentBet * 2);
            setPointIsMet(true);
            endGame();
        }

        return point;
    }

    public int roll(int currentBet) {
        int temp = dice.getSum();
        while (!pointIsMet) {
            if (sixEightBet > 0) {
                if (temp == 6 || temp == 8) {
                    winBet(currentBet);
                }
            } else if (crapsBet > 0) {
                if (temp == 2 || temp == 3 || temp == 12) {
                    winBet(currentBet * 4);
                } else {
                    loseBet(currentBet);
                }
            } else if (temp == 7) {
                Console.output("Crapped Out! Sorry you lose");
                loseBet(currentBet);
                setPointIsMet(true);
            } else if (temp == point) {
                Console.output("Point! You win " + currentBet);
                setPointIsMet(true);
                winBet(currentBet);
                Console.output("Your bankroll is " + player.getBankroll());
            } else {
                roll(currentBet);
            }
        }
        return temp;
    }

    public void start() {
        while(isPlaying) {
            while(pointIsMet) {

            }
        }
    }

    public void startGame() {
        Craps craps = new Craps(player);
        setPointIsMet(false);
        while (isPlaying) {
            setCurrentBet(Console.numberFromString(Console.askForInput("Starting bet amount: ")));
            String ready = Console.askForInput("Ready to Roll? (Y/N)");
            if (ready.equals("y")) {
                comeOutRoll(currentBet);
            }

            Console.output("Your point is " + point);
            String choose = Console.askForInput("Would you like to bet a 6 - 8? (Y/N)");
            if (choose.equals("y")) {
                setSixEightBet(Console.numberFromString(Console.askForInput("Side bet amount: ")));
            }
            choose = Console.askForInput("Would you like to bet for craps? (Y/N)");
            if (choose.equals("y")) {
                setCrapsBet(Console.numberFromString(Console.askForInput("Side bet amount: ")));
            }
            if (!pointIsMet) {
                ready = Console.askForInput("Ready to Roll? (Y/N)");
                if (ready.equals("y")) {
                    roll(currentBet);
                } else if (ready.equalsIgnoreCase("n")) {
                    setIsPlaying(false);

                }
            }
            choose = Console.askForInput("Keep playing? (Y/N)");
            if (choose.equals("y")) {
                setIsPlaying(true);
                setPointIsMet(false);
            } else if (choose.equals("n")) {
                endGame();

            }


        }
    }

    public void endGame() { this.isPlaying = false; }


}