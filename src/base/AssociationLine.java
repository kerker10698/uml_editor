package base;

import java.awt.Graphics;

public class AssociationLine extends Line{

	public AssociationLine(Base src, Base des, int srcP, int desP) {
		super(src, des, srcP, desP);
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//g.drawLine(5, 5, width - 5 , height - 5);
		super.paintComponent(g);
		this.adjust(source, destination,  sourcePort, destinationPort);
		MyPoint sourceP = source.getPortPoint(sourcePort);
		MyPoint destinationP = destination.getPortPoint(destinationPort);
		
		MyPoint sourcePRelative = new MyPoint(sourceP, adjustPin.inverse());
		MyPoint destinationPRelative = new MyPoint(destinationP, adjustPin.inverse());
		MyPoint body = new MyPoint(destinationPRelative, sourcePRelative.inverse());
		
		g.drawLine(sourcePRelative.x, sourcePRelative.y, destinationPRelative.x, destinationPRelative.y);
	
		// body.print("body");
		MyPoint wing1 = body.lenModify(20);
		// wing1.print("wing");
		wing1 = wing1.rotate(3.14/6);
		wing1 = wing1.inverse();
		// wing1.print("wing");
		MyPoint wing1P = new MyPoint(destinationPRelative, wing1);
		
		
		MyPoint wing2 = body.lenModify(20);
		wing2 = wing2.rotate(-3.14/6);
		wing2 = wing2.inverse();
		MyPoint wing2P = new MyPoint(destinationPRelative, wing2);
		
		g.drawLine(destinationPRelative.x, destinationPRelative.y, wing1P.x, wing1P.y);
		g.drawLine(destinationPRelative.x, destinationPRelative.y, wing2P.x, wing2P.y);
		//up.repaint();
		// System.out.println("LINELINELINE");
	}
	
}
