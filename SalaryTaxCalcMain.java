//package salaryTaxCalc;
import java.util.Scanner; // Used to collect input from user

/**
 * This program collects user input from the keyboard for an employee name,
 * hours worked, hourly wage, and computes from that their regular pay (including taxes),
 * gross pay (before taxes), overtime pay, federal tax deduction, state tax deduction, and
 * net pay.
 *
 * Practice with collecting + utilizing user input, print formatting/rounding floats,
 * conditional if-statements, and simple mathematic operations.
 * 
 * @author FOSSphorous
 * 
 * Status: Working (WIP)
 */
public class SalaryTaxCalcMain {

	public static void main(String[] args) {
		// Employees name. Employees number of hours worked, and wage. User input from keyboard.
		String inputEmployeeName;
		double inputEmployeeHoursWorked, inputEmployeeWage;

		/* hours worked in excess of typical week (worth more than regular hours)
		 * employee's pay over regular, and overtime hours. gross pay (total before tax), and net pay (after tax)
		 * values are calculated.
		 */
		double workedCalcHoursOvertime;
		double payCalcHoursRegular, payCalcHoursOvertime, payCalcGross, payCalcNet;

		/* overtime pay (150%) rate to be added. federal tax (10%), state tax (5%) rates to be deducted.
		 * The regular work week hours, earns normal pay
		 * Values are static.
		 */
		final double PAY_RATE_OVERTIME = 1.50, TAX_RATE_FEDERAL = 0.10, TAX_RATE_STATE = 0.05; 
		final double REGULAR_HOURS = 40.0;

		// instantiate user input source (the user's keyboard)
		Scanner keyboard = new Scanner(System.in);

		// Get user input to store in respective variables
		System.out.print("Please enter the employee\'s name: ");
		inputEmployeeName = keyboard.nextLine();

		System.out.print("How many hours have they worked this week?: ");
		inputEmployeeHoursWorked = keyboard.nextDouble();

		System.out.print("What is their hourly wage?: "); // User is currently allowed to input negative hours
		inputEmployeeWage = keyboard.nextDouble();
		// Stop collection from the user input source (the keyboard)
		keyboard.close();
		// Echo the user's variables as formatted terminal output
		System.out.println("\n\nEmployee Name: " + inputEmployeeName 
				+ "\nHours worked: " + inputEmployeeHoursWorked
				+ "\nHourly Wage: $" + inputEmployeeWage + "/hr");
		/* if hours are greater than/equal to 0 & less than/equal to REGULAR_HOURS, pay is at regular rate
		 * when hours worked are greater than REGULAR_HOURS, overtime pay worth a greater % for the extra
		 * 
		 * if hours worked are less than 0 or a value otherwise unaccounted for in calculations, then notify user of an error 
		 */
		if (inputEmployeeHoursWorked >= 0 && inputEmployeeWage >= 0) {

			if (inputEmployeeHoursWorked > REGULAR_HOURS) {
				workedCalcHoursOvertime = inputEmployeeHoursWorked - REGULAR_HOURS; // calculate hours worked overtime
			} else {
				workedCalcHoursOvertime = 0; // There are no overtime hours to calculate in any other case
			} 

			System.out.printf("%s worked %s hours of overtime.", inputEmployeeName, workedCalcHoursOvertime);
			// Adjust employee's hours to separate overtime from regular pay
			inputEmployeeHoursWorked = inputEmployeeHoursWorked - workedCalcHoursOvertime;
			// Add calculated regular pay to calculated overtime pay
			payCalcHoursOvertime = workedCalcHoursOvertime * (inputEmployeeWage * PAY_RATE_OVERTIME); // earnings during overtime hours with wage at overtime rate
			payCalcHoursRegular = inputEmployeeHoursWorked * inputEmployeeWage; // earnings during regular hours with wage at standard (unaltered) rate
			payCalcGross = payCalcHoursRegular + payCalcHoursOvertime; // Gross (total unadjusted) earnings over work period
			// Add federal & state taxed off of gross together, & deduct from gross. Store as Net (adjusted/received) pay
			payCalcNet = payCalcGross - ((payCalcGross * TAX_RATE_FEDERAL) + (payCalcGross * TAX_RATE_STATE));
		} else {
			// There is nothing to calculate here, as the hours are out of bounds
			payCalcGross = 0;
			payCalcNet = 0;
			System.out.println("Sorry, but it seems this program has run into an error in its calculations. Please check your input and try again.");
			System.exit(0);
		}

		// "string's Gross Pay: $" + float rounded to .00 (nearest cent)
		System.out.printf("\n"
				+ "%s\'s Gross Pay: $" 
				+ "%.2f", inputEmployeeName, payCalcGross);
		// "employees's Net Pay: $" + rounded float
		System.out.printf("\n"
				+ "%s\'s Net Pay: $"
				+ "%.2f", inputEmployeeName, payCalcNet);

		// Standard exit
		System.out.println("\n\nExiting program.");
	}
}
