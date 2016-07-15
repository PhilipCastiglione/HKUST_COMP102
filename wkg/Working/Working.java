
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Working
{    
    
   public int iVar;
   final static public int classVar = 5;
    
    public Working() {
        iVar = 2;
    }
    
    public Working(int inputIVar) {
        iVar = inputIVar;
    }
    
   public static void main(String[] args) {
       Working a = new Working();
       Working b = new Working(4);

       System.out.println(a);
       System.out.println(b);
       System.out.println(a.iVar);
       System.out.println(b.iVar);
       System.out.println(a.classVar);
   }
}

