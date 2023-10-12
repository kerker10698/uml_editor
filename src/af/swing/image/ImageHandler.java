package af.swing.image;

import java.awt.Image;

public class ImageHandler extends ImageHandlerInterface{
	private Image image;
	
	public ImageHandler()
	{
		
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public void setImage(Image i)
	{
		image = i;
	}
}
