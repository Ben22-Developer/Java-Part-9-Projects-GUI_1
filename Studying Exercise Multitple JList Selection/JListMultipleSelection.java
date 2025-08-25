import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.out;

public class JListMultipleSelection extends JFrame {

    private final String[] colors =
    {
            "Red","Green","Blue","Yellow","Orange","Cyan","Gray","Pink","Magenta", "White","Black"
    };

    private JPanel panel;
    private JLabel label;
    private JList<String> color_list,selected_color_list;
    private JScrollPane scroll_pane,selected_scroll_pane;
    private JButton button;
    private final int window_height = 700;
    private final int window_width = 700;
    private boolean addedTo_selected_list;

    public JListMultipleSelection () {

        panel = new JPanel();
        label = new JLabel();
        button = new JButton("Copy >>>");
        color_list = new JList<>(colors);
        selected_color_list = new JList<>();
        selected_scroll_pane = new JScrollPane();
        addedTo_selected_list = false;

        color_list.setSize(300,500);
        color_list.setVisibleRowCount(4);
        color_list.setSelectionMode(1);

        selected_color_list.setVisibleRowCount(4);
        selected_color_list.setSize(100,800);

        scroll_pane = new JScrollPane(color_list);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected_color_list.setListData(color_list.getSelectedValuesList().toArray(new String[0]));
            }
        });

        panel.add(scroll_pane);
        panel.add(button);
        panel.add(new JScrollPane(selected_color_list));

        add(panel);
        setTitle("Multiple Selection List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(window_width,window_height));
        setVisible(true);
    }
}
