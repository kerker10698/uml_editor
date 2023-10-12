package interfacee.Mode;

import java.util.ArrayList;

import javax.swing.JPanel;

import base.Base;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public abstract class ModeListInterface extends JPanel{

	public ArrayList<Mode> getIconList() {
		// TODO Auto-generated method stub
		return null;
	}

	public CanvasInterface getCanvas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	abstract public int getCanvasMode();
	abstract public void setCanvasMode(int p);
}
