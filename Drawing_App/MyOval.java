import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape
{

    public MyOval () {
        this (0,0,0,0,Color.BLACK, false);
    }

    public MyOval (int upper_x, int upper_y, int lower_x, int lower_y, Color color, boolean is_filled)
    {
        super (upper_x, upper_y, lower_x, lower_y, color, is_filled);
    }

    public void draw (Graphics g)
    {
        g.setColor(getColor());

        if (getIs_filled())
        {
            g.fillOval(getUpperX(), getUpperY(), getWidth(), getHeight());
        }
        else
        {
            g.drawOval(getUpperX(), getUpperY(), getWidth(), getHeight());
        }
    }
}
