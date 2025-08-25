import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JPrinterTest {

    public static void main(String[] args) {

        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        new JPrinter();
    }
}
