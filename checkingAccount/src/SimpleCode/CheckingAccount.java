package SimpleCode;

public class CheckingAccount {
	String owner; //imi� i nazwisko w�a�ciciela konta
	int balance; //ilo�� pieni�dzy, jak� mo�na wyp�aci� z konta
	static int counter; //statyczny licznik ilo�ci obiekt�w
	
	public CheckingAccount(String acctOwner, int acctBalance) {
		owner = acctOwner;
		balance = acctBalance;
		counter++;
	}
	
	public CheckingAccount(String acctOwner) {
		this(acctOwner, 100);
	}
	
	CheckingAccount printBalance()
	{
		if(balance < 0)
			System.out.println("("+ -balance + ")");
		else
		if (balance == 0)
			System.out.println("zero balance");
		else
			System.out.println(balance);
		return this;
	}
//	int deposit(int amount)
//	{
//		if(amount <= 0)
//		{
//			System.out.println("nie mo�na obci��y� konta warto�ci� zerow� lub ujemn�");
//			return balance;
//		}
//		balance += amount;
//		return balance;
//	}
	
	CheckingAccount deposit(int amount)
	{
		balance += amount;
		return this;
	}
	int withdraw(int amount)
	{
		return amount;
	}
	
	double sum(double... values)
	{
		int total = 0;
		for(int i = 0; i < values.length; i++)
		{
			total += values[i];
		}
		return total;
	}
}
 