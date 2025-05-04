package src.javaconcepts;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumber {
    public static int min = 1;
    public static int max = 6;

    public static void main(String[] args) {
        // Ramdom value when we N roll dice

        int diceValue = rollDice(2);
    }

    private static int rollDice(int numDice) {
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < numDice) {
            totalSum += ThreadLocalRandom.current().nextInt(max, max+1);
            diceUsed++;
        }

        return totalSum;
    }
}
