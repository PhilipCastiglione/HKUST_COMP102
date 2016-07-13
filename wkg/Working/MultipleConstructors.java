
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultipleConstructors
{    
//     public MultipleConstructors(int a, int b) {
//         System.out.print("Yay! Ints! ");
//         System.out.println(a + b);
//     }

    public MultipleConstructors(double a, double b) {
        System.out.print("Omg! Doubles! ");
        System.out.println(a + b);
    }

    public MultipleConstructors(int a, double b) {
        System.out.print("OK! An int and a double. ");
        System.out.println(a + b);
    }

    public MultipleConstructors(double a, int b) {
        System.out.print("OK! A double and an int. ");
        System.out.println(a + b);
    }
    
    public static void main(String[] args) {
        MultipleConstructors m = new MultipleConstructors(1, 2);
//         MultipleConstructors m1 = new MultipleConstructors((double) 1, (double) 2);
//         MultipleConstructors m2 = new MultipleConstructors((double) 1, 2);
    }
}
