package oops;

public class RunnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee();
		emp1.Name = "Ramya";
		emp1.EmpId = 100;
		emp1.SetSalary(50000);
		
		
		Employee emp2 = new Employee();
		emp2.Name = "Ashima";
		emp2.EmpId = 101;
		emp2.SetSalary(75000);
		
		
		Employee emp3 = new Employee("Rohini",102,80000);
		
		emp1.Display();
		emp2.Display();
		emp3.Display();

		
		ICICIBank ici1=new ICICIBank();
		ici1.BankID=1001;

		
		HDFCBank hdfc1=new HDFCBank();
		
	}

}
