package CheckingAccount;

public class CheckingAccount {
	String owner; //imi� i nazwisko w�a�ciciela konta
	int balance; //ilo�� pieni�dzy, jak� mo�na wyp�aci� z konta
	static int counter; //statyczny licznik ilo�ci obiekt�w
	
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
 