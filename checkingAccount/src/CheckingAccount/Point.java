package CheckingAccount;

public class Point {
	private int x,y;
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	int getX()
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	@Override public boolean equals(Object o)
	{
		if(o == this)
			return true;
		
		if(!(o instanceof Point))
			return false;
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
	public static void main(String[] args)
	{
		Point p1 = new Point(10,20);
		Point p2 = new Point(20,30);
		Point p3 = new Point(10,20);
		//Sprawdzanie zwrotności
		System.out.println(p1.equals(p1)); // Wynik: true
		//Sprawdzanie symetrii
		System.out.println(p1.equals(p2)); // Wynik false
		System.out.println(p2.equals(p1)); // Wynik false
		//Sprawdzanie przechodności
		System.out.println(p2.equals(p3)); // Wynik false
		System.out.println(p1.equals(p3)); // Wynik true
		//Sprawdzanie wyniku porównania z null
		System.out.println(p1.equals(null)); // Wynik false
		//Dodatkowe sprawdzanie przydatności operatora instanceof
		System.out.println(p1.equals("abc")); // Wynik false
		java.util.Map map = new java.util.HashMap();
		map.put(p1, "pierwszy punkt");
		System.out.println(map.get(p1)); //Wynik: pierwszy punkt
		System.out.println(map.get(new Point(10,20))); // Wynik null, jeśli nie ma hashCode
		System.out.println(p1);
	}
}
