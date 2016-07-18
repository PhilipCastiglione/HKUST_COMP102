import comp102x.Canvas;
import comp102x.ColorImage;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TreeDemo2 implements MouseListener, KeyListener {
    private ColorImage background;
    private ColorImage leafImage;
    private Canvas canvas;
    
    public TreeDemo2() {       
        canvas = new Canvas();
        background = new ColorImage("tree.jpg");
        background.setMovable(false);
    }
    
    public void demo() {   
        canvas.add(background);
        canvas.addMouseListener(this);
        canvas.getJPanel().addKeyListener(this);
        canvas.getJPanel().requestFocusInWindow();
    }
    
    public void mouseClicked(MouseEvent e) {
       int x = e.getX();
       int y = e.getY();
            
       Random random = new Random();
       int rotation = random.nextInt(360); // random rotation
       double scale = random.nextDouble(); // random scaling in [0.0, 1.0)
            
       leafImage = new ColorImage("leaf.png");
       leafImage.setScale(scale);
       leafImage.setRotation(rotation);
       canvas.add(leafImage, x - (int)(leafImage.getWidth() * scale / 2), y - (int)(leafImage.getHeight() * scale / 2));    
    }
    
    public void mousePressed(MouseEvent e) { }
    
    public void mouseReleased(MouseEvent e) { }
    
    public void mouseEntered(MouseEvent e) { }
    
    public void mouseExited(MouseEvent e) { }
    
    public void keyPressed(KeyEvent e) {    
        
        if (leafImage == null) return;
        
        int keyCode = e.getKeyCode();
        
        switch( keyCode ) { 
            
            case KeyEvent.VK_UP:
            leafImage.setScale(leafImage.getScale() + 0.01);
            break;
            
            case KeyEvent.VK_DOWN:
            leafImage.setScale(leafImage.getScale() - 0.01);
            break;
            
            case KeyEvent.VK_RIGHT:
            leafImage.setRotation(leafImage.getRotation() + 5);
            break;
            
            case KeyEvent.VK_LEFT:
            leafImage.setRotation(leafImage.getRotation() - 5);
            break;
        }
    }
    
    public void keyReleased(KeyEvent e) { }
    
    public void keyTyped(KeyEvent e) {
        // Can be used when a unicode character is entered
        // not suitable for arrow keys
        // System.out.println("keyTyped" + e.getKeyChar());
    }
}