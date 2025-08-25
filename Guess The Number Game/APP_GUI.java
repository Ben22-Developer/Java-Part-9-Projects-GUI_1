import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class APP_GUI extends JFrame {

    private Container container;
    private JPanel game_playing_panel_title,game_playing_panel_body, game_playing_south_panel, start_game_btn_room;
    private JButton submit_button, start_game_btn;
    private JLabel user_guider_label, user_ask_label, re_start_game_label;
    private JTextField text_field_user_input;

    private final int window_width = 1285;
    private final int window_height = 678;

    private final Color bg_normal_container_color = Color.BLACK;
    private final Color error_input_bg_color = new Color(223, 33, 33);
    private final Color too_high_input_bg_color = new Color(156, 27, 27);
    private final Color too_low_input_bg_color = new Color(0, 81, 136);
    private final Color win_input_bg_color = new Color(11, 99, 2);
    private final Color fg_light_text_color = new Color(255, 255, 255);
    private final Color fg_dark_text_color = new Color(55, 31, 31);

    public APP_GUI () {

        setUIManager ();
        setTitle("Guess The Number Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(window_width, window_height));
        container = getContentPane();

        app_starting();
        add (game_playing_panel_title, BorderLayout.NORTH);
        add (game_playing_panel_body, BorderLayout.CENTER);
        add (game_playing_south_panel, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);
    }

    private void app_starting () {
        setExternalWindowState ();
        setInternalWindowState ();
        addEventListenersToButtons ();
    }

    private void addEventListenersToButtons () {

        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                gamePlaying(text_field_user_input.getText());
                text_field_user_input.setText("");
            }
        });

        text_field_user_input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    gamePlaying(text_field_user_input.getText());
                    text_field_user_input.setText("");
                }
            }
        });

        start_game_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Game_Logic.GAME_PLAYING) {
                    gameStart();
                }
                else {
                    gameEnd();
                }
            }
        });
    }

    private void gamePlaying (String user_input_str) {
        Game_Logic.getUserInput(user_input_str);
        giveUserFeedBack();
    }

    private void giveUserFeedBack () {

        switch (Game_Logic.Game_Condition) {
            case Game_Condition_Enum.WIN -> {
                user_win_feedBack();
            }
            case Game_Condition_Enum.TOO_LOW -> {
                user_low_feedBack();
            }
            case Game_Condition_Enum.TOO_HIGH -> {
                user_high_feedBack();
            }
            case Game_Condition_Enum.ERROR_INPUT -> {
                user_error_feedBack ();
            }
        }

        UIComponent.componentTextUpdate(text_field_user_input,"");
    }

    private void user_win_feedBack () {
        UIComponent.updateContainerBgColor(container,win_input_bg_color);
        UIComponent.componentTextUpdate(user_guider_label,"It's a win you got my number "+Game_Logic.USER_GUESS + "! You made it in "+Game_Logic.GUESS_TRIALS+" Trials");
        disableUIComponents();
    }

    private void user_low_feedBack () {
        UIComponent.updateContainerBgColor(container, too_low_input_bg_color);
        UIComponent.componentTextUpdate(user_guider_label,"Your Guess is low, you've guessed: "+Game_Logic.USER_GUESS);
    }

    private void user_high_feedBack () {
        UIComponent.updateContainerBgColor(container,too_high_input_bg_color);
        UIComponent.componentTextUpdate(user_guider_label,"Your Guess is high, you've guessed: "+Game_Logic.USER_GUESS);
    }

    private void user_error_feedBack () {
        UIComponent.updateContainerBgColor(container,error_input_bg_color);
        UIComponent.componentTextUpdate(user_guider_label,"Please enter a number!");
    }

    private void disableUIComponents () {
        UIComponent.componentTextUpdate(start_game_btn, "Start Game");
        UIComponent.componentEnableState(submit_button, false);
        UIComponent.componentEnableState(text_field_user_input,false);
        UIComponent.componentVisibilityState(re_start_game_label, true);
        Game_Logic.GAME_PLAYING = false;
    }

    private void gameStart () {
        UIComponent.updateContainerBgColor(container, bg_normal_container_color);
        UIComponent.componentVisibilityState(re_start_game_label, false);
        UIComponent.componentTextUpdate(start_game_btn, "End Game");
        UIComponent.componentTextUpdate(user_guider_label,"Enter your first guess");
        UIComponent.componentEnableState(submit_button, true);
        UIComponent.componentEnableState(text_field_user_input,true);
        Game_Logic.GAME_PLAYING = true;
        Game_Logic.GUESS_TRIALS = 0;
        Game_Logic.setGuessedNumber();
    }

    private void gameEnd () {
        UIComponent.updateContainerBgColor(container,bg_normal_container_color);
        UIComponent.componentTextUpdate(user_guider_label,"Enter your first guess");
        disableUIComponents ();
    }

    private void setInternalWindowState () {
        createAllLabels();
        createAllButtons();
        createJTextFields();
        createAllPanels();
        addJComponentsToPanels();
    }

    private void addJComponentsToPanels () {
        UIComponent.addJComponentsToPanels(game_playing_panel_title, new JComponent[] {user_ask_label,user_guider_label}, false, BorderFactory.createEmptyBorder(35,0,0,0));
        UIComponent.addJComponentsToPanels(game_playing_panel_body, new JComponent[]{text_field_user_input, submit_button}, false);
        UIComponent.addJComponentsToPanels(start_game_btn_room,new JComponent[]{start_game_btn}, false);
        UIComponent.addJComponentsToPanels(game_playing_south_panel, new JComponent[]{re_start_game_label,start_game_btn_room}, false, BorderFactory.createEmptyBorder(0,0,30,0));
    }

    private void createAllPanels () {
        game_playing_panel_title = new JPanel(new GridLayout(2,1,0,150));
        game_playing_panel_body = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        start_game_btn_room = new JPanel();
        game_playing_south_panel = new JPanel(new GridLayout(2,1,0,50));
    }

    private void createJTextFields () {
        text_field_user_input = new JTextField();
        UIComponent.createTextField(text_field_user_input,250,40, Font.PLAIN,20,0, false);
    }

    private void createAllButtons () {
        submit_button = new JButton();
        start_game_btn = new JButton();
        UIComponent.createButton(submit_button, "Submit",new Color(251, 73, 58),bg_normal_container_color,100,50, false);
        UIComponent.createButton(start_game_btn, "Start Game",new Color(251, 73, 58),bg_normal_container_color, 200,70,true);
    }

    private void createAllLabels () {
        user_guider_label = new JLabel();
        user_ask_label = new JLabel();
        re_start_game_label = new JLabel();
        UIComponent.createLabel(user_ask_label, "I have a number between 1 and 1000. Can you guess my Number?",fg_light_text_color);
        UIComponent.createLabel(user_guider_label, "Enter your first guess", fg_light_text_color);
        UIComponent.createLabel(re_start_game_label, "Click the button below to start the game", fg_light_text_color);
    }

    private void setExternalWindowState () {
        ImageIcon wall_paper_icon = new ImageIcon("download.jpg");
        container.setBackground (bg_normal_container_color);
        setIconImage(wall_paper_icon.getImage());
    }

    private void setUIManager () {
        try  {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"UI Manager failed to load","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }
}
