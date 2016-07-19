package comp102x.project.task;

import comp102x.project.model.GameRecord;

public class Util {
    
    public static void sort(GameRecord[] records) {
    
        int minIndex;
        int remaining = records.length;

        while (remaining > 1) {

            minIndex = minPos(records, remaining);
            swap(records, minIndex, --remaining);
        }
    }

    private static int minPos(GameRecord[] records, int size) {
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

    private static void swap(GameRecord[] array, int index1, int index2) {

        GameRecord temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
