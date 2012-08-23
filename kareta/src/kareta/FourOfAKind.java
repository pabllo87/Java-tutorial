package kareta;
/**
 * <code>FourOfAKind</code> implementuje grê karcian¹ rozgrywan¹ miêdzy dwoma graczami:
 * cz³owiekiem i komputerem. Grê rozgrywa siê przy u¿yciu standardowej talii 52 kart,
 * a jej celem jest ogranie komputera w ten sposób, by jako pierwszy gracz
 * zebraæ cztery karty tej samej rangi (na przyk³ad cztery asy).
 * 
 * <p>
 * Gra rozpoczyna siê od potasowania talii kart i po³o¿enia jej grzebitem do góry.
 * Ka¿dy gracz bierze kartê zgóry talii. Gracz który wyci¹gnie wy¿sz¹ kartê
 * (najwy¿sz¹ kart¹ jest król), rozdaje cztery karty najpierw drugiemu graczowi,
 * a potem sobie. Nastêpnie gracz, który rozdawa³ karty, rozpoczyna partiê.
 * 
 * <p>
 * Gracz sprawdza karty i ustala, które z nich daj¹ najwiêksze szanse na zebranie karety.
 * Nastêpnie gracz odrzuca jedn¹ kartê na stos kart odrzuconych i pobiera jedn¹ kartê z góry talii.
 * Je¿eli gracz zbierze karetê, rzuca wszystkie swoje karty na stó³
 * (figurami do góry) i wygrywa partiê.
 * 
 * @author Player
 *
 */
public class FourOfAKind {
	/**
	 * Gracz - cz³owiek
	 */
	final static int HUMAN = 0;
	/**
	 * Gracz - komputer
	 */
	final static int COMPUTER = 1;
	/**
	 * G³ówna metoda aplikacji.
	 * 
	 * @param args tablica argumentów wiersza poleceñ przekazanych do metody.
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
			deck.shuffle(); // zapobiegnie sytuacji, w której ka¿da nastêpna
							// dwójka kart ma tê sam¹ figurê
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
					choice = prompt("Której karty chcesz siê pozbyæ (A, B, C, D)?");
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
					System.out.println("Cz³owiek wygrywa!");
					System.out.println();
					putDown("Karty cz³owieka", hCards);
					System.out.println();
					putDown("Karty komputera",  cCards);
					return; // wyjœcie z aplikacji przez zakoñczenie metody main()
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
					return; // wyjœcie z aplikacji przez zakoñczenie metody main()
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
	 * przekazane do metody maj¹ tê sam¹ rangê.
	 * 
	 * @param cards tablica obiektów <code>Card</code> przekazana do metody.
	 * 
	 * @return true, jeœli wszystkie obiekty <code>Card</code> maj¹ tê sam¹ rangê;
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
	 * Wskazuje jedn¹ kartê <code>Card</code> spoœród kart przekazanych do metody.
	 * która jest kart¹ najmniej po¿¹dn¹ do dalszego przetrzymywania.
	 * 
	 * @param cards tablica obiektów <code>Card</code> przekazana do metody.
	 * 
	 * @return najmniej po¿¹dana karta (0 to as, król to 13)
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
		return 0;  //wy³¹cznie dla kompilatora (instrukcja nigdy nie powinna zostaæ wykonana)
	}
	/**
	 * Proœba dla gracza, aby wpisa³ znak
	 * 
	 * @param msg komunikat prezentowany graczowi.
	 * 
	 * @return wartoœæ ca³kowitoliczbowa znaku wpisanego przez gracza.
	 */
	static int prompt(String msg)
	{
		System.out.print(msg);
		try
		{
			int ch = System.in.read();
			//Usuniêcie wszystkich kolejnych znaków, w tym koñcz¹cego znaku \n,
			//aby nie wp³ywa³y one na kolejne wywo³anie metody prompt();
			while (System.in.read() != '\n');
			return ch;
		}
		catch (java.io.IOException ioe)
		{
		}
		return 0;
	}
	/**
	 * Wyœwietlenie komunikatu i wszystkich kart posiadanych przez gracza.
	 * Odpowiada rzuceniu wszystkich kart na stó³.
	 * 
	 * @param msg komunikat wyœwietlany graczowi.
	 * @param cards tablica obiektów <code>Card</code> rzucanych na stó³.
	 */
	static void putDown(String msg, Card[] cards)
	{
		System.out.println(msg);
		for (int i = 0; i < cards.length; i++)
			System.out.println(cards[i]);
	}
	/**
	 * Wyœwietlenie posiadanych kart <code>Card</code> w oddzielnych wierszach.
	 * Ka¿dy wiersz rozpoczyna siê od litery <code>A</code>.
	 * 
	 * @param cards tablica obiektów <code>Card</code>
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
