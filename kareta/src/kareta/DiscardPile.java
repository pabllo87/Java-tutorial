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
	 * Tworzy stos kart <code>DiscardPile</code>, w kt�rym mog� si� znajdowa� maksymalnie 52 karty
	 * <code>Card</code>. Stos <code>DiscardPile</code> jest na pocz�tku pusty.
	 */
	public DiscardPile()
	{
		cards = new Card[52]; //Miejsce na wszystkie karty na stosie
							  //(nigdy nie powinno by� potrzebne)
		top = -1;
	}
	/**
	 * Zwaraca kart� <code>Card</code> na g�r� stosu <code>DiscardPile</code>.
	 * 
	 * @return obiekt karty <code>Card</code> na g�rze stosu <code>DiscardPile</code> lub
	 * null, je�li stos <code>DiscardPile</code> jest pusty.
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
	 * Wskazuje obiekt karty <code>Card</code> jako kart� na g�rze stosu <code>DiscardPile</code>.
	 * 
	 * @param card obiekt karty <code>Card</code> rzucanej na g�r� stosu <code>DiscardPile</code>/
	 */
	public void setTopCard(Card card)
	{
		cards[++top] = card;
	}
	/**
	 * Identyfikuje kart� <code>Card</code> na g�rze stosu <code>DiscardPile</code>
	 * bez usuwania tej karty
	 * 
	 * @return karta <code>Card</code> z g�ry stosu lub null, je�li stos <code>DiscardPile</code> jest pusty.
	 */
	public Card topCard()
	{
		return (top == -1) ? null : cards[top];
	}
}
