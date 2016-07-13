
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Working
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Working
     */
    public Working(int x)
    {
        // initialise instance variables
        x = x;
    }
    
    public static void main(String[] args) {
        Working w = new Working(13);
        System.out.println(w.x);
    }
}
