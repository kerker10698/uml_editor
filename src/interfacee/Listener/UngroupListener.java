package interfacee.Listener;

import java.awt.event.ActionEvent;

import base.Base;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class UngroupListener extends MyListener{

	public UngroupListener(Toolbar b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean ok = false;
		// System.out.println("to ungroup1");
		if(boat.getCanvas().getSelectedList().size() == 1)
		{
			Base b = boat.getCanvas().getSelectedList().get(0);
			ok = boat.getCanvas().getBaseList().remove(b);
			boat.getCanvas().remove(b);
			// System.out.println("to ungroup");
			// System.out.println("to ungroup====================================================================================1");
		}
		else
		{
			// System.out.println("to ungroup====================================================================================2");

		}
		boat.getCanvas().repaint();
		
		/*if(gg instanceof Group)
		{
			 ok = canvas.getBaseList().remove(gg);
		}*/
			
		System.out.println("tool ungroup" + Boolean.toString(ok) + "size" + Integer.toString(boat.getCanvas().getSelectedList().size()));
	}
}
