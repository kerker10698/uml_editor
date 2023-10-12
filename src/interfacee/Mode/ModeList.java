package interfacee.Mode;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import af.swing.layout.AfYLayout;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;




public class ModeList extends ModeListInterface{
	
	private ArrayList<Mode> iconList = new ArrayList<>();
	private CanvasInterface can;
	
	public ModeList(String path, CanvasInterface c)
	{
		this.setLayout(new AfYLayout());
		Scanner myReader = getIconSet(path);
		can = c;

		
	    while(myReader.hasNextLine())
	    {
	    	String iconUse = myReader.next();
	    	String iconPathNormal = myReader.next();
	    	String iconPathOn = myReader.next();
	    	int  iconPattern = myReader.nextInt();
	    	ModeFactory m = new ModeFactory();
	    	Mode IconTemp = m.make(iconUse, iconPathNormal, iconPathOn, iconPattern, this);
	    	IconTemp.addObserver();
	    	this.add(IconTemp, "50px");
	    	iconList.add(IconTemp);
	    	
	    }
	}
	
	public ModeList(CanvasInterface c)
	{
		can = c;
	}
	
	private Scanner getIconSet(String path)
	{
		Scanner myReader = null;
	    try {
	    	File iconText = new File(path);
			myReader = new Scanner(iconText);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return myReader;
	}
	
	public ArrayList<Mode> getIconList()
	{
		return iconList;
	}
	
	public CanvasInterface getCanvas()
	{
		return can;
	}

	@Override
	public void setCanvasMode(int p) {
		can.changeMode(p);
		
	}

	@Override
	public int getCanvasMode() {
		// TODO Auto-generated method stub
		return can.getMode();
	}
}
