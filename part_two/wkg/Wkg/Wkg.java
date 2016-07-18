import java.util.Scanner;

public class Wkg extends Sup
{
    int nCount = 0;
    
    public int fibonacci(int n) {
        nCount++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main (String[] args) {
        Wkg w = new Wkg();
        w.fibonacci(8);
        System.out.println(w.nCount);
    }
}
