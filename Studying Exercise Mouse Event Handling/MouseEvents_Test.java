import javax.swing.JFrame;
import java.awt.Dimension;

public class MouseEvents_Test {

    public static final int window_width = 500;
    public static final int window_height = 350;

    public static void main (String[] args) {

        MouseEvents e = new MouseEvents();

        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.setSize(new Dimension(window_width,window_height));
        e.setVisible(true);
    }
}
