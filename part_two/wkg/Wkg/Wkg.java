import java.util.Scanner;

public class Wkg extends Sup
{
    public static int f2(int a, int b) {
    
        if (b >= 1)
            return f2(a + 1, b - 1);
        else
            return a;
    }
    
    public static int f3(int n) {
      
        if (n == 0)
            return 1;
      
        else if (n < 10 && n > -10)
            return 0;
      
        else      
            return f3(n / 10) + f3(n % 10);
    }
 
    public static void main (String[] args) {
        //Scanner s = new Scanner();
        System.out.println(Wkg.f3(10200));

 
    }
}
