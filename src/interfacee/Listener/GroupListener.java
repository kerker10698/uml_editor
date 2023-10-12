package interfacee.Listener;

import java.awt.event.ActionEvent;

import base.Base;
import base.Group;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class GroupListener extends MyListener{

	public GroupListener(Toolbar b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Base gg = new Group(boat.getCanvas().getSelectedList());
		gg.getInnerBorder().print("tool group make a groupp");
		boat.getCanvas().addABase(gg);
		boat.getCanvas().unselectAll();
		boat.getCanvas().addASelected(gg);
		gg.setSelect(true);
		boat.getCanvas().repaint();
		// System.out.println("tool group");
	}
}
