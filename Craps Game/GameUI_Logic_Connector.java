import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;

public class GameUI_Logic_Connector {

    public static void gameEndOrStart (JButton roll_button, JButton start_or_end_button, JLabel result_label, JTextField[] fields) {

        if (Game_Logic.GAME_STATUS == Game_Status.START) {
            gameStart (roll_button, start_or_end_button,result_label);
        }
        else {
            gameEnd (roll_button, start_or_end_button,result_label,"Click 'Start Game Button' to start the Game");
        }

        for (JTextField field : fields) {
            UIComponent.updateJComponentText(field,"");
        }
    }

    private static void gameStart (JButton roll_button, JButton start_or_end_button, JLabel result_label) {
        UIComponent.setJComponentEnabled(roll_button, true);
        UIComponent.updateJComponentText(start_or_end_button, "End The Game");
        UIComponent.updateJComponentText(result_label, "Click Roll to roll the Dice!");
    }

    private static void gameEnd (JButton roll_button, JButton start_or_end_button, JLabel result_label, String text) {
        UIComponent.setJComponentEnabled(roll_button, false);
        UIComponent.updateJComponentText(start_or_end_button, "Start The Game");
        UIComponent.updateJComponentText(result_label, text);
        Game_Logic.setGameToStart();
    }

    public static void userRolled (JButton roll_button, JButton start_or_end_button, JLabel result_label, JTextField[] fields) {

        ArrayList<String> rolls = new ArrayList<>();

        rolls = Game_Logic.gameController();

        for (int i = 0; i < rolls.size(); i++) {
            UIComponent.updateJComponentText(fields[i], rolls.get(i));
        }

        if (Game_Logic.GAME_STATUS == Game_Status.WON) {

            if (Game_Logic.getSumOfDice() == Game_Logic.getMyPoint()) {
                gameEnd(roll_button, start_or_end_button, result_label, "It's a win you got the point");
            }
            else {
                gameEnd(roll_button, start_or_end_button, result_label, "Maestro you hit a win at your first try!");
            }
        }
        else if (Game_Logic.GAME_STATUS == Game_Status.LOST) {
            gameEnd (roll_button, start_or_end_button,result_label,"It's a lose");
        }
        else {
            UIComponent.updateJComponentText(result_label, "You must roll the dice sum of "+Game_Logic.getMyPoint()+" again!");
        }

    }

}
