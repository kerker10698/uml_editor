package interfacee.Mode;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import af.swing.image.*;


public abstract class Mode extends AfImageView{
	
	protected ImageHandlerInterface normalHdr;
	protected ImageHandlerInterface onHdr;
	protected boolean mode = false;
	protected String use;
	protected int pattern;
	
	ModeListInterface boat;
	
	public Mode(String use, String imagePathNormal, String imagePathOn, int p, ModeListInterface _f)
	{
		super();
		// System.out.println(use);
		this.setBgColor(new Color(255, 255, 255, 0));
		this.use = use;
		this.pattern = p;
		this.boat = _f;
		try {
			normalHdr = imageFromResource(imagePathNormal);
			onHdr = imageFromResource(imagePathOn);
			this.setImage(normalHdr);
		}catch(Exception e2)
		{
			System.out.println(imagePathNormal);
			System.out.println(imagePathOn);
			e2.printStackTrace();
		}
	}
	

	public void mode_down()
	{
		this.setImage(normalHdr);
	}
	
	public void mode_on()
	{
		this.setImage(onHdr);
	}
	
	private ImageHandlerInterface imageFromResource(String imagePath) throws Exception //
	{
		if(imagePath.equals("fake_normal") || imagePath.equals("fake_on"))
		{
			URL imageUrl = this.getClass().getResource("/interfacee/Mode/test.png");
			BufferedImage image = ImageIO.read(imageUrl);
			ImageHandlerInterface hdr = new ImageHandlerStub(imagePath);
			hdr.setImage(image);
			return hdr;
		}
		// System.out.println("EXP: " + imagePath);
		URL imageUrl = this.getClass().getResource(imagePath);
		BufferedImage image = ImageIO.read(imageUrl);
		ImageHandlerInterface hdr = new ImageHandler();
		hdr.setImage(image);
		return hdr;
	}
	
	public void addObserver()
	{
		MouseListener for_icon = new MyMouseAdapter();
		this.addMouseListener(for_icon);
	}
	
	class MyMouseAdapter extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//canvas.unSelectAll();
			//canvas.repaint();
			IconSetOn(boat.getIconList(), (Mode) e.getSource());
			setCanvasMode(((Mode)e.getSource()).pattern);
			//MyFrame2.this.pattern = ((MyIcon) e.getSource()).pattern;
			//System.out.println(((MyIcon) e.getSource()).pattern);
		}
	};

	private void IconSetOn(ArrayList<Mode> list, Mode toSetOn)
	{
		for(Mode icon: list)
		{
			if(icon == toSetOn)
			{
				icon.mode_on();
			}
			else
			{
				icon.mode_down();
			}
		}
	}
	
	private void setCanvasMode(int p)
	{
		if(p >= 0 && p <= 5)
			boat.setCanvasMode(p);
		else if(p == -1 && ((ImageHandlerStub) normalHdr).getName() =="fake_normal") {
			boat.setCanvasMode(p);
		}
		else
		{
			System.out.println("Invalid Input");
		}
	}
	
	public ImageHandlerInterface getNormalHdr()
	{
		return normalHdr;
	}
	
	public ImageHandlerInterface getOnHdr()
	{
		return onHdr;
	}

	public abstract void clicked(MouseEvent e);
	public abstract void pressed(MouseEvent e);
	public abstract void released(MouseEvent e);	
	
	public void testOnlyIconSetOn(ArrayList<Mode> list, Mode toSetOn) {
		IconSetOn(list, toSetOn);
	}
	

}
