package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Line extends JPanel{
	protected MyPoint pin;
	protected Border outerBorder;
	protected Border innerBorder;
	protected int height;
	protected int width;
	protected Base source; 
	protected Base destination;
	protected int sourcePort;
	protected int destinationPort;
	/*int portLength = 6;
	Port up;
	Port left;
	Port down;
	Port right;
	*/
	protected MyPoint adjustPin;
	
	public Line(MyPoint p, Border b, Base src, Base des, int srcP, int desP) {
		pin = p;
		outerBorder = b;
		source = src;
		destination = des;
		sourcePort = srcP;
		destinationPort = desP;
		
	}
	
	public Line(Base src, Base des, int srcP, int desP) {
		this.setLayout(null);
		adjust(src, des, srcP, desP);
		width = outerBorder.getWidth();
		height = outerBorder.getHeight();
		
		source = src;
		destination = des;
		sourcePort = srcP;
		destinationPort = desP;
		
		this.repaint();
		// System.out.println("line created");
		print("line");
	}
	

	public MyPoint getPin()
	{
		return pin;
	}
	
	public MyPoint getAdjustPin()
	{
		return adjustPin;
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
		this.setBackground(new Color(0, 0, 0, 0));
	}

	public void print(String s)
	{
		System.out.println(s);
		source.print("src");
		destination.print("des");
		pin.print("pin:");
		adjustPin.print("adjust:");
		outerBorder.print("outerBorder:");
		innerBorder.print("innerBorder:");
		//System.out.println("height = " + height + " width = " + width + " portLength = " + portLength);
	}
	
	public void adjust(Base src, Base des, int srcP, int desP)
	{
		int edge = 10;
		innerBorder = MyPoint.getBorder(src.getPortPoint(srcP), des.getPortPoint(desP));
		pin = innerBorder.getPin();
		adjustPin = new MyPoint(pin.x - edge, pin.y - edge);
		outerBorder = new Border(innerBorder, edge);
		width = outerBorder.getWidth();
		height = outerBorder.getHeight();
		this.setBounds(this.getAdjustPin().x, this.getAdjustPin().y, width, height);
	}
}
