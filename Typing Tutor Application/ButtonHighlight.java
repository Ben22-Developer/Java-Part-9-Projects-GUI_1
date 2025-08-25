import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import static java.lang.System.out;

public class ButtonHighlight extends KeyAdapter {

    private Color btn_transparent_color;
    private HashMap <Integer, JButton> hash_table;
    private int[] hash_keys =
    {
                                 192,49,50,51,52,53,54,55,56,57,48,45,61,8,
                                 9,81,87,69,82,84,89,85,73,79,80,91,93,92,
                                20,65,83,68,70,71,72,74,75,76,59,222,10,
                                16,90,88,67,86,66,78,77,44,46,47,38,
                                32,37,40,39
    };

    public void setBtn_transparent_color (Color color) {
        btn_transparent_color = color;
    }

    public void setButtonsHashMap (JButton[] buttons) {
        hash_table = new HashMap<>();
        for (int i = 0; i < buttons.length; i++) {
            hash_table.put (hash_keys[i], buttons[i]);
        }
    }

    @Override
    public void keyPressed (KeyEvent e) {

        if (hash_table.containsKey(e.getKeyCode())) {
            JButton pressed_button = getPressed_Or_Released_Button(e.getKeyCode());
            pressed_button.setBackground(new Color(0, 0, 0));
            pressed_button.setForeground(new Color(255, 255, 255, 200));
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {
        if (hash_table.containsKey(e.getKeyCode())) {
            JButton released_button = getPressed_Or_Released_Button(e.getKeyCode());
            released_button.setBackground(btn_transparent_color);
            released_button.setForeground(new Color(0, 0, 0));
        }
    }

    private JButton getPressed_Or_Released_Button(int hash_key) {
        return hash_table.get (hash_key);
    }
}
