
public class PalindromeChecker
{
    /**
     * Checks if a given String is a palindrome. The checking should be case insensitive.
     * 
     * @param str The String to be checked.
     * @return true if str is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {    
        
        // Please write your code after this line
        
        
        
        return false; // this line should be modified or removed after finishing the implementation.
    }
    
    /**
     * Returns the reverse of a given String.
     * 
     * @param inputStr The String to be reversed.
     * @return A new String object representing the reverse of inputStr. 
     */
    public static String reverseString(String inputStr) {
        
        String revStr= "";
        
        for(int i = 0; i< inputStr.length(); i++) {
            revStr= inputStr.charAt(i) + revStr;
        }
        
        return revStr;
    }
}
