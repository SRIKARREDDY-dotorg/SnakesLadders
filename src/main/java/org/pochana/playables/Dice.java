package org.pochana.playables;

public class Dice {
    private static volatile Dice diceInstance;
    private Dice() {}

    public static Dice getInstance() {
        if (diceInstance == null) {
            synchronized (Dice.class) {
                if (diceInstance == null) {
                    diceInstance = new Dice();
                }
            }
        }
        return diceInstance;
    }

    public Integer rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
