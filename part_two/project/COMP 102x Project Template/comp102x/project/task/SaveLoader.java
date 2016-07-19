package comp102x.project.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import comp102x.project.model.GameRecord;

public class SaveLoader {
    
    public void saveGameRecords(GameRecord[] records, String filename) throws FileNotFoundException {
        PrintWriter gameRecordPrinter = new PrintWriter(new File(filename));
       
        for (int i = 0; i < records.length; i++) {
            gameRecordPrinter.println(records[i].getName() + '\t' + records[i].getLevel() + '\t' + records[i].getScore());
         }
       
        gameRecordPrinter.close();
    }
    
    public GameRecord[] loadGameRecords(String filename) throws FileNotFoundException {
        final int MAX_N = 30;
        GameRecord[] records = new GameRecord[MAX_N];
        
        Scanner recordReader = new Scanner(new File(filename));
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

}
