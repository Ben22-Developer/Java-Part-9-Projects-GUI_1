import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JColorSelectTest {

    public static int window_width = 400;
    public static int window_height = 200;

    public static void main(String[] args) {

        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        JColorSelect j_color_select = new JColorSelect();

        j_color_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j_color_select.setSize(window_width,window_height);
        j_color_select.setVisible(true);
        j_color_select.setResizable(false);
    }
}
