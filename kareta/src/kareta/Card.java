package kareta;
/**
 * Model karty do gry.
 */
public enum Card
{
	AS_TREFL(Suit.TREFL, Rank.AS),
	DWÓJKA_TREFL(Suit.TREFL, Rank.DWÓJKA),
	TRÓJKA_TREFL(Suit.TREFL, Rank.TRÓJKA),
	CZWÓRKA_TREFL(Suit.TREFL, Rank.CZWÓRKA),
	PI¥TKA_TREFL(Suit.TREFL, Rank.PI¥TKA),
	SZÓSTKA_TREFL(Suit.TREFL, Rank.SZÓSTKA),
	SIÓDEMKA_TREFL(Suit.TREFL, Rank.SIÓDEMKA),
	ÓSEMKA_TREFL(Suit.TREFL, Rank.ÓSEMKA),
	DZIEWI¥TKA_TREFL(Suit.TREFL, Rank.DZIEWI¥TKA),
	DZIESI¥TKA_TREFL(Suit.TREFL, Rank.DZIESI¥TKA),
	WALET_TREFL(Suit.TREFL, Rank.WALET),
	KRÓLOWA_TREFL(Suit.TREFL, Rank.KRÓLOWA),
	KRÓL_TREFL(Suit.TREFL, Rank.KRÓL),
	AS_KARO(Suit.KARO, Rank.AS),
	DWÓJKA_KARO(Suit.KARO, Rank.DWÓJKA),
	TRÓJKA_KARO(Suit.KARO, Rank.TRÓJKA),
	CZWÓRKA_KARO(Suit.KARO, Rank.CZWÓRKA),
	PI¥TKA_KARO(Suit.KARO, Rank.PI¥TKA),
	SZÓSTKA_KARO(Suit.KARO, Rank.SZÓSTKA),
	SIÓDEMKA_KARO(Suit.KARO, Rank.SIÓDEMKA),
	ÓSEMKA_KARO(Suit.KARO, Rank.ÓSEMKA),
	DZIEWI¥TKA_KARO(Suit.KARO, Rank.DZIEWI¥TKA),
	DZIESI¥TKA_KARO(Suit.KARO, Rank.DZIESI¥TKA),
	WALET_KARO(Suit.KARO, Rank.WALET),
	KRÓLOWA_KARO(Suit.KARO, Rank.KRÓLOWA),
	KRÓL_KARO(Suit.KARO, Rank.KRÓL),
	AS_KIER(Suit.KIER, Rank.AS),
	DWÓJKA_KIER(Suit.KIER, Rank.DWÓJKA),
	TRÓJKA_KIER(Suit.KIER, Rank.TRÓJKA),
	CZWÓRKA_KIER(Suit.KIER, Rank.CZWÓRKA),
	PI¥TKA_KIER(Suit.KIER, Rank.PI¥TKA),
	SZÓSTKA_KIER(Suit.KIER, Rank.SZÓSTKA),
	SIÓDEMKA_KIER(Suit.KIER, Rank.SIÓDEMKA),
	ÓSEMKA_KIER(Suit.KIER, Rank.ÓSEMKA),
	DZIEWI¥TKA_KIER(Suit.KIER, Rank.DZIEWI¥TKA),
	DZIESI¥TKA_KIER(Suit.KIER, Rank.DZIESI¥TKA),
	WALET_KIER(Suit.KIER, Rank.WALET),
	KRÓLOWA_KIER(Suit.KIER, Rank.KRÓLOWA),
	KRÓL_KIER(Suit.KIER, Rank.KRÓL),
	AS_PIK(Suit.PIK, Rank.AS),
	DWÓJKA_PIK(Suit.PIK, Rank.DWÓJKA),
	TRÓJKA_PIK(Suit.PIK, Rank.TRÓJKA),
	CZWÓRKA_PIK(Suit.PIK, Rank.CZWÓRKA),
	PI¥TKA_PIK(Suit.PIK, Rank.PI¥TKA),
	SZÓSTKA_PIK(Suit.PIK, Rank.SZÓSTKA),
	SIÓDEMKA_PIK(Suit.PIK, Rank.SIÓDEMKA),
	ÓSEMKA_PIK(Suit.PIK, Rank.ÓSEMKA),
	DZIEWI¥TKA_PIK(Suit.PIK, Rank.DZIEWI¥TKA),
	DZIESI¥TKA_PIK(Suit.PIK, Rank.DZIESI¥TKA),
	WALET_PIK(Suit.PIK, Rank.WALET),
	KRÓLOWA_PIK(Suit.PIK, Rank.KRÓLOWA),
	KRÓL_PIK(Suit.PIK, Rank.KRÓL);

	private Suit suit;
	/**
	 * Zwraca kolor karty <code>Card</code>
	 * 
	 * @return <code>TREFL</code>, <code>KARO</code>, <code>KIER</code> lub <code>PIK</code>
	 */
	public Suit suit(){ return suit; }
	private Rank rank;
	/**
	 * Zwraca figurê karty <code>Card</code>
	 * 
	 * @return <code>AS</code>, <code>DWÓJKA</code>, <code>TRÓJKA</code>,
	 * <code>CZWÓRKA</code>, <code>PI¥TKA</code>, <code>SZÓSTKA</code>,
	 * <code>SIÓDEMKA</code>, <code>ÓSEMKA</code>, <code>DZIEWI¥TKA</code>,
	 * <code>DZIESI¥TKA</code>, <code>WALET</code>, <code>KRÓLOWA</code>,
	 * <code>KRÓL</code>.
	 */
	public Rank rank() { return rank; }
	Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	/**
	 * Kolor karty
	 */
	public enum Suit
	{
		TREFL, KARO, KIER, PIK
	}
	/**
	 * Wag¹ karty jest jej wartoœæ ca³kowitoliczbowa.
	 */
	public enum Rank
	{
		AS, DWÓJKA, TRÓJKA, CZWÓRKA, PI¥TKA, SZÓSTKA, SIÓDEMKA, ÓSEMKA, DZIEWI¥TKA, DZIESI¥TKA, WALET, KRÓLOWA, KRÓL
	}
}