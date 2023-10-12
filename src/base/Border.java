package base;

public class Border {
	private int left;
	private int right;
	private int up;
	private int down;
	
	
	public Border(int _left, int _right, int _up, int _down)
	{
		left = _left;
		right = _right;
		up = _up;
		down = _down;
	}
	
	public Border(Border inner, int len)
	{
		left = inner.left - len;
		right = inner.right + len;
		up = inner.up - len;
		down = inner.down + len;
	}
	
	
	public void print(String s)
	{
		System.out.println(s + " up = " + up + " left = " + left + " down = " + down + " right = " + right );
	}
	public boolean in(MyPoint p)
	{
		if(p.x >= left && p.x <= right && p.y >= up && p.y <= down)
		{
			return true;
		}
		return false;
	}
	
	public boolean in(Border b)
	{

		
		if(b.left <= this.left && b.right >= this.right && b.up <= this.up && b.down >= this.down)
		{
			return true;
		}
		
		
		return false;
	}
	
	private static int getMin(int x1, int x2)
	{
		if(x1 < x2)
		{
			return x1;
		}
		else
		{
			return x2;
		}
	}
	
	private static int getMax(int x1, int x2)
	{
		if(x1 > x2)
		{
			return x1;
		}
		else
		{
			return x2;
		}
	}
	
	static public Border bigBorder(Border b1, Border b2)
	{
		
		return new Border(getMin(b1.left, b2.left),
				          getMax(b1.right, b2.right),
						  getMin(b1.up, b2.up),
						  getMax(b1.down, b2.down));
	}
	
	public MyPoint getPin()
	{
		return new MyPoint(left, up);
	}
	
	public int getWidth()
	{
		return right - left;
	}
	
	public int getHeight()
	{
		return down - up;
	}
	
	
	
}
