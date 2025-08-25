import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.out;

public class GridLayoutDemo extends JPanel implements ActionListener {

    private final JButton[] j_buttons = {
            new JButton("One"),new JButton("Two"),new JButton("Three"),
            new JButton("Four"),new JButton("Five"),new JButton("Six")
    };

    private final GridLayout grid_layout_1, grid_layout_2;
    private boolean grid_layout_3cls = true;

    public GridLayoutDemo () {

        grid_layout_1 = new GridLayout(2,3,5,5);
        grid_layout_2 = new GridLayout(3,2,5,5);

        addButtonsToJFrame();
        setLayout(grid_layout_1);

        this.setOpaque(false);
        j_buttons[0].addActionListener(this);
    }


    private void addButtonsToJFrame () {
        for (JButton j_button : j_buttons) {
            add(j_button);
        }
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        out.printf("in");

        if (grid_layout_3cls) {
            grid_layout_2.layoutContainer(this);
        }
        else {
            grid_layout_1.layoutContainer(this);
        }

        grid_layout_3cls = !grid_layout_3cls;
    }
}
