import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Window extends JFrame {

    private String[] color_names = {
            "Red","Green","Blue","Yellow","Orange","Cyan","Gray","Pink","Magenta", "White","Black"
    };

    private Color[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.gray, Color.PINK,
            Color.magenta, Color.white, Color.BLACK
    };

    private JList list = new JList(color_names);
    private JScrollPane scroll_pane;
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();

    public Window () {

        list.setVisibleRowCount(4);
        scroll_pane = new JScrollPane(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        EventHandler handler = new EventHandler();
        list.addListSelectionListener(handler);

        setLabelText(color_names[0]);
        panel.add(scroll_pane);
        panel.add(label);
        panel.setBackground(colors[0]);
        panel.setSize(new Dimension(350,350));
        panel.setLayout(new FlowLayout(2,30,12));

        setTitle("BackGround Color Selection");
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,500));
        setVisible(true);
    }

    private class EventHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            int index = list.getSelectedIndex();
            setLabelText(color_names[index]);
            panel.setBackground(colors[index]);
        }
    }

    private void setLabelText (String color) {
        label.setText("BackGround color is "+color);
        if (color.equals("Black") || color.equals("Blue") || color.equals("Gray")) {
            label.setForeground(Color.WHITE);
        }
        else {
            label.setForeground(Color.BLACK);
        }
    }
}
