import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App_GUI extends JFrame {

    private JTextField fahrenheit_text_field,celsius_text_field, kelvin_text_field;
    private JButton convert_to_celsius_btn, convert_to_kelvin_btn;
    private final int window_width = 650;
    private final int window_height = 450;
    private final int left_gap = 140;

    public App_GUI () {

        setTitle ("Temperature conversion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addTitleToGUI();
        addConversionGUIComponents();
        addEventListener ();
        setSize(new Dimension(window_width,window_height));
        setVisible(true);
        setResizable(false);
    }

    private void setHeaders (JLabel label_text, String font_face, int style ,int size) {
        label_text.setFont(new Font(font_face,style,size));
    }

    private void addTitleToGUI () {
        JPanel GUI_title = new JPanel(new FlowLayout(FlowLayout.LEFT,left_gap,20));
        JLabel title_label = new JLabel("Temperature Converter App");

        setHeaders(title_label,"Arial Black",Font.BOLD,20);
        GUI_title.add(title_label);
        add (GUI_title, BorderLayout.NORTH);
    }

    private void addConversionGUIComponents () {

        JLabel fahrenheit_label;
        JPanel celsius_container, fahrenheit_container, kelvin_container ,all_container;
        BoxLayout box_1,box_2, box_3;

        fahrenheit_label = new JLabel("Enter below the temperature in Fahrenheit:");

        setHeaders(fahrenheit_label,"Arial Rounded MT Bold",0,16);

        celsius_container = new JPanel();
        fahrenheit_container = new JPanel();
        kelvin_container = new JPanel();
        all_container = new JPanel();

        box_1 = new BoxLayout(fahrenheit_container,BoxLayout.PAGE_AXIS);
        box_2 = new BoxLayout(celsius_container,BoxLayout.PAGE_AXIS);
        box_3 = new BoxLayout(kelvin_container,BoxLayout.PAGE_AXIS);

        createTextFields();
        setResultFieldsEditableFalse();

        fahrenheit_container.add(fahrenheit_label);
        createConversionPanel (fahrenheit_container, fahrenheit_text_field, box_1);
        createConversionPanel (celsius_container, celsius_text_field, box_2);
        createConversionPanel (kelvin_container, kelvin_text_field, box_3);
        setFullConversionContainer (all_container,fahrenheit_container,celsius_container, kelvin_container);
        add (all_container, BorderLayout.CENTER);
    }

    private void createTextFields () {
        celsius_text_field = new JTextField();
        fahrenheit_text_field = new JTextField();
        kelvin_text_field = new JTextField();
    }

    private void setResultFieldsEditableFalse () {
        celsius_text_field.setEditable(false);
        kelvin_text_field.setEditable(false);
    }

    private void createConversionPanel (JPanel panel, JTextField text_field, BoxLayout layout) {

        int space = 5;
        text_field.setMaximumSize(new Dimension(window_width - 300,35));
        panel.setLayout (layout);
        panel.add (Box.createVerticalStrut(space));
        panel.add (text_field);
        panel.add (Box.createVerticalStrut(space));
    }

    private void setFullConversionContainer (JPanel all_container, JPanel fahrenheit_panel, JPanel celsius_panel, JPanel kelvin_panel) {

        BoxLayout layout = new BoxLayout(all_container, BoxLayout.PAGE_AXIS);

        convert_to_celsius_btn = new JButton("Convert To Celsius >>>");
        convert_to_kelvin_btn = new JButton("Convert To Kelvin >>>");

        all_container.setLayout (layout);
        all_container.setBorder(BorderFactory.createEmptyBorder(0,left_gap,0,0));

        all_container.add (fahrenheit_panel);
        all_container.add(Box.createVerticalStrut(10));
        all_container.add (convert_to_celsius_btn);
        all_container.add(Box.createVerticalStrut(10));
        all_container.add (celsius_panel);
        all_container.add(Box.createVerticalStrut(10));
        all_container.add(convert_to_kelvin_btn);
        all_container.add(Box.createVerticalStrut(10));
        all_container.add (kelvin_panel);
    }

    public void addEventListener () {

        convert_to_celsius_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String celsius_str = getConversion (true);
                celsius_text_field.setText(celsius_str);
            }
        });

        convert_to_kelvin_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kelvin_str = getConversion (false);
                kelvin_text_field.setText(kelvin_str);
            }
        });
    }

    private String getConversion (boolean convert_to_celsius) {

        String fahrenheit, converted_str;
        double converted;

        fahrenheit = fahrenheit_text_field.getText();
        converted_str = "";
        converted = 0;

        if (convert_to_celsius) {
            converted = Converter.convertToCelsius(fahrenheit);
        }
        else {
            converted = Converter.convertToKelvin(fahrenheit);
        }

        if (Converter.convert_successful) {
            converted_str = convert_to_celsius ? String.format("%.2f %s", converted, "°C") : String.format("%.2f %s", converted, "K");
        }

        return converted_str;
    }
}


// Line 108, Creating Margins