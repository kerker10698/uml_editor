package base;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class UseCase extends Base{
	
	
	
	public UseCase(MyPoint p)
	{
		super(p);
		height = 90;
		width = 120;
		setPort();
		setBorder();
		l1.setBounds(37, 38, width - 12, 10);
		print("");
	}
	

	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(portLength, portLength, width - 2*portLength, height - 2*portLength);
		//up.repaint();
		// System.out.println("color rec2");
	}

	
}