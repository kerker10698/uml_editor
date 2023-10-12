package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BorderTest {

	@Test
	void  In_InBorder_True() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new MyPoint(120, 188)), true);
	}
	
	@Test
	void  In_InBorderBoundary_True() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new MyPoint(100, 188)), true);
		assertEquals(b.in(new MyPoint(120, 188)), true);
		assertEquals(b.in(new MyPoint(200, 188)), true);
		assertEquals(b.in(new MyPoint(100, 100)), true);
		assertEquals(b.in(new MyPoint(120, 188)), true);
		assertEquals(b.in(new MyPoint(200, 200)), true);
	}
	
	@Test
	void  In_OutOfBorder_False() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new MyPoint(99, 188)), false);
		assertEquals(b.in(new MyPoint(201, 188)), false);
		assertEquals(b.in(new MyPoint(200, 99)), false);
		assertEquals(b.in(new MyPoint(100, 202)), false);
		assertEquals(b.in(new MyPoint(50, 197)), false);
		assertEquals(b.in(new MyPoint(123, 299)), false);
	}

	@Test
	void  InBorder_InBorder_True() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new Border(0, 300, 0, 300)), true);
	}
	
	@Test
	void  InBorder_InBorderBoundary_True() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new Border(100, 200, 100, 200)), true);
		assertEquals(b.in(new Border(50, 250, 100, 200)), true);
		assertEquals(b.in(new Border(100, 200, 50, 250)), true);
		assertEquals(b.in(new Border(100, 250, 100, 200)), true);
		assertEquals(b.in(new Border(100, 200, 100, 250)), true);
		assertEquals(b.in(new Border(50, 200, 100, 200)), true);
		assertEquals(b.in(new Border(100, 200, 50, 200)), true);
		assertEquals(b.in(new Border(50, 200, 50, 200)), true);
		assertEquals(b.in(new Border(100, 250, 100, 250)), true);
		assertEquals(b.in(new Border(50, 250, 50, 250)), true);
	}
	
	@Test
	void  InBorder_OutOfBorder_False() {
		Border b = new Border(100, 200, 100, 200);
		assertEquals(b.in(new Border(50, 100, 100, 200)), false);
		assertEquals(b.in(new Border(200, 250, 100, 100)), false);
		assertEquals(b.in(new Border(100, 200, 50, 100)), false);
		assertEquals(b.in(new Border(100, 200, 200, 250)), false);
		assertEquals(b.in(new Border(50, 100, 200, 250)), false);
	}
	/*
	@Test
	void BiggerBorder_Test()
	{
		Border b1 = Border.bigBorder(new Border(23, 377, 45, 666), new Border(37, 288, 66, 99));
		assertEquals(b1.print(""), " up = 45 left = 23 down = 666 right = 377");
		Border b2 = Border.bigBorder(new Border(23, 288, 45, 666), new Border(37, 377, 66, 99));
		assertEquals(b2.print(""), " up = 45 left = 23 down = 666 right = 377");
		Border b3 = Border.bigBorder(new Border(37, 377, 45, 666), new Border(23, 288, 66, 99));
		assertEquals(b3.print(""), " up = 45 left = 23 down = 666 right = 377");
	}
	*/
}
