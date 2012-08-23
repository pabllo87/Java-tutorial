package kareta;
/**
 * <code>FourOfAKind</code> implementuje gr� karcian� rozgrywan� mi�dzy dwoma graczami:
 * cz�owiekiem i komputerem. Gr� rozgrywa si� przy u�yciu standardowej talii 52 kart,
 * a jej celem jest ogranie komputera w ten spos�b, by jako pierwszy gracz
 * zebra� cztery karty tej samej rangi (na przyk�ad cztery asy).
 * 
 * <p>
 * Gra rozpoczyna si� od potasowania talii kart i po�o�enia jej grzebitem do g�ry.
 * Ka�dy gracz bierze kart� zg�ry talii. Gracz kt�ry wyci�gnie wy�sz� kart�
 * (najwy�sz� kart� jest kr�l), rozdaje cztery karty najpierw drugiemu graczowi,
 * a potem sobie. Nast�pnie gracz, kt�ry rozdawa� karty, rozpoczyna parti�.
 * 
 * <p>
 * Gracz sprawdza karty i ustala, kt�re z nich daj� najwi�ksze szanse na zebranie karety.
 * Nast�pnie gracz odrzuca jedn� kart� na stos kart odrzuconych i pobiera jedn� kart� z g�ry talii.
 * Je�eli gracz zbierze karet�, rzuca wszystkie swoje karty na st�
 * (figurami do g�ry) i wygrywa parti�.
 * 
 * @author Player
 *
 */
public class FourOfAKind {
	/**
	 * Gracz - cz�owiek
	 */
	final static int HUMAN = 0;
	/**
	 * Gracz - komputer
	 */
	final static int COMPUTER = 1;
	/**
	 * G��wna metoda aplikacji.
	 * 
	 * @param args tablica argument�w wiersza polece� przekazanych do metody.
	 */
	public static void main(String[] args)
	{
		System.out.println("Witaj w grze Kareta!");
		Deck deck = new Deck(); // talia jest potasowana automatycznie
		DiscardPile discardPile = new DiscardPile();
		Card hCard;
		Card cCard;
		while (true)
		{
			hCard = deck.deal();
			cCard = deck.deal();
			if (hCard.rank() != cCard.rank())
				break;
			deck.putBack(hCard);
			deck.putBack(hCard);
			deck.shuffle(); // zapobiegnie sytuacji, w kt�rej ka�da nast�pna
							// dw�jka kart ma t� sam� figur�
		}
		int curPlayer = HUMAN;
		if (cCard.rank().ordinal() > hCard.rank().ordinal())
			curPlayer = COMPUTER;
		deck.putBack(hCard);
		hCard = null;
		deck.putBack(cCard);
		cCard = null;
		Card[] hCards = new Card[4];
		Card[] cCards = new Card[4];
		if (curPlayer == HUMAN)
			for (int i = 0; i < 4; i++)
			{
				cCards[i] = deck.deal();
				hCards[i] = deck.deal();
			}
		else
			for (int i = 0; i < 4; i++)
			{
				hCards[i] = deck.deal();
				cCards[i] = deck.deal();
			}
		while (true)
		{
			if (curPlayer == HUMAN)
			{
				showHeldCards(hCards);
				int choice = 0;
				while (choice < 'A' || choice > 'D')
				{
					choice = prompt("Kt�rej karty chcesz si� pozby� (A, B, C, D)?");
					switch(choice)
					{
						case 'a': choice = 'A'; break;
						case 'b': choice = 'B'; break;
						case 'c': choice = 'C'; break;
						case 'd': choice = 'D';
					}
				}
				discardPile.setTopCard(hCards[choice-'A']);
				hCards[choice-'A'] = deck.deal();
				if (isFourOfAKind(hCards))
				{
					System.out.println();
					System.out.println("Cz�owiek wygrywa!");
					System.out.println();
					putDown("Karty cz�owieka", hCards);
					System.out.println();
					putDown("Karty komputera",  cCards);
					return; // wyj�cie z aplikacji przez zako�czenie metody main()
				}
				curPlayer = COMPUTER;
			}
			else
			{
				int choice = leastDesirableCard(cCards);
				discardPile.setTopCard(cCards[choice]);
				cCards[choice] = deck.deal();
				if (isFourOfAKind(cCards))
				{
					System.out.println();
					System.out.println("Komputer wygrywa!");
					System.out.println();
					putDown("Karty komputera",  cCards);
					return; // wyj�cie z aplikacji przez zako�czenie metody main()
				}
				curPlayer = HUMAN;
			}
			if (deck.isEmpty())
			{
				while (discardPile.topCard() != null)
					deck.putBack(discardPile.getTopCard());
				deck.shuffle();
			}
		}
	}
	/**
	 * Sprawdza, czy wszystkie obiekty kart <code>Card</code>
	 * przekazane do metody maj� t� sam� rang�.
	 * 
	 * @param cards tablica obiekt�w <code>Card</code> przekazana do metody.
	 * 
	 * @return true, je�li wszystkie obiekty <code>Card</code> maj� t� sam� rang�;
	 * w przeciwnym razie false
	 */
	static boolean isFourOfAKind(Card[] cards)
	{
		for (int i = 1; i < cards.length; i++)
			if (cards[i].rank() != cards[0].rank())
				return false;
		return true;
	}
	/**
	 * Wskazuje jedn� kart� <code>Card</code> spo�r�d kart przekazanych do metody.
	 * kt�ra jest kart� najmniej po��dn� do dalszego przetrzymywania.
	 * 
	 * @param cards tablica obiekt�w <code>Card</code> przekazana do metody.
	 * 
	 * @return najmniej po��dana karta (0 to as, kr�l to 13)
	 */
	static int leastDesirableCard(Card[] cards)
	{
		int[] rankCounts = new int[13];
		for (int i = 0; i < cards.length; i++)
			rankCounts[cards[i].rank().ordinal()]++;
		int minCount = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < rankCounts.length; i++)
			if(rankCounts[i] < minCount && rankCounts[i] != 0)
			{
				minCount = rankCounts[i];
				minIndex = i;
			}
		for (int i = 0; i < cards.length; i++)
			if (cards[i].rank().ordinal() == minIndex)
				return i;
		return 0;  //wy��cznie dla kompilatora (instrukcja nigdy nie powinna zosta� wykonana)
	}
	/**
	 * Pro�ba dla gracza, aby wpisa� znak
	 * 
	 * @param msg komunikat prezentowany graczowi.
	 * 
	 * @return warto�� ca�kowitoliczbowa znaku wpisanego przez gracza.
	 */
	static int prompt(String msg)
	{
		System.out.print(msg);
		try
		{
			int ch = System.in.read();
			//Usuni�cie wszystkich kolejnych znak�w, w tym ko�cz�cego znaku \n,
			//aby nie wp�ywa�y one na kolejne wywo�anie metody prompt();
			while (System.in.read() != '\n');
			return ch;
		}
		catch (java.io.IOException ioe)
		{
		}
		return 0;
	}
	/**
	 * Wy�wietlenie komunikatu i wszystkich kart posiadanych przez gracza.
	 * Odpowiada rzuceniu wszystkich kart na st�.
	 * 
	 * @param msg komunikat wy�wietlany graczowi.
	 * @param cards tablica obiekt�w <code>Card</code> rzucanych na st�.
	 */
	static void putDown(String msg, Card[] cards)
	{
		System.out.println(msg);
		for (int i = 0; i < cards.length; i++)
			System.out.println(cards[i]);
	}
	/**
	 * Wy�wietlenie posiadanych kart <code>Card</code> w oddzielnych wierszach.
	 * Ka�dy wiersz rozpoczyna si� od litery <code>A</code>.
	 * 
	 * @param cards tablica obiekt�w <code>Card</code>
	 */
	static void showHeldCards(Card[] cards)
	{
		System.out.println();
		System.out.println("Posiadane karty:");
		for (int i = 0; i < cards.length; i++)
			if (cards[i] != null)
				System.out.println((char) ('A'+i) + ". " + cards[i]);
		System.out.println();
	}
}
