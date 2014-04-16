// Point class implements the interface Shape
package JavaApplication14;
import java.awt.*;

public class Point implements Shape 
{
    private int x;  // x part of coordinate pair
    private int y;  // y part of coordinate pair
    private Color c; // color of Point for drawing
    
    // no-argument constructor; x and y default to 0
    public Point()
    {
      // implicit call to Object constructor occurs here
    } 
    
    // constructor
    public Point( int xValue, int yValue, Color cValue )
    {
      // implicit call to Object constructor occurs here
      x = xValue;  // no need for validation ?
      y = yValue;
      c = cValue;
    } 
    
    // set x in coordinate pair
    public void setX( int xValue )
    {
      x = xValue;  // no need for validation?
    } 
    
    // return x from coordinate pair
    public int getX()
    {
      return x;
    } 
    
    // set y in coordinate pair
    public void setY( int yValue )
    {
      y = yValue;
    } 
    
    // return y from coordinate pair
    public int getY()
    {
      return y;
    } 
    
    // set color
    public void setC( Color cValue )
    {
      c = cValue;
    } 
    
    // return color
    public Color getC()
    {
      return c;
    } 
    
    // draw 2x2 circle for point
    public void draw (Graphics g)
    {
      g.setColor(c);
      g.fillOval(x-1, y-1, 2, 2);
    }

    
    // override toString to return String representation of Point
    public String toString()
    {
      return "[" + getX() + ", " + getY() + "](" + c + ")" ;
    } 
    
} // end class Point
