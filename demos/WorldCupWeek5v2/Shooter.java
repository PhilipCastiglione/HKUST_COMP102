import comp102x.ColorImage;

public class Shooter
{
    /**
     * Shoots the football horizontally by incrementing the x position of the football image repeatly.
     * 
     * Hints:
     * 1. Write a loop to complete this method.
     * 2. Use the getX()and setX(int) instance method of the ColorImage class.
     * 3. Call the pause(int) method at the end of each loop iteration to spare time for the screen to update.
     * 4. The suggested parameter for calling the pause(int) method is 2, i.e. pause(2).
     *    
     * @param footballImage The football image to be updated.
     * @param numberOfTimes The number of times to increment the x position of the football image.
     * @param unitDistance The amount to increment for the x position for each time.
     */
    public void shoot(ColorImage footballImage, int numberOfTimes, int unitDistance)
    {
        // write your code after this line
        

        
        
    }
    
    /**
     * Shoots the football horizontally with spinning animation by incrementing the x position and the rotation angle of the football image repeatly.
     * 
     * Hints:
     * 1. Write a loop to complete this method.
     * 2. Use the getX()and setX(int) instance method of the ColorImage class.
     * 3. Use the getRotation() and setRotation(int) instance method of the ColorImage class.
     * 4. Call the pause(int) method at the end of each loop iteration to spare time for the screen to update.
     * 5. The suggested parameter for calling the pause(int) method is 2, i.e. pause(2).
     *    
     * @param footballImage The football image to be updated.
     * @param numberOfTimes The number of times to increment the x position and the rotation angle of the football image.
     * @param unitDistance The amount to increment for the x position for each time.
     * @param unitRotation The amount to increment for the rotation angle for each time.
     */
    public void spinningShoot(ColorImage footballImage, int numberOfTimes, int unitDistance, int unitRotation)
    {   
        // write your code after this line
        

        
        
    }
    
    /**
     * Pauses the increment on the position or the rotation angle of the football image so that the screen can be updated to so the animation.
     * 
     * @param sleepTime The amount of time to pause the update in milliseconds.
     */
    private void pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.exit(-1);
        }
    }
}

