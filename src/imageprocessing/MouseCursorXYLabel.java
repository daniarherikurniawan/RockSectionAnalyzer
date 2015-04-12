import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
 
/**
 * @author Alvin Alexander, <a href="http://devdaily.com" title="http://devdaily.com">http://devdaily.com</a>
 * 
 * A Java class to demonstrate how to create a
 * custom Java mouse cursor, in this case, a 
 * mouse cursor that shows the x/y coordinates of the
 * mouse as the mouse is moved over a Java/Swing application.
 *
 */
public class MouseCursorXYLabel extends JFrame 
{
 
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        displayJFrame();
      }
    });
  }
 
  static void displayJFrame()
  {
    // create a jframe as usual
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("Mouse Cursor with Label");
    jFrame.setLayout(new GridBagLayout());
    // set the jframe size and center it
    jFrame.setPreferredSize(new Dimension(400, 300));
    jFrame.pack();
    jFrame.setLocationRelativeTo(null);
     
    JButton But = new JButton("add");
    JButton Buet = new JButton("add5");
    // create an instance of my custom mouse cursor component
    final AlsXYMouseLabelComponent alsXYMouseLabel = new AlsXYMouseLabelComponent();
    jFrame.add(But);
    jFrame.add(Buet);
    // add my component to the DRAG_LAYER of the layered pane (JLayeredPane)
    JLayeredPane layeredPane = But.getRootPane().getLayeredPane();
    layeredPane.add(alsXYMouseLabel, JLayeredPane.DRAG_LAYER);
    alsXYMouseLabel.setBounds(0, 0, But.getWidth(), But.getHeight());
 
    // add a mouse motion listener, and update my custom mouse cursor with the x/y
    // coordinates as the user moves the mouse
    But.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent me)
      {
        alsXYMouseLabel.x = me.getX();
        alsXYMouseLabel.y = me.getY();
        alsXYMouseLabel.repaint();
      }
    });
 
    // make the cursor a crosshair shape
    But.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
     
    // display the jframe
    jFrame.setVisible(true);
  }
   
}
 
/**
 * This is the class that draws the x/y coordinates
 * near the mouse cursor/pointer.
 */
class AlsXYMouseLabelComponent extends JComponent
{
  public int x;
  public int y;
   
  public AlsXYMouseLabelComponent() {
    this.setBackground(Color.blue);
  }
 
  // use the xy coordinates to update the mouse cursor text/label
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    String s = x + ", " + y;
    g.setColor(Color.red);
    g.drawString(s, x, y);
  }
}
