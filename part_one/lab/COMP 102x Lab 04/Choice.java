import comp102x.ColorImage;
import comp102x.Canvas; 

/**
 * The Choice class represents a choice made by the player or the computer.
 * It can be either "rock", "paper", or "scissors".
 */
public class Choice
{
    private int type; //stores the choice type: 0=rock, 1=paper, 2=scissors
    
    /**
     * The constructor
     * 
     * @param   type   the choice type to be represented by this Choice object
     */
    public Choice(int type)
    {
        //initialize the "type" instance varialble
        this.type = type;
    }
    
    /**
     * Get a number that represents the choice type
     * 
     * @return  a number that represents the choice type: 0=rock, 1=paper, 2=scissors
     */
    public int getType()
    {
        return type;
    }
    
    /**
     * Compare "this" with anotherChoice
     * 
     * @param   anotherChoice   the choice to be compared
     * @return  either 1, -1, or 0 which indicates the comparison result: 1 means "this" wins anotherChoice; -1 means "this" loses to anotherChoice; 0 means "this" and anotherChoice are the same
     */
    public int compareWith(Choice anotherChoice)
    {
        // write your code after this line
        int result = 2;
        
        if (this.type == anotherChoice.type) {
            result = 0;
        }
        
        if (this.type == 0) {
            switch(anotherChoice.type) {
                case 1: result = -1;
                        break;
                case 2: result = 1;
                        break;
            }
        }
        else if (this.type == 1) {
            switch(anotherChoice.type) {
                case 0: result = 1;
                        break;
                case 2: result = -1;
                        break;
            }
        }
        else {
            switch(anotherChoice.type) {
                case 0: result = -1;
                        break;
                case 1: result = 1;
                        break;
            }
        }
        
        return result;
    }
    
    /**
     * Draw the choice image (rock/paper/scissors) on the given canvas
     * 
     * @param   canvas      the canvas to draw on
     * @param   x           the x-position of the choice image to be drawn
     * @param   y           the y-position of the choice image to be drawn
     * @param   rotation    the rotation of the choice image to be drawn
     */ 
    public void draw(Canvas canvas, int x, int y, int rotation)
    {
        // write your code after this line
        String fileName;
        switch(getType()) {
            case 0:
                fileName = "rock.png";
                break;
            case 1:
                fileName = "paper.png";
                break;
            case 2:
                fileName = "scissors.png";
                break;
            default:
                fileName = "wat.png";
                break;
        }

        ColorImage image = new ColorImage(fileName);
        image.setX(x);
        image.setY(y);        
        image.setRotation(rotation);
        canvas.add(image);
    }
}
