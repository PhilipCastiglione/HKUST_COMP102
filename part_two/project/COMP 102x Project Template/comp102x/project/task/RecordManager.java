package comp102x.project.task;

import comp102x.project.model.GameRecord;

public class RecordManager {

    public GameRecord[] updateGameRecords(GameRecord[] oldRecords, GameRecord newRecord) {        GameRecord[] updatedRecords = oldRecords;
        
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
}
