import java.util.Stack;
import comp102x.Canvas;
import comp102x.ColorImage;

public class NQueens {

    public static Stack<Integer> s = new Stack<Integer>();
    public static int n; 
    public static int total; 
    private static Canvas canvas;
    private static ColorImage board;
    private static int gridSize = 80;
    private static ColorImage queen = new ColorImage("bq80.png");
    private static ColorImage wq = new ColorImage("wq80.png");
    private static ColorImage[] queens;
    
    public NQueens(int size) {
        
        n = size;
        int iSize = gridSize*n;
        canvas = new Canvas(iSize+10, iSize+10);
        board = new ColorImage(iSize, iSize);
        queens = new ColorImage[n];
        for (int i = 0; i<iSize; i++)
            for (int j = 0; j<iSize; j++){
                int r = i/gridSize;
                int c = j/gridSize;
                if ((r+c)/2*2 == (r+c)) board.setRGB(i, j, 0, 0, 255);
                    else board.setRGB(i, j, 255, 255, 255);
                }
                
        for (int i=0; i<n; i++)
            queens[i] = new ColorImage(queen);
            
        canvas.add(board);
        displayI(wq, n+1, n+1);
    }
            
      //finds and prints out all solutions to the n-queens problem
    public static int solve(){
        
        int i = 0;   // i goes through each row to place a queen
        int x = 0;   // x goes through the columns within each row 
        total = 0;
    
        while ( i < n ) {        
            while (x < n) {
                moveI(wq, x, i);
                if(isConflict(i, x) == false){ 
                    s.push(x); // no conflict, push x
                    moveI(wq, n+1, n+1);
                    displayI(queens[i], x, i);
                    //pause(200);
                    break; //break out of loop to next row
                }
                else 
                    x++;
            }
              
            if (s.isEmpty() == true) break;
              
            if (x >= n) {
                moveI(wq, n+1, n+1);
                x = s.pop() + 1;
                i--;
                removeI(queens[i]);
                //pause(200);
            }
            
            else {
                i++;
                x = 0;
            }
              
            if (s.size()==n){ 
                total++; 
                pause(200);
                System.out.println(total + ": " + s);
                //if (total == 1) printSolution(s);
                removeI(queens[n-1]);
                x = s.pop() + 1;
                i--;                    
            }
        } 
        return total; 
    }

    public static boolean isConflict(int row, int col){
        int diff = row-col;
        int sum = row+col;
        for (int i = 0; i < row; i++) {
            int t = s.get(i);
            if (t==col || i-t == diff || i+t == sum) return true;
          }
          return false;
    }
    
    private static void printSolution(Stack<Integer> s) {
        for (int i = 0; i < s.size(); i ++) {
            for (int j = 0; j < s.size(); j ++) {
                if (j == s.get(i))
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }//for
            System.out.println();
        }//for
        System.out.println();  
    }//printSolution()

    public static void displayI(ColorImage image, int x, int y){
      x = x * gridSize;
      y = y * gridSize;
      canvas.add(image, x, y);
    }
    
    public static void removeI(ColorImage image){
       canvas.remove(image);
    }
    
    public static void moveI(ColorImage image, int x, int y){
        image.setX(x*gridSize);
        image.setY(y*gridSize);
    }
  
    public static void pause(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            System.err.println("Error in running animation!");
            System.exit(-1);
        }
    }

    public void demo() {
        //NQueens nQ = new NQueens(n);

        int number = solve();
        System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
    }

}