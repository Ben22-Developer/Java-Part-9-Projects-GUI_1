import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;

public class GridLayoutDemoTest {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Look and Feel Failed To Load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

//        for (UIManager.LookAndFeelInfo l : UIManager.getInstalledLookAndFeels()) {
//            System.out.println(l);
//        }

        JFrame frame = new JFrame("Grid Layout Demonstration");

        frame.add(new GridLayoutDemo());
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (400,400);
        frame.setVisible (true);

    }
}
