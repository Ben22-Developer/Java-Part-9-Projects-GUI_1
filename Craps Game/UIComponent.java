import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

public class UIComponent {

    public static void createJLabel (JLabel label, String text, String font_face, int font_style, int font_size, Color fg) {
        label.setText(text);
        label.setFont(new Font(font_face, font_style, font_size));
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        label.setForeground(fg);
    }

    public static void createJTextField (JTextField text_field, int width, int height) {
        text_field.setPreferredSize(new Dimension(width,height));
        text_field.setEditable(false);
        text_field.setHorizontalAlignment(0);
        text_field.setFont(new Font("Arial",1,18));
    }

    public static void createJButton (JButton button, String text, Color fg, Color bg, int width, int height, boolean button_enabled) {
        button.setText(text);
        button.setFont(new Font("Arial Rounded MT Bold",0,20));
        button.setForeground(fg);
        button.setBackground(bg);
        button.setPreferredSize(new Dimension(width, height));
        setJComponentEnabled(button, button_enabled);
    }

    public static void createJPanel (JPanel panel, JComponent[] components, LayoutManager layout, boolean set_opaque, int width, int height) {
        panel.setMaximumSize(new Dimension(width, height));
        panel.setLayout(layout);
        for (JComponent component : components) {
            panel.add(component);
        }
        panel.setOpaque(set_opaque);
    }

    public static void updateJComponentText (JComponent component, String text) {

        if (component instanceof JLabel) {
            ((JLabel) component).setText(text);
        }
        else if (component instanceof JButton) {
            ((JButton) component).setText(text);
        }
        else if (component instanceof JTextField) {
            ((JTextField) component).setText(text);
        }
    }

    public static void setJComponentEnabled (JComponent component, boolean enabled) {
        component.setEnabled(enabled);
    }
}
