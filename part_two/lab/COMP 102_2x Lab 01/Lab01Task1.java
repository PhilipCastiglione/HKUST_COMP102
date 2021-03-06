
public class Lab01Task1
{
    public int minPos(GameRecord[] records, int size) {
        int idx = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (records[i].getLevel() < records[idx].getLevel() ||
                records[i].getLevel() == records[idx].getLevel() &&
                records[i].getScore() < records[idx].getScore()) {
                idx = i;
            }
        }
        return idx;
    }
    
    public static void testCase1() {
    
        GameRecord[] records = new GameRecord[4];
        records[0] = new GameRecord("A", 2, 10);
        records[1] = new GameRecord("B", 3, 8);
        records[2] = new GameRecord("C", 2, 5);
        records[3] = new GameRecord("D", 1, 2);
        
        Lab01Task1 lab01Task1 = new Lab01Task1();
        int actualOutput = lab01Task1.minPos(records, 3); // only searching the first 3 elements
        
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + actualOutput);
    }
    
    // You can add more test cases to test your program prior to submitting your code to the online grader.
}
