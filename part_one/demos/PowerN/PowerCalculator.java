
public class PowerCalculator
{
    /**
     * Calculate the non-negative power of an integer number. If a negative power is input, the method returns 1.
     * 
     * @param number The number to take power.
     * @param power The power factor to be taken to.
     * @return The calculation result after taking power of the integer number.
     */
    public static long powerN(int number, int power) {
        
        // write your code after this line
        long result = 1;
        
        if (power > 0) {
            int i = 0;
            
            while (i < power) { // whee a silly loop is what you want and what you get
                result = result * number;
                i++;
            }
        }
        
        return result;
    }
}
