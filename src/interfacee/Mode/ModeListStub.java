package interfacee.Mode;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

public class ModeListStub extends ModeListInterface{
	
	private int canvasMode = -1;
	
	ModeListStub()
	{
		
	}
	
	public void setCanvasMode(int p) {
		canvasMode = p;
	}

	@Override
	public int getCanvasMode() {
		// TODO Auto-generated method stub
		return canvasMode;
	}
}
