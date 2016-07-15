
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Working
{    
    public static void main(String[] args) {
        int a = 8;
        int b = a-- + ++a;
        
        System.out.println(b); // 17
        System.out.println(a); // 8
    }
}
