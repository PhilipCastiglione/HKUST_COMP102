import comp102x.ColorImage;
import comp102x.Canvas;

public class Lab03
{  
    
    public void loadAnImage() 
    {
        // Please write your code after this line
        ColorImage yayAnImage = new ColorImage();
        Canvas aSweetCanvas = new Canvas(yayAnImage.getWidth(), yayAnImage.getHeight());
        aSweetCanvas.add(yayAnImage);
    }
    
    public void loadTwoImagesOnTheSameCanvas()
    {
        // Please write your code after this line
        ColorImage image1 = new ColorImage();
        ColorImage image2 = new ColorImage();
        Canvas canvas = new Canvas(image1.getWidth() * 2, image1.getHeight());
        canvas.add(image1);
        canvas.add(image2, image1.getWidth(), 0);
    }
    
    public void imageAddition() 
    {    
        // Please write your code after this line
        ColorImage image1 = new ColorImage();
        ColorImage image2 = new ColorImage();
        ColorImage image3 = ColorImage.add(image1, image2);
        Canvas canvas = new Canvas(image1.getWidth() * 3 + 20, image1.getHeight());
        canvas.add(image1);
        canvas.add(image2, image1.getWidth() + 10, 0);
        canvas.add(image3, image1.getWidth() * 2 + 20, 0);
    }
   
    public void imageMultiplication() 
    {
        // Please write your code after this line
        ColorImage image1 = new ColorImage();
        ColorImage image2 = new ColorImage();
        ColorImage image3 = ColorImage.multiply(image1, image2);
        Canvas canvas = new Canvas(image1.getWidth() * 3 + 20, image1.getHeight());
        canvas.add(image1);
        canvas.add(image2, image1.getWidth() + 10, 0);
        canvas.add(image3, image1.getWidth() * 2 + 20, 0);
    }
    
    public void changeColor()
    {
        ColorImage image = new ColorImage();
        image.increaseRed(40);
        image.increaseBlue(30);
        image.decreaseGreen(20);
        Canvas canvas = new Canvas(image.getWidth(), image.getHeight());
        canvas.add(image);
        
        image.save();
    }
}
