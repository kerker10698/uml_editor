package interfacee.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import base.Base;
import base.Border;
import base.MyPoint;
import base.UseCase;
import interfacee.Mode.ModeListInterface;
import base.ClassDef;
import base.Group;
import base.Line;

public class Canvas extends CanvasInterface implements MouseListener{
	
	private ArrayList<Base> baseList = new ArrayList<>();
	private ArrayList<Base> selectedList = new ArrayList<>();
	private ArrayList<Line> lineList = new ArrayList<>();
	
	private JLabel modeInfo = new JLabel("777");
	private MyPoint pressPoint;
	private MyPoint releasePoint;
	private Base pressBase;
	private Base releaseBase;
	private Base pressBaseBB;
	private Base releaseBaseBB;
	ModeListInterface toolKit;
	//ClassDef ttc= new ClassDef(new MyPoint(100, 100), new Border(100, 200, 100, 200));;
	public Canvas()
	{
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.addMouseListener(this);
		//test();
		this.add(modeInfo);
		modeInfo.setPreferredSize(new Dimension(100, 80));
		modeInfo.setBounds(0, 0, 100, 80);
		
		//ttc = new ClassDef(new MyPoint(100, 100), new Border(100, 200, 100, 200));
		//this.add(ttc);
		//ttc.setBounds(100, 100, 200, 200);
		//ttc.setPreferredSize(new Dimension(200, 200));

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		unselectAll();
		toolKit.getIconList().get(mode).clicked(e);
		this.repaint();
		repaintAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		unselectAll();
		pressPoint = new MyPoint(e.getX(), e.getY());
		pressBase = searchBase(pressPoint);
		if (pressBase != null)	
			addASelected(pressBase);
		pressBaseBB = searchBaseBB(pressPoint);
		this.repaint();
		repaintAll();
		System.out.println("press");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		releasePoint = new MyPoint(e.getX(), e.getY());
		releaseBase = searchBase(releasePoint);
		releaseBaseBB = searchBaseBB(releasePoint);
		
		System.out.println("release");
		toolKit.getIconList().get(mode).released(e);
		this.repaint();
		this.updateUI();
		repaintAll();
		System.out.println("releasend");
		System.out.println(lineList);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void changeMode(int a) //ok
	{
		System.out.println("modemode");
		if(a < 0)
		{
			System.out.println("Invalid Mode in Canvas change mode");
		}
		mode = a;
		modeInfo.setText("mode: " + Integer.toString(a));
	}
	
	public Base searchBase(MyPoint se)
	{
		for(int index = baseList.size() - 1; index >= 0; index--)
		{
			Base element = baseList.get(index);
			if(element.in(se))
			{
				return element;
			}
		}
		return null;
	}
	
	public Base searchBaseBB(MyPoint se)
	{
		for(int index = baseList.size() - 1; index >= 0; index--)
		{
			Base element = baseList.get(index);
			if(element.inBB(se))
			{
				return element;
			}
		}
		return null;
	}
	
	public void moveBase(Base b, MyPoint p) //ok
	{
		// if(p.x < 0 || p.y < 0) {
		// 	System.out.println("Invalid point in canvas moveBase");
		// }
		// else {
		b.modifyPin(p);
		// }
	}
	
	public void setFuncList(ModeListInterface _f)
	{
		toolKit = _f;
	}
	
	public void addABase(Base b) //ok
	{
		this.add(b);
		baseList.add(b);
		b.setBounds(b.getPin().x, b.getPin().y, b.getWidth(), b.getHeight());
		this.repaint();
	}
	
	public void addALine(Line l) //
	{
		this.add(l);
		lineList.add(l);
		l.setBounds(l.getPin().x, l.getPin().y, l.getWidth(), l.getHeight());
		this.repaint();
	}

	public void addASelected(Base b)	
	{	
		this.add(b);	
		selectedList.add(b);	
		b.setBounds(b.getPin().x, b.getPin().y, b.getWidth(), b.getHeight());	
		this.repaint();	
	}

	public ArrayList<Base> getBaseList()
	{
		return baseList;
	}
	
	public MyPoint getPressPoint()
	{
		return pressPoint;
	}
	
	public MyPoint getReleasePoint()
	{
		return releasePoint;
	}
	
	public Base getPressBase()
	{
		return pressBase;
	}
	
	public ArrayList<Base> getSelectedList() 
	{
		return selectedList;
	}
	
	public Base getPressBaseBB()
	{
		return pressBaseBB;
	}
	
	public Base getReleaseBase()
	{
		return releaseBase;
	}
	
	public Base getReleaseBaseBB()
	{
		return releaseBaseBB;
	}
	
	public void repaintAll()
	{
		for(Base element: baseList)
		{
			element.repaint();
		}
		
		for(Line line: lineList)
		{
			line.repaint();
		}
	}

	public void clearSelectedList() //ok
	{
		selectedList.clear();
	}
	
	public void addSelectedList(Base b) //ok
	{
		selectedList.add(b);
	}
	
	public void unselectAll() //ok
	{
		clearSelectedList();
		for(Base element: baseList)
		{
			element.setSelect(false);
		}
	}
	@Override
	public int getMode() {
		// TODO Auto-generated method stub
		return mode;
	}

	public void printAllLine() {
		for (Line l : lineList) {
			l.print("LINELINELINELINELINELINELINE=========LINELINELINELINELINELINELINE");
		}
	}
}
