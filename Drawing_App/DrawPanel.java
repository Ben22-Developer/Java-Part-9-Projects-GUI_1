import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawPanel extends JPanel
{
    private MyShape[] shapes;
    private int shape_count;
    private int shape_type;
    private Color current_color;
    private boolean is_filled;
    private MyShape current_shape;
    private JLabel status_label;
    private boolean mouse_is_draggable;
    private Point upper_points;
    private Point lower_points;
    private ArrayList <Point> dragging_points;

    public DrawPanel (JLabel status_label)
    {
        this.status_label = status_label;
        this.shapes = new MyShape[100]; // shapes to be drawn are 100
        this.shape_count = 0; // number of shapes drawn
        this.shape_type = 0; // 0 represents a line, 1 represents a rectangle, 2 represents an oval
        this.current_shape = null;
        this.current_color = Color.BLACK;
        this.is_filled = false;
        setBackground(Color.WHITE);
        registerEventHandler();
    }

    @Override
    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        shapesDrawing(g);

        if (mouse_is_draggable) {
            pointsDrawing(g);
        }
    }

    private void shapesDrawing (Graphics g) {
        for (int i = 0; i < shape_count; i++) {
            shapes[i].draw(g);
        }
    }

    private void pointsDrawing (Graphics g) {
        for (Point point : dragging_points) {
            current_shape.setLowerX (point.x);
            current_shape.setLowerY (point.y);

            if (current_shape instanceof MyBoundedShape) {
                MyBoundedShape bounded_shape = (MyBoundedShape) current_shape;
                bounded_shape.setIs_filled(is_filled);
            }

            current_shape.draw(g);
        }
    }

    public void setShape_type (int shape_type) {
        this.shape_type = shape_type;
    }

    public int getShape_type () {
        return shape_type;
    }

    public int getShape_count () {
        return shape_count;
    }

    public void setCurrent_color (Color color) {
        this.current_color = color;
    }

    public Color getCurrent_color() {
        return current_color;
    }

    public void clearLastDrawing () {
        shape_count --;
        repaint();
    }

    public void clearDrawing () {
        shape_count = 0;
        repaint();
    }

    public void setIs_filled (boolean is_filled) {
        this.is_filled = is_filled;
    }

    private void setCurrent_shape (int upper_x, int upper_y) {

        current_shape = null;
        int shape_type_to_draw = getShape_type();

        switch (shape_type_to_draw) {
            case 0 -> {
                current_shape = new MyLine();
            }
            case 1 -> {
                current_shape = new MyRectangle();
            }
            case 2 -> {
                current_shape = new MyOval();
            }
        }

        current_shape.setColor(current_color);
        current_shape.setUpperX(upper_x);
        current_shape.setUpperY(upper_y);
    }

    private void registerEventHandler () {
        InnerClassEventHandler handler = new InnerClassEventHandler();
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    private class InnerClassEventHandler extends MouseAdapter {

        public void mousePressed (MouseEvent e) {
            current_color = getCurrent_color();
            upper_points = e.getPoint();
            shape_type = getShape_type();
            setCurrent_shape (upper_points.x,upper_points.y);
        }

        public void mouseDragged(MouseEvent e) {

            if (e.getY() < getHeight() && e.getY() >= 0 && e.getX() < getWidth() && e.getX() >= 0) {
                mouse_is_draggable = true;
                mouseCoordinates(e);
                dragging_points = new ArrayList<>();
                dragging_points.add(e.getPoint());
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {

            lower_points = e.getPoint();
            current_shape.setLowerX (lower_points.x);
            current_shape.setLowerY (lower_points.y);

            if (shape_count < shapes.length) {
                shapes[shape_count] = current_shape;
                shape_count += 1;
            }
            else {
                JOptionPane.showMessageDialog(null, "You have hit the maximum shapes limit!","Error Message",JOptionPane.ERROR_MESSAGE);
            }
            mouse_is_draggable = false;
            current_shape = null;
            repaint();
        }

        public void mouseMoved (MouseEvent e) {
            mouseCoordinates(e);
        }

        public void mouseCoordinates (MouseEvent e) {
            if (e.getY() < getHeight() && e.getY() >= 0 && e.getX() < getWidth() && e.getX() >= 0) {
                status_label.setText("Mouse Coordinates: ( "+e.getX()+" , "+e.getY()+" )");
            }
        }
    }
}