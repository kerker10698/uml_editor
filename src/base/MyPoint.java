package base;


public class MyPoint {
	public int x;
	public int y;
	
	public MyPoint(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
	
	public MyPoint(MyPoint p)
	{
		x = p.x;
		y = p.y;
	}
	
	public MyPoint(MyPoint p1, MyPoint p2)
	{
		x = p1.x + p2.x;
		y = p1.y + p2.y;
	}
	
	public MyPoint(double _x, double _y)
	{
		x = (int)_x;
		y = (int)_y;
	}
	
	public String print(String s)
	{
		System.out.println(s + " x = " + x + " y = " + y);
		return new String(s + " x = " + x + " y = " + y);
	}
	
	static public MyPoint getPin(MyPoint p1, MyPoint p2)
	{
		int x;
		int y;
		if(p1.x < p2.x)
		{
			x = p1.x;
		}
		else
		{
			x = p2.x;
		}
		
		if(p1.y < p2.y)
		{
			y = p1.y;
		}
		else
		{
			y = p2.y;
		}
		return new MyPoint(x, y);
	}
	
	public MyPoint rotate(double a)
	{
		return new MyPoint(Math.cos(a) * this.x - Math.sin(a) * this.y, Math.sin(a) * this.x + Math.cos(a) * this.y);
	}

	
	public MyPoint lenModify(int len)
	{
		double n = Math.sqrt(this.x * this.x + this.y * this.y);
		return new MyPoint(this.x * len / n, this.y * len / n);
	}
	
	public MyPoint lenMutiple(double multi)
	{
		return new MyPoint(this.x * multi, this.y * multi);
	}
	
	public MyPoint inverse()
	{
		return new MyPoint(-this.x, -this.y);
	}
	
	public MyPoint project(MyPoint base)
	{
		double multi = (double)this.innerProduct(base)/(double)base.innerProduct(base);
		base.lenMutiple(multi);
		return base.lenMutiple(multi);
	}
	
	public int innerProduct(MyPoint v)
	{
		return this.x * v.x + this.y * v.y;
	}

	public int distance(MyPoint p2) {
		return (this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y);
	}
	
	static public Border getBorder(MyPoint pointA, MyPoint pointB)
	{
		int left = smaller(pointA.x, pointB.x);
		int right = greater(pointA.x, pointB.x);
		int up= smaller(pointA.y, pointB.y); 
		int down = greater(pointA.y, pointB.y);
		
		return new Border(left, right, up, down);
	}
	
	private static int smaller(int a, int b)
	{
		if(a < b)
			return a;
		else
			return b;
	}
	
	private static int greater(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
}
