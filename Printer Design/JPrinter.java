import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class JPrinter extends JFrame {

    private JPanel container_1, container_2;

    public JPrinter () {

        setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
        setTitle ("Printer");

        setContainer_1();
        setContainer_2();

        add (container_1);
        add (container_2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,220));
        setVisible(true);
    }

    private void setContainer_1 () {

        container_1 = new JPanel();
        container_1.setLayout(new BoxLayout(container_1,BoxLayout.PAGE_AXIS));

        JPanel title_panel, text_area1_panel,text_area2_panel,text_area3_panel, j_check_box_panel,j_radio_btn_panel,print_panel,center_sub_container;
        JTextArea text_area_1,text_area_2,text_area_3;
        JCheckBox image_check_box,text_check_box,code_check_box, print_file_check_box;
        JRadioButton select_radio_btn,all_radio_btn,applet_radio_btn;
        ButtonGroup j_radio_btns;
        JLabel title, print_quality;
        JComboBox print_quality_box;
        String[] print_quality_str =
        {
          "High", "Medium", "Low"
        };

        title = new JLabel("Printer : My printer");
        print_quality = new JLabel("Print Quality:  ");

        text_area_1 = new JTextArea(3,4);
        text_area_2 = new JTextArea(3,2);
        text_area_3 = new JTextArea(3,4);

        image_check_box = new JCheckBox("Image");
        text_check_box = new JCheckBox("Text");
        code_check_box = new JCheckBox("Code");
        print_file_check_box = new JCheckBox("Print to File");

        select_radio_btn = new JRadioButton("Selection");
        all_radio_btn = new JRadioButton("All");
        applet_radio_btn = new JRadioButton("Applet");

        j_radio_btns = new ButtonGroup();
        j_radio_btns.add(select_radio_btn);
        j_radio_btns.add(all_radio_btn);
        j_radio_btns.add(applet_radio_btn);

        all_radio_btn.setSelected(true);

        print_quality_box = new JComboBox(print_quality_str);

        title_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        text_area1_panel = new JPanel();
        text_area2_panel = new JPanel();
        text_area3_panel = new JPanel();
        j_check_box_panel = new JPanel();
        j_check_box_panel.setLayout(new BoxLayout(j_check_box_panel,BoxLayout.PAGE_AXIS));
        j_radio_btn_panel = new JPanel();
        j_radio_btn_panel.setLayout(new BoxLayout(j_radio_btn_panel,BoxLayout.PAGE_AXIS));
        print_panel = new JPanel();

        title_panel.add(title);
        text_area1_panel.add(text_area_1);
        text_area2_panel.add(text_area_2);
        text_area3_panel.add(text_area_3);
        j_check_box_panel.add(image_check_box);
        j_check_box_panel.add(text_check_box);
        j_check_box_panel.add(code_check_box);
        j_radio_btn_panel.add(select_radio_btn);
        j_radio_btn_panel.add(all_radio_btn);
        j_radio_btn_panel.add(applet_radio_btn);
        print_panel.add (print_quality);
        print_panel.add (print_quality_box);
        print_panel.add (print_file_check_box);

        center_sub_container = new JPanel();

        center_sub_container.add(text_area1_panel);
        center_sub_container.add(j_check_box_panel);
        center_sub_container.add(text_area2_panel);
        center_sub_container.add(j_radio_btn_panel);
        center_sub_container.add(text_area3_panel);

        container_1.add (title_panel);
        container_1.add (center_sub_container);
        container_1.add (print_panel);
    }

    private void setContainer_2 () {

        container_2 = new JPanel(new GridLayout(4,1,0,5));
        JButton ok_btn,cancel_btn,setup_btn,help_btn;
        int width, height;

        ok_btn = new JButton("Ok");
        cancel_btn = new JButton("Cancel");
        setup_btn = new JButton("Setup");
        help_btn = new JButton("Help");

        width = 70;
        height = 30;

        ok_btn.setPreferredSize(new Dimension(width,height));
        cancel_btn.setPreferredSize(new Dimension(width,height));
        setup_btn.setPreferredSize(new Dimension(width,height));
        help_btn.setPreferredSize(new Dimension(width,height));

        container_2.add (ok_btn);
        container_2.add (cancel_btn);
        container_2.add (setup_btn);
        container_2.add (help_btn);
    }
}
