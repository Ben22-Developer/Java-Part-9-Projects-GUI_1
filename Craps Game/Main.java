import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {

    public static final int WINDOW_WIDTH = 1270;
    public static final int WINDOW_HEIGHT = 800;

    public static void main(String[] args) {
        Game_GUI frame = new Game_GUI();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.eventRegistration();
    }


}
