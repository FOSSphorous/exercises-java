import java.lang.Runtime; // A method is used to check program exit/shutdown status
import java.util.concurrent.TimeUnit; // Used to delay execution for specified amount of time

/**
 * Write a program that counts up and prints to console
 * "fizz" when a number is divisible by three, and "buzz" when
 * divisible by five -- output should be "fizzbuzz" when divisible
 * by both three and five.
 *
 * Practice with using a language's features to solve a common
 * logic problem asked in coding  interviews.
 *
 * @author FOSSphorous
 * 
 * Status: Working (WIP)
 */

public class FizzBuzzMain {

	public static void main(String[] args) {


		// variable initiates an incremental count from this number upwards
		int countTracker = 1;
		
		while(true){ // Perform actions indefinitely
			System.out.print(countTracker + ": "); // Display status of current number in count
			fizzBuzzer(countTracker); // Performs check on divisibility of number, prints fizz/buzz to console
			countTracker++; // Increment count by 1
			delaySecond(); // Delay program execution for 1 second to allow user to register results
			
			// Try to exit gracefully if program is shut down with CTRL-C or other interrupt
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				System.out.println("Exiting program..."); // Standard program exit (Spams console occasionally?)
			}));
			
		}
	}

	/**
	 * Check for numbers divisible by 3 for fizz condition
	 * and/or 5 for buzz condition, print status console
	 * to console.
	 *
	 * @param int
	 *
	 * Status: Working
	 */
	private static void fizzBuzzer(int counter){
		// Initialize fizz & buzz variables to check for divisibility
		final int FIZZER = 3,
			  BUZZER = 5,
			  COMPARISON_VALUE = 0; // Modulo operations result in remainder of zero when nums are cleanly divisble.

		// If divisible by FIZZER, print "fizz"
		if (COMPARISON_VALUE == counter % FIZZER) {
			System.out.print("fizz");
		}
		// If divisible by BUZZER, print "buzz"
		if (COMPARISON_VALUE == counter % BUZZER) {
			System.out.print("buzz");
		}
		
		System.out.print("\n"); // Formatting after uses of non-delimiting print
	}
	
	/**
	 * Stall execution of program logic for specified amount of seconds.
	 *
	 * Status: Working
	 */
	private static void delaySecond(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
