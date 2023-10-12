package interfacee.Mode;

import java.awt.event.MouseEvent;

import base.Base;
import base.CompositionLine;
import base.GeneralizationLine;
import base.Line;
import base.MyPoint;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class CompositoinLineMode extends Mode{

	public CompositoinLineMode(String use, String imagePathNormal, String imagePathOn, int p, ModeListInterface _f)
	{
		super(use, imagePathNormal, imagePathOn, p, _f);
	}

	@Override
	public void clicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void released(MouseEvent e) {
		// TODO Auto-generated method stub
		MyPoint pressPoint = boat.getCanvas().getPressPoint();
		MyPoint releasePoint = boat.getCanvas().getReleasePoint();
		
		Base pressBase = boat.getCanvas().searchBaseBB(pressPoint);
		Base releaseBase = boat.getCanvas().searchBaseBB(releasePoint);
		
		if(pressBase != null && releaseBase != null)
		{
			int pressPort = pressBase.portIn(pressPoint);
			int releasePort = releaseBase.portIn(releasePoint);
			if(pressPort != 0 && releasePort != 0)
			{
				Line line = new CompositionLine(pressBase, releaseBase, pressPort, releasePort);
				this.add(line);
				boat.getCanvas().addALine(line);
				line.setBounds(line.getAdjustPin().x, line.getAdjustPin().y, 1000, 1000);
				//line.setBounds(line.getAdjustPin().x, line.getAdjustPin().y, line.getWidth(), line.getHeight());
			}
			
		}
		this.repaint();
	}
}