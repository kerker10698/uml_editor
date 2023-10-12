package interfacee;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import af.swing.layout.AfYLayout;
import base.Base;

public class ChangeWindow extends JFrame{
	
	Base target;
	String newLabel;
	
	public ChangeWindow(Base t)
	{
		target = t;
		JPanel root = new JPanel();
		this.setContentPane(root);
		root.setLayout(new AfYLayout());
		
		JPanel classP = new JPanel();
		JLabel newClassName = new JLabel("new class name");
		JTextField classInput = new JTextField(20);
		classP.add(newClassName);
		classP.add(classInput);
		root.add(classP, "100px");
		
		JPanel buttonP = new JPanel();
		JButton buttonOK = new JButton("OK");
		JButton buttonCanl = new JButton("Cancel");
		buttonP.add(buttonOK);
		buttonP.add(buttonCanl);
		root.add(buttonP, "50px");
		
		buttonOK.addActionListener((e)->
		{
			newLabel = classInput.getText();
			System.out.println("your input is " + newLabel);
			target.rename(newLabel);
			dispose();
		});	
		
		buttonCanl.addActionListener((e)->
		{
			//caller.waitingForRenameWindow(target, null);
			dispose();
		});	
	}
	
	public String getNewName()
	{
		return newLabel;
	}
	
}
