import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Dimension;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        setUIManager();

        GUI user_interface = new GUI();
        user_interface.setTitle("Typing Application");
        user_interface.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        user_interface.setSize (new Dimension(1200,670));
        user_interface.setVisible (true);
        user_interface.setLocation(43,0);
        user_interface.setResizable(false);
    }

    private static void setUIManager () {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            out.println("UIManager Look and Fell failed to load!");
        }
    }
}
