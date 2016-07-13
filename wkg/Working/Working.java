
/**
 * Write a description of class Working here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Working
{    
    public static void main(String[] args) {
        int score = 62;    //initialize value according to question
        char grade;

        switch(score/10) {

            case 10: grade = 'S'; break;
            case  9: grade = 'A'; 
            case  8: grade = 'B'; 
            case  7: grade = 'C'; 
            case  6: grade = 'D'; 
            case  5: grade = 'E'; break;
            default: grade = 'F';
        }
        System.out.println(grade);
    }
}
