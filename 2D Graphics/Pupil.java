import java.awt.Graphics;
import java.awt.Color;

public class Pupil implements Drawable {

    private int pupil_location_x, pupil_location_y, size;
    private final Color pupil_color = Color.BLACK;
    private Eyes eye;
    private boolean blink;

    public Pupil (int pupil_location_x, int  pupil_location_y, int size) {
        this.pupil_location_x = pupil_location_x;
        this.pupil_location_y = pupil_location_y;
        this.size = size;
        this.blink = false;
    }

    public void setEye (Eyes eye) {
        this.eye = eye;
    }

    public int getPupil_location_x () {
        return pupil_location_x;
    }

    public int getPupil_location_y () {
        return pupil_location_y;
    }

    public void setPupil_location_x (int mouse_location_x) {
        int left_most_border = eye.getLocation_x();
        int right_most_border = left_most_border + eye.getSize() - (this.getSize());
        int x_coordinate_position = left_most_border + mouse_location_x;
        if (x_coordinate_position <= right_most_border) {
            this.pupil_location_x = x_coordinate_position;
        }
    }

    public void setPupil_location_y (int mouse_location_y) {
        int up_most_border = eye.getLocation_y();
        int bottom_most_border = up_most_border + eye.getSize() - (this.getSize());
        int y_coordinate_position = up_most_border + mouse_location_y;
        if (y_coordinate_position <= bottom_most_border) {
            this.pupil_location_y = y_coordinate_position;
        }
    }

    public int getSize() {
        return size;
    }

    public void setBlink (boolean blink) {
        this.blink = blink;
    }

    @Override
    public void draw (Graphics g) {
        if (blink) {
            g.setColor (Color.ORANGE);
        }
        else {
            g.setColor (Color.BLACK);
        }
        g.fillOval(getPupil_location_x(), getPupil_location_y(), getSize(), getSize());
    }
}
