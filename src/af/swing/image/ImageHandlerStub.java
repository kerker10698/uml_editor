package af.swing.image;

import java.awt.Image;

public class ImageHandlerStub extends ImageHandlerInterface {

	String name;
	public ImageHandlerStub(String s)
	{
		name = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Image getImage()
	{
		return null;
	}
	
	public void setImage(Image i)
	{
		
	}
}
