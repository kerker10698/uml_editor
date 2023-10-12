package interfacee.Mode;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import base.Base;
import base.Border;
import base.Group;
import base.MyPoint;

public class SelectMode extends Mode{

	public SelectMode(String use, String imagePathNormal, String imagePathOn, int p, ModeListInterface _f)
	{
		super(use, imagePathNormal, imagePathOn, p, _f);
	}

	@Override
	public void clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Base> baseList = boat.getCanvas().getBaseList();
		
		MyPoint clickedPoint = new MyPoint(e.getX(), e.getY());
		for(int i = baseList.size() - 1; i >= 0; i--)
		{
			Base element = baseList.get(i);
			boolean ans = element.in(clickedPoint);
			String s = Integer.toString(element.portIn(clickedPoint));
			// System.out.println(ans);
			if(ans)
			{
				//element.rename("in" + s);
				element.setSelect(true);
				boat.getCanvas().addSelectedList(element);
				break;
			}
			else
			{
				//element.rename("out" + s);
				element.setSelect(false);
			}
			this.repaint();
		}
	}

	@Override
	public void pressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released(MouseEvent e) {
		// TODO Auto-generated method stub
		Base toMove = boat.getCanvas().getPressBase();
		// System.out.println("release-------------------------------------");
		// System.out.println(toMove);
		MyPoint pressPoint = boat.getCanvas().getPressPoint();
		MyPoint releasePoint = boat.getCanvas().getReleasePoint();
		
		if(toMove != null)
		{
			toMove.setSelect(true);
			MyPoint relativeToPin = new MyPoint(boat.getCanvas().getPressPoint(), toMove.getPin().inverse());
			boat.getCanvas().moveBase(toMove, new MyPoint(releasePoint, relativeToPin.inverse()));
		}
		else
		{
			pressPoint.print("pressPoint");
			releasePoint.print("releasePoint");
			
			Border frame = MyPoint.getBorder(pressPoint, releasePoint);
			ArrayList<Base> baseList = boat.getCanvas().getBaseList();
			
			/*Base gg = new Group(pressPoint, releasePoint);
			gg.getInnerBorder().print("framming border");
			boat.getCanvas().addABase(gg);*/

			for(Base element: baseList)
			{
				boolean ans = element.in(frame);
				// System.out.println(ans);
				if(ans)
				{
					//element.rename("in");
					element.setSelect(true);
					boat.getCanvas().addSelectedList(element);
				}
				else
				{
					//element.rename("out");
					element.setSelect(false);
				}
				this.repaint();
			}
		}
		boat.getCanvas().printAllLine();
		boat.getCanvas().repaintAll();
	}
}