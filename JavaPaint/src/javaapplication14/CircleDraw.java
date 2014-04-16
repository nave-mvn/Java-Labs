package JavaApplication14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/** Draw circles centered where the user clicks.
 *  Uses named inner classes.
 */

public class CircleDraw extends JFrame 
{
    // panel that contains the circles to be drawn
    private CirclePanel cPanel = new CirclePanel();
    
    // radius of circle to draw 
    private int radius = 25;
    
    private ArrayList<java.awt.Point> circles = new ArrayList<java.awt.Point>();
    
    public CircleDraw () 
    {
        // Set size, location, color and close behavior
        setSize(450,350);
        setLocation(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(cPanel);
        
    }

    /**
     * Inner class that inherits from MouseAdapter
     * It gets an empty definition of all the MouseListener
     * methods so it only needs to override the one(s) it
     * cares about
     */
    private class CircleListener extends MouseAdapter 
    {
          
        public void mousePressed(MouseEvent event) 
        {
            /*
            // Get the graphics context to draw on
            Graphics g = cPanel.getGraphics();

            // Set the drawing color to blue and draw circle
            // Since the x,y passed to the fillOval is upper-left corner
            // need to offset to make centered at click
            g.setColor(Color.blue);
            g.fillOval(event.getX()-radius,
                       event.getY()-radius,
                       2*radius,
                       2*radius);
            */
            circles.add(event.getPoint());
            repaint();
        }
    }
    
    private class CirclePanel extends JPanel
    {
        public CirclePanel()
        {
            // register new instance of CircleListener for mouse events
            addMouseListener(new CircleListener());
        }
        
        protected void paintComponent(Graphics g)
        {
            for (java.awt.Point circle: circles)
            {
                g.setColor(Color.blue);
                g.fillOval((int)circle.getX()-radius,
                       (int)circle.getY()-radius,
                       2*radius,
                       2*radius);
            }
        }
    }
    
    public static void main (String[] args) {
        CircleDraw cd = new CircleDraw();
        cd.setVisible(true);
    }
}

