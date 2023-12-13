//package collectQuizScore;
import java.util.Scanner;

/**
 * This program will get a quiz score from the user's input
 * and display whether the value is valid input within a range
 * of 0-20 (inclusive).
 * 
 * Practice using loops, if-else statements, collecting user input, and try-catch error handling.
 * 
 * @author FOSSphorous
 * 
 * Status: Working
 */

public class CollectQuizScoreMain {

	public static void main(String[] args) {

		// instantiate program variables
		int inputQuizScore; // Quiz's score. User input
		final int RANGE_SCORE_MIN = 0, RANGE_SCORE_MAX = 20; // minumum and max allowable values for the quiz score. Constant
		boolean CLOSE_PROGRAM = false; // Used to control while loop state, and close program on non-numeric input (expected as being any raised exception)

		Scanner keyboard = new Scanner(System.in); // user input source (the keyboard)

		System.out.println("\nNumbers only please!! Any non-numeric values entered will end this script.\n");
		System.out.printf("Valid quiz scores are considered values within the range of %d-%d\n", RANGE_SCORE_MIN, RANGE_SCORE_MAX);
		
		// Loop the program to collect+evaluate user input until an error/exception is caught
		while (false == CLOSE_PROGRAM){
			try{
				System.out.print("What was your quiz score?: ");
				inputQuizScore = keyboard.nextInt(); // collect quiz score from user input (keyboard)

				/*
				// if user inputs a score greater than or equal to range minimum, and it is less than or equal to range maximum print valid. otherwise print invalid
				if (inputQuizScore >= RANGE_SCORE_MIN  &&  inputQuizScore <= RANGE_SCORE_MAX) {
					System.out.println(inputQuizScore + " is a valid score.\n");
				} else {
					System.out.println(inputQuizScore + " is an invalid score.\n");
				}
				*/
		
				// if user inputs a score less than range minimum or greater than range max print invalid score. else print valid score 
				if ( inputQuizScore < RANGE_SCORE_MIN || inputQuizScore > RANGE_SCORE_MAX) {
					System.out.println(inputQuizScore + " is an invalid score.\n");
				} else {
					System.out.println(inputQuizScore + " is a valid score.\n");
				}
		
			} catch (Exception e) {
				keyboard.close(); // stop reading from/close user input source
				CLOSE_PROGRAM = true; // An exception is expected to initiate the close of this program
			}
		}

		// Standard program exit
		System.out.println("\nExiting...");
	}

}
