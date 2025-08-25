import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Dimension;

import static java.lang.System.out;

public class Main {

    public static int WINDOW_WIDTH = 1280;
    public static int WINDOW_HEIGHT = 700;

    public static void main(String[] args) {

//        out.println(Double.parseDouble("45.5"));

        setUIManager ();
        Text_Panel_Frame frame = new Text_Panel_Frame();

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        frame.setVisible(true);
    }

    private static void setUIManager () {

        for (UIManager.LookAndFeelInfo l : UIManager.getInstalledLookAndFeels()) {
            out.println(l);
        }

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            out.println("UIManager failed!");
        }
    }
}
