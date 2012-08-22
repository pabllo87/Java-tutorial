package kareta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
*Symulacja talii kart
*/
public class Deck
{
	private Card[] cards = new Card[]
	{
			Card.AS_TREFL,
			Card.DWÓJKA_TREFL,
			Card.TRÓJKA_TREFL,
			Card.CZWÓRKA_TREFL,
			Card.PI¥TKA_TREFL,
			Card.SZÓSTKA_TREFL,
			Card.SIÓDEMKA_TREFL,
			Card.ÓSEMKA_TREFL,
			Card.DZIEWI¥TKA_TREFL,
			Card.DZIESI¥TKA_TREFL,
			Card.WALET_TREFL,
			Card.KRÓLOWA_TREFL,
			Card.KRÓL_TREFL,
			Card.AS_KARO,
			Card.DWÓJKA_KARO,
			Card.TRÓJKA_KARO,
			Card.CZWÓRKA_KARO,
			Card.PI¥TKA_KARO,
			Card.SZÓSTKA_KARO,
			Card.SIÓDEMKA_KARO,
			Card.ÓSEMKA_KARO,
			Card.DZIEWI¥TKA_KARO,
			Card.DZIESI¥TKA_KARO,
			Card.WALET_KARO,
			Card.KRÓLOWA_KARO,
			Card.KRÓL_KARO,
			Card.AS_KIER,
			Card.DWÓJKA_KIER,
			Card.TRÓJKA_KIER,
			Card.CZWÓRKA_KIER,
			Card.PI¥TKA_KIER,
			Card.SZÓSTKA_KIER,
			Card.SIÓDEMKA_KIER,
			Card.ÓSEMKA_KIER,
			Card.DZIEWI¥TKA_KIER,
			Card.DZIESI¥TKA_KIER,
			Card.WALET_KIER,
			Card.KRÓLOWA_KIER,
			Card.KRÓL_KIER,
			Card.AS_PIK,
			Card.DWÓJKA_PIK,
			Card.TRÓJKA_PIK,
			Card.CZWÓRKA_PIK,
			Card.PI¥TKA_PIK,
			Card.SZÓSTKA_PIK,
			Card.SIÓDEMKA_PIK,
			Card.ÓSEMKA_PIK,
			Card.DZIEWI¥TKA_PIK,
			Card.DZIESI¥TKA_PIK,
			Card.WALET_PIK,
			Card.KRÓLOWA_PIK,
			Card.KRÓL_PIK
	};
	
	private List<Card> deck;
	/**
	 * Tworzy taliê <code>Deck</code> 52 kart <code>Card</code>.
	 * Tasuje obiekty kart.
	 */
	public Deck()
	{
		deck = new ArrayList<Card>();
		for(int i = 0; i < cards.length; i++){
			deck.add(cards[i]);
			cards[i] = null;
		}
		Collections.shuffle(deck);
	}
	/**
	 * Wydaje kartê <code>Card</code> z góry talii <code>Deck</code>.
	 * 
	 * @return obiekt karty <code>Card</code> znajduj¹cej siê na górze talii <code>Deck</code>
	 */
	public Card deal()
	{
		return deck.remove(0);
	}
	/**
	 * Zwraca wskaŸnik, który pokazuje, czy talia <code>Deck</code> jest pusta.
	 * 
	 * @return true, jeœli talica <code>Deck</code> nie zawiera ¿adnej karty <code>Card</code>
	 * w przeciwnym razie false
	 */
	public boolean isEmpty()
	{
		return deck.isEmpty();
	}
	/**
	 * Zwraca kartê <code>Card</code> na dó³ talii <code>Deck</code>
	 * 
	 * @param card obiekt karty <code>Card</code>, która zosta³a zwrócona
	 */
	public void putBack(Card card)
	{
		deck.add(card);
	}
	/**
	 * Tasuje taliê <code>Deck</code>
	 */
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
}