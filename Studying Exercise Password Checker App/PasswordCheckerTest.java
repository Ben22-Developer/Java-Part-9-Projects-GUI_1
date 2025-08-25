import javax.swing.JOptionPane;
import static java.lang.System.out;

class PasswordCheckerTest {



    public static void app_control (int user_input) {

        switch (user_input) {
            case 1 -> {
                user_register();
            }
            case 2 -> {

            }
            case 3 -> {

            }

        }

    }

    private static void user_register () {

        String user_name, user_password;
    }

    public static void main (String[] args) {

        GUI user_interface = new GUI();
        user_interface.set_look_and_feel();
        user_interface.show_app_msg();


    }
}