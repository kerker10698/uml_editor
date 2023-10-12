package base;

public class PortStub extends PortInterface {

	public boolean show = false;
	public int length;
	
	public PortStub(int portLength) {
		length = portLength;
	}

	public void setShow(boolean b)
	{
		show = b;
	}
	
	public boolean isShowing()
	{
		return show;
	}
	

}
