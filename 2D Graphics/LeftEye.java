import java.awt.Color;
import java.awt.Graphics;

public class LeftEye extends Eyes {

    private Pupil pupil;

    LeftEye(int location_x, int location_y, int size, int pupil_size) {

        super (location_x, location_y, size, pupil_size);
        setPupil ();
    }

    public void setPupil () {
        pupil = super.getPupil();
        pupil.setEye (this);
    }
}
