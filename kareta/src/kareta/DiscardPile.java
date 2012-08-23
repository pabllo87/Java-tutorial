package kareta;

/**
 * Symulacja stosu kart odrzuconych.
 * @author Player
 *
 */
public class DiscardPile {
	private Card[] cards;
	private int top;
	
	/**
	 * Tworzy stos kart <code>DiscardPile</code>, w którym mog¹ siê znajdowaæ maksymalnie 52 karty
	 * <code>Card</code>. Stos <code>DiscardPile</code> jest na pocz¹tku pusty.
	 */
	public DiscardPile()
	{
		cards = new Card[52]; //Miejsce na wszystkie karty na stosie
							  //(nigdy nie powinno byæ potrzebne)
		top = -1;
	}
	/**
	 * Zwaraca kartê <code>Card</code> na górê stosu <code>DiscardPile</code>.
	 * 
	 * @return obiekt karty <code>Card</code> na górze stosu <code>DiscardPile</code> lub
	 * null, jeœli stos <code>DiscardPile</code> jest pusty.
	 */
	public Card getTopCard()
	{
		if (top == -1)
			return null;
		Card card = cards[top];
		cards[top--] = null;
		return card;
	}
	/**
	 * Wskazuje obiekt karty <code>Card</code> jako kartê na górze stosu <code>DiscardPile</code>.
	 * 
	 * @param card obiekt karty <code>Card</code> rzucanej na górê stosu <code>DiscardPile</code>/
	 */
	public void setTopCard(Card card)
	{
		cards[++top] = card;
	}
	/**
	 * Identyfikuje kartê <code>Card</code> na górze stosu <code>DiscardPile</code>
	 * bez usuwania tej karty
	 * 
	 * @return karta <code>Card</code> z góry stosu lub null, jeœli stos <code>DiscardPile</code> jest pusty.
	 */
	public Card topCard()
	{
		return (top == -1) ? null : cards[top];
	}
}
