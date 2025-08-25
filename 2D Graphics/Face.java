import javax.swing.JPanel;
import java.awt.Graphics;

public class Face extends JPanel {

    private Head head;
    private RightEye right_eye;
    private LeftEye left_eye;
    private Nose nose;
    private Mouth mouth;

    public Face() {
        setOpaque (false);
        makeHead ();
        makeRightEye ();
        makeLeftEye ();
        makeNose ();
        makeMouth ();
    }

    private void makeHead () {

        int size = 300;
        int location_x = (Frame.WIDTH  / 2) - (size - 150);
        int location_y = (Frame.HEIGHT / 2) - (size - 120);

        head = new Head (location_x, location_y, size);
    }

    private void makeRightEye () {

        int eye_size = 65;
        int location_x = head.getLocation_x() + (int) (head.getLocation_x() * 0.42);
        int location_y = head.getLocation_y() + 85;
        int pupil_size = 20;

        right_eye = new RightEye (location_x, location_y, eye_size, pupil_size);
    }

    private void makeLeftEye () {

        int eye_size = 65;
        int location_x = head.getLocation_x() + (int) (head.getLocation_x() * 0.07);
        int location_y = head.getLocation_y() + 85;
        int pupil_size = 20;

        left_eye = new LeftEye (location_x, location_y, eye_size, pupil_size);
    }

    private void makeNose () {
        int upper_nose_x1 = head.getLocation_x() + (int) (head.getLocation_x() * 0.32);
        int upper_nose_y1 = head.getLocation_y() + 135;
        int upper_nose_x2 = upper_nose_x1 - 25;
        int upper_nose_y2 = upper_nose_y1 + 60;
        int lower_nose_x1 = upper_nose_x2;
        int lower_nose_y1 = upper_nose_y2;
        int lower_nose_x2 = lower_nose_x1 + 50;
        int lower_nose_y2 = lower_nose_y1;

        nose = new Nose (upper_nose_x1, upper_nose_y1, upper_nose_x2, upper_nose_y2, lower_nose_x1, lower_nose_y1, lower_nose_x2, lower_nose_y2);
    }

    private void makeMouth () {
        int start_x = head.getLocation_x() + 100;
        int start_y = head.getLocation_y() + 190;
        int width = 100;
        int height = 70;
        int start_angle = 0;
        int arc_angle = -180;

        mouth = new Mouth (start_x, start_y, width, height, start_angle, arc_angle);
    }

    public void eyeBlink (boolean inner_blink) {
        if (inner_blink) {
            isBlink();
        }
        else {
            noBlink();
        }
        repaint();
    }

    private void isBlink() {
        right_eye.blink (true);
        left_eye.blink (true);
    }

    private void noBlink () {
        right_eye.blink (false);
        left_eye.blink (false);
    }

    public void pupilMovement() {
        right_eye.pupilMovement (Frame.MOUSE_X_POSITION, Frame.MOUSE_Y_POSITION);
        left_eye.pupilMovement (Frame.MOUSE_X_POSITION, Frame.MOUSE_Y_POSITION);
        repaint();
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Drawable[] face_parts = { head, right_eye, left_eye, nose, mouth };

        for (Drawable face_part : face_parts) {
            face_part.draw (g);
        }
    }

}
