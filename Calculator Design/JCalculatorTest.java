import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Dimension;

public class JCalculatorTest {

    public static int window_height = 300;
    public static int window_width = 350;

    public static void main(String[] args)  {

        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        for (UIManager.LookAndFeelInfo l : UIManager.getInstalledLookAndFeels()) {
            System.out.println(l);
        }

        JFrame frame = new JFrame("JCalculator");
        JCalculator j_calculator = new JCalculator();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(j_calculator);
        frame.setSize(new Dimension(window_width,window_height));
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
