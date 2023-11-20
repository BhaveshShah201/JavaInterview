package com.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaObjectStream {

	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		EmployeeFactory employeeFactory = new EmployeeFactory();
		employeeList = employeeFactory.getAllEmployee();
		distinctProjectDesc(employeeList);
		firstNameStartWith(employeeList, "b");
		allEmployeeJoinedIn(employeeList, "2023");
		sortByFirstNameAndSalary(employeeList);
	}

	// List all distinct project in non-ascending order.
	public static void distinctProjectDesc(List<Employee> employeeList) {
		List<Project> projects = employeeList.stream().flatMap(emp -> emp.getProjects().stream()).distinct()
				.sorted((a, b) -> b.getName().compareTo(a.getName())).collect(Collectors.toList());
		System.out.println(projects);
	}

	// Print full name of any employee whose firstName starts with ‘A’.
	public static void firstNameStartWith(List<Employee> employeeList, String startWith) {
		List<String> firstNames = employeeList.stream().map(emp -> emp.getFirstName())
				.filter(emp -> emp.toLowerCase().startsWith(startWith.toLowerCase())).collect(Collectors.toList());
		System.out.println(firstNames);
	}

	// List of all employee who joined in year 2023 (year to be extracted from
	// employee id i.e., 1st 4 characters)
	public static void allEmployeeJoinedIn(List<Employee> employeeList, String year) {
		List<String> empList = employeeList.stream().filter(emp -> emp.getId().substring(0, 4).equals(year))
				.map(emp -> emp.getFirstName()).collect(Collectors.toList());
		System.out.println(empList);
	}

	// Sort employees based on firstName, for same firstName sort by salary.
	public static void sortByFirstNameAndSalary(List<Employee> employeeList) {
		List<Employee> empList = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(empList);
	}
}

class Project {
	private String name;
	private String team;
	private String projectManager;

	Project() {
	}

	public Project(String name, String team, String projectManager) {
		this.name = name;
		this.team = team;
		this.projectManager = projectManager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", team=" + team + ", projectManager=" + projectManager + "]";
	}
}

class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private int salary;
	private int totalLaptopsAssigned;
	// OneToMany
	private List<Project> projects;

	Employee() {
	}

	public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
			List<Project> projects) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.totalLaptopsAssigned = totalLaptopsAssigned;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
				+ projects + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getTotalLaptopsAssigned() {
		return totalLaptopsAssigned;
	}

	public void setTotalLaptopsAssigned(int totalLaptopsAssigned) {
		this.totalLaptopsAssigned = totalLaptopsAssigned;
	}
}

class EmployeeFactory extends Employee {

	ArrayList<Employee> employees = new ArrayList<>();

	public List<Employee> getAllEmployee() {
		Project Delta = new Project("Delta Model", "Login", "Robert Downey Jr");
		Project Beta = new Project("Beta Enhancement", "Authentication", "Chris");
		Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
		Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
		Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
		Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
		Project Verification = new Project("Source Verification", "Data", "Pablo");
		Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
		Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
		Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
		Project TwoPhaseDeployment = new Project("Two Phase Deployment", "Deployment", "Shaktiman");

		employees.add(new Employee("2020Emp0234", "Bhaskar", "Sharan", 900000, 1, Arrays.asList(Delta, Beta)));
		employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 3500000, 3,
				Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
		employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3,
				Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
		employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(Delta, TwoFactorAuth)));
		employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3,
				Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
		employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
		employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
		employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
		employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(Delta)));
		employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2,
				Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

		return employees;
	}
}