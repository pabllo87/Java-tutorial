package SimpleCode;

public class Circle extends Point {
	private int radius;
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius = radius;
	}
	
	int getRadius()
	{
		return radius;
	}
	
	@Override public String toString()
	{
		return "" + radius;
	}
	
	@Override public void draw(int color)
	{
		System.out.println("Okr¹g wyrysowany w punkcje " + super.toString() + 
							" i z promieniem " + toString() + " w kolorze: " + color);
	}
}
