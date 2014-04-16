// Oval class inherits from Point
package JavaApplication14;
import java.awt.*;

public class Oval extends Point {

   private double height;
   private double width;

   // no-argument constructor; height/width default to 0.0
   public Oval()
   {
      // implicit call to Point constructor occurs here
   } 
   
   // constructor
   public Oval( int x, int y, Color c, double h, double w )
   {
      super( x, y, c );  // call Point constructor
      setHeight( h );
      setWidth( w );
   } 

   // set height
   public void setHeight( double h )
   {
      height = ( h < 0.0 ? 0.0 : h );
   } 

   // set width
   public void setWidth( double w )
   {
      width = ( w < 0.0 ? 0.0 : w );
   } 

   // return height
   public double getHeight()
   {
      return height;
   } 

   // return width
   public double getWidth()
   {
      return width;
   } 

   // override abstract method draw
   public void draw(Graphics g)
   {
      g.setColor(super.getC());
      g.fillOval((int) super.getX(),
         (int) super.getY(),
         (int) getWidth(),
         (int) getHeight());
   }

   // override toString to return String representation of Oval
   public String toString()
   {
      return String.format("Oval at [%d, %d] ", getX(), getY());
   }

} // end class Oval
