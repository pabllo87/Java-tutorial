package CheckingAccount;

public class CheckingAccount {
	String owner; //imiê i nazwisko w³aœciciela konta
	int balance; //iloœæ pieniêdzy, jak¹ mo¿na wyp³aciæ z konta
	static int counter; //statyczny licznik iloœci obiektów
	
	void printBalance()
	{
		int magnitude = (balance < 0) ? -balance : balance;
		String balanceRep = (balance < 0) ? "(" : "";
		balanceRep += magnitude;
		balanceRep += (balance <0) ? ")" : "";
		System.out.println(balanceRep);
	}
	int deposit(int amount)
	{
		return amount;
	}
	int withdraw(int amount)
	{
		return amount;
	}
	
	double sum(double... values)
	{
		return 0;
	}
}
 