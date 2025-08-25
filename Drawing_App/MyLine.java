import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{
    public MyLine () {
        this (0,0,0,0,Color.BLACK);
    }

    public MyLine (int upper_x, int upper_y, int lower_x, int lower_y, Color color)
    {
        super(upper_x, upper_y, lower_x, lower_y, color);
    }

    public void draw (Graphics g) {
        g.setColor(getColor());
        g.drawLine(getUpperX(), getUpperY(), getLowerX(), getLowerY());
    }
}
