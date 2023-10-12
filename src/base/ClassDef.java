package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClassDef extends Base{
	
	
	public ClassDef(MyPoint p)
	{
		super(p);
		height = 120;
		width = 100;
		setPort();
		setBorder();
		l1.setBounds(12, 22, width - 12, 10);
		print("");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawRect(portLength, portLength, width - 2*portLength, height - 2*portLength);
		g.drawLine(portLength, portLength + (height-2*portLength)/3, width - portLength, portLength + (height-2*portLength)/3);
		g.drawLine(portLength, portLength + 2*(height-2*portLength)/3, width - portLength, portLength + 2*(height-2*portLength)/3);
		//up.repaint();
		// System.out.println("color rec2");
	}
	
	public void rename(String s)
	{
		l1.setText(s);
	}

	
}
