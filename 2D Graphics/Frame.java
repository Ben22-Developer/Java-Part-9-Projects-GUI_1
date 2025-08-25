import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    public final static int HEIGHT = 670;
    public final static int WIDTH = 1280;
    public static int MOUSE_X_POSITION, MOUSE_Y_POSITION;
    private Face face;

    public Frame () {

        setTitle ("Moving Eyes");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (new Dimension (Frame.WIDTH, Frame.HEIGHT));
        makeFace ();
        add (face);
        setVisible (true);
        setResizable (false);
        addEventListener ();
        getContentPane().setBackground(new Color(73, 73, 73));
    }

    private void makeFace () {
        face = new Face();
    }

    private void setMouse_x_position (int position) {

        double position_x_double = ((double) position / (double) Frame.WIDTH) * 100;
        int position_x_int = (int) position_x_double;
        MOUSE_X_POSITION = position_x_int;
//        System.out.println ("x axis is now "+MOUSE_X_POSITION);
    }

    private void setMouse_y_position (int position) {

        double position_y_double = ((double) position / (double) Frame.HEIGHT) * 100;
        int position_y_int = (int) position_y_double;
        MOUSE_Y_POSITION = position_y_int;
    }

    private void addEventListener () {
        EventHandler event_andler = new EventHandler();
        this.addMouseMotionListener (event_andler);
        this.addMouseListener (event_andler);
    }

    private class EventHandler extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            face.eyeBlink (true);
        }

        public void mouseReleased(MouseEvent e) {
            face.eyeBlink (false);
        }

        public void mouseMoved (MouseEvent e) {
            setMouse_x_position (e.getX());
            setMouse_y_position (e.getY());
            face.pupilMovement();

        }
    }
}
