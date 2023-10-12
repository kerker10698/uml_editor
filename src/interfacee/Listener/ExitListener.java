package interfacee.Listener;

import java.awt.event.ActionEvent;

public class ExitListener extends MyListener{

	public ExitListener(Toolbar b) {
		super(b);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
