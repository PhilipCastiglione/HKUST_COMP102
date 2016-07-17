import comp102x.Canvas;

public class Lab04GradedTask2
{
   // Test case 1 - to test if a Rock image is drawn at (0, 480) on a canvas with size (480 x 960) without any rotation
   // Setup: A Choice of Rock (0), A canvas of size (480 x 960), x-position of image (0), y-position of image (480), rotation of image (0)
   // Expected output: A Rock image being drawn at (0, 480) on a canvas with size (480 x 960) without any rotation
   public static void testCase1() {    
       
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(0); //Rock
       choice1.draw(canvas, 0, 480, 0);
       
   }
   
   // You may wish to create some more to test the program.  
   public static void testCase2() {    
       
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(1); //Paper
       choice1.draw(canvas, 0, 480, 0);
       
   }
   
   public static void testCase3() {    
       
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(2); //Scissors
       choice1.draw(canvas, 0, 480, 0);
       
   }
   
   public static void testCase4() {    
       
       Canvas canvas = new Canvas(480, 960);
       Choice choice1 = new Choice(0); //Rock
       Choice choice2 = new Choice(1); //Paper
       choice1.draw(canvas, 0, 480, 0);
       choice2.draw(canvas, 0, 0, 180);       
   }
   
}
