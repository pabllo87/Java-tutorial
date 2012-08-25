package CheckingAccount;

public class Compass {
	static final int POLNOC = 0;
	static final int POLUDNIE = 1;
	static final int ZACHOD = 2;
	static final int WSCHOD = 3;
	void printDirection(int dir)
	{
		switch(dir)
		{
		case POLNOC : System.out.println("Idziesz na pó³noc"); break;
		case POLUDNIE : System.out.println("Idziesz na poludnie"); break;
		case ZACHOD : System.out.println("Idziesz na zachód"); break;
		case WSCHOD : System.out.println("Idziesz na wschód"); break;
		default : System.out.println("Kierunek nieznany");
		}
	}
}
