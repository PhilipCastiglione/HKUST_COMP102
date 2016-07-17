import comp102x.IO;

/**
 * Demonstrate the use of array for storing and manipulating a set of scores
 */
public class Scores
{
    private double[] scoreArray; // declare a reference variable to an array

    public Scores(int size) {
        scoreArray = new double[size];
    }
    
    /**
     * SetScore asks user to enter score for each array element
     */
    public void setScore () {
        // length is a constant instance variable for each array that
        // gives the number of elements in the array.
        int size = scoreArray.length;
        
        for ( int i = 0; i < scoreArray.length; i++ ) {
            IO.output("Enter score for student " + i + ": ");
            scoreArray[i] = IO.inputDouble( );
        }
    }
    
    /**
     * getScore retrieves the value of an element of the array
     */
    public double getScore(int index) {
        // check to make sure that index is within 0 and array size -1
        if ( index >= 0 && index < scoreArray.length )
            return scoreArray[index];
        else {
            IO.outputln("Error: index out of range");
            return -1;
        }
    }
    
    /**
     * aveScore computes the average of the values in an array
     */
    public double aveScore() {
        double sum = 0; // for storing the cumulative sum
        int size = scoreArray.length; // size of the array
        
        for (int i = 0; i < size; i++)
            sum = sum + scoreArray[i];
            
        return sum / size;
    }
    
    /**
     * maxIndex finds the location of the largest values in an array
     * up to index size - 1
     */
    public int maxIndex(int size){
        int mIndex = 0; // index for the current maximum
        if (size > scoreArray.length) size = scoreArray.length;
        
        for (int i = 0; i < size; i++) {
            if (scoreArray[i] > scoreArray[mIndex]) mIndex = i;
        }
        
        return mIndex;
    }
    
    /**
     * swap two elements of the array arr indexed by index1 and index2
     */
    public void swap (double[] arr, int index1, int index2) {
        double temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    /**
     * Use selection sort to arrange the array in ascending order
     */
    public void selectSort () {
        int maxPos; // index for the largest element in unsorted array
        
        for (int i = scoreArray.length-1; i > 0; i--) {
            maxPos = maxIndex(i+1); // find the largest element
            swap (scoreArray, maxPos, i); // swap the largest and last elements of unsorted portion
        }
    }
    
    
    /**
     * Prints all the score in the array
     */
    public void printScores() {
        
        IO.output("Scores: ");
        
        for (int i = 0; i < scoreArray.length; i++) {
            IO.output(scoreArray[i] + " ");
        }
        
        IO.outputln("");
    }
}
