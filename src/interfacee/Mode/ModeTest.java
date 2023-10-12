package interfacee.Mode;
import interfacee.Canvas.*;
import interfacee.Mode.*;
import interfacee.Listener.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import af.swing.image.ImageHandlerStub;

class ModeTest {

	@Test
	void Mode_Test() {
		ModeStub m = new ModeStub("", "fake_normal", "fake_on", 1, new ModeListStub());
		assertEquals(((ImageHandlerStub)m.getNormalHdr()).getName(), new ImageHandlerStub("fake_normal").getName());
		assertEquals(((ImageHandlerStub)m.getOnHdr()).getName(), new ImageHandlerStub("fake_on").getName());
	}
	
	@Test
	void ModeDown_Test() {
		ModeStub m = new ModeStub("", "fake_normal", "fake_on", 1, new ModeListStub());
		assertEquals(((ImageHandlerStub)m.getImage()).getName(), new ImageHandlerStub("fake_normal").getName());
		m.mode_on();
		assertEquals(((ImageHandlerStub)m.getImage()).getName(), new ImageHandlerStub("fake_on").getName());
		m.mode_down();
		assertEquals(((ImageHandlerStub)m.getImage()).getName(), new ImageHandlerStub("fake_normal").getName());
	}
	
	@Test
	void ModeOn_Test() {
		ModeStub m = new ModeStub("", "fake_normal", "fake_on", 1, new ModeListStub());
		assertEquals(((ImageHandlerStub)m.getImage()).getName(), new ImageHandlerStub("fake_normal").getName());
		m.mode_on();
		assertEquals(((ImageHandlerStub)m.getImage()).getName(), new ImageHandlerStub("fake_on").getName());
	}
	
	@Test
	void IconSetOn_Test() {
		ModeStub m = new ModeStub("", "fake_normal", "fake_on", 1, new ModeListStub());
		ArrayList<Mode> list = new ArrayList<Mode>();
		Mode to_set_on = null;
		ModeFactory modeFactory = new ModeFactory();
		for(int i = 0 ; i < 10; ++i)
		{
			Mode to_add = modeFactory.make("", "fake_normal", "fake_on", -1, new ModeListStub());
			list.add(to_add);
			if(i ==2) {
				to_set_on = to_add;
			}
		}
		m.testOnlyIconSetOn(list, to_set_on);
		for(int i = 0 ; i < 10; ++i)
		{
			if(i !=2) {
				assertEquals(((ImageHandlerStub)list.get(i).getImage()).getName(), new ImageHandlerStub("fake_normal").getName());
			}
			else {
				assertEquals(((ImageHandlerStub)list.get(i).getImage()).getName(), new ImageHandlerStub("fake_on").getName());
			}
		}
	}
}
