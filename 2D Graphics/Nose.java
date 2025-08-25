import java.awt.Color;
import java.awt.Graphics;

public class Nose implements Drawable {

    private int upper_nose_x1, upper_nose_y1,upper_nose_x2, upper_nose_y2, lower_nose_x1, lower_nose_y1, lower_nose_x2, lower_nose_y2;

    public Nose (int upper_nose_x1, int upper_nose_y1, int upper_nose_x2, int upper_nose_y2 , int lower_nose_x1, int lower_nose_y1, int lower_nose_x2, int lower_nose_y2) {
        this.upper_nose_x1 = upper_nose_x1;
        this.upper_nose_y1 = upper_nose_y1;
        this.upper_nose_x2 = upper_nose_x2;
        this.upper_nose_y2 = upper_nose_y2;
        this.lower_nose_x1 = lower_nose_x1;
        this.lower_nose_y1 = lower_nose_y1;
        this.lower_nose_x2 = lower_nose_x2;
        this.lower_nose_y2 = lower_nose_y2;
    }

    public int getLower_nose_x1() {
        return lower_nose_x1;
    }

    public int getLower_nose_x2() {
        return lower_nose_x2;
    }

    public int getLower_nose_y1() {
        return lower_nose_y1;
    }

    public int getLower_nose_y2() {
        return lower_nose_y2;
    }

    public int getUpper_nose_x1() {
        return upper_nose_x1;
    }

    public int getUpper_nose_x2() {
        return upper_nose_x2;
    }

    public int getUpper_nose_y1() {
        return upper_nose_y1;
    }

    public int getUpper_nose_y2() {
        return upper_nose_y2;
    }

    @Override
    public void draw (Graphics g) {
        g.setColor (Color.BLACK);
        g.drawLine (getUpper_nose_x1(), getUpper_nose_y1(), getUpper_nose_x2(), getUpper_nose_y2());
        g.drawLine (getLower_nose_x1(), getLower_nose_y1(), getLower_nose_x2(), getLower_nose_y2());
    }
}
