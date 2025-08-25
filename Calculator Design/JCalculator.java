import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class JCalculator extends JPanel {

    private final JButton[] buttons =
    {
            new JButton("7"),new JButton("8"),new JButton("9"),new JButton("/"),
            new JButton("4"),new JButton("5"), new JButton("6"),new JButton("*"),
            new JButton("1"),new JButton("2"), new JButton("3"),new JButton("-"),
            new JButton("0"),new JButton("."),new JButton("="),new JButton("+"),
    };

    private final JTextField j_text_field;
    private final JPanel buttons_area, j_text_field_panel;

    public JCalculator() {

        j_text_field = new JTextField();
        j_text_field.setPreferredSize(new Dimension(JCalculatorTest.window_width - 33,45));

        j_text_field_panel = new JPanel(new GridLayout(1,1));
        buttons_area = new JPanel(new GridLayout(4,4,3,3));

        for (JButton btn : buttons) {
            btn.setPreferredSize(new Dimension(75,48));
            buttons_area.add(btn);
        }

        j_text_field_panel.setLayout(new BorderLayout());
        j_text_field_panel.setSize(new Dimension(100,40));
        j_text_field_panel.add(j_text_field);

        add (j_text_field_panel);
        add (buttons_area);
    }
}
