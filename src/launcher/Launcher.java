package launcher;

import javax.swing.JFrame;

import interfacee.Window;


public class Launcher {
	 
	
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				try {
					createGUI();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private static void createGUI() throws InterruptedException
	{
		Window frame = new Window("Swing Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
