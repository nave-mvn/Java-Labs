package JavaApplication14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class JavaPaint extends JFrame
{
    private Vector<Shape> shapeVector = new Vector<Shape>();
    private Color currentFGColor = Color.WHITE;
    private Color currentBGColor = new Color(103,0,1);
    private DrawingPanel drawingPanel;
    private String currentShape = "Circle";

    public JavaPaint()
    {
        super("Drawing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocation(300,300);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(currentBGColor);
        drawingPanel.addMouseListener(new ShapeListener());

        JPanel buttonPanel = new JPanel();
    
        ButtonListener bl = new ButtonListener();
        RadioListener rl = new RadioListener();
        
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        JRadioButton r1 = new JRadioButton("Circle", true);
        r1.addActionListener(rl);
        JRadioButton r2 = new JRadioButton("Oval");
        r2.addActionListener(rl);
        JRadioButton r3 = new JRadioButton("Rectangle");
        r3.addActionListener(rl);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(r1);
        buttons.add(r2);
        buttons.add(r3);
        radioPanel.add(r1);
        radioPanel.add(r2);
        radioPanel.add(r3);
        radioPanel.setBorder(new TitledBorder(new EtchedBorder(), "Shape")); 
        buttonPanel.add(radioPanel);
        
        
        JButton fgColorButton = new JButton("Foreground");
        buttonPanel.add(fgColorButton);
        fgColorButton.addActionListener(bl);

        JButton bgColorButton = new JButton("Background");
        buttonPanel.add(bgColorButton);
        bgColorButton.addActionListener(bl);

        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        clearButton.addActionListener(bl);
    
        add(drawingPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    private class DrawingPanel extends JPanel 
    {
    
      protected void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
         System.out.println("Drawing panel paint....");
         for (Shape s: shapeVector) 
         {
            s.draw(g);
         }
       }
    }


    private class ShapeListener extends MouseAdapter 
    {

      private int begX, begY, endX, endY;

      public void mousePressed(MouseEvent event) 
      {
         // save beginning x and y

      }
    
      public void mouseReleased(MouseEvent event) 
      {
         // save ending x and y

         Graphics g = getGraphics();
         Shape s;

         // remove the following line, it exists so the initial program will compile
         s = new Circle();
         // create correct shape (based on user selection)

         shapeVector.addElement(s);
         System.out.println(s);
         drawingPanel.repaint();
      }
    }
 
    private class RadioListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            currentShape = event.getActionCommand();
            System.out.println(currentShape + " selected");
        }
    }
    
    private class ButtonListener implements ActionListener 
    {
      public void actionPerformed(ActionEvent event) 
      {

         if (event.getActionCommand().equals("Clear")) 
         {


         }
         else if (event.getActionCommand().equals("Foreground")) 
         {
            Color holdColor = currentFGColor;
            currentFGColor = JColorChooser.showDialog(JavaPaint.this,
                                "Select Foreground Color",
                                currentFGColor);
            if (currentFGColor == null) 
              currentFGColor = holdColor;
         } 
         else if (event.getActionCommand().equals("Background")) 
         {





         }
      }
    }

    public static void main (String[] args) 
    {
       JavaPaint window = new JavaPaint();
       window.setVisible(true);
    }
}