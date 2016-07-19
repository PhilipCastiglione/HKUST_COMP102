package comp102x.project.task;

import java.util.Random;

import comp102x.project.model.Target;

public class TargetUpdater {
    
    public void updateTarget(Target[] targets, int level) {
        int swapCount = 0;
        
        if (level == 2) {
            swapCount = 4;
        } else if (level == 3) {
            swapCount = 10;
        }
        
        for (int i = 0; i < swapCount; i++) {
            Random r = new Random();
            int targetOneIdx = r.nextInt(targets.length);
            int targetTwoIdx = r.nextInt(targets.length);
            while (targetOneIdx == targetTwoIdx) {
                targetTwoIdx = r.nextInt(targets.length);
            }
            
            if (targets[targetOneIdx].isHit() && !targets[targetTwoIdx].isHit() ||
                targets[targetOneIdx].isHit() && !targets[targetTwoIdx].isHit()) {
                int x = targets[targetOneIdx].getX();
                int y = targets[targetOneIdx].getY();
                int z = targets[targetOneIdx].getZ();
                targets[targetOneIdx].setX(targets[targetTwoIdx].getX());
                targets[targetOneIdx].setY(targets[targetTwoIdx].getY());
                targets[targetOneIdx].setZ(targets[targetTwoIdx].getZ());
                targets[targetTwoIdx].setX(x);
                targets[targetTwoIdx].setY(y);
                targets[targetTwoIdx].setZ(z);
            }
        }
    }

}
