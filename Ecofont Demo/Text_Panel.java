import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Text_Panel extends JPanel {

    private JTextArea text_area;
    private JScrollPane pane;
    private TextFieldManipulators text_field_manipulators;
    private JPanel panel_upper, panel_center;

    public Text_Panel () {

        text_field_manipulators = new TextFieldManipulators();
        createText_area();
        setPane();

        registerEventListener();

//        setPreferredSize(new Dimension(Main.WINDOW_WIDTH - 300, Main.WINDOW_HEIGHT - 300));
        setBackground(new Color(251, 192, 129));

        add (text_field_manipulators);
        add (pane);
        text_field_manipulators.setText_panel(this);
    }

    private void createText_area() {
        text_area = new JTextArea(20,100);
        text_area.setLineWrap(true);
    }

    private void setPane () {
        pane = new JScrollPane (text_area);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public void setText_area () {
        int font_size = text_field_manipulators.getFontSize();
        text_area.setFont(new Font("Ecofont Vera Sans", Font.PLAIN,font_size));
    }

    public String getTextAreaText () {
        return this.text_area.getText();
    }

    private void registerEventListener () {

        text_area.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                setText_area();
            }
        });
    }
}
