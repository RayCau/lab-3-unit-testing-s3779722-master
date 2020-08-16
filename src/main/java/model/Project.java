package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project inside the company.
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class Project {
	/**
	 * Name the this project
	 */
	private String name;

	/**
	 * Project start
	 */
	private Date startDate;

	/**
	 * Project maximum end date
	 */
	private Date dueDate;

	/**
	 * Estimated duration of the project in DAYS (WEEKENDS INCLUDED)
	 */
	private int estimatedDuration;

	/**
	 * Team allocated to this project
	 */
	private List<Employee> team = new ArrayList<Employee>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getEstimatedDuration() {
		return estimatedDuration;
	}

	public void setEstimatedDuration(int estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	public List<Employee> getTeam() {
		return team;
	}


	/**
	 * Adds a new member to the team
	 * @param employee the employee to add as member
	 * @return true if the Employee was successfully added to the team, false otherwise
	 * @throws IllegalTeamMemberException 
	 */

	public boolean addTeamMember(Employee employee) throws IllegalTeamMemberException{
		boolean added = false;
		if(canAddTeamMember(employee)){
			team.add(employee);
			added = true;
		}
		return added;
	}

	public boolean removeTeamMember(Employee employee) throws IllegalTeamMemberException{	
		boolean removed = false;
		String errorMessage = "";
		//removes the first instance found of employee with same name as parameter
		if(employee != null) {
			for(int i = 0; i < team.size(); i++) {
				if(employee.getName().equals(team.get(i).getName())) {
					team.remove(i);
					removed = true;
				    return removed;
				}else {
					errorMessage = "Exception: The team member that you have requested to remove is not in the team.";
					throw new IllegalTeamMemberException(errorMessage);
				}
			}
		}else {
			errorMessage = "Exception: The team member to be removed cannot be null.";
			throw new IllegalTeamMemberException(errorMessage);
		}
		return removed;
	}

	/**
	 * Verifies the Project has valid dates.
	 * @return true if dates are valid, false otherwise.
	 */
	public boolean isValidDates(){
		//Sets the current date for checking
		Date currDate = new Date();
		boolean valid = false;

		if(!dueDate.before(currDate) && startDate.before(dueDate)) {
			valid = true;
		}
		return valid;
	}

	/**
	 * Verifies that an employee can be added as team member
	 * @return true if the Employee can be added to the team, false otherwise.
	 * @throws IllegalTeamMemberException 
	 */
	public boolean canAddTeamMember(Employee employee) throws IllegalTeamMemberException{
		boolean addMember = false;
		String errorMessage = "";
		if(employee != null) {
			if(employee.getName() != "" && employee.getName() != null){
				if (!team.contains(employee)) {
					addMember = true;
				} else {
					errorMessage = "Exception: This team member already exists in the team.";
					throw new IllegalTeamMemberException(errorMessage);
				}
			}
			else {
				errorMessage = "Exception: The employee name cannot be blank or null";
				throw new IllegalTeamMemberException(errorMessage);
			}
		}else {
			errorMessage = "Exception: A team member cannot be null.";
			throw new IllegalTeamMemberException(errorMessage);
		}
		return addMember;
	}
}
