# Software Engineering Fundamentals - Lab #3: Unit Testing

**Time:** 30 minutes

**Weighting:** 13.5

This assessment is part of the individual assessments of the course. There are 5 of them, but we only count the best 4 out of 5. That means that the worst result won't be taken into account.

Also, you cannot sit the assessment twice: you must sit for the assessment during your corresponding tutorial class.


<br />


## Introduction

This assessment evaluates the following CLOs:

- CLO 1: Explain and apply the main aspects of software engineering.
- CLO 5: communicate effectively with others, especially regarding the progress of the system development and the content of the design by means of reports and presentations.

The following topics are assessed:
- Unit Testing


<br />


## About the Assessment

In this assessment you will need to implement the functionalities and verify you code using unit testing to ensure specifications are met. **IMPORTANT: Provided code may include bugs that you need to detect and fix**.

<br />

### Naming Convention
Use the following naming convention for your tests:

```
MethodName_ExpectedBehavior_StateUnderTest
```

For example:
```
isValid_False_IfMandatoryFieldsMissing
calculateBonus_ThrowsException_IfNotValidEmployee
```


<br />

### Warning: No Dummy Tests
The use of "dummy tests" is _not_ allowed. If you have dummy tests or dummy returns in your classes you will _fail_ the assignment.

**What is a dummmy test?**

This test will always pass, regardless of the content of the classes (model). In short words, a dummy test _tests nothing_! Any type of dummy test is forbidden and will make you fail the assignment.

```java
// This is a dummy test in java
public void isValid_False_IfMandatoryFieldsMissing() {
    assertTrue(true);
}
```

<br />

**What are dummy returns?**

This refers to hard-coding a return in a class and you only test that very same return. This way, the test will always pass, but tests nothing!


<br />

## Assignment Instructions

The Company is developing a software tool to manage employees and projects developed within the company.  You are part of the scrum team developing the solution.

1. **Complete the Behaviour in Classes.** The folders 'java/model' and 'java/utils' have some classes with default/fixed returns. You need to complete these classes. _You are required to ONLY complete those that are directly linked to the test you need to do_. **Note:** The quality of the code you put here will influence your marking. Refer to the Rubric.

2. **Test your Code.** There is a class in 'test/java/*'. You need to fill the tests according to the following instructions. **Note:** name the tests using the _naming convention_ defined above. 

    - The method you use in the test class to initialize the objects during the testing, needs to be tagged `@BeforeAll`.
  
    - Each method that contains an assert, needs to be tagged `@Test`.
    
    - You _must_ tag your tests. That is an important part of testing.
    
    - Maven is already set up. The test should run when you do `mvn test`.
    

3. **What to test?** See subsection "Your Test Case".

4. **Autograding Email**. After every push to the main repository, GitHub will automatically run your tests if they are properly tagged. Some Q/A about this:

    - _What does a "tests/build failed" means?_ That means your tests are not working. You need to fix your tests, or your tagging, and push again.
    
    - _My tests passed! Does this mean I passed the assigment?_ <span style="color:red">**No, it doesn't: having tests that pass does not mean that you have passed the assigment**</span>. This only means that your tests run and detect no erros. Tutors will individually double check the code to mark your assigment. Please, refer to the Rubric. 

  


### Your test case:

Implement and test `Accounting.projectWeeklyCost(Project)` that respects the following constraints:
 * Every employee gets a bonus of 100 AUD fortnightly for every project.
 * A project has a fix daily cost of 25 AUD with less than 5 members and 30 AUD after
 
 Each test criteria must be in an independent test method and named as specified in the README.

Initialize the test object with `setUp` method.





<br />

## Rubric

| HD     | DI     | CR     | PA     | F      |
| ------ | ------ | ------ | ------ | ------ |
| Flawless testing (borderline and common cases, with perfect organisation), code quality and organisation. All tests pass. No dymmy tests or returns. | Professional quality testing (borderline and common cases, with great organisation), code quality and organisation. No dummy tests or returns. | There are correct tests for both borderline and core (common) cases, but code organisation is not the best. Model classes code quality and organisation is not the best. No dummy tests or returns. | All tests pass, but only common cases were provided. Code organisation is minimal. No dummy tests or returns. | It is not submitted, there are dummy tests or returns, tests don't pass, or the model is incomplete. |




