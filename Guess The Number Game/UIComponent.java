import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

public class UIComponent {

    public static void createButton (JButton button, String text,Color fg_color, Color bg_color, int width, int height, boolean is_button_enabled) {
        button.setText (text);
        button.setFont (new Font("Arial",3,20));
        button.setPreferredSize(new Dimension(width,height));
        button.setBackground(bg_color);
        button.setForeground(fg_color);
        componentEnableState(button, is_button_enabled);
    }

    public static void createLabel (JLabel label, String text, Color fg_color) {
        label.setText(text);
        label.setFont(new Font("Arial",1,25));
        label.setForeground(fg_color);
        label.setHorizontalAlignment(0);
    }

    public static void createTextField (JTextField field, int width, int height, int font_style,int font_size,int alignment, boolean j_text_field_enabled) {
        field.setPreferredSize(new Dimension(width,height));
        field.setFont(new Font("Arial",font_style,font_size));
        field.setHorizontalAlignment(alignment);
        componentEnableState(field,j_text_field_enabled);
    }

    public static void addJComponentsToPanels(JPanel panel, JComponent[] components, boolean is_panel_opaque, Border...border) {
        for (JComponent component : components) {
            panel.add(component);
        }
        panel.setOpaque(is_panel_opaque);
        if (border.length != 0) {
            panel.setBorder(border[0]);
        }
    }

    public static void componentTextUpdate (JComponent component, String text) {

        if (component instanceof JButton) {
            ((JButton) component).setText(text);
        }
        else if (component instanceof JLabel) {
            ((JLabel) component).setText(text);
        }
        else if (component instanceof JTextField) {
            ((JTextField) component).setText(text);
        }
    }

    public static void componentEnableState (JComponent component, boolean is_enabled) {
        component.setEnabled(is_enabled);
    }

    public static void componentVisibilityState (JComponent component, boolean is_visible) {
        component.setVisible(is_visible);
    }

    public static void updateContainerBgColor (Container container, Color bg_color) {
        container.setBackground(bg_color);
    }

}
