package base;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Port extends PortInterface{
	
	private int length;
	private boolean show = false;
	
	public Port(int s)
	{
		length = s;
		this.setBackground(new Color(0, 0, 0, 0));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(show)
			this.setBackground(Color.BLACK);
		else
			this.setBackground(new Color(0, 0, 0, 0));
		// System.out.println("hell wowrld");
	}
	
	public void setShow(boolean b)
	{
		show = b;
	}
	
	
	
}
