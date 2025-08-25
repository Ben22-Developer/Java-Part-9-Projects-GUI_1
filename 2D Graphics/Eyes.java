import java.awt.Color;
import java.awt.Graphics;

abstract class Eyes implements Drawable {

   private final int location_x, location_y, size, pupil_size;
   private Pupil pupil;

   public Eyes (int location_x, int location_y, int size, int pupil_size) {
      this.location_x = location_x;
      this.location_y = location_y;
      this.size = size;
      this.pupil_size = pupil_size;
      setEyePupil();
   }

   public int getSize () {
      return size;
   }

   public int getLocation_x () {
      return location_x;
   }

   public int getLocation_y () {
      return location_y;
   }

   public int getPupil_size() {
      return pupil_size;
   }

   public Pupil getPupil () {
      return pupil;
   }

   public void blink (boolean blink) {
      if (blink) {
         pupil.setBlink (true);
      }
      else {
         pupil.setBlink (false);
      }
   }

   public void pupilMovement (int x_coordinate, int y_coordinate) {
      pupilMovementX (x_coordinate);
      pupilMovementY (y_coordinate);
   }

   private void pupilMovementX (int x_coordinate) {
      pupil.setPupil_location_x (x_coordinate);
   }

   private void pupilMovementY (int y_coordinate) {
      pupil.setPupil_location_y (y_coordinate);
   }

   public void setEyePupil() {

      int eye_x_axis = getLocation_x();
      int eye_y_axis = getLocation_y();
      int pupil_size = getPupil_size();

      pupil = new Pupil (eye_x_axis + 23, eye_y_axis + 23, pupil_size);
   }

   @Override
   public void draw (Graphics g) {
      g.setColor (Color.BLACK);
      g.drawArc (getLocation_x(), getLocation_y(), getSize(), getSize(), 0, 360);
      pupil.draw (g);
   }
}
