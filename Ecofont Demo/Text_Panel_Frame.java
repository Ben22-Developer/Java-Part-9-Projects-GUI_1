import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import java.awt.BorderLayout;

public class Text_Panel_Frame extends JFrame {

    private Text_Panel text_panel;
    public Text_Panel_Frame () {

        setTitle ("Ecofont Style Demo");
        setTextPanel();
        add (text_panel, BorderLayout.CENTER);
    }

    private void setTextPanel () {
        text_panel = new Text_Panel();
    }

    public Text_Panel getText_panel () {
        return text_panel;
    }
}
