package utils;

import model.Employee;
import model.IllegalSalaryException;
import model.Project;

/**
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class Accounting {

    /**
     * Calculates the  Fortnight Salary of an Employee.
     * @param employee Employee to calculate the salary for.
     * @return Fortnightly Salary of the Employee.
     * @throws IllegalSalaryException 
     */
    public double calculateFortnightSalary(Employee employee) throws IllegalSalaryException{
    	double fortnightWithBonus = 0.0;
    	String exceptionMessage = "";
    	if(employee != null && employee.getPerWeekSalary() != 0) {
    			fortnightWithBonus = (employee.getPerWeekSalary() * 2) + (100.0*employee.getNumberOfProjects());
    	}else {
    		exceptionMessage = "Error - This salary is illegal.";
    		throw new IllegalSalaryException(exceptionMessage);
    	}
    	return fortnightWithBonus;
    }

    /**
     * Calculates the costs of a project taking in consideration the salary and bonuses of team members
     * @param project Project to calculate the cost for.
     * @return the Weekly Cost of the project
     * @throws IllegalSalaryException 
     */
    public double projectWeeklyCost(Project project) throws IllegalSalaryException{
        double projCost  = 0.0;
        int numMembers = project.getTeam().size();
        if(numMembers < 5) {
        	projCost = 25.0;
        	//loop through all members and add their salary plus half the bonus
        	for(int i = 0; i < numMembers; i++) {
        		projCost += (50 + project.getTeam().get(i).getPerWeekSalary());
        	}
        }
        else{
        	projCost = 30.0;
        	for(int i = 0; i < numMembers; i++) {
        		projCost += (50 + project.getTeam().get(i).getPerWeekSalary());
        	}
        }
    	return projCost;
    }


}
