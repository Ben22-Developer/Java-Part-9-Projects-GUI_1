import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game_GUI extends JFrame {

    private JLabel title_label, result_label, die_1_label, die_2_label, dice_sum_label, point_label;
    private JTextField die_1_text_field, die_2_text_field, dice_sum_text_field, point_text_field;
    private JButton end_or_start_game_button, roll_button, help_button;
    private Container container;

    public Game_GUI () {

        super ("Craps Game");

        container = getContentPane();
        container.setBackground(new Color(0, 44, 58));
        setLayout (new BoxLayout (container,BoxLayout.PAGE_AXIS));
        setUIManager();

        try {
            setIconImage (new ImageIcon("images.jpg").getImage());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Image failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        createJLabels();
        createJTextFields();
        createJButtons();
        createJPanels();
    }

    private void createJLabels () {

        title_label = new JLabel();
        result_label = new JLabel();
        die_1_label = new JLabel();
        die_2_label = new JLabel();
        dice_sum_label = new JLabel();
        point_label = new JLabel();

        UIComponent.createJLabel(title_label,"Craps Game", "Cascadia Code", 3,30, Color.WHITE);
        UIComponent.createJLabel(result_label,"Click 'Start Game Button' to start the Game", "Bahnschrift", 2,24, Color.WHITE);
        UIComponent.createJLabel(die_1_label,"Die One", "Arial",1,20, Color.WHITE);
        UIComponent.createJLabel(die_2_label,"Die Two", "Arial",1,20, Color.WHITE);
        UIComponent.createJLabel(dice_sum_label,"Dice Sum", "Arial",1,20, Color.WHITE);
        UIComponent.createJLabel(point_label,"The Point", "Arial",1,20, Color.WHITE);
    }

    private void createJTextFields () {

        final int width, height;

        width = 25;
        height = 35;

        die_1_text_field = new JTextField();
        die_2_text_field = new JTextField();
        point_text_field = new JTextField();
        dice_sum_text_field = new JTextField();

        for (JTextField field : new JTextField[]{ die_1_text_field, die_2_text_field, point_text_field, dice_sum_text_field }) {
            UIComponent.createJTextField(field, width,height);
        }
    }

    private void createJButtons () {

        roll_button = new JButton();
        end_or_start_game_button = new JButton();
        help_button = new JButton();

        UIComponent.createJButton(roll_button, "Roll",new Color(255, 217, 159), Color.black, 100, 50, false);
        UIComponent.createJButton(end_or_start_game_button, "Start The Game",new Color(255, 217, 159), Color.black, 300, 60, true);
        UIComponent.createJButton(help_button, "Help",new Color(255, 217, 159), Color.black, 100, 50, true);
    }

    private void createJPanels () {

        JPanel title_panel, result_panel, outer_dice_panel,inner_dice_panel, buttons_panel, playing_btn_panel, help_button_panel,start_end_btn_panel;

        title_panel = new JPanel();
        result_panel = new JPanel();
        outer_dice_panel = new JPanel ();
        inner_dice_panel = new JPanel();
        playing_btn_panel = new JPanel();
        start_end_btn_panel = new JPanel();
        help_button_panel = new JPanel();
        buttons_panel = new JPanel ();

        UIComponent.createJPanel (title_panel, new JComponent[]{title_label}, new FlowLayout(FlowLayout.CENTER, 0,30), false,Main.WINDOW_WIDTH,100);
        UIComponent.createJPanel (result_panel, new JComponent[]{result_label}, new FlowLayout(FlowLayout.CENTER, 0,20), false,Main.WINDOW_WIDTH,100);
        UIComponent.createJPanel (inner_dice_panel, new JComponent[]{die_1_label, die_2_label, dice_sum_label, point_label, die_1_text_field, die_2_text_field, dice_sum_text_field, point_text_field}, new GridLayout(2,4,200,25), false,0, 0);
        UIComponent.createJPanel (outer_dice_panel, new JComponent[]{inner_dice_panel}, new FlowLayout(FlowLayout.CENTER, 0, 30), false,Main.WINDOW_WIDTH, 175);

        UIComponent.createJPanel (playing_btn_panel, new JComponent[]{roll_button}, new FlowLayout(FlowLayout.CENTER, 0,10), false, Main.WINDOW_WIDTH, 50);
        UIComponent.createJPanel (start_end_btn_panel, new JComponent[]{end_or_start_game_button}, new FlowLayout(), false, Main.WINDOW_WIDTH, 60);
        UIComponent.createJPanel (help_button_panel, new JComponent[]{help_button}, new FlowLayout(FlowLayout.CENTER, 0,0), false, Main.WINDOW_WIDTH, 60);
        UIComponent.createJPanel (buttons_panel, new JComponent[]{ playing_btn_panel, start_end_btn_panel, help_button_panel}, new GridLayout(3,1,0,10), false, 400,270);

        add (title_panel);
        add (result_panel);
        add (outer_dice_panel);
        add (buttons_panel);
    }

    public void eventRegistration () {

        end_or_start_game_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                GameUI_Logic_Connector.gameEndOrStart(roll_button, end_or_start_game_button, result_label,new JTextField[]{die_1_text_field, die_2_text_field, dice_sum_text_field, point_text_field});
            }
        });

        roll_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                GameUI_Logic_Connector.userRolled(roll_button, end_or_start_game_button, result_label,new JTextField[]{die_1_text_field, die_2_text_field, dice_sum_text_field, point_text_field});
            }
        });

        help_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHowToPlayGame();
            }
        });
    }

    private void setUIManager () {

//        for (UIManager.LookAndFeelInfo l : UIManager.getInstalledLookAndFeels()) {
//            System.out.println(l);
//        }

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Exception e) {
            System.out.println("UI Manager failed to load");
        }
    }

    private void getHowToPlayGame () {
        JOptionPane.showMessageDialog(null,"Welcome to Craps Game,Then how to play it ? 🤔🤔🤔\n\n1st. On your first Roll if your Dice Sum is either 2,3 or 12 then u lose the game\n\n2nd. On your first Roll when you hit the Dice Sum of 7 or 11 then it's a win\n\n3rd. On your first Roll when you hit the other sort of Dice Sum (i.e not mentioned above) then you will \n need to hit that Dice Sum again (it's your point) to win the game,\n but if you hit the Dice Sum of 7 then it's a lose\n\nHappy Game, Remember it's a Game of Chance!","Game Guide",JOptionPane.INFORMATION_MESSAGE);
    }
}
