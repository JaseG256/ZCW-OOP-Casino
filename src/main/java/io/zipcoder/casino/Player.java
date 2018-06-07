package io.zipcoder.casino;

public class Player {

    private String name;
    private int bankroll;
    private int score;

    public Player(String name) {
        this.name = name;
        bankroll = 1000;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBankroll() {
        return bankroll;
    }

    public void addToBankroll(int winnings) {
        bankroll += winnings;
    }

    public void subtractFromBankroll(int losings) {
        bankroll -= losings;
    }

    public void setScore(int value) {
        score += value;
    }

    public int getScore() {
        return score;
    }


}
