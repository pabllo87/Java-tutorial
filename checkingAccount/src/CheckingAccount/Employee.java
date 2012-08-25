package CheckingAccount;

class Date
{
	int year, month, day;
	Date(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
}

public class Employee implements Cloneable{
	final static int RETIREMENT_AGE = 65;
	private String firstName;
	private String lastName;
	int salary;
	int age;
	Date hireDate;
	
	public Employee(String name, int age, Date hireDate)
	{
		setName(name);
		this.age = age;
		this.hireDate = hireDate;
	}
	public Employee(String firstName, String lastName, int age, Date hireDate)
	{
		setName(firstName + " " + lastName);
		this.age = age;
		this.hireDate = hireDate;
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
	
	@Override protected Object clone() throws CloneNotSupportedException
	{
		Employee emp = (Employee) super.clone();
		if (hireDate != null) // klonowanie obiektu null (czyli takiego, który nie istnieje)
							  // nie ma sensu
			emp.hireDate = new Date(hireDate.year, hireDate.month, hireDate.day);
		return emp;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Employee e1 = new Employee("Jan Kowalski", 46, new Date(2000, 1, 20));
		Employee e2 = (Employee) e1.clone();
		System.out.println(e1==e2); // wynik false
		System.out.println(e1.firstName == e2.firstName); // wynik true
		System.out.println(e1.hireDate==e2.hireDate); // wynik false
		System.out.println(e2.hireDate.year + " " + e2.hireDate.month + " " + e2.hireDate.day); // wynik 2000 1 20
	}
}
