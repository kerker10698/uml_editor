package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyPointTest {

	@Test
	void GetPin_GetMostLeftUpPoint() {
		
		MyPoint p1 = MyPoint.getPin(new MyPoint(10, 20), new MyPoint(30, 40));
		assertEquals(p1.x, 10); 
		assertEquals(p1.y, 20); 
		
		MyPoint p2 = MyPoint.getPin(new MyPoint(30, 40), new MyPoint(10, 20));
		assertEquals(p2.x, 10); 
		assertEquals(p2.y, 20); 
		
		MyPoint p3 = MyPoint.getPin(new MyPoint(10, 40), new MyPoint(10, 20));
		assertEquals(p3.x, 10); 
		assertEquals(p3.y, 20); 
		
		MyPoint p4 = MyPoint.getPin(new MyPoint(30, 20), new MyPoint(10, 40));
		assertEquals(p4.x, 10); 
		assertEquals(p4.y, 20); 
	}
	
	@Test
	void Rotate_GetRotatedVector() {
		
		MyPoint p = new MyPoint(100, 100);
		assertEquals(p.rotate(Math.PI/6).print(""), " x = 36 y = 136");
		
	}
	
	@Test
	void LenModify_GetSameDirectionAndDesiredLengthVector() {
		
		MyPoint p1 = new MyPoint(100, 100);
		assertEquals(p1.lenModify(10).print(""), " x = 7 y = 7");
		
		MyPoint p2 = new MyPoint(100, 100);
		assertEquals(p2.lenModify(0).print(""), " x = 0 y = 0");
	}
	
	@Test
	void LenMutipleGetSameDirectionAndMultipledLengthVector() {
		
		MyPoint p1 = new MyPoint(100, 100);
		assertEquals(p1.lenMutiple(5).print(""), " x = 500 y = 500");
		
		MyPoint p2 = new MyPoint(100, 100);
		assertEquals(p2.lenMutiple(0).print(""), " x = 0 y = 0");
	}
	
	@Test
	void Project_GetVectorProjectOnTheOtherOne() {
		
		MyPoint p1 = new MyPoint(100, 100);
		assertEquals(p1.project(new MyPoint(20, 50)).print(""), " x = 48 y = 120");
	}
	
	@Test
	void Project_SameDirection_GetVectoNotModified() {
		
		MyPoint p2 = new MyPoint(100, 100);
		assertEquals(p2.project(new MyPoint(20, 20)).print(""), " x = 100 y = 100");
	}
	
	@Test
	void Project_Orthogonal_GetV0() {
		
		MyPoint p3 = new MyPoint(100, 100);
		assertEquals(p3.project(new MyPoint(20, -20)).print(""), " x = 0 y = 0");
	}

	@Test
	void InnerProduct_GetInnerProduct()
	{
		
		MyPoint p1 = new MyPoint(100, 100);
		assertEquals(p1.innerProduct(new MyPoint(20, 50)), 7000);
	}
	
	@Test
	void InnerProduct_SameDirection_GetInnerProduct() {
		
		MyPoint p2 = new MyPoint(100, 100);
		assertEquals(p2.innerProduct(new MyPoint(20, 20)), 4000);
	}
	
	@Test
	void InnerProduct_Orthogonal_GetInnerProduct() {
		
		MyPoint p3 = new MyPoint(100, 100);
		assertEquals(p3.innerProduct(new MyPoint(20, -20)), 0);
	}

}
