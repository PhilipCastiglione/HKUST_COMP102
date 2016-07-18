import comp102x.Canvas;
import comp102x.ColorImage;

import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MultiImageListener implements MouseListener
{
    private final int maxR = 10;
    private final int maxC = 4;
    private ColorImage[][] images = new ColorImage[maxR][maxC];
    private Canvas canvas = new Canvas(650,600);
    public ColorImage backgroundImage = new ColorImage(650, 600);
    
    public MultiImageListener()  { 
        
        // code for setting up the top panel
        // ---------------------------------------
        JPanel panel = new JPanel();
        
        JButton button1 = new JButton("Button 1");
        button1.addMouseListener(this);
        
        JButton button2 = new JButton("Button 2");
        button2.addMouseListener(new ImageListener2());
        
        JButton button3 = new JButton("Button 3");
        button3.addMouseListener(new ImageListener3());
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        canvas.setComponentAtTop(panel);
        // ---------------------------------------
        
        initImage();
        backgroundImage.setMovable(false);
        canvas.add(backgroundImage);
    }
    
    private void initImage() {
        for (int r = 0; r < maxR; r++) {
            images[r][0] = new ColorImage("images/celtb" + r + ".png");
            images[r][1] = new ColorImage("images/celtf" + r + ".png");
            images[r][2] = new ColorImage("images/celtd" + r + ".png");
            images[r][3] = new ColorImage("images/celtg" + r + ".png");
        }
    }

    public void mouseClicked(MouseEvent e) {
        canvas.removeAll();
        canvas.add(backgroundImage);
        for (int i = 0; i < maxC; i++) {
           canvas.add(images[0][i], i*120+50, i*120+50);
        }
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
  
    
    class ImageListener2 implements MouseListener {
        
        public void mouseClicked(MouseEvent e) {
            
            canvas.removeAll();
            canvas.add(backgroundImage);
            Random random = new Random();
            
            canvas.add(images[random.nextInt(10)][0], 50, 50);
            canvas.add(images[random.nextInt(10)][1], 170, 170);
            canvas.add(images[random.nextInt(10)][2], 290, 290);
            canvas.add(images[random.nextInt(10)][3], 410, 410);
        }
        
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
    /*
     * ToDo: Implement ImageListener3 for button3 so that the faces 
     * will be display at in a 2D grid at random depths
     */    
    class ImageListener3 implements MouseListener {
      
        public void mouseClicked(MouseEvent e) {
            
            canvas.removeAll();
            canvas.add(backgroundImage);
            Random random = new Random();
            

            
            
            
            
            
            
        }
        
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
}