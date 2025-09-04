import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.lang.System.out;

public class FileHandling {

    private DrawPanel draw_panel;

    public void setDraw_panel(DrawPanel draw_panel) {
        this.draw_panel = draw_panel;
    }

    public void saveShapesFunctionHandler () {
        String file_name = getFilePath();
        if (!file_name.isEmpty()) {
            saveShapesToFile(file_name);
        }
    }

    private String getFilePath () {
        JFileChooser file_chooser = new JFileChooser("F:\\Java\\Exercises\\Chapter 12 GUI Part_1\\Drawing_App");
        try {
            int user_input = file_chooser.showDialog(null, "Save To");
            if (user_input == JFileChooser.CANCEL_OPTION) {
                out.println("user_cancelled");
                return "";
            }
        }
        catch  (NullPointerException e) {}
        return file_chooser.getSelectedFile().getAbsolutePath();
    }


    private void saveShapesToFile (String file_name) {

        ArrayList <MyShape> file_objects = new ArrayList<>();
        getObjectsSavedInFile (file_objects, file_name);

        File file = new File (file_name);
        FileOutputStream file_output_stream = null;
        ObjectOutputStream object_output_stream = null;

        try {
            file_output_stream = new FileOutputStream (file);
            object_output_stream = new ObjectOutputStream (file_output_stream);
        }
        catch (IOException e) {
            out.println ("Failed to initialize Output Streams");
        }

        writeDataToFiles (object_output_stream ,file_objects);
        closeOutputStreams (file_output_stream, object_output_stream);
    }

    private void writeDataToFiles ( ObjectOutputStream object_output_stream, ArrayList <MyShape> file_objects) {
        MyShape[] shapes = draw_panel.getShapes();
        reSaveOldDataFiles (file_objects, object_output_stream);
        saveCurrentDataToFile (shapes, object_output_stream);
    }

    private void reSaveOldDataFiles (ArrayList <MyShape> file_objects, ObjectOutputStream object_output_stream) {
        for (MyShape file_object : file_objects) {
            try {
                object_output_stream.writeObject(file_object);
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog (null, "Failed to save double check your file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveCurrentDataToFile (MyShape[] shapes, ObjectOutputStream object_output_stream) {

        int counts = draw_panel.getShape_count();
        for (int i = 0; i < counts; i++) {
            try {
                object_output_stream.writeObject(shapes[i]);
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog (null, "Failed to save double check your file!", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeOutputStreams (FileOutputStream file_output_stream, ObjectOutputStream object_output_stream) {

        if (file_output_stream != null && object_output_stream != null) {
            try {
                file_output_stream.close();
                object_output_stream.close();
            } catch (IOException e) {
                out.println("Failed to close Output Streams");
            }
        }
    }

    private void getObjectsSavedInFile (ArrayList <MyShape> file_objects, String file_name) {

        File file = new File (file_name);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream (file);
            ois = new ObjectInputStream (fis);
        }
        catch (IOException e) {
            out.println ("Failed to initialize streams reading objects in file");
        }

        readingFileObjects (ois, file_objects);
        closeInputStreams (fis, ois);
    }

    private void readingFileObjects (ObjectInputStream ois, ArrayList <MyShape> file_objects) {
        try {
            while (true) {
                MyShape shape = (MyShape) ois.readObject();
                if (shape == null) {
                    break;
                }
                file_objects.add (shape);
            }
        }
        catch (EOFException e) {
            out.println ("Reading objects already in file done.");
        }
        catch (IOException | ClassNotFoundException e) {
            out.println ("Unexpected IOException or ClassNotFoundException. In readingFileObjects");
        }
        catch (NullPointerException e) {}
    }

    public void loadSavedShapesManipulator () {

        String file_name =  getLoadingFileName();
        loadSavedShapes (file_name);
    }

    private String getLoadingFileName () {
        JFileChooser file_chooser = new JFileChooser ("F:\\Java\\Exercises\\Chapter 12 GUI Part_1\\Drawing_App");
        int user_option = file_chooser.showDialog (null, "Display");

        if (user_option == JFileChooser.CANCEL_OPTION) {
            return "";
        }
        return file_chooser.getSelectedFile().getName();
    }

    private void loadSavedShapes (String file_name) {

        File file = new File (file_name);
        FileInputStream file_input_stream = null;
        ObjectInputStream object_input_stream = null;

        try {
            file_input_stream = new FileInputStream (file);
            object_input_stream = new ObjectInputStream (file_input_stream);
            drawLoadedShapes (object_input_stream);
            closeInputStreams (file_input_stream, object_input_stream);
        }
        catch (IOException e) {
            out.println ("Failed to initialize Input Streams");
        }
        catch (NullPointerException e) {}
    }

    private void drawLoadedShapes (ObjectInputStream object_input_stream) {

        draw_panel.clearDrawing();
        try {
            while (true) {

                MyShape shape = (MyShape) object_input_stream.readObject();
                if (shape == null) {
                    break;
                }
                int index = draw_panel.getShape_count();
                draw_panel.recordNewShapeInArray (index, shape);
                draw_panel.incrementShapeCount();
                draw_panel.repaint();
            }
        }
        catch (EOFException e) {
            out.println("End of file records!");
        }
        catch (IOException | ClassNotFoundException e) {
            out.println("Failed to load a shape! in drawLoadedShapes 'DrawFrame.class'");
        }
        catch (NullPointerException e) {
            JOptionPane.showMessageDialog (null, "Your file is empty!", "Informational Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void closeInputStreams (FileInputStream file_input_stream, ObjectInputStream object_input_stream) {

        if (file_input_stream != null && object_input_stream != null ) {
            try {
                file_input_stream.close();
                object_input_stream.close();
            } catch (IOException e) {
                out.println("Failed to close Input Streams");
            }
        }
    }

    public void emptyFileController () {

        String file_path = getFilePath2 ();

        if (!file_path.isEmpty()) {
            emptyingFile (file_path);
        }
    }

    private void emptyingFile (String file_path) {

        File file = new File (file_path);
        PrintStream ps = null;

        try {
            ps = new PrintStream (file);
        }
        catch (FileNotFoundException e) {
            out.println("Failed to get the file to empty");
        }
        ps.print("");
        ps.close();
        draw_panel.clearDrawing();
        draw_panel.repaint();
    }

    private String getFilePath2 () {

        JFileChooser file_chooser = new JFileChooser ("F:\\Java\\Exercises\\Chapter 12 GUI Part_1\\Drawing_App");

        try {
            int user_choice = file_chooser.showDialog(null, "Ok");
            if (user_choice == JFileChooser.CANCEL_OPTION) {
                return "";
            }
        }
        catch (NullPointerException e) {
            return "";
        }

        return file_chooser.getSelectedFile().getAbsolutePath();
    }
}
