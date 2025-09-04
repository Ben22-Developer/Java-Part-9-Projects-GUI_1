import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrawFrame extends JFrame {

    private final int window_width = 1280;
    private final int window_height = 670;
    private Color[] colors_array;
    private Color selected_color;
    private String[] colors_string_array;
    private String[] shapes_string_array;

    private JComboBox colors_box;
    private JComboBox shapes_box;
    private JButton undo_button;
    private JButton clear_button;
    private JButton save_button;
    private JButton load_button;
    private JButton empty_file_button;
    private JCheckBox is_filled_box;
    private JLabel status_label;
    private JPanel tab_panel;
    private DrawPanel draw_panel;
    private JPanel south_panel;

    private FileHandling file_handler;

    public DrawFrame () {

        setTitle ("Java Drawings");
        setSize (window_width,window_height);

        setColorsArray ();
        setColorsStringArray ();
        setShapes_string_array();
        setJLabel();
        setButtons();
        setJCombo_boxes();
        setJCheck_Box();
        setJPanels();
        createFileHandler();

        registerEventHandler();

        add (tab_panel, BorderLayout.NORTH);
        add (draw_panel, BorderLayout.CENTER);
        add (south_panel, BorderLayout.SOUTH);
    }

    private void setColorsArray () {
        colors_array = new Color[12];
        colors_array[0] = Color.BLACK;
        colors_array[1] = Color.LIGHT_GRAY;
        colors_array[2] = Color.DARK_GRAY;
        colors_array[3] = Color.GRAY;
        colors_array[4] = Color.RED;
        colors_array[5] = Color.PINK;
        colors_array[6] = Color.ORANGE;
        colors_array[7] = Color.YELLOW;
        colors_array[8] = Color.GREEN;
        colors_array[9] = Color.MAGENTA;
        colors_array[10] = Color.CYAN;
        colors_array[11] = Color.BLUE;
    }

    private void setColorsStringArray () {
        colors_string_array = new String[12];
        colors_string_array[0] = "Black";
        colors_string_array[1] = "Light Gray";
        colors_string_array[2] = "Dark Gray";
        colors_string_array[3] = "Gray";
        colors_string_array[4] = "Red";
        colors_string_array[5] = "Pink";
        colors_string_array[6] = "Orange";
        colors_string_array[7] = "Yellow";
        colors_string_array[8] = "Green";
        colors_string_array[9] = "Magenta";
        colors_string_array[10] = "Cyan";
        colors_string_array[11] = "Blue";
    }

    private void setSelected_color () {
        int selected_color_index = colors_box.getSelectedIndex();
        selected_color = colors_array[selected_color_index];
    }

    private Color getSelected_color () {
        setSelected_color();
        return selected_color;
    }

    private void setShapes_string_array () {
        shapes_string_array = new String[3];
        shapes_string_array[0] = "Line";
        shapes_string_array[1] = "Rectangle";
        shapes_string_array[2] = "Oval";
    }

    private int getSelectedShape () {
        return shapes_box.getSelectedIndex();
    }

    private void setButtons () {
        undo_button = new JButton("Undo");
        clear_button = new JButton("Clear");
        load_button = new JButton("Load");
        save_button = new JButton("Save");
        empty_file_button = new JButton("Empty File");

        setJButtonProperties(new JButton[]{ undo_button, clear_button, load_button, save_button, empty_file_button },
                             new Font[] { new Font("Arial",Font.ITALIC,14) },
                             new Dimension[] { new Dimension(75,35) , new Dimension(75,35), new Dimension(75,35), new Dimension(75,35), new Dimension(100,35) });
    }

    private void setJButtonProperties (JButton[] buttons, Font[] fonts, Dimension[] dimensions) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(fonts[0]);
            buttons[i].setPreferredSize(dimensions[i]);
        }
    }

    private void setJCombo_boxes () {
        colors_box = new JComboBox<>(colors_string_array);
        shapes_box = new JComboBox<>(shapes_string_array);

        colors_box.setFont(new Font("Arial",Font.ITALIC,14));
        shapes_box.setFont(new Font("Arial",Font.ITALIC,14));

        colors_box.setPreferredSize(new Dimension(120,35));
        shapes_box.setPreferredSize(new Dimension(100,35));
    }

    private void setJCheck_Box () {
        is_filled_box = new JCheckBox("Filled");
        is_filled_box.setFont(new Font("Arial",Font.PLAIN,16));
    }

    private void setJLabel () {
        status_label = new JLabel("Mouse Coordinates:");
        status_label.setFont(new Font("Arial",Font.BOLD,16));
        status_label.setHorizontalAlignment(0);
    }

    private void setJPanels () {
        tab_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,20));
        draw_panel = new DrawPanel(status_label);
        south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,27));

        addJComponentsToJPanels(tab_panel, new JComponent[]{undo_button, clear_button, save_button, load_button, empty_file_button, colors_box, shapes_box, is_filled_box}, window_width, 70);
        addJComponentsToJPanels(south_panel, new JComponent[]{status_label}, window_width, 70);
    }

    private void addJComponentsToJPanels (JPanel panel, JComponent[] components, int...dimensions) {

        if (dimensions.length != 0) {
            panel.setPreferredSize(new Dimension(dimensions[0], dimensions[1]));
        }

        for (JComponent component : components) {
            panel.add(component);
        }
    }

    private void createFileHandler () {
         file_handler = new FileHandling();
         file_handler.setDraw_panel (draw_panel);
    }

    private void registerEventHandler() {

        undo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int counts = draw_panel.getShape_count();

                if (counts > 0) {
                    draw_panel.clearLastDrawing();
                }
            }
        });

        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int counts = draw_panel.getShape_count();

                if (counts > 0) {
                    draw_panel.clearDrawing();
                }
            }
        });

        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int counts = draw_panel.getShape_count();

                if (counts > 0) {
                    file_handler.saveShapesFunctionHandler();
                }
                else {
                    JOptionPane.showMessageDialog (null, "You have nothing drawn in the canvas!", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        load_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file_handler.loadSavedShapesManipulator();
            }
        });

        empty_file_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file_handler.emptyFileController();
            }
        });

        colors_box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                draw_panel.setCurrent_color(colors_array[colors_box.getSelectedIndex()]);
            }
        });

        shapes_box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                draw_panel.setShape_type(shapes_box.getSelectedIndex());
            }
        });

        is_filled_box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw_panel.setIs_filled(is_filled_box.isSelected());
            }
        });
    }
}
