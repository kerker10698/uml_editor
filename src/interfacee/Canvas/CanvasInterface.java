package interfacee.Canvas;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JPanel;

import base.Base;
import base.Line;
import base.MyPoint;
import interfacee.Mode.ModeListInterface;

public abstract class CanvasInterface extends JPanel {

	int mode = -1;
	public abstract void setFuncList(ModeListInterface f);
	public abstract MyPoint getPressPoint();
	public abstract MyPoint getReleasePoint();
	public abstract Base getPressBase();
	public abstract ArrayList<Base>  getSelectedList();
	public abstract ArrayList<Base>  getBaseList();
	public abstract void addABase(Base createdClass);
	public abstract void addALine(Line line);
	public abstract void addSelectedList(Base element);
	public abstract Base searchBaseBB(MyPoint pressPoint);
	public abstract void unselectAll();
	public abstract void moveBase(Base toMove, MyPoint myPoint);
	public abstract void changeMode(int pattern);
	public abstract int getMode();
	public abstract Base searchBase(MyPoint myPoint);
	public abstract void clearSelectedList();
	public abstract void addASelected(Base gg);
    public void printAllLine() {
    }
    public void repaintAll() {
    }
}
