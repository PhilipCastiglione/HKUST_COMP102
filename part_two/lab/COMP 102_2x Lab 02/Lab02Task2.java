import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Lab02Task2
{
    /**
     * Loads the game records from a text file.
     * A GameRecord array is constructed to store all the game records.
     * The size of the GameRecord array should be the same as the number of non-empty records in the text file.
     * The GameRecord array contains no null/empty entries.
     * 
     * @param reader    The java.io.Reader object that points to the text file to be read.
     * @return  A GameRecord array containing all the game records read from the text file.
     */
    public GameRecord[] loadGameRecord(java.io.Reader reader) {
        // write your code after this line
        final int MAX_N = 30;
        GameRecord[] records = new GameRecord[MAX_N];
        
        Scanner recordReader = new Scanner(reader);
        Scanner line;
        
        int i;
        for (i = 0; recordReader.hasNextLine(); i++) {
            if (i >= MAX_N) {
                break;
            }
            line = new Scanner(recordReader.nextLine());
            line.useDelimiter("\\t");
            records[i] = new GameRecord(line.next(), line.nextInt(), line.nextInt());
        }
        
        recordReader.close();
        
        // wow this is nasty, there must be a better way of handling this
        GameRecord[] sizedRecords = new GameRecord[i];
        for (int j = 0; j < i; j++) {
            sizedRecords[j] = records[j];
        }
        records = sizedRecords;
        
        return records;
    }
    
    public static void testCase1() throws IOException {
           
        Lab02Task2 lab02Task2 = new Lab02Task2();
        
        FileReader reader = new FileReader("records.txt");
        GameRecord[] actualArray = lab02Task2.loadGameRecord(reader );
           
        System.out.println("Expceted: ");
        System.out.println("====================");
        int size = 9;
        for (int i = 0; i < size; i++) {
            System.out.println("" + (char)(i + 97) + "\t" + (3 - i / 3) + "\t " + (size - 3 * (i % 3) - i / 3));
        }
        System.out.println("====================");
           
        System.out.println();
        System.out.println("Actual: ");
        System.out.println("====================");
        for (int i = 0; actualArray != null && i < actualArray.length; i++) {
            if (actualArray[i] != null) {
                System.out.println(actualArray[i].getName() + "\t" + actualArray[i].getLevel() + "\t" + actualArray[i].getScore());
            } else {
                System.out.println(); // For visualizing null entries
            }
        }
        System.out.println("====================");
    }
}
