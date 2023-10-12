package base;

import java.awt.Graphics;
import java.util.ArrayList;

public class Group extends Base{

	ArrayList<Base> baseList = new ArrayList<>();
	public Group(MyPoint p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	public Group(MyPoint p1, MyPoint p2)
	{
		super(p1, p2);
		innerBorder = MyPoint.getBorder(p1, p2);
		outerBorder = innerBorder;
		width = outerBorder.getWidth();
		height = outerBorder.getHeight();
		setPort();
	}
	
	public Group(ArrayList<Base> _baseList)
	{
		super(_baseList);
		addList(_baseList);
		pin = new MyPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
		innerBorder = new Border(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
		for(Base element: _baseList)
		{
			innerBorder.print("innerBorder");
			element.innerBorder.print("innerBorder");
			pin = MyPoint.getPin(pin, element.pin);
			innerBorder = Border.bigBorder(innerBorder, element.innerBorder);
		}
		outerBorder = new Border(innerBorder, portLength);
		width = outerBorder.getWidth();
		height = outerBorder.getHeight();
		setPort();
		print("Group");
	}
	
	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		super.setSelect(b);
		if(b)
		for(Base element: baseList)
		{
			element.setSelect(!b);
		}
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//g.drawRect(portLength, portLength, width - 2*portLength, height - 2*portLength);
		//up.repaint();
		// System.out.println("color rec2");
	}

	@Override
	public void modifyPin(MyPoint p) {
		// TODO Auto-generated method stub
		p.print("p --");
		pin.inverse().print("pin.inverse()");
		MyPoint arrow = new MyPoint(p, pin.inverse());
		pin = p;
		this.setBounds(this.getPin().x, this.getPin().y, this.getWidth(), this.getHeight());
		setBorder();
		arrow.print("arrow");
		for(Base element: baseList)
		{
			element.modifyPinRelative(arrow);
			setBorder();
			element.print("=== element===");
		}
	}
	
	public void addList(ArrayList<Base> _baseList)
	{
		for(Base element: _baseList)
		{
			baseList.add(element);
		}
	}
	

}
