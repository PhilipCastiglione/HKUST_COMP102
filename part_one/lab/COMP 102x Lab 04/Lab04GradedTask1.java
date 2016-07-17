import comp102x.IO;

public class Lab04GradedTask1
{
   // Test case 1 - to test if rock vs paper result in a lose
   // Setup: My choice = Rock (0), oppoent's choice = Paper (1)
   // Expected output: Loses (-1)
   public static void testCase1() {
       
       IO.outputln("Rock vs Paper");
       IO.outputln("Expected: -1");
       
       Choice choice1 = new Choice(0);
       Choice choice2 = new Choice(1);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }
   
   // You may wish to create some more to test the program.  
   public static void testCase2() {
       
       IO.outputln("Rock vs Scissors");
       IO.outputln("Expected: 1");
       
       Choice choice1 = new Choice(0);
       Choice choice2 = new Choice(2);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }   

   public static void testCase3() {
       
       IO.outputln("Rock vs Rock");
       IO.outputln("Expected: 0");
       
       Choice choice1 = new Choice(0);
       Choice choice2 = new Choice(0);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }
   
   public static void testCase4() {
       
       IO.outputln("Paper vs Paper");
       IO.outputln("Expected: 0");
       
       Choice choice1 = new Choice(1);
       Choice choice2 = new Choice(1);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }
   
   // You may wish to create some more to test the program.  
   public static void testCase5() {
       
       IO.outputln("Paper vs Scissors");
       IO.outputln("Expected: -1");
       
       Choice choice1 = new Choice(1);
       Choice choice2 = new Choice(2);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }   

   public static void testCase6() {
       
       IO.outputln("Paper vs Rock");
       IO.outputln("Expected: 1");
       
       Choice choice1 = new Choice(1);
       Choice choice2 = new Choice(0);
       int result = choice1.compareWith(choice2);
       
       IO.outputln("Actual: " + result);
   }
}
