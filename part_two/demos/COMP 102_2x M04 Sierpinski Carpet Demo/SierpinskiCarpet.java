import comp102x.Canvas;
import comp102x.ColorImage;

public class SierpinskiCarpet
{
    Canvas canvas;
    
    public void demo() {
        
        int width = 729;
        int height = 729;
        int iterations = 6;
        canvas = new Canvas(width,height);
        ColorImage image = new ColorImage(width, height);
        canvas.add(image);
        
        drawSierpinskiCarpet(image, 0, 0, width, height, iterations);
    }
    
        
    private void drawSierpinskiCarpet(ColorImage image, int left, int top, int width, int height, int iterations) {
        
        if (image == null || width != height || width < 3 || iterations < 1)
            return;
        
        int size = width /= 3;

//        image.drawRectangle(left + 1 * size, top + 1 * size, size, size);
         image.drawRectangle(left + 1 * size, top + 1 * size, size, size, 
                              iterations%3*100, iterations%4*80, iterations*40);
         pause(1);
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                drawSierpinskiCarpet(image, left + j * size, top + i * size, size, size, iterations - 1);
        }
    }

    
    public static void pause(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            System.err.println("Error in running rotation animation!");
            System.exit(-1);
        }
    }
}
