// Circle class inherits from Point
package JavaApplication14;
import java.awt.*;

public class Circle extends Point {
   private double radius;  // Circle's radius

   // no-argument constructor; radius defaults to 0.0
   public Circle()
   {
      // implicit call to Point constructor occurs here
   } 
   
   // constructor
   public Circle( int x, int y, Color c, double radiusValue )
   {
      super( x, y, c );  // call Point constructor
      setRadius( radiusValue );
   } 

   // set radius
   public void setRadius( double radiusValue )
   {
      radius = ( radiusValue < 0.0 ? 0.0 : radiusValue );
   } 

   // return radius
   public double getRadius()
   {
      return radius;
   } 

   // calculate and return diameter
   public double getDiameter()
   {
      return 2 * getRadius();
   } 


   // override abstract method draw
   public void draw(Graphics g)
   {
      g.setColor(super.getC());
      g.fillOval((int) ( super.getX() - getRadius()),
         (int) (super.getY() - getRadius()),
         (int) getDiameter(),
         (int) getDiameter());
   }

   // override toString to return String representation of Circle
   public String toString()
   { 
      return String.format("Circle with radius = %.2f ", getRadius());
   } 

} // end class Circle
