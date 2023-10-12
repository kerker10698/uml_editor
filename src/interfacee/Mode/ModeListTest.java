package interfacee.Mode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfacee.Canvas.CanvasStub;

class ModeListTest {

	@Test
	void SetCanvasMode_RightMode() {
		ModeListInterface f = new ModeList(new CanvasStub());
		f.setCanvasMode(1);
		assertEquals(f.getCanvasMode(), 1);
	}

}
