import java.security.SecureRandom;
import java.util.ArrayList;

public class Game_Logic {
 // create secure random number generator for use in method rollDice
        private static final SecureRandom randomNumbers = new SecureRandom();
// constants that represent common rolls of the dice
        private static final int SNAKE_EYES = 2;
        private static final int TREY = 3;
        private static final int SEVEN = 7;
        private static final int YO_LEVEN = 11;
        private static final int BOX_CARS = 12;

        public static Game_Status GAME_STATUS = Game_Status.START; // can contain CONTINUE, WON or LOST

        private static int myPoint, sumOfDice;  // point if no win or loss on first roll

        // plays one game of craps
        public static ArrayList<String> gameController () {

            ArrayList<String> rolls = new ArrayList<>();

            if (GAME_STATUS == Game_Status.START) {
                rollDice (rolls); // first roll of the dice
                // determine game status and point based on first roll
                checkFirstRollResults (rolls);
            }
            else {
                // while game is not complete
                gamePlayingAfter_1st_Roll (rolls);
            }

            return rolls;
        }

        public static void gamePlayingAfter_1st_Roll (ArrayList<String> rolls) {

            rollDice (rolls); // roll dice again // determine game status
            if (sumOfDice == myPoint) { // win by making point
                GAME_STATUS = Game_Status.WON;
            }
            else if (sumOfDice == SEVEN) {
                GAME_STATUS = Game_Status.LOST;// lose by rolling 7 before point
            }
        }

        private static void checkFirstRollResults (ArrayList<String> rolls) {
            switch (sumOfDice)  {
                case SEVEN: // win with 7 on first roll
                case YO_LEVEN: // win with 11 on first roll
                    GAME_STATUS = Game_Status.WON;
                    break;
                case SNAKE_EYES: // lose with 2 on first roll
                case TREY: // lose with 3 on first roll
                case BOX_CARS: // lose with 12 on first roll
                    GAME_STATUS = Game_Status.LOST;
                    break;
                default: // did not win or lose, so remember point
                    GAME_STATUS = Game_Status.CONTINUE; // game is not over
                    myPoint = sumOfDice; // remember the point
                    System.out.printf("Point is %d%n", myPoint);
                    rolls.add(String.valueOf(myPoint));
            }
        }

        // roll dice, calculate sum and display results
        public static void rollDice(ArrayList<String> rolls) {

            // pick random die values
            int die1 = 1 + randomNumbers.nextInt(6); // first die roll
            int die2 = 1 + randomNumbers.nextInt(6); // second die roll
            sumOfDice = die1 + die2; // sum of die values
            // display results of this roll
            System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sumOfDice);

            rolls.add(String.valueOf(die1));
            rolls.add(String.valueOf(die2));
            rolls.add(String.valueOf(sumOfDice));
        }

    public static void setGameToStart () {
        GAME_STATUS = Game_Status.START;
        sumOfDice = 0;
        myPoint = 0;
    }

    public static int getMyPoint () {
            return myPoint;
    }

    public static int getSumOfDice () {
            return sumOfDice;
    }
}
