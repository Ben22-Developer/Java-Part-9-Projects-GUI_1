import java.security.SecureRandom;

public class Game_Logic {

    public static boolean GAME_PLAYING = false;
    public static Game_Condition_Enum Game_Condition;
    public static int GUESSED_NUMBER, GUESS_TRIALS, USER_GUESS;

    public static void getUserInput (String user_input_str) {

        int user_input_nbr = 0;

        try {
            user_input_nbr = Integer.parseInt(user_input_str);
            GUESS_TRIALS += 1;
            USER_GUESS = user_input_nbr;
            validateUserInput();
        }
        catch (Exception e) {
            user_input_nbr = 0;
            Game_Condition = Game_Condition_Enum.ERROR_INPUT;
        }
    }

    public static void setGuessedNumber () {
        SecureRandom randomize = new SecureRandom();
        GUESSED_NUMBER = randomize.nextInt(1,1001);
    }

    private static void validateUserInput () {

        int difference = GUESSED_NUMBER - USER_GUESS;

        if (difference > 0) {
            Game_Condition = Game_Condition_Enum.TOO_LOW;
        }
        else if (difference < 0) {
            Game_Condition = Game_Condition_Enum.TOO_HIGH;
        }
        else {
            Game_Condition = Game_Condition_Enum.WIN;
        }
    }

}
