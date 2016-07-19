import java.util.Stack;

 public class NQueen {
     
     public static Stack<Integer> s = new Stack<Integer>();
     public static int n;         // n is the number of queens
     public static int total = 0;    // total is the total number of solution.
    
     public static void solve(int n) {       //finds all solutions to the n-queen problem
         
         int row = 0; 
         int col = 0;  

         while ( row < n ) {       // go through each row to place a queen       
             while ( col < n ) {        // go through the columns within each row
                 if ( isConflict(row, col) == false ) {     // check if there is a conflict
                     s.push(col);     // push col to stack
                     break;              //break out of loop to next row
                 }
                 else  
                    col++;
                }
                
          if (s.isEmpty() == true) break;  // either no solution or all solutions have been found
          
          if (col >= n) {                // finished all possible placements in a row
              col = s.pop() + 1;
              row--;
          }
          
          else {
              row++;
              col = 0;
          }       
          
          if (s.size()==n){           // if stack size is n a solution is found
              total++; 
              System.out.println(total + ": " + s);
              col = s.pop() + 1; // continue to find next solution
              row--;
          }
      } 
   } 
   
   public static boolean isConflict(int row, int col) {
       
       int diff = row-col;
       int sum  = row+col;
       
       for (int i = 0; i < row; i++) {
           int t = s.get(i);
           if (t==col || i-t == diff || i+t == sum) return true;
       }
       
       return false;
    }
    
   public void demo(int n) {

       total = 0;
       solve(n);
       System.out.println("There are " + total + " solutions to the " + n + "-queens problem.");
   }//main()

}
