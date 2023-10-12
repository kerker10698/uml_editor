package base;

import java.util.ArrayList;

import base.Base;
import base.MyPoint;

public class BaseStub extends Base {

	public BaseStub(MyPoint p1, MyPoint p2, boolean isBig) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
		if(!isBig)
		{
			innerBorder = MyPoint.getBorder(p1, p2);
		}
		else
		{
			outerBorder = MyPoint.getBorder(p1, p2);
		}
	}
	
	public BaseStub(MyPoint p, boolean setPortAndBorder) {
		super(p);
		height = 100;
		width = 100;
		if(setPortAndBorder) {
			
		setPort();
		setBorder();
		}
	}

	public void setWidthAndHeight(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public MyPoint getPin() {
		return pin;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setHWidthAndHeight(int w, int h) {
		width = w;
		height = h;
	}
	
}
