import java.awt.Color;

abstract public class MyBoundedShape extends MyShape
{
    private boolean is_filled;

    public MyBoundedShape () {
        this (0,0,0,0,Color.BLACK, false);
    }

    public MyBoundedShape (int upper_x, int upper_y, int lower_x, int lower_y, Color color, boolean is_filled) {
        super(upper_x, upper_y, lower_x, lower_y, color);
        this.is_filled = is_filled;
    }

    public void setIs_filled (boolean is_filled)
    {
        this.is_filled = is_filled;
    }

    public int getWidth ()
    {
        return Math.abs(getUpperX() - getLowerX());
    }

    public int getHeight()
    {
        return Math.abs(getUpperY() - getLowerY());
    }

    public boolean getIs_filled()
    {
        return is_filled;
    }
}
