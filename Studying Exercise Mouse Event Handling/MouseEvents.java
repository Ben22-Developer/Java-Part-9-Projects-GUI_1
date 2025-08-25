import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends JFrame {

    final int panel_board_height = 270;
    final int panel_width = 500;
    JPanel panel_board, panel_text;
    JLabel label;

    String mouse_outside_panel, mouse_moving_panel, mouse_clicked_panel, mouse_pressed_panel, mouse_dragged_panel, mouse_released_panel;

    public MouseEvents () {

        setLayout(new BorderLayout());

        mouse_outside_panel = "Mouse outside panel ";
        mouse_moving_panel = "Mouse moved at ";
        mouse_clicked_panel = "Mouse clicked at ";
        mouse_pressed_panel = "Mouse pressed at ";
        mouse_dragged_panel = "Mouse dragged at ";
        mouse_released_panel = "Mouse released at ";

        label = new JLabel();
        panel_board = new JPanel();
        panel_text = new JPanel();

        panel_board.setPreferredSize(new Dimension(panel_width,panel_board_height));
        panel_board.setBackground(Color.lightGray);

        label.setText(mouse_outside_panel);

        panel_text.setPreferredSize(new Dimension(panel_width,30));
        panel_text.add(label);
        panel_text.setBackground(Color.ORANGE);

        MouseEventsHandler handler = new MouseEventsHandler();
        panel_board.addMouseListener(handler);
        panel_board.addMouseMotionListener(handler);

        add (panel_board,BorderLayout.NORTH);
        add (panel_text,BorderLayout.SOUTH);
    }

    private class MouseEventsHandler implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {
            panel_board.setBackground(new Color(0,100,0));
            label.setText(mouse_clicked_panel+ "[" + e.getX() + "," + e.getY()+"]");
        }

        public void mousePressed(MouseEvent e) {
            panel_board.setBackground(new Color(0,100,0));
            label.setText(mouse_pressed_panel+ "[" + e.getX() + "," + e.getY()+"]");
        }

        public void mouseReleased(MouseEvent e) {
            if (e.getX() <= panel_width && e.getY() <= panel_board_height) {
                panel_board.setBackground(new Color(0, 100, 0));
                label.setText(mouse_released_panel + "[" + e.getX() + "," + e.getY() + "]");
            }
        }

        public void mouseEntered(MouseEvent e) {
            label.setText("Mouse entered the panel");
        }

        public void mouseExited(MouseEvent e) {
            panel_board.setBackground(Color.lightGray);
            label.setText(mouse_outside_panel);
        }

        public void mouseDragged(MouseEvent e) {
            if (e.getX() <= panel_width && e.getY() <= panel_board_height &&
               e.getX() >= 0 && e.getY() >= 0) {
                label.setText(mouse_dragged_panel + "[" + e.getX() + "," + e.getY() + "]");
            }
        }

        public void mouseMoved(MouseEvent e) {}
    }
}
