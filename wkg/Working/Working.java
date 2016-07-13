
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
        System.out.print("arg x is a: ");
        //System.out.println(x.getClass());
        // this has a compile error "int cannot be dereferenced" referring to x.getClass()
        x = x;
    }
    
    public static void main(String[] args) {
        Working w = new Working(13);

        System.out.println("w is a: " + w.getClass());

        //System.out.println("w.x is a: " + w.x.getClass());
        // this has a compile error "int cannot be dereferenced" referring to w.x.getClass()
    }
}
