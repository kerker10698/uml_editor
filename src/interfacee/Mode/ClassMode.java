package interfacee.Mode;

import java.awt.event.MouseEvent;

import base.Base;
import base.ClassDef;
import base.MyPoint;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class ClassMode extends Mode{

	public ClassMode(String use, String imagePathNormal, String imagePathOn, int p, ModeListInterface _f)
	{
		super(use, imagePathNormal, imagePathOn, p, _f);
	}

	@Override
	public void clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("hello world");
		MyPoint clickedPoint = new MyPoint(e.getX(), e.getY());
		Base createdClass = new ClassDef(clickedPoint);
		boat.getCanvas().addABase(createdClass);
	}

	@Override
	public void pressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
