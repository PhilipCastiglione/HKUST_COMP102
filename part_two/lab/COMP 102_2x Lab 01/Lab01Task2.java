
public class Lab01Task2
{
    public GameRecord[] updateGameRecords(GameRecord[] oldRecords, GameRecord newRecord) {
        GameRecord[] updatedRecords = oldRecords;
        
        boolean matched = false;
        
        int recordsAtLevel = 0;
        
            System.out.println("new record name: " + newRecord.getName());
            System.out.println("new record level: " + newRecord.getLevel());
            
        for (int i = 0; i < oldRecords.length; i++) {
            System.out.println("old record " + i + " name: " + oldRecords[i].getName());
            System.out.println("old record " + i + " level: " + oldRecords[i].getLevel());
            if (oldRecords[i].getName().equals(newRecord.getName()) &&
                oldRecords[i].getLevel() == newRecord.getLevel()) {
                System.out.println("we have matched");
                matched = true;
                if (oldRecords[i].getScore() < newRecord.getScore()) {
                    updatedRecords[i] = newRecord;
                }
                break;
            }
            
            if (oldRecords[i].getLevel() == newRecord.getLevel()) {
                recordsAtLevel++;
            }
        }
        
        if (!matched) {
            System.out.println("we did not match");
            if (recordsAtLevel == 10) {
                int lowestScoreAtLevelIndex = -1;
                for (int i = 0; i < updatedRecords.length; i++) {
                    if (updatedRecords[i].getLevel() == newRecord.getLevel()) {
                        if (lowestScoreAtLevelIndex == -1 ||
                            updatedRecords[i].getScore() < updatedRecords[lowestScoreAtLevelIndex].getScore()) {
                            lowestScoreAtLevelIndex = i;
                        }
                    }
                }
                if (updatedRecords[lowestScoreAtLevelIndex].getScore() < newRecord.getScore()) {
                    updatedRecords[lowestScoreAtLevelIndex] = newRecord;
                }
            } else {
                updatedRecords = new GameRecord[oldRecords.length + 1];
                for (int i = 0; i < oldRecords.length; i++) {
                    updatedRecords[i] = oldRecords[i];
                }
                updatedRecords[oldRecords.length] = newRecord;
            }
        }
        
        Util.sort(updatedRecords);
        
        return updatedRecords;
    }
    
    // test case 1: updating an existing record, given that the new record has a better score.
    public static void testCase1() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord(new String("B"), 2, 10); // use new String to mimic dynamic user input
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    // test case 2: inserting a new record given that we have less than records for the new record's level.
    public static void testCase2() {
    
        GameRecord[] oldRecords = new GameRecord[2];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 8);
        
        GameRecord newRecord = new GameRecord(new String("C"), 2, 10); // use new String to mimic dynamic user input
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("B, 2, 8");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }

    // test case 3: replacing a lower score record of the same level, given that we already have 10 records for that level.
    public static void testCase3() {
    
        GameRecord[] oldRecords = new GameRecord[10];
        oldRecords[0] = new GameRecord("A", 2, 10);
        oldRecords[1] = new GameRecord("B", 2, 10);
        oldRecords[2] = new GameRecord("C", 2, 10);
        oldRecords[3] = new GameRecord("D", 2, 10);
        oldRecords[4] = new GameRecord("E", 2, 10);
        oldRecords[5] = new GameRecord("F", 2, 10);
        oldRecords[6] = new GameRecord("G", 2, 10);
        oldRecords[7] = new GameRecord("H", 2, 10);
        oldRecords[8] = new GameRecord("I", 2, 10);
        oldRecords[9] = new GameRecord("J", 2, 8);
        
        GameRecord newRecord = new GameRecord(new String("K"), 2, 10); // use new String to mimic dynamic user input
        
        Lab01Task2 lab01Task2 = new Lab01Task2();
        GameRecord[] updatedRecords = lab01Task2.updateGameRecords(oldRecords, newRecord);
        
        System.out.println("Expected output:");
        System.out.println("============================");
        System.out.println("A, 2, 10");
        System.out.println("B, 2, 10");
        System.out.println("C, 2, 10");
        System.out.println("D, 2, 10");
        System.out.println("E, 2, 10");
        System.out.println("F, 2, 10");
        System.out.println("G, 2, 10");
        System.out.println("H, 2, 10");
        System.out.println("I, 2, 10");
        System.out.println("K, 2, 10");
        System.out.println("============================\n");
        
        System.out.println("Actual output:");
        System.out.println("============================");
        printHighscoreTable(updatedRecords);
        System.out.println("============================\n");
    }
    
    // You can add more test case to test your program prior to submitting your code to the online grader.
    
    private static void printHighscoreTable(GameRecord[] records) {
        
        if (records == null) {
            return;
        }
        
        for (int i = 0; i < records.length; i++) {
            if (records[i] != null) {
                System.out.println(records[i].getName() + ", " + records[i].getLevel() + ", " + records[i].getScore());
            } else {
                System.out.println();
            }
        }
    }
}
