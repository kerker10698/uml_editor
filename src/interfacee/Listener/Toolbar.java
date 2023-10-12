package interfacee.Listener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import base.Base;
import base.Group;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;




public class Toolbar extends ToolbarInterface{ 

	private JMenu file = new JMenu("file");
	private JMenu edit = new JMenu("edit");
	private CanvasInterface canvas;
	
	public Toolbar(CanvasInterface _c, String path) 
	{
		canvas = _c;
		
		Scanner myReader = getToolSet(path);
		ListenerFactory l = new ListenerFactory();
		while(myReader.hasNextLine())
		{
		   String menu = myReader.next();
		   MyMenu mm = new MyMenu(menu);
		   this.add(mm);
		   String next = new String("");
		   String end = new String("end");
		   do
		   {
			   next = myReader.next();
			   if(next.compareTo(end) != 0)
			   {
				   MyMenuItem item = new MyMenuItem(next);
				   int pattern = myReader.nextInt();
				   item.addActionListener(l.make(this, pattern));
				   mm.add(item);
				   System.out.println(menu + " " + next + " " + Integer.toString(pattern));
			   }
			   
		   }while(next.compareTo(end) != 0);
		}
		
	}
	
	private Scanner getToolSet(String path)
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
	
	class printSomething implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("exiting");
		}
		
	}
	
	public CanvasInterface getCanvas()
	{
		return canvas;
	}
}


