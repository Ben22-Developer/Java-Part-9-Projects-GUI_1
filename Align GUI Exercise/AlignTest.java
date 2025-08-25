import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

public class AlignTest {

    public static void main(String[] args) {

        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

//        for (UIManager.LookAndFeelInfo l : UIManager.getInstalledLookAndFeels()) {
//            System.out.println(l);
//        }

        Align frame = new Align();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(320,150));
        frame.getContentPane().setBackground(new Color(138, 168, 214));
        frame.setVisible(true);
    }
}
