import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape
{
    public MyRectangle () {
        this (0,0,0,0,Color.BLACK, false);
    }

    public MyRectangle (int upper_x, int upper_y, int lower_x, int lower_y, Color color, boolean is_filled)
    {
        super (upper_x, upper_y, lower_x, lower_y, color, is_filled);
    }

    public void draw (Graphics g)
    {
        g.setColor(getColor());

        if (getIs_filled())
        {
            g.fillRect(getUpperX(), getUpperY(), getWidth(), getHeight());
        }
        else
        {
            g.drawRect(getUpperX(), getUpperY(), getWidth(), getHeight());
        }
    }
}
