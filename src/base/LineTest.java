package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

	@Test
	void AdjustPin_SamePort_Test() {
		MyPoint p = new MyPoint(100, 100);
		Border b = new Border(100, 600, 100, 600);
		Base b1 = new BaseStub(new MyPoint(100, 100), new MyPoint(200, 200), true);
		((BaseStub)b1).setWidthAndHeight(100,100);
		Base b2 = new BaseStub(new MyPoint(500, 500), new MyPoint(600, 600), true);
		((BaseStub)b2).setWidthAndHeight(100,100);
		Line l1 = new LineStub(p, b, b1, b2, 1, 1);
		//l1.print("before adjust");
		l1.adjust(b1, b2, 1, 1);
		
		assertEquals(l1.innerBorder.getPin().x, 150);
		assertEquals(l1.innerBorder.getPin().y, 106);
		assertEquals(l1.innerBorder.getWidth(), 400);
		assertEquals(l1.innerBorder.getHeight(), 400);
		
		assertEquals(l1.outerBorder.getPin().x, 140);
		assertEquals(l1.outerBorder.getPin().y, 96);
		assertEquals(l1.outerBorder.getWidth(), 420);
		assertEquals(l1.outerBorder.getHeight(), 420);
		
		assertEquals(l1.getPin().x, 150);
		assertEquals(l1.getPin().y, 106);
		
		assertEquals(l1.getAdjustPin().x, 140);
		assertEquals(l1.getAdjustPin().y, 96);
		
		assertEquals(l1.getWidth(), 420);
		assertEquals(l1.getHeight(), 420);
		
		assertEquals(l1.getBounds().x, 140);
		assertEquals(l1.getBounds().y, 96);
		assertEquals(l1.getBounds().width, 420);
		assertEquals(l1.getBounds().height, 420);
	}
	
	@Test
	void AdjustPin_DiffernentPort_Test() {
		MyPoint p = new MyPoint(100, 100);
		Border b = new Border(100, 600, 100, 600);
		Base b1 = new BaseStub(new MyPoint(100, 100), new MyPoint(200, 200), true);
		((BaseStub)b1).setWidthAndHeight(100,100);
		Base b2 = new BaseStub(new MyPoint(500, 500), new MyPoint(600, 600), true);
		((BaseStub)b2).setWidthAndHeight(100,100);
		Line l1 = new LineStub(p, b, b1, b2, 1, 2);
		//l1.print("before adjust");
		l1.adjust(b1, b2, 1, 2);
		// l1.print("after adjust");
		
		assertEquals(l1.innerBorder.getPin().x, 150);
		assertEquals(l1.innerBorder.getPin().y, 106);
		assertEquals(l1.innerBorder.getWidth(), 356);
		assertEquals(l1.innerBorder.getHeight(), 444);
		
		assertEquals(l1.outerBorder.getPin().x, 140);
		assertEquals(l1.outerBorder.getPin().y, 96);
		assertEquals(l1.outerBorder.getWidth(), 376);
		assertEquals(l1.outerBorder.getHeight(), 464);
		
		assertEquals(l1.getPin().x, 150);
		assertEquals(l1.getPin().y, 106);
		
		assertEquals(l1.getAdjustPin().x, 140);
		assertEquals(l1.getAdjustPin().y, 96);
		
		assertEquals(l1.getWidth(), 376);
		assertEquals(l1.getHeight(), 464);
		
		assertEquals(l1.getBounds().x, 140);
		assertEquals(l1.getBounds().y, 96);
		assertEquals(l1.getBounds().width, 376);
		assertEquals(l1.getBounds().height, 464);
	}

}
