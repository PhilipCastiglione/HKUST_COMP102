package comp102x.project.task;

public class CharValidator {
   
	public boolean validateChar(char c) {
	    return Character.isDigit(c) || Character.isLetter(c);
	}

}
