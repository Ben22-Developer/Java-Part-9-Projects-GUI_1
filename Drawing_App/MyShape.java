import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

abstract public class MyShape implements Serializable {

    private int upper_x, upper_y, lower_x, lower_y;
    private Color color;

    public MyShape () {
        this (0,0,0,0,Color.BLACK);
    }

    public MyShape (int upper_x, int upper_y, int lower_x, int lower_y, Color color) {
        this.upper_x = upper_x;
        this.upper_y = upper_y;
        this.lower_x = lower_x;
        this.lower_y = lower_y;
        this.color = color;
    }

    public void setColor (Color color)
    {
        this.color = color;
    }

    public void setUpperX (int upper_x)
    {
        this.upper_x = upper_x;
    }

    public void setUpperY (int upper_y)
    {
        this.upper_y = upper_y;
    }

    public void setLowerX (int lower_x)
    {
        this.lower_x = lower_x;
    }

    public void setLowerY (int lower_y)
    {
        this.lower_y = lower_y;
    }

    public Color getColor ()
    {
        return color;
    }

    public int getUpperX ()
    {
        return upper_x;
    }

    public int getUpperY ()
    {
        return upper_y;
    }

    public int getLowerX ()
    {
        return lower_x;
    }

    public int getLowerY ()
    {
        return lower_y;
    }

    public abstract void draw (Graphics g);
}
