import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TestDraw
{
    public static void main(String[] args) throws Exception
    {

        setUIManager();
        DrawFrame draw_frame = new DrawFrame();
        draw_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw_frame.setVisible(true);
    }

    private static int getNumberOfShapesToDraw () throws Exception
    {
        String shapes_str = JOptionPane.showInputDialog(null,"Enter the number of shapes to draw","Number Of Shapes To Draw",JOptionPane.QUESTION_MESSAGE);
        int shapes_int = 0;

        try
        {
            shapes_int = Integer.parseInt(shapes_str);
        }
        catch (Exception e)
        {
            shapes_int = 0;
            JOptionPane.showMessageDialog(null, "Invalid input\nApplication Down!","Error Message",JOptionPane.ERROR_MESSAGE);
            throw e;
        }

        return shapes_int;
    }

    private static void setUIManager ()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e)
        {
            JOptionPane.showInputDialog("UIManager failed to load!");
        }
    }
}
