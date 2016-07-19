import java.util.Stack;
import comp102x.IO;

public class SqApple2 {

	public static Stack<Indices2> s = new Stack<Indices2>();
	public static int[][] grid;
	public static int n;
	public static int startX;
	public static int startY;
	public static int choices = 4;
	public static int total;

	public SqApple2(int size, int x, int y) {
		n = size;
		startX = x;
		startY = y;
		grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = 0;
	}

	public static int solve() {
		int maxStep = n * n;
		int i = 1;
		int j = 0;
		total = 0;
		Indices2 m = new Indices2(startX, startY);
		int currentX = startX;
		int currentY = startY;
		grid[currentX][currentY] = 1;
		s.push(m);

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
					break; // break out of loop to move on to next row, i++
				} else
					j++;
			}

			if (s.isEmpty() == true)
				break;

			if (j >= choices) {
				m = s.pop();
				grid[m.x][m.y] = 0;
				if (m.x == startX && m.y == startY)
					break;
				else {
					currentX = s.peek().x;
					currentY = s.peek().y;
				}
				j = grid[currentX][currentY];
				i--;
			} else {
				i++;
				j = 0;
			}

			if (s.size() == maxStep) { // if stack size is n, a solution has
										// been found
				total++;
				System.out.print(total + ": ");
				printSolution(s);

				m = s.pop();
				grid[m.x][m.y] = 0;
				currentX = s.peek().x;
				currentY = s.peek().y;
				j = grid[currentX][currentY];
				i--;
			}

		}
		return total;
	}

	public static Indices2 move0(int x, int y) {
		Indices2 m0 = new Indices2(x + 1, y);
		return m0;
	}

	public static Indices2 move1(int x, int y) {
		Indices2 m1 = new Indices2(x, y + 1);
		return m1;
	}

	public static Indices2 move2(int x, int y) {
		Indices2 m2 = new Indices2(x - 1, y);
		return m2;
	}

	public static Indices2 move3(int x, int y) {
		Indices2 m3 = new Indices2(x, y - 1);
		return m3;
	}

	public static boolean isLegalMove(Indices2 m) {
		int nextX = m.x;
		int nextY = m.y;

		if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
			return false;
		if (grid[nextX][nextY] != 0)
			return false;
		else
			return true;

	}

	private static void printSolution(Stack<Indices2> s) {
		for (int i = 0; i < s.size(); i++) {
			System.out.print("(" + s.get(i).x + "," + s.get(i).y + "),");
		}// for
		System.out.println();
	}// printSolution()

	public static boolean solutionExist(int row, int col) {
		int sum = row + col;
		return (sum / 2 * 2 == sum);
	}

	public static void main(String[] args) {

		int n = 3;
		int row = 0;
		int col = 0;
		IO.output("Enter size of n: ");
		n = IO.inputInteger();
		while (true) {
			IO.output("Enter starting row (from 0 to " + (n - 1) + "): ");
			row = IO.inputInteger();
			if (row < 0 || row > n - 1)
				IO.outputln("Input out-of-range, please try again.");
			else
				break;
		}
		while (true) {
			IO.output("Enter starting column (from 0 to " + (n - 1) + "): ");
			col = IO.inputInteger();
			if (col < 0 || col > n - 1)
				IO.outputln("Input out-of-range, please try again.");
			else
				break;
		}

		SqApple2 apples = new SqApple2(n, row, col);

		int number = 0;
		if (solutionExist(row, col))
			number = apples.solve();
		System.out.println("There is(are) " + number + " solution(s).");
	}// main()

}

class Indices2 {
	public int x, y;

	public Indices2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}