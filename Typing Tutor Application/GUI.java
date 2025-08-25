import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class GUI extends JFrame {

    private JLabel title_text_1, title_text_2;
    private JTextArea text_area;
    private JButton[] buttons;
    private ButtonHighlight button_highlight;

    public GUI () {

        createTitles();
        createTextArea();
        setButtons();
        setButtonHighLight();
        addEventListener();
    }

    private void createTitles () {

        JPanel title_panel = new JPanel(new GridLayout(2,1,0,10));
        title_panel.setBorder(BorderFactory.createEmptyBorder(5,50,10,0));

        title_text_1 = new JLabel ("Type some text using your keyboard. The keys you press will be highlighted and the text displayed.");
        title_text_2 = new JLabel ("Note: Clicking the buttons with your mouse will not perform any action.");
        setTextFont (title_text_1, "Arial Narrow", Font.PLAIN, 18);
        setTextFont (title_text_2, "Arial Narrow", Font.PLAIN, 18);

        title_panel.add (title_text_1);
        title_panel.add (title_text_2);

        add (title_panel, BorderLayout.NORTH);
    }

    private void createTextArea () {

        JPanel panel = new JPanel ();

        text_area = new JTextArea (12,90);
        text_area.setLineWrap(true);
        setTextFont (text_area, "Arial Narrow", Font.PLAIN, 18);

        JScrollPane pane = new JScrollPane (text_area);
        pane.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add (pane);
        add (panel,BorderLayout.CENTER);
    }

    private void setButtons () {

        create_JButtons();

    }

    private void create_JButtons() {

        buttons = new JButton [57];

        int start_index = 0;

        JPanel buttons_panel = new JPanel (new GridLayout(5,1,0,0));

        buttons_panel.setBorder(BorderFactory.createEmptyBorder(0,50,15,0));
        buttons_panel.setPreferredSize(new Dimension(100,280));

        String[] first_row_buttons_names = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-","+", "Backspace"};
        String[] second_row_buttons_names = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
        String[] third_row_buttons_names = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter"};
        String[] fourth_row_buttons_names = {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "^"};
        String[] fifth_row_buttons_names = {"               ", "<","v",">"};

        start_index = createFirst_Second_Third_JButtonRows (buttons_panel, first_row_buttons_names, start_index);
        start_index = createFirst_Second_Third_JButtonRows (buttons_panel, second_row_buttons_names, start_index);
        start_index = createFirst_Second_Third_JButtonRows (buttons_panel, third_row_buttons_names, start_index);
        start_index = createFourthJButtonRow (buttons_panel, fourth_row_buttons_names, start_index);
        createFifthJButtonRow (buttons_panel, fifth_row_buttons_names, start_index);

        add (buttons_panel, BorderLayout.SOUTH);
    }

    private int createFirst_Second_Third_JButtonRows(JPanel buttons_panel , String[] button_names, int start_index) {

        JPanel buttons_row = new JPanel (new FlowLayout(FlowLayout.LEFT));

        for (String button_name : button_names) {
            JButton button = new JButton ();
            createJButton (button, button_name);
            buttons_row.add (button);
            buttons [start_index] = button;
            start_index ++;
        }

        buttons_panel.add (buttons_row);
        return start_index;
    }

    private int createFourthJButtonRow (JPanel buttons_panel , String[] button_names, int start_index) {

        JPanel buttons_row = new JPanel (new FlowLayout(FlowLayout.LEFT));
        JPanel upper_btn_panel = new JPanel (new FlowLayout(FlowLayout.LEFT,25,0));
        JButton button;
        int i;

        for (i = 0; i < button_names.length; i++) {
            button = new JButton ();
            createJButton (button, button_names[i]);
            buttons [start_index] = button;
            start_index ++;
            if (i < button_names.length - 1) {
                buttons_row.add (button);
            }
        }

        upper_btn_panel.add (buttons [start_index - 1]);
        buttons_row.add(upper_btn_panel);
        buttons_panel.add (buttons_row);
        return start_index;

    }

    private void createFifthJButtonRow (JPanel buttons_panel , String[] button_names, int start_index) {

        JPanel space_bar_panel = new JPanel();
        JPanel arrows_panel = new JPanel();
        JPanel south_panel = new JPanel();
        JButton button;

        button = new JButton();
        createJButton (button, button_names[0]);
        space_bar_panel.add (button);
        buttons [start_index] = button;
        start_index ++;

        for (int i = 1; i < button_names.length; i++) {
            button = new JButton();
            createJButton (button, button_names[i]);
            arrows_panel.add (button);
            buttons [start_index] = button;
            start_index ++;
        }

        space_bar_panel.setBorder (BorderFactory.createEmptyBorder(0,185,0,145));
        south_panel.add (space_bar_panel);
        south_panel.add (arrows_panel);

        buttons_panel.add (south_panel);
    }

    private void createJButton (JButton button, String button_name) {

        int height = 45;

        if (button_name.length() == 1) {  // properties set for keyBoard key with only 1 digit
            setJButtonProperties (button, button_name, 70,height);
        }
        else if (button_name.length() < 10) { // properties set for keyBoard keys which aren't space bar
            setJButtonProperties (button, button_name, 120,height);
        }
        else { // property set fot a spaceBar
            setJButtonProperties (button, button_name, 400,height);
        }
    }

    private void setJButtonProperties (JButton button, String text, int width, int height) {
        button.setText (text);
        button.setPreferredSize (new Dimension(width, height));
        setTextFont (button, "Bahnschrift", Font.PLAIN, 18);
    }

    private void setTextFont (JComponent component, String font_face, int font_style, int font_size) {
        component.setFont (new Font(font_face, font_style, font_size));
    }

    private void setButtonHighLight () {
        button_highlight = new ButtonHighlight();
        button_highlight.setButtonsHashMap (buttons);
        button_highlight.setBtn_transparent_color (buttons[1].getBackground());
    }

    private void addEventListener () {
        text_area.addKeyListener(button_highlight);
    }
}
