import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GUI {

    private String app_msg = "App Controller\n------------------------\nPress 1 to register\nPress 2 to retrieve the stored data\nPress 3 to end the application";
    private final int total_user_choices = 3;

    public void set_look_and_feel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to load look and feel\n"+e,"Error Occurred",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void show_app_msg () {

        String user_input_str;
        int user_input_int = 0;

        do {
            try {
                user_input_str = JOptionPane.showInputDialog(null, app_msg, "App Navigator", JOptionPane.QUESTION_MESSAGE);
                user_input_int = Integer.parseInt(user_input_str);

                if (user_input_int <= 0 || user_input_int > total_user_choices) {
                    throw new Exception();
                }

                PasswordCheckerTest.app_control(user_input_int);
            }
            catch (Exception e) {
                show_error_msg("Please choose a character which is present in the\napp controller messages!");
                user_input_int = 0;
            }
        }
        while (user_input_int != 3);
    }

    private void show_error_msg (String error_msg) {
        JOptionPane.showMessageDialog(null, error_msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String retrieve_user_info (String window_title, String window_msg) {

        String user_input = "";

        do {
            try {
                user_input = JOptionPane.showInputDialog(null, window_msg, window_title, JOptionPane.QUESTION_MESSAGE);
                if (user_input.isEmpty()) {
                    throw new Exception();
                }
            }
            catch (Exception e) {
                show_error_msg("You have inserted nothing!\nIn the input field!");
                user_input = "";
            }
        }
        while (user_input.isEmpty());

        return user_input;
    }

}
