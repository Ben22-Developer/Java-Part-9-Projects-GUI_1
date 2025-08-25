import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class JColorSelect extends JFrame {

    private JPanel container_1,container_2,container_3;
    private JComboBox color_selector;
    private JCheckBox back_ground,fore_ground;
    private JButton ok_btn, cancel_btn;

    private String[] color_names =
    {
        "RED","GREEN","BLUE","BLACK","WHITE","Orange"
    };

    private Color[] colors =
    {
      Color.RED, Color.GREEN, Color.BLUE, Color.black,Color.WHITE,Color.ORANGE
    };

    public JColorSelect () {
        setTitle("Color Select");
        setContainer_2();
        setContainer_1();
        setContainer_3();
        add (container_1,BorderLayout.NORTH);
        add (container_2, BorderLayout.CENTER);
        add (container_3, BorderLayout.SOUTH);
    }

    public void setContainer_1 () {

        container_1 = new JPanel(new BorderLayout());
        color_selector = new JComboBox(color_names);

        container_1.setSize(new Dimension(JColorSelectTest.window_width - 100, 20));
        container_1.add(color_selector,BorderLayout.NORTH);
    }

    public void setContainer_2 () {

        container_2 = new JPanel(new FlowLayout(FlowLayout.CENTER,30,45));

        back_ground = new JCheckBox("Background");
        fore_ground = new JCheckBox("Foreground");

        container_2.add(back_ground);
        container_2.add(fore_ground);
    }

    private void setContainer_3 () {

        container_3 = new JPanel();

        ok_btn = new JButton("Ok");
        cancel_btn = new JButton("Cancel");

        container_3.add(ok_btn);
        container_3.add(cancel_btn);
    }
}
