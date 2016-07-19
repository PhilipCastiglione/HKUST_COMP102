import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

import comp102x.Canvas;
import comp102x.ColorImage;
import comp102x.IO;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JButton;

public class CarQueue implements MouseListener
{
    private ArrayDeque<ColorImage> carQueue = new ArrayDeque<ColorImage>();
    private Canvas canvas = new Canvas(1000, 600);
    private int ncar = 7;
    private ColorImage[] images = new ColorImage[ncar];
    private ColorImage flag = new ColorImage("images/flag.png");
    private Random random = new Random();
    
    // a single thread for moving the car images after an event has occured
    public static final ExecutorService threadPool = Executors.newSingleThreadExecutor();
    
    public CarQueue()  {
        
        // load the car images into the images array
        for (int i = 0; i < ncar; i++) {
            images[i] = new ColorImage("images/c" + i + ".png");
        }
        
        // create the control panel at the top
        JPanel panel = new JPanel();
        
        JButton button1 = new JButton("Add");
        button1.addMouseListener(this);
        
        JButton button2 = new JButton("Remove");
        button2.addMouseListener(new ImageListener2());
        
        JButton button3 = new JButton("Leave");
        button3.addMouseListener(new ImageListener3());
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        // add the control panel to the canvas
        canvas.setComponentAtTop(panel);
        canvas.add(flag, 700, 50);
    }
    
    public void addImage(){
        
        ColorImage image = new ColorImage(images[random.nextInt(ncar)]);
        carQueue.addLast(image);
        displayQueue();
    }
    
    public void removeImage() {
                
        Runnable r = new Runnable()
        {
            public void run() {
                if (!carQueue.isEmpty()) {
                    ColorImage image = carQueue.removeFirst();
                    canvas.remove(flag);
                    turn90Deg(image, 90, 200);
                    moveCar(image, 400);
                    displayQueue();
                }
            }
        };
        
        threadPool.execute(r);
    }
    
    /*
     * TODO: Implement the leaveQueue method for button3 so that the last car 
     * will drive away from the end of queue
     */  
    public void leaveQueue() {

        Runnable r = new Runnable()
        {
            public void run() {
                if (!carQueue.isEmpty()) {
                    
                    // Write your code in the following area
                    // -------------------------------------
                    
                    // 1. By using the removeLast() method from the ArrayDeque class,
                    //    retrieve and remove the ColorImage of the car in the end of the queue.
                    //    The ArrayDeque used in this class is referenced by the instance variable "carQueue".
                    
                    // 2. By using the moveCar() instance method,
                    //    move the ColorImage of the car backwards by a distance of 100.
                    
                    // 3. By using the turn90Deg() instance method,
                    //    turn the ColorImage of the car by 90 degrees.
                    //    The suggested values for the parameters "times" and "radius" of the turn90Deg() method are 90 and 200 respectively.
                    
                    // 4. By using the moveCar() instance method,
                    //    move the ColorImage of the car forward by long distance so that it will move out of the canvas
                    
                    // 5. Redraw all the elements on the canvas by writing "displayQueue();"
                    
                    // -------------------------------------
                }
            }
        };
        
        threadPool.execute(r);
    }
    
    public void displayQueue() {
        
        Iterator itr = carQueue.iterator();
        canvas.removeAll();
        canvas.add(flag, 700, 50);
        int i = 0;
        
        while (itr.hasNext()) {
             ColorImage image = (ColorImage) itr.next();
             canvas.add(image, 600-i*100, 100);
             i++;
        }
    }
    
    public void move(ColorImage carImage, int dist) { 
        
        double radian = Math.toRadians(carImage.getRotation());
        double distX = dist * Math.cos(radian);
        double distY = dist * Math.sin(radian);
        
        carImage.setX(carImage.getX() + (int)distX);
        carImage.setY(carImage.getY() + (int)distY);
    }
    
    public void moveCar(ColorImage carImage, int dist) {
        
        int unit = 10;
        int steps = Math.abs(dist/unit); // calculate the number of steps for the move car animation
        
        if (dist < 0) {
            unit = -unit; // change the unit distance to move to be negative if the car is moving backward
        }
        
        for (int i=0; i < steps; i++) {
            move(carImage, unit);
            pause(20);
        }
    }
    
    public void turn90Deg(ColorImage carImage, int times, int radius) {
        
        double rotateAngle = 90.0/times;
        double rAngleRadian = Math.toRadians(rotateAngle);
        
        while (times > 0) {
            
            carImage.setRotation((int)(carImage.getRotation() + rotateAngle) % 360);
            double moveDist = Math.abs(2 * radius * Math.sin(rAngleRadian/2));
            move(carImage, (int) moveDist);
            --times;
            pause (10);
        }
    }

    private static void pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            System.err.println("Error in running animation");
            System.exit(-1);
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        addImage();
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    // Inner class for button 2 (remove operation: drive away from the head of the queue)
    class ImageListener2 implements MouseListener { 
        
        public void mouseClicked(MouseEvent e) {
            removeImage();
        }
        
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
  
    // Inner class for button 3 (leave operation: drive away from the end of the queue)
    class ImageListener3 implements MouseListener { 
        
        public void mouseClicked(MouseEvent e) {
            leaveQueue();
        }
        
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
  
    public static void main(String[] args) {
        CarQueue q = new CarQueue();
    }
}