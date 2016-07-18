import comp102x.IO;
import comp102x.Canvas;
import comp102x.ColorImage;
import java.awt.Color;

public class TowerHanoiAnimate {
    Canvas canvas = new Canvas(1000,600);
    ColorImage[] disks;
    int[] pn = new int[4];
    int[] clr = new int[3];
    int vp = 300;
    int h1 = 200;
    int h2 = 500;
    int h3 = 800;
    int step = 0;
    int dWidth = 30;
    int dHeight = 15;
    int longpause;
    
    void towers(int num, int from, int to) {
        int temp = 6 - from - to;
        if (num == 1){
            IO.outputln(++step + ": move disk 1 from " + from + " to " + to);
            
            disks[1].setX(hPos(to, disks[1].getWidth()));
            disks[1].setY(vPos(to));
            pn[to]++;
            pn[from]--;
            pause(100);
        } else {
            towers(num-1, from, temp);

            IO.outputln(++step + ": move disk " + num + " from " + from + " to " + to);
            
            disks[num].setX(hPos(to, disks[num].getWidth()));
            disks[num].setY(vPos(to));
            pn[to]++;
            pn[from]--;
            pause(100);
            
            towers(num-1, temp, to);
        }
    }
    
    void demo(int num) {
        canvas.removeAll();
        disks = new ColorImage[num+1];
        pn[1] = 0;
        pn[2] = 0;
        pn[3] = 0;
        step = 0;
        longpause = num;
        for (int i = 1; i <= num; i++) {
            disks[i] = new ColorImage(dWidth*i+1, dHeight);
            setC(clr, i%9);
            for (int j =1; j< disks[i].getWidth(); j++)
                for (int k = 1; k < disks[i].getHeight(); k++)
                    disks[i].setRGB(j,k, clr[0], clr[1], clr[2]);
        }

        for (int i = num; i >= 1; i--) {
            canvas.add(disks[i], hPos(1, disks[i].getWidth()), vPos(1));
            pn[1]++;
        }
        towers(num, 1, 3);
    }
    
    int hPos(int p, int w) {
        if (p == 1) return h1 - w/2;
        if (p == 2) return h2 - w/2;
        else return h3 - w/2;
    }
    
    int vPos(int p) {
        if (p == 1) return vp - pn[1] * dHeight;
        if (p == 2) return vp - pn[2] * dHeight;
        else return vp - pn[3] * dHeight;
    }

    public static void pause(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            System.err.println("Error in running rotation animation!");
            System.exit(-1);
        }
    }
    
        public void setC(int[] clr, int i) {
        switch (i) {
            case 1: clr[0]=Color.GREEN.getRed();
                    clr[1]=Color.GREEN.getGreen();
                    clr[2]=Color.GREEN.getBlue(); 
                    break;
            case 2: clr[0]=Color.YELLOW.getRed();
                    clr[1]=Color.YELLOW.getGreen();
                    clr[2]=Color.YELLOW.getBlue(); 
                    break;
            case 3: clr[0]=Color.CYAN.getRed();
                    clr[1]=Color.CYAN.getGreen();
                    clr[2]=Color.CYAN.getBlue(); 
                    break;
            case 4: clr[0]=Color.ORANGE.getRed();
                    clr[1]=Color.ORANGE.getGreen();
                    clr[2]=Color.ORANGE.getBlue(); 
                    break;
            case 5: clr[0]=Color.MAGENTA.getRed();
                    clr[1]=Color.MAGENTA.getGreen();
                    clr[2]=Color.MAGENTA.getBlue(); 
                    break;
            case 6: clr[0]=Color.PINK.getRed();
                    clr[1]=Color.PINK.getGreen();
                    clr[2]=Color.PINK.getBlue(); 
                    break;
            case 7: clr[0]=Color.RED.getRed();
                    clr[1]=Color.RED.getGreen();
                    clr[2]=Color.RED.getBlue(); 
                    break;
            case 8: clr[0]=Color.BLUE.getRed();
                    clr[1]=Color.BLUE.getGreen();
                    clr[2]=Color.BLUE.getBlue(); 
                    break;
            default: clr[0]=Color.GRAY.getRed();
                    clr[1]=Color.GRAY.getGreen();
                    clr[2]=Color.GRAY.getBlue(); 
                    break;
        }
    }
}
