import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BorderLayoutt extends JFrame implements MouseListener {

    private JPanel panel_north, panel_south, panel_center,panel_east, panel_west;
    private JLabel panel_north_text, panel_south_text,panel_center_text,panel_east_text, panel_west_text;
    private JPanel[] panels;

    public BorderLayoutt() {

        setLayout(new BorderLayout());

        panel_north = new JPanel(new BorderLayout());
        panel_south = new JPanel(new BorderLayout());
        panel_center = new JPanel(new BorderLayout());
        panel_west = new JPanel(new BorderLayout());
        panel_east = new JPanel(new BorderLayout());

        panel_north.setBackground(Color.BLACK);
        panel_south.setBackground(Color.BLACK);
        panel_center.setBackground(Color.gray);
        panel_west.setBackground(Color.darkGray);
        panel_east.setBackground(Color.darkGray);

        panel_north.setPreferredSize(new Dimension(100,100));
        panel_south.setPreferredSize(new Dimension(100,100));
        panel_center.setPreferredSize(new Dimension(100,100));
        panel_east.setPreferredSize(new Dimension(100,100));
        panel_west.setPreferredSize(new Dimension(100,100));

        panel_north_text = new JLabel("NORTH");
        panel_south_text = new JLabel("SOUTH");
        panel_center_text = new JLabel("CENTER");
        panel_west_text = new JLabel("WEST");
        panel_east_text = new JLabel("EAST");

        panel_north_text.setForeground(Color.WHITE);
        panel_south_text.setForeground(Color.WHITE);
        panel_center_text.setForeground(Color.WHITE);
        panel_west_text.setForeground(Color.WHITE);
        panel_east_text.setForeground(Color.WHITE);

        panel_north_text.setHorizontalAlignment(SwingConstants.CENTER);
        panel_south_text.setHorizontalAlignment(SwingConstants.CENTER);
        panel_center_text.setHorizontalAlignment(SwingConstants.CENTER);
        panel_east_text.setHorizontalAlignment(SwingConstants.CENTER);
        panel_west_text.setHorizontalAlignment(SwingConstants.CENTER);

        panel_north.add(panel_north_text,BorderLayout.CENTER);
        panel_south.add(panel_south_text,BorderLayout.CENTER);
        panel_center.add(panel_center_text,BorderLayout.CENTER);
        panel_east.add(panel_east_text,BorderLayout.CENTER);
        panel_west.add(panel_west_text,BorderLayout.CENTER);

        panel_north.addMouseListener(this);
        panel_south.addMouseListener(this);
        panel_center.addMouseListener(this);
        panel_east.addMouseListener(this);
        panel_west.addMouseListener(this);

        add (panel_north, BorderLayout.NORTH);
        add (panel_south, BorderLayout.SOUTH);
        add (panel_center, BorderLayout.CENTER);
        add (panel_east, BorderLayout.EAST);
        add (panel_west, BorderLayout.WEST);

        panels = new JPanel[5];
        panels[0] = panel_north;
        panels[1] = panel_south;
        panels[2] = panel_center;
        panels[3] = panel_east;
        panels[4] = panel_west;
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        for (JPanel panel : panels) {
            if (e.getSource() == panel) {
                panel.setVisible(false);
            }
            else {
                panel.setVisible(true);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}