import comp102x.Canvas;
import comp102x.ColorImage;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TreeDemo implements MouseListener {
    private ColorImage background;
    private ColorImage leafImage;
    private Canvas canvas;
    
    public TreeDemo() {       
        canvas = new Canvas();
        background = new ColorImage("tree.jpg");
        background.setMovable(false);
    }
    
    public void demo() {   
        canvas.add(background);
        canvas.addMouseListener(this);
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
}