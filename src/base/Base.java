package base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public abstract class Base extends JPanel{
	protected MyPoint pin;
	protected Border outerBorder;
	protected Border innerBorder;
	protected int height = 0;
	protected int width = 0;
	protected int portLength = 12;
	protected PortInterface up;
	protected PortInterface left;
	protected PortInterface down;
	protected PortInterface right;
	protected boolean selected = false;
	protected boolean testing = false;
	protected JLabel l1 = new JLabel("Hello");
	
	public Base(MyPoint p)
	{
		this.setLayout(null);
		this.add(l1);
		pin = p;
	}
	
	public Base(MyPoint p1, MyPoint p2)
	{
		this.setLayout(null);
		this.add(l1);
		Border b = MyPoint.getBorder(p1, p2);
		pin = b.getPin();
	}
	
	public Base(ArrayList<Base> baseList)
	{
		this.setLayout(null);
	}
	

	public MyPoint getPin()
	{
		return pin;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		up.repaint();
		left.repaint();
		down.repaint();
		right.repaint();
	}

	public void print(String s)
	{
		System.out.println(s);
		pin.print("pin:");
		outerBorder.print("outerBorder:");
		innerBorder.print("innerBorder:");
		System.out.println("height = " + height + " width = " + width + " portLength = " + portLength);
	}
	
	public void setPort() //
	{
		if(!testing) {
			up = new Port(portLength);
			left = new Port(portLength);
			down = new Port(portLength);
			right = new Port(portLength);
		}
		else {
			up = new PortStub(portLength);
			left = new PortStub(portLength);
			down = new PortStub(portLength);
			right = new PortStub(portLength);
		}
			
		
		this.add(up);
		up.setPreferredSize(new Dimension(portLength, portLength));
		this.add(left);
		left.setPreferredSize(new Dimension(portLength, portLength));
		this.add(down);
		down.setPreferredSize(new Dimension(portLength, portLength));
		this.add(right);
		right.setPreferredSize(new Dimension(portLength, portLength));
		up.setBounds( (width-portLength)/2, 0, portLength, portLength);        //(height-portLength)/2  height - 2*portLength
		left.setBounds(0, (height-portLength)/2, portLength, portLength);
		down.setBounds((width-portLength)/2, height - portLength, portLength, portLength);
		right.setBounds(width - portLength, (height-portLength)/2, portLength, portLength);
	}
	
	public Border getInnerBorder()
	{
		return innerBorder;
	}
	
	public void setBorder() //
	{
		outerBorder = new Border(pin.x, pin.x + width, pin.y, pin.y + height);
		innerBorder = new Border(pin.x + portLength, pin.x + width - portLength, pin.y + portLength, pin.y + height - portLength);
	}
	
	public void rename(String s)//
	{
		l1.setText(s);
	}
	
	public boolean in(MyPoint p) 
	{
		return innerBorder.in(p);
	}
	
	public boolean in(Border b)
	{
		this.innerBorder.print("inner border:");
		b.print("frame");
		return innerBorder.in(b);
	}
	
	public boolean inBB(MyPoint p)
	{
		return outerBorder.in(p);
	}
	
	public boolean inBB(Border b)
	{
		return outerBorder.in(b);
	}
	
	
	public int portIn(MyPoint p)
	{

		if (innerBorder.in(p)) {
			int dP1 = getPortPoint(1).distance(p);
			int minD = dP1;
			int r = 1;

			int dP2 = getPortPoint(2).distance(p);
			if (dP2 < minD) {
				minD = dP2;
				r = 2;
			}
			int dP3 = getPortPoint(3).distance(p);
			if (dP3 < minD) {
				minD = dP3;
				r = 3;
			}
			int dP4 = getPortPoint(4).distance(p);
			if (dP4 < minD) {
				minD = dP4;
				r = 4;
			}
			return r;

			
		} else if (outerBorder.in(p)) {
			int dP1 = getPortPoint(1).distance(p);
			int minD = dP1;
			int r = 1;

			int dP2 = getPortPoint(2).distance(p);
			if (dP2 < minD) {
				minD = dP2;
				r = 2;
			}
			int dP3 = getPortPoint(3).distance(p);
			if (dP3 < minD) {
				minD = dP3;
				r = 3;
			}
			int dP4 = getPortPoint(4).distance(p);
			if (dP4 < minD) {
				minD = dP4;
				r = 4;
			}
			
			if (minD < 144) 
				return r;
			return 0;

			
		} else {
			return 0;
		}
		// Border up = new Border( pin.x + (width-portLength)/2, pin.x + (width-portLength)/2 + portLength, pin.y + 0, pin.y + portLength);
		// if(up.in(p))
		// {
		// 	return 1;
		// }
		// Border left = new Border( pin.x + 0, pin.x + portLength, pin.y + (height-portLength)/2, pin.y + (height-portLength)/2 + portLength);
		// if(left.in(p))
		// {
		// 	return 2;
		// }
		// Border down = new Border( pin.x + (width-portLength)/2, pin.x + (width-portLength)/2 + portLength, pin.y + height-portLength, pin.y + height);
		// if(down.in(p))
		// {
		// 	return 3;
		// }
		// Border right = new Border( pin.x + width-portLength, pin.x + width, pin.y + (height-portLength)/2, pin.y + (height-portLength)/2 + portLength);
		// if(right.in(p))
		// {
		// 	return 4;
		// }
		// return 0;
		
	}
	
	public void setSelect(boolean b)//
	{
		selected = b;
		up.setShow(b);
		left.setShow(b);
		down.setShow(b);
		right.setShow(b);
	}
	
	public MyPoint getPortPoint(int i)//
	{
		switch(i)
		{
			case 1:
				return new MyPoint(pin.x + width / 2, pin.y + portLength / 2);
			case 2:
				return new MyPoint(pin.x + portLength / 2, pin.y + height / 2);
			case 3:
				return new MyPoint(pin.x + width / 2, pin.y + height - portLength/ 2);
			case 4:
				return new MyPoint(pin.x + width - portLength/ 2, pin.y + height / 2);
			default:
				System.out.println("invalid port number");
				return new MyPoint(-1, -1);
		}
	}
	
	public void modifyPin(MyPoint p)//
	{
		pin = p;
		this.setBounds(this.pin.x, this.pin.y, this.width, this.height);
		setBorder();
	}
	
	public void modifyPinRelative(MyPoint p)//
	{
		p.print("p");
		pin = new MyPoint(pin, p);
		pin.print("move to");
		this.setBounds(this.pin.x, this.pin.y, this.width, this.height);
		setBorder();
	}

	public void testOn()
	{
		testing = true;
	}
}
