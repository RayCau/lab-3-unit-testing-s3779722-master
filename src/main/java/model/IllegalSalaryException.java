package model;

/**
 * Signals that the Salary for an Employee is invalid.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class IllegalSalaryException extends Exception{
	public IllegalSalaryException(String message) {
		super(message);
	}
}
