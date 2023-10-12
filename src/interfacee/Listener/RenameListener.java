package interfacee.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfacee.ChangeWindow;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class RenameListener extends MyListener{

	public RenameListener(Toolbar b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(boat.getCanvas().getSelectedList().size() == 1)
		{
			ChangeWindow frame1 = new ChangeWindow(boat.getCanvas().getSelectedList().get(0));
			frame1.setSize(500, 250);
			frame1.setVisible(true);
		}
		
		
	}
}
