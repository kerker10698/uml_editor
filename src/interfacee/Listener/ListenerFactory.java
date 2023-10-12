package interfacee.Listener;

public class ListenerFactory {

	public ListenerFactory()
	{
		
	}
	
	public MyListener make(Toolbar b, int pattern)
	{
		switch(pattern)
		{
			case 0:
				return new ExitListener(b);
			case 1:
				return new GroupListener(b);
			case 2:
				return new UngroupListener(b);
			case 3:
				return new RenameListener(b);
			default : 
				System.out.println("wrong pattern in listener factory");
				return null;
		}
	}
}
