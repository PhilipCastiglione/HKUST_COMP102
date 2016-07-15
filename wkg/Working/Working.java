
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Working
{    
    public static void main(String[] args) {
        double[] a = {1.5,2.5,3.5};
        double avg = 0;
        
        for (int i = 0; i < a.length; i++) {
            avg += a[i];
        }
        avg /= a.length;
        System.out.println(avg);
    }
}
