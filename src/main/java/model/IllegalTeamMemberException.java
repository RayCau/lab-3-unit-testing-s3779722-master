package model;

/**
 * Signals the employee can not be added to a Team.
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class IllegalTeamMemberException extends Exception{
	public IllegalTeamMemberException(String message) {
		super(message);
	}
}
