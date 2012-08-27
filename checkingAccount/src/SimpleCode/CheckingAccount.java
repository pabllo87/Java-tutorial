package SimpleCode;

public class CheckingAccount {
	String owner; //imiê i nazwisko w³aœciciela konta
	int balance; //iloœæ pieniêdzy, jak¹ mo¿na wyp³aciæ z konta
	static int counter; //statyczny licznik iloœci obiektów
	
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
//			System.out.println("nie mo¿na obci¹¿yæ konta wartoœci¹ zerow¹ lub ujemn¹");
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
 