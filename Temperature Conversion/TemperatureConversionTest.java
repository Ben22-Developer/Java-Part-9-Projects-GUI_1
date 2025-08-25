import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

public class TemperatureConversionTest {

    public static void main(String[] args) {

//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        String fonts[] = ge.getAvailableFontFamilyNames();
//
//        for (String f : fonts) {
//            System.out.println(f);
//        }

        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        new App_GUI();

    }
}
