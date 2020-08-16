package utils;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import model.Employee;
import model.IllegalSalaryException;
import model.IllegalTeamMemberException;
import model.Project;




/**
 *  Implement and test {@link Accounting#projectWeeklyCost(Project)} that respects the following constraints:
 *
 *  <ul>
 *      <li>Every employee gets a bonus of 100 AUD fortnightly for every project.</li>
 *      <li>A project has a fix daily cost of 25 AUD with less than 5 members and 30 AUD after</li>
 *  </ul>
 *
 * Each test criteria must be in an independent test method and named as specified in the README.
 *
 * Initialize the test object with setUp method.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountingProjectTest {

	Accounting acc;

	@BeforeAll
	public void setUp() {		
		acc = new Accounting();
	}

	//checks fortnightly salary for an employee with no project
	//thus should not get a fortnightly bonus as 100 * 0 = 0.
	@Test
	public void calculateFortnightlySalaryNoProject_True_IfValueMatchesFortnightSalary(){
		Employee test1 = new Employee("Joanne Smith", new Date());
		test1.setPerWeekSalary(340);

		double fortnightSalary = 0.0;
		try {
			fortnightSalary = acc.calculateFortnightSalary(test1);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(fortnightSalary, 680.0);
	}

	//checks fortnightly salary for an employee in 1 project (THUS SHOULD HAVE A 100 DOLLAR BONUS)
	//As demonstrated in the above test, without a project, the employee does not have a bonus of 100 dollars
	//However, in the following test, the assert passes meaning the 100 dollars has been added for the one project that the employee is in
	@Test
	public void calculateFortnightlySalaryWithProject_True_IfValueMatchesFortnightSalary() {
		Project testProject = new Project();		
		testProject.setName("Test Project");
		Employee test1 = new Employee("Joanne Smith", new Date());
		try {
			testProject.addTeamMember(test1);
		} catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.setPerWeekSalary(340);
		test1.setNumberOfProjects(1);

		double fortnightSalary = 0.0;
		try {
			fortnightSalary = acc.calculateFortnightSalary(test1);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(fortnightSalary, 780.0);
	}

	//Checks if the fixed daily cost for a project with less than five members is 25 dollars
	@Test
	public void projectWeeklyCost_True_IfLessThanFiveValueMatch() throws IllegalSalaryException, IllegalTeamMemberException{
		Project testProject = new Project();		
		testProject.setName("Test Project");

		Employee test1 = new Employee("James Harland", new Date());
		test1.setPerWeekSalary(540);
		Employee test2 = new Employee("John Doe", new Date());
		test2.setPerWeekSalary(870);

		testProject.addTeamMember(test1);
		testProject.addTeamMember(test2);
		test1.setNumberOfProjects(1);
		test2.setNumberOfProjects(1);

		double projectWeeklyCost = acc.projectWeeklyCost(testProject);//this should be 1535.0
		//calculated the project weekly cost without the fixed cost of 25 dollars
		double valueWithoutFixDailyCost = 1510.0;
		//if assert matches, then shows that there is a fixed daily cost of 25 for projects with less than 5 members
		assertEquals(projectWeeklyCost - valueWithoutFixDailyCost, 25);

	}

	//Checks if the fixed daily cost for a project with less than five members is not 30 dollars
	@Test
	public void projectWeeklyCost_True_IfLessThanFiveValueDoesNotMatch(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		Employee test1 = new Employee("Chelsea Statham", new Date());
		test1.setPerWeekSalary(540);
		Employee test2 = new Employee("Red Rock", new Date());
		test2.setPerWeekSalary(870);

		try {
			testProject.addTeamMember(test1);
			testProject.addTeamMember(test2);
		} catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.setNumberOfProjects(1);
		test2.setNumberOfProjects(1);

		double projectWeeklyCost = 0;
		try {
			projectWeeklyCost = acc.projectWeeklyCost(testProject);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//this should be 1535.0
		//calculated the project weekly cost without the fixed cost of 25 dollars
		double valueWithoutFixDailyCost = 1510.0;
		//if assert doesnt match, then shows that the fixed daily cost isnt 30
		assertNotEquals(projectWeeklyCost - valueWithoutFixDailyCost, 30);

	}

	//Checks if team with no members returns fixed cost of 25
	@Test
	public void projectWeeklyCost_True_IfProjectWeeklyCostMatches(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		try {
			assertEquals(acc.projectWeeklyCost(testProject), 25);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Checks if the fixed daily cost for a project with greater than five members is 30 dollars
	@Test
	public void projectWeeklyCost_True_IfGreaterThanFiveValueMatch(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		//create employees with salaries
		Employee test1 = new Employee("James Harland", new Date());
		test1.setPerWeekSalary(540);
		Employee test2 = new Employee("John Doe", new Date());
		test2.setPerWeekSalary(1000);
		Employee test3 = new Employee("Chelsea Statham", new Date());
		test3.setPerWeekSalary(310);
		Employee test4 = new Employee("Chris Cross", new Date());
		test4.setPerWeekSalary(840);
		Employee test5 = new Employee("Bob Jones", new Date());
		test5.setPerWeekSalary(340);
		Employee test6 = new Employee("Tim Tatman", new Date());
		test6.setPerWeekSalary(230);

		//add them to the team and set their numProjects
		
		try {
			testProject.addTeamMember(test1);
			testProject.addTeamMember(test2);
			testProject.addTeamMember(test3);
			testProject.addTeamMember(test4);
			testProject.addTeamMember(test5);
			testProject.addTeamMember(test6);



		} catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.setNumberOfProjects(1);
		test2.setNumberOfProjects(1);
		test3.setNumberOfProjects(1);
		test4.setNumberOfProjects(1);
		test5.setNumberOfProjects(1);
		test6.setNumberOfProjects(1);

		double projectWeeklyCost = 0;
		try {
			projectWeeklyCost = acc.projectWeeklyCost(testProject);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //this should be 3590.0
		//calculated the project weekly cost without the fixed cost of 30 dollars
		double valueWithoutFixedCost = 3560.0;
		//if assert successful, then shows that there is a fixed daily cost of 30 for projects with greater than 5 members
		assertEquals(projectWeeklyCost - valueWithoutFixedCost, 30);
	}

	//Checks if the fixed daily cost for a project with greater than five members is not 25 dollars
	@Test
	public void projectWeeklyCost_True_IfGreaterThanFiveValueDoesNotMatch(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		//create employees with salaries
		Employee test1 = new Employee("James Harland", new Date());
		test1.setPerWeekSalary(540);
		Employee test2 = new Employee("John Doe", new Date());
		test2.setPerWeekSalary(1000);
		Employee test3 = new Employee("Chelsea Statham", new Date());
		test3.setPerWeekSalary(310);
		Employee test4 = new Employee("Chris Cross", new Date());
		test4.setPerWeekSalary(840);
		Employee test5 = new Employee("Bob Jones", new Date());
		test5.setPerWeekSalary(340);
		Employee test6 = new Employee("Tim Tatman", new Date());
		test6.setPerWeekSalary(230);

		//add them to the team and set their numProjects
		try {
			testProject.addTeamMember(test1);
			testProject.addTeamMember(test2);
			testProject.addTeamMember(test3);
			testProject.addTeamMember(test4);
			testProject.addTeamMember(test5);
			testProject.addTeamMember(test6);
		} catch (IllegalTeamMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test1.setNumberOfProjects(1);
		test2.setNumberOfProjects(1);
		test3.setNumberOfProjects(1);
		test4.setNumberOfProjects(1);
		test5.setNumberOfProjects(1);
		test6.setNumberOfProjects(1);

		double projectWeeklyCost = 0;
		try {
			projectWeeklyCost = acc.projectWeeklyCost(testProject);
		} catch (IllegalSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //this should be 3590.0
		//calculated the project weekly cost without the fixed cost of 30 dollars
		double valueWithoutFixedCost = 3560.0;
		//if assert successful, then shows that there the fixed daily cost is not 25 
		assertNotEquals(projectWeeklyCost - valueWithoutFixedCost, 25);
	}

	//Checks if exception is thrown when an employee of null has their fortnightly salary calculated
	@Test
	public void calculateFortnightSalary_Throws_IfEmployeeisNull(){
		Employee e = null;

		assertThrows(
				IllegalSalaryException.class,
				() -> acc.calculateFortnightSalary(e),
				"Error - This salary is illegal.");
	}

	//Checks if exception is thrown when an employee with a salary of 0 has their fortnightly salary calculated
	@Test
	public void calculateFortnightSalary_Throws_IfEmployeeSalary0(){
		Employee e = new Employee("John Watts", new Date());
		e.setPerWeekSalary(0);

		assertThrows(
				IllegalSalaryException.class,
				() -> acc.calculateFortnightSalary(e),
				"Error - This salary is illegal.");
	}

	//Checks if exception is thrown when removing a team member that isn't in the team
	@Test
	public void removeTeamMember_Throws_IfTeamMemberDoesNotExistInTeam(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		Employee e = new Employee("Janice Smith", new Date());
		e.setPerWeekSalary(250);
		try {
			testProject.addTeamMember(e);
		} catch (IllegalTeamMemberException e2) {
			System.out.println(e2);
		}

		Employee e1 = new Employee("Horice Smith", new Date());
		e.setPerWeekSalary(350);
		
		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.removeTeamMember(e1),
				"Exception: The team member that you have requested to remove is not in the team.");
	}

	//Checks if exception is thrown when removing a team member that is null
	@Test
	public void removeTeamMember_Throws_IfTeamMemberIsNull(){
		Project testProject = new Project();		
		testProject.setName("Test Project");

		Employee e = new Employee("John Johnson", new Date());
		e.setPerWeekSalary(3432);
		try {
			testProject.addTeamMember(e);
		} catch (IllegalTeamMemberException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Employee e1 = null;

		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.removeTeamMember(e1),
				"Exception: The team member to be removed cannot be null.");

	}
	
	//Tests if exception is thrown when added team member already exists in the team
	@Test
	public void canAddTeamMember_Throws_IfTeamMemberAlreadyExists(){
		Project testProject = new Project();		
		testProject.setName("Test Project");
		
		Employee e2 = new Employee("test", new Date());
		try {
			testProject.addTeamMember(e2);
		} catch (IllegalTeamMemberException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.canAddTeamMember(e2),
				"Exception: This team member already exists in the team.");
	}
	
	//Tests if exception is thrown when added team member name is "" (empty string)
	@Test
	public void canAddTeamMember_Throws_IfTeamMemberIsBlank(){
		Project testProject = new Project();		
		testProject.setName("Test Project");
		
		Employee e = new Employee("", new Date());
		
		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.canAddTeamMember(e),
				"Exception: The employee name cannot be blank or null");
	}
	
	//Tests if exception is thrown when added team member name is null
	@Test
	public void canAddTeamMember_Throws_IfTeamMemberNameIsNull(){
		Project testProject = new Project();		
		testProject.setName("Test Project");
		
		Employee e = new Employee(null, new Date());
		
		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.canAddTeamMember(e),
				"Exception: The employee name cannot be blank or null");
	}
	
	//Tests if exception is thrown when added team member itself is null
	@Test
	public void canAddTeamMember_Throws_IfTeamMemberIsNull(){
		Project testProject = new Project();		
		testProject.setName("Test Project");
		
		Employee e = null;
	
		assertThrows(
				IllegalTeamMemberException.class,
				() -> testProject.canAddTeamMember(e),
				"Exception: A team member cannot be null.");
	}
}