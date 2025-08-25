import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JComboBoxClassTest {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error",JOptionPane.ERROR_MESSAGE);
        }

        window a_window = new window();
    }
}
