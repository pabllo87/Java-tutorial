package CheckingAccount;

public class Employee {
	final static int RETIREMENT_AGE = 65;
	private String firstName;
	private String lastName;
	int salary;
	
	public Employee(String name)
	{
		setName(name);
	}
	public Employee(String firstName, String lastName)
	{
		setName(firstName + " " + lastName);
	}
	
	public void setName(String empName)
	{
		setFirstName(empName.substring(0, empName.indexOf(' ')));
		setLastName(empName.substring(empName.indexOf(' ')+1));
	}
	public String getName()
	{
		return getFirstName() + " " + getLastName();
	}
	
	void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	String getFirstName()
	{
		return firstName;
	}
	
	void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	String getLastName()
	{
		return lastName;
	}
	
	void setSalary(int empSalary)
	{
		if (empSalary < 0){
			System.out.println("Pensja nie mo¿e byæ ujemna");
			return;
		}
		salary = empSalary;
	}
}
