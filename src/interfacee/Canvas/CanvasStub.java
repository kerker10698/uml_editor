package interfacee.Canvas;

import java.util.ArrayList;

import base.Base;
import base.Line;
import base.MyPoint;
import interfacee.Mode.ModeListInterface;

public class CanvasStub extends CanvasInterface{
	
	@Override
	public int getMode() {
		// TODO Auto-generated method stub
		return mode;
	}

	@Override
	public Base searchBase(MyPoint myPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearSelectedList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFuncList(ModeListInterface f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MyPoint getPressPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPoint getReleasePoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base getPressBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Base> getSelectedList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Base> getBaseList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addABase(Base createdClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addALine(Line line) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSelectedList(Base element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Base searchBaseBB(MyPoint pressPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unselectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveBase(Base toMove, MyPoint myPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeMode(int pattern) {
		// TODO Auto-generated method stub
		mode = pattern;
	}

	@Override
	public void addASelected(Base gg) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addASelected'");
	}
}
