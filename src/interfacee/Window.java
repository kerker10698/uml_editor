package interfacee;

import java.awt.BorderLayout;
import interfacee.Canvas.*;
import interfacee.Listener.*;
import interfacee.Mode.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel; 

public class Window extends JFrame{

	public Window(String title) throws InterruptedException
	{
		super(title);
		// this.setUndecorated(true);
		// // Set the JFrame to be maximized
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// // Make the JFrame not resizable
		// this.setResizable(false);
		
		JPanel root = new JPanel();
		this.setContentPane(root);
		root.setLayout(new BorderLayout());
		
		CanvasInterface c = new Canvas();
		ToolbarInterface t = new Toolbar(c, ".\\src\\interfacee\\Listener\\tool_bar.txt");
		this.setJMenuBar(t);
		ModeListInterface f = new ModeList(".\\src\\interfacee\\Images\\icon_set.txt", c);
		c.setFuncList(f);
		root.add(f, BorderLayout.LINE_START);
		root.add(c);
	}
}
