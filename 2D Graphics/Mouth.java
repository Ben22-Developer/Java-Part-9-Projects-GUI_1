import java.awt.Color;
import java.awt.Graphics;

public class Mouth implements Drawable {

    private int start_x, start_y, width, height, start_angle, arc_angle ;

    public Mouth (int start_x, int start_y, int width, int height, int start_angle, int arc_angle) {
        this.start_x = start_x;
        this.start_y = start_y;
        this.width = width;
        this.height = height;
        this.start_angle = start_angle;
        this.arc_angle = arc_angle;
    }

    public int getStart_x() {
        return start_x;
    }

    public int getStart_y() {
        return start_y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStart_angle() {
        return start_angle;
    }

    public int getArc_angle() {
        return arc_angle;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor (new Color (255, 255, 255, 168));
        g.fillArc (getStart_x(), getStart_y() , getWidth() , getHeight() , getStart_angle() ,getArc_angle());
    }
}
