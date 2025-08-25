import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Align extends JFrame {

    private JPanel panel_1, panel_2, panel_3;
    private JButton ok_btn, cancel_btn, help_btn;
    private JCheckBox box_1, box_2;
    private JTextField field_x, field_y;
    private JLabel x,y;

    public Align () {

        setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
        setTitle("Align");

        setPanel_1 ();
        setPanel_2 ();
        setPanel_3 ();

        add (panel_1);
        add (panel_2);
        add (panel_3);
    }

    private void setPanel_1 () {

        panel_1 = new JPanel();
        BoxLayout box = new BoxLayout(panel_1,BoxLayout.PAGE_AXIS);

        box_1 = new JCheckBox("Snap to Grid");
        box_2 = new JCheckBox("Show Grid");

        box_1.setOpaque(false);
        box_2.setOpaque(false);

        panel_1.setOpaque(false);
        panel_1.setLayout(box);
        panel_1.add(box_1);
        panel_1.add(box_2);
    }

    private void setPanel_2 () {

        JPanel x_panel, y_panel;
        x_panel = new JPanel();
        y_panel = new JPanel();

        panel_2 = new JPanel(new GridLayout(2,1));

        x = new JLabel("X: ");
        y = new JLabel("Y: ");

        field_x = new JTextField("8",5);
        field_y = new JTextField("8",5);
        field_x.setEditable(false);
        field_y.setEditable(false);

        x_panel.add(x);
        x_panel.add(field_x);
        y_panel.add(y);
        y_panel.add(field_y);
        x_panel.setOpaque(false);
        y_panel.setOpaque(false);

        panel_2.add(x_panel);
        panel_2.add(y_panel);
        panel_2.setBackground(new Color(138, 168, 214));
    }

    private void setPanel_3 () {

        panel_3 = new JPanel(new GridLayout(3,1,0,7));

        ok_btn = new JButton("Ok");
        cancel_btn = new JButton("Cancel");
        help_btn = new JButton("Help");

        panel_3.add(ok_btn);
        panel_3.add(cancel_btn);
        panel_3.add(help_btn);
        panel_3.setBackground(new Color(138, 168, 214));
    }
}
