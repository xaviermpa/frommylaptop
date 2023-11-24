package oops;

public class Employee {
	
	public String Name;
	public int EmpId;
	private int Salary;
	
	public void Display() {
		
		System.out.println("Name of the employee is " + Name);
		System.out.println("Id of the employee is " + EmpId);
		System.out.println("Salary of the employee is " + Salary);
	}
	
	public void SetSalary(int sal) {
		
		this.Salary = sal;
	}
	
	// Default cons
	public Employee() {
		
		System.out.println("Inside default cons");
	}
	
	
	// parameterized cons
	public Employee(String Name1,int EmpId1, int Salary1) {
		
		System.out.println("Inside param cons");
		
		this.Name = Name1;
		this.EmpId = EmpId1;
		this.Salary = Salary1;
				
	}

}
