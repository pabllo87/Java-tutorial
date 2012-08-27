package SimpleCode;

public class Rectangle extends Shape{
	private int height;
	private int width;
	private int x;
	private int y;
	public Rectangle(int x, int y, int height, int width) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}
	
	int getWidth()
	{
		return width;
	}
	
	int getHeight()
	{
		return height;
	}
	
	int getX()
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	@Override public String toString()
	{
		return "(" + x + ", " + y + ") o wysokoœci " + height + " i szerokoœci " + width;
	}
	
	@Override void draw()
	{
		System.out.println("Prostok¹t wyrysowany w punkcje " +  toString());
	}
}
