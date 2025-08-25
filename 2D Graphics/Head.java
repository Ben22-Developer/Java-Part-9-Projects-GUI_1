import java.awt.Color;
import java.awt.Graphics;

public class Head implements Drawable {

    private int location_x, location_y, size;

    public Head (int location_x, int location_y, int size) {
        this.location_x = location_x;
        this.location_y = location_y;
        this.size = size;
    }

    public int getLocation_x() {
        return location_x;
    }

    public int getLocation_y() {
        return location_y;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void draw (Graphics g) {
        g.setColor (Color.ORANGE);
        g.fillOval (getLocation_x(), getLocation_y(), getSize(), getSize());
    }
}
