package comp102x.project.task;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import comp102x.project.view.GameScreen;

public class AimListener implements MouseMotionListener {
    private double pan;
    private double tilt;
    
    public double getPan() {
        return pan;
    }
    
    public double getTilt() {
        return tilt;
    }
    
    public void mouseMoved(MouseEvent e) {
        pan = e.getX() / (double) GameScreen.WIDTH * 180 - 90;
        tilt = e.getY() / (double) GameScreen.HEIGHT * 90;
    }
    
    public void mouseDragged(MouseEvent e) {}
}
