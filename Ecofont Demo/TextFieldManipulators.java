import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.out;

public class TextFieldManipulators extends JPanel {

    private final int MAX_FONT_SIZE = 1000;
    private final int MIN_FONT_SIZE = 1;
    private final int FONT_SIZE_NO_UPDATE = -18;

    private int font_size;
    private JLabel title_label, size_label;
    private JTextField font_size_JText_field_content;
    private JButton increase_font_button, decrease_font_button, apply_button;
    private JPanel panel_title, panel_components;
    private Text_Panel text_panel;

    public TextFieldManipulators() {

        setLayout (new GridLayout(5,1));
        setOpaque(false);
        font_size = 16;

        createJLabels();
        createJTextFields();
        createFontJButtons();
        createJPanels();
        registerEventListeners();
    }

    public void setText_panel (Text_Panel text_panel) {
        this.text_panel = text_panel;
    }

    private void setJComponentFontProperties (JComponent component, int font_style, int font_size) {
        component.setFont(new Font ("Ecofont Vera Sans", font_style, font_size));
    }

    private void createJLabels() {
        title_label = new JLabel("Ecofont Vera Sans");
        size_label = new JLabel("Size:");

        setJComponentFontProperties (title_label, Font.BOLD, 30);
        setJComponentFontProperties (size_label, Font.PLAIN, 16);
    }

    private void createJTextFields () {
        font_size_JText_field_content = new JTextField (3);
        setJComponentFontProperties(font_size_JText_field_content, Font.PLAIN, 16);
        setFontJTextFieldContent();
    }

    private void setFontJTextFieldContent () {
        font_size_JText_field_content.setText(String.valueOf(getFontSize()));
    }

    private void setFontJTextFieldContent (boolean is_increased) {

        int actual_font_size = getFontSize();

        if (is_increased) {
            int increased_font_size = actual_font_size + 1;
            incrementFontSize(actual_font_size, increased_font_size);
        }
        else {
            int decreased_font_size = actual_font_size - 1;
            decrementFontSize(actual_font_size, decreased_font_size);
        }
        font_size_JText_field_content.setText(String.valueOf(getFontSize()));
    }

    private void incrementFontSize (int actual_font_size, int increased_font_size) {
        if (actual_font_size < MAX_FONT_SIZE) {
            setFont_size (increased_font_size);
        }
    }

    private void decrementFontSize (int actual_font_size, int decreased_font_size) {
        if (actual_font_size > MIN_FONT_SIZE) {
            setFont_size (decreased_font_size);
        }
    }

    private int getFontJTextFieldContent () {
        String content = font_size_JText_field_content.getText();
        return validateFontJTextFieldContent(content);
    }

    private void setFont_size (int font_size) {
        this.font_size = font_size;
    }

    public int getFontSize () {
        return font_size;
    }

    private int validateFontJTextFieldContent (String font_size_string) {

        double font_size_double;
        int font_size_int;

        try {
            font_size_double = Double.parseDouble(font_size_string);
            font_size_int = (int) (font_size_double);

            if (font_size_int < MIN_FONT_SIZE || font_size_int > MAX_FONT_SIZE) {
                JOptionPane.showMessageDialog(null,"The font size must be between "+ MIN_FONT_SIZE +" and "+ MAX_FONT_SIZE,"EcoFont",JOptionPane.WARNING_MESSAGE);
                font_size_int = FONT_SIZE_NO_UPDATE;
            }
        }
        catch (Exception e) {
            font_size_int = FONT_SIZE_NO_UPDATE;
            JOptionPane.showMessageDialog(null,"The font size must be a number between "+ MIN_FONT_SIZE +" and "+ MAX_FONT_SIZE,"EcoFont",JOptionPane.ERROR_MESSAGE);
        }



        return font_size_int;
    }

    private void createFontJButtons () {
        increase_font_button = new JButton("Increase Font");
        decrease_font_button = new JButton("Decrease Font");
        apply_button = new JButton("Apply Font");
        setButtonsFontStyle (new JButton[] {increase_font_button, decrease_font_button, apply_button});
    }

    private void setButtonsFontStyle (JButton[] buttons) {
        for (JButton button : buttons) {
            button.setFont(new Font ("Ecofont Vera Sans",Font.PLAIN, 16));
            button.setPreferredSize(new Dimension(150,50));
        }
    }

    private void createJPanels () {

        JPanel space_1 = new JPanel();
        JPanel space_2 = new JPanel();
        JPanel space_3 = new JPanel();
        JPanel size_panel = new JPanel();

        space_1.setOpaque(false);
        space_2.setOpaque(false);
        space_3.setOpaque(false);
        size_panel.setOpaque(false);
        add (space_1);

        panel_title = new JPanel();
        panel_components = new JPanel();


        addJComponentsToJPanel (size_panel, new FlowLayout(FlowLayout.LEFT, 10, 0), new JComponent[]{size_label, font_size_JText_field_content}, false);
        addJComponentsToJPanel (panel_title, new FlowLayout(FlowLayout.CENTER, 0, 0), new JComponent[]{title_label}, true);
        add (space_2);
        addJComponentsToJPanel (panel_components, new FlowLayout(FlowLayout.CENTER, 40, 0), new JComponent[]{size_panel, apply_button, decrease_font_button, increase_font_button}, true);
        add (space_3);
    }

    private void addJComponentsToJPanel (JPanel panel, LayoutManager layout, JComponent[] components, boolean add_to_main_panel) {

        panel.setLayout(layout);

        for (JComponent component : components) {
            panel.add (component);
        }
        panel.setOpaque(false);
        if (add_to_main_panel) {
            add(panel);
        }
    }

    private void registerEventListeners () {

        increase_font_button.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontJTextFieldContent (true);
                text_panel.setText_area();
            }
        });

        decrease_font_button.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontJTextFieldContent (false);
                text_panel.setText_area();
            }
        });

        apply_button.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTypedFontSize();
            }
        });

        font_size_JText_field_content.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTypedFontSize();
            }
        });
    }

    private void updateTypedFontSize () {
        int font_size = getFontJTextFieldContent();

        if (font_size != FONT_SIZE_NO_UPDATE) {
            setFont_size(font_size);
        }
        setFontJTextFieldContent();
        text_panel.setText_area();
    }

}
