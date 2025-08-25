import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.SecureRandom;

public class window extends JFrame {

    private int test = 0;

    private Icon[] icons = {
            new ImageIcon("user_black.png"),
            new ImageIcon("user_blue.jpg"),
            new ImageIcon("user_suite.jpg")
    };

    private String[] selection_list = {"User Black Icon","User Blue Icon","User Suite Icon"};
    private JComboBox combo_box = new JComboBox(selection_list);

    private JLabel label = new JLabel() ;
    private JPanel panel = new JPanel();
    private ImageIcon logo = (ImageIcon) icons[new SecureRandom().nextInt(icons.length)];

    public window() {

        label.setIcon(icons[0]);

        combo_box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = combo_box.getSelectedIndex();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setIcon(icons[index]);
                    test ++;
                    System.out.printf("%d%n",test);
                }
            }
        });

        panel.add(label);
        panel.add(combo_box);

        add(panel);
        setTitle("Icon Display");
        setIconImage(logo.getImage());
        setSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
