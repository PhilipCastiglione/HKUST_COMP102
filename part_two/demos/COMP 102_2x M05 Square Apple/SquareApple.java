import java.util.Stack;
import comp102x.ColorImage;
import comp102x.Canvas;
import comp102x.IO;

public class SquareApple {

    public static Stack<Indices3> s = new Stack<Indices3>();
    public static int[][] grid;
    public static int n;
    public static int startX;
    public static int startY;
    public static int choices = 4;
    public static int total;
    public static ColorImage[][] appleI;
    public static ColorImage[] numI;
    public static ColorImage wormI = new ColorImage("images/gworm200.jpg");
    Canvas canvas = new Canvas(600, 423);
    
    private static int pauseAfterEachMove = 100;
    private static int initialDelay = 1500;

    public SquareApple(int size, int x, int y) {
        
        canvas.setResizable(false);
        wormI.setMovable(false);
        
        n = size;
        int n2 = n * n;
        startX = x;
        startY = y;
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = 0;

        appleI = new ColorImage[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                appleI[i][j] = new ColorImage("images/sq1-apple200.jpg");
                appleI[i][j].setMovable(false);
            }

        numI = new ColorImage[n2];
        for (int i = 0; i < n2; i++) {
            numI[i] = new ColorImage("images/ii" + (i + 1) + ".jpg");
            numI[i].setMovable(false);
        }
    }

    private int solve() {

        int maxStep = n * n;
        int i = 1;
        int j = 0;
        total = 0;
        Indices3 m = new Indices3(startX, startY);
        int currentX = startX;
        int currentY = startY;
        grid[currentX][currentY] = 1;
        s.push(m);

        initDisplay(n);
        pause(initialDelay);
        while (i < maxStep) {

            while (j < choices) {
                switch (j) {
                case 0:
                    m = move0(currentX, currentY);
                    break;
                case 1:
                    m = move1(currentX, currentY);
                    break;
                case 2:
                    m = move2(currentX, currentY);
                    break;
                case 3:
                    m = move3(currentX, currentY);
                    break;
                }
                if (isLegalMove(m) == true) {
                    s.push(m);
                    grid[currentX][currentY] = j + 1;
                    currentX = m.x;
                    currentY = m.y;
                    removeI(appleI[currentX][currentY]);
                    displayI(wormI, currentX, currentY);
                    displayI(numI[i], currentX, currentY);
                    pause(pauseAfterEachMove);
                    break; // break out of loop to move on to next row, i++
                } else
                    j++;
            }

            if (s.isEmpty() == true)
                break;

            if (j >= choices) {
                m = s.pop();
                grid[m.x][m.y] = 0;
                displayI(appleI[m.x][m.y], m.x, m.y);
                removeI(numI[i - 1]);
                if (m.x == startX && m.y == startY)
                    break;
                else {
                    currentX = s.peek().x;
                    currentY = s.peek().y;
                    displayI(wormI, currentX, currentY);
                }
                j = grid[currentX][currentY];
                pause(pauseAfterEachMove);
                i--;
            } else {
                i++;
                j = 0;
            }

            if (s.size() == maxStep) { // if stack size is n, a solution has been found
                total++;
                System.out.print(total + ": ");
                printSolution(s);
                pause(pauseAfterEachMove);
                m = s.pop();
                grid[m.x][m.y] = 0;
                displayI(appleI[m.x][m.y], m.x, m.y);
                removeI(numI[maxStep - 1]);
                currentX = s.peek().x;
                currentY = s.peek().y;
                displayI(wormI, currentX, currentY);
                j = grid[currentX][currentY];
                pause(pauseAfterEachMove);
                i--;
            }

        }
        return total;
    }

    private static Indices3 move0(int x, int y) {
        Indices3 m0 = new Indices3(x + 1, y);
        return m0;
    }

    private static Indices3 move1(int x, int y) {
        Indices3 m1 = new Indices3(x, y + 1);
        return m1;
    }

    private static Indices3 move2(int x, int y) {
        Indices3 m2 = new Indices3(x - 1, y);
        return m2;
    }

    private static Indices3 move3(int x, int y) {
        Indices3 m3 = new Indices3(x, y - 1);
        return m3;
    }

    private static boolean isLegalMove(Indices3 m) {
        int nextX = m.x;
        int nextY = m.y;

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
            return false;
        if (grid[nextX][nextY] != 0)
            return false;
        else
            return true;
    }

    private static void printSolution(Stack<Indices3> s) {
        for (int i = 0; i < s.size(); i++) {
            if (i == s.size() - 1)
                System.out.print("(" + s.get(i).x + "," + s.get(i).y + ")");
            else
                System.out.print("(" + s.get(i).x + "," + s.get(i).y + "),");
        }// for
        System.out.println();
    }// printSolution()

    private void displayI(ColorImage image, int x, int y) {
        x = x * 200;
        y = y * 145;
        canvas.add(image, x, y);
    }

    private void removeI(ColorImage image) {
        canvas.remove(image);
    }

    private void initDisplay(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                displayI(appleI[i][j], i, j);
        removeI(appleI[startX][startY]);
        displayI(numI[0], startX, startY);
        displayI(wormI, startX, startY);
    }

    private void pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.err.println("Error in running rotation animation!");
            System.exit(-1);
        }
    }
    
    private static int[] promptForStartingLocation() {
    
        // print grid
        System.out.println();
        System.out.println("a | b | c");
        System.out.println("---------");
        System.out.println("d | e | f");
        System.out.println("---------");
        System.out.println("g | h | i");
        System.out.println();
        
        // ask for user input
        // validate user input
        char userInput;
        do {
        
            System.out.print("Please choose a starting location (a - i): ");
            userInput = IO.inputCharacter();
            
        } while (userInput < 'a' || userInput > 'i');
        
        // mapping
        // return
        switch (userInput) {
            
            case 'a': return new int[]{0, 0};
            case 'b': return new int[]{1, 0};
            case 'c': return new int[]{2, 0};
            case 'd': return new int[]{0, 1};
            case 'e': return new int[]{1, 1};
            case 'f': return new int[]{2, 1};
            case 'g': return new int[]{0, 2};
            case 'h': return new int[]{1, 2};
            case 'i': return new int[]{2, 2};
            default : return new int[]{1, 1};
        }
    } 

    public static void main(String[] args) {

        int n = 3;
        int[] startingLocation = promptForStartingLocation();
        SquareApple apples = new SquareApple(3, startingLocation[0], startingLocation[1]);

        int number = apples.solve();
        System.out.println("There is(are) " + number + " solution(s).");
    }// main()

}

class Indices3 {
    public int x, y;

    public Indices3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}