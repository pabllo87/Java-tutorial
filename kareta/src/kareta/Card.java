package kareta;
/**
 * Model karty do gry.
 */
public enum Card
{
	AS_TREFL(Suit.TREFL, Rank.AS),
	DW�JKA_TREFL(Suit.TREFL, Rank.DW�JKA),
	TR�JKA_TREFL(Suit.TREFL, Rank.TR�JKA),
	CZW�RKA_TREFL(Suit.TREFL, Rank.CZW�RKA),
	PI�TKA_TREFL(Suit.TREFL, Rank.PI�TKA),
	SZ�STKA_TREFL(Suit.TREFL, Rank.SZ�STKA),
	SI�DEMKA_TREFL(Suit.TREFL, Rank.SI�DEMKA),
	�SEMKA_TREFL(Suit.TREFL, Rank.�SEMKA),
	DZIEWI�TKA_TREFL(Suit.TREFL, Rank.DZIEWI�TKA),
	DZIESI�TKA_TREFL(Suit.TREFL, Rank.DZIESI�TKA),
	WALET_TREFL(Suit.TREFL, Rank.WALET),
	KR�LOWA_TREFL(Suit.TREFL, Rank.KR�LOWA),
	KR�L_TREFL(Suit.TREFL, Rank.KR�L),
	AS_KARO(Suit.KARO, Rank.AS),
	DW�JKA_KARO(Suit.KARO, Rank.DW�JKA),
	TR�JKA_KARO(Suit.KARO, Rank.TR�JKA),
	CZW�RKA_KARO(Suit.KARO, Rank.CZW�RKA),
	PI�TKA_KARO(Suit.KARO, Rank.PI�TKA),
	SZ�STKA_KARO(Suit.KARO, Rank.SZ�STKA),
	SI�DEMKA_KARO(Suit.KARO, Rank.SI�DEMKA),
	�SEMKA_KARO(Suit.KARO, Rank.�SEMKA),
	DZIEWI�TKA_KARO(Suit.KARO, Rank.DZIEWI�TKA),
	DZIESI�TKA_KARO(Suit.KARO, Rank.DZIESI�TKA),
	WALET_KARO(Suit.KARO, Rank.WALET),
	KR�LOWA_KARO(Suit.KARO, Rank.KR�LOWA),
	KR�L_KARO(Suit.KARO, Rank.KR�L),
	AS_KIER(Suit.KIER, Rank.AS),
	DW�JKA_KIER(Suit.KIER, Rank.DW�JKA),
	TR�JKA_KIER(Suit.KIER, Rank.TR�JKA),
	CZW�RKA_KIER(Suit.KIER, Rank.CZW�RKA),
	PI�TKA_KIER(Suit.KIER, Rank.PI�TKA),
	SZ�STKA_KIER(Suit.KIER, Rank.SZ�STKA),
	SI�DEMKA_KIER(Suit.KIER, Rank.SI�DEMKA),
	�SEMKA_KIER(Suit.KIER, Rank.�SEMKA),
	DZIEWI�TKA_KIER(Suit.KIER, Rank.DZIEWI�TKA),
	DZIESI�TKA_KIER(Suit.KIER, Rank.DZIESI�TKA),
	WALET_KIER(Suit.KIER, Rank.WALET),
	KR�LOWA_KIER(Suit.KIER, Rank.KR�LOWA),
	KR�L_KIER(Suit.KIER, Rank.KR�L),
	AS_PIK(Suit.PIK, Rank.AS),
	DW�JKA_PIK(Suit.PIK, Rank.DW�JKA),
	TR�JKA_PIK(Suit.PIK, Rank.TR�JKA),
	CZW�RKA_PIK(Suit.PIK, Rank.CZW�RKA),
	PI�TKA_PIK(Suit.PIK, Rank.PI�TKA),
	SZ�STKA_PIK(Suit.PIK, Rank.SZ�STKA),
	SI�DEMKA_PIK(Suit.PIK, Rank.SI�DEMKA),
	�SEMKA_PIK(Suit.PIK, Rank.�SEMKA),
	DZIEWI�TKA_PIK(Suit.PIK, Rank.DZIEWI�TKA),
	DZIESI�TKA_PIK(Suit.PIK, Rank.DZIESI�TKA),
	WALET_PIK(Suit.PIK, Rank.WALET),
	KR�LOWA_PIK(Suit.PIK, Rank.KR�LOWA),
	KR�L_PIK(Suit.PIK, Rank.KR�L);

	private Suit suit;
	/**
	 * Zwraca kolor karty <code>Card</code>
	 * 
	 * @return <code>TREFL</code>, <code>KARO</code>, <code>KIER</code> lub <code>PIK</code>
	 */
	public Suit suit(){ return suit; }
	private Rank rank;
	/**
	 * Zwraca figur� karty <code>Card</code>
	 * 
	 * @return <code>AS</code>, <code>DW�JKA</code>, <code>TR�JKA</code>,
	 * <code>CZW�RKA</code>, <code>PI�TKA</code>, <code>SZ�STKA</code>,
	 * <code>SI�DEMKA</code>, <code>�SEMKA</code>, <code>DZIEWI�TKA</code>,
	 * <code>DZIESI�TKA</code>, <code>WALET</code>, <code>KR�LOWA</code>,
	 * <code>KR�L</code>.
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
	 * Wag� karty jest jej warto�� ca�kowitoliczbowa.
	 */
	public enum Rank
	{
		AS, DW�JKA, TR�JKA, CZW�RKA, PI�TKA, SZ�STKA, SI�DEMKA, �SEMKA, DZIEWI�TKA, DZIESI�TKA, WALET, KR�LOWA, KR�L
	}
}