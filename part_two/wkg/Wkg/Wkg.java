import java.util.Scanner;

public class Wkg extends Sup
{
 
    public static void main (String[] args) {
        //Scanner s = new Scanner();
        Scanner scanner = new Scanner("1 A 2 B");
        
        System.out.println(scanner.nextInt()); // statement 1
        System.out.println(scanner.nextInt()); // statement 2
                
        scanner.close();

 
    }
}
