package interfacee.Canvas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import base.Base;
import base.BaseStub;
import base.MyPoint;

class CanvasTest {

	@Test
	void SearchBase_SearchOutOfBorder_ReturnNull() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), false);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), false);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBase(new MyPoint(50, 60)), null);
		assertEquals(c.searchBase(new MyPoint(150, 300)), null);
		assertEquals(c.searchBase(new MyPoint(20, 350)), null);
		assertEquals(c.searchBase(new MyPoint(412, 432)), null);
	}
	
	@Test
	void SearchBase_SearchInBorder_ReturnRightBase() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), false);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), false);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBase(new MyPoint(125, 177)), b1);
		assertEquals(c.searchBase(new MyPoint(234, 267)), b2);
		assertEquals(c.searchBase(new MyPoint(345, 368)), b3);
	}
	

	@Test
	void SearchBase_SearchInBorderEdge_ReturnRightBase() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), false);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), false);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBase(new MyPoint(100, 100)), b1);
		assertEquals(c.searchBase(new MyPoint(100, 200)), b1);
		assertEquals(c.searchBase(new MyPoint(200, 100)), b1);
		
		assertEquals(c.searchBase(new MyPoint(200, 200)), b2);
		assertEquals(c.searchBase(new MyPoint(200, 300)), b2);
		assertEquals(c.searchBase(new MyPoint(300, 200)), b2);
		
		assertEquals(c.searchBase(new MyPoint(300, 300)), b3);
		assertEquals(c.searchBase(new MyPoint(300, 400)), b3);
		assertEquals(c.searchBase(new MyPoint(400, 300)), b3);
		assertEquals(c.searchBase(new MyPoint(400, 400)), b3);
	}
	
	@Test
	void SearchBaseBB_SearchOutOfBorder_ReturnNull() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), true);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), true);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBaseBB(new MyPoint(50, 60)), null);
		assertEquals(c.searchBaseBB(new MyPoint(150, 300)), null);
		assertEquals(c.searchBaseBB(new MyPoint(20, 350)), null);
		assertEquals(c.searchBaseBB(new MyPoint(412, 432)), null);
	}
	
	@Test
	void SearchBaseBB_SearchInBorder_ReturnRightBase() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), true);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), true);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBaseBB(new MyPoint(125, 177)), b1);
		assertEquals(c.searchBaseBB(new MyPoint(234, 267)), b2);
		assertEquals(c.searchBaseBB(new MyPoint(345, 368)), b3);
	}
	

	@Test
	void SearchBaseBB_SearchInBorderEdge_ReturnRightBase() {
		CanvasInterface c = new Canvas();
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		Base b2 = new BaseStub(new MyPoint(200, 200), new MyPoint(300, 300), true);
		Base b3 = new BaseStub(new MyPoint(400, 400), new MyPoint(300, 300), true);
		c.addABase(b1);
		c.addABase(b2);
		c.addABase(b3);
		assertEquals(c.searchBaseBB(new MyPoint(100, 100)), b1);
		assertEquals(c.searchBaseBB(new MyPoint(100, 200)), b1);
		assertEquals(c.searchBaseBB(new MyPoint(200, 100)), b1);
		
		assertEquals(c.searchBaseBB(new MyPoint(200, 200)), b2);
		assertEquals(c.searchBaseBB(new MyPoint(200, 300)), b2);
		assertEquals(c.searchBaseBB(new MyPoint(300, 200)), b2);
		
		assertEquals(c.searchBaseBB(new MyPoint(300, 300)), b3);
		assertEquals(c.searchBaseBB(new MyPoint(300, 400)), b3);
		assertEquals(c.searchBaseBB(new MyPoint(400, 300)), b3);
		assertEquals(c.searchBaseBB(new MyPoint(400, 400)), b3);
	}
	
	@Test
	void ChangeMode_Change_ChangedMode() {
		CanvasInterface c = new Canvas();
		c.changeMode(1);
		assertEquals(c.getMode(), 1);
	}

	@Test
	void MoveBase_PositivePoint_MovedBase() {
		CanvasInterface c = new Canvas();
		Base b = new BaseStub(new MyPoint(100, 100), true);
		c.addABase(b);
		c.moveBase(b, new MyPoint(200, 300));
		assertEquals( (c.getBaseList().get(0)).getPin().x, 200);
		assertEquals( (c.getBaseList().get(0)).getPin().y, 300);
	}
	
	@Test
	void MoveBase_NegativePoint_UnmovedBase() {
		CanvasInterface c = new Canvas();
		Base b = new BaseStub(new MyPoint(100, 100), true);
		c.addABase(b);
		c.moveBase(b, new MyPoint(-200, -300));
		assertEquals( (c.getBaseList().get(0)).getPin().x, -200);
		assertEquals( (c.getBaseList().get(0)).getPin().y, -300);
	}
	
	@Test
	void AddABase_Add_ListWithBaseAdded() {
		CanvasInterface c = new Canvas();
		Base b = new BaseStub(new MyPoint(100, 100), true);
		c.addABase(b);
		assertEquals( c.getBaseList().get(0), b);
	}
	
	@Test
	void AddSelectedList_Add_ListWithBaseAdded() {
		CanvasInterface c = new Canvas();
		Base b = new BaseStub(new MyPoint(100, 100), true);
		c.addSelectedList(b);
		assertEquals( c.getSelectedList().get(0), b);
	}
	
	@Test
	void ClearSelectedList_ClearSelectedList_EmptyList() {
		CanvasInterface c = new Canvas();
		assertEquals( c.getSelectedList().isEmpty(), true);
		Base b1 = new BaseStub(new MyPoint(100, 100), true);
		c.addSelectedList(b1);
		Base b2 = new BaseStub(new MyPoint(200, 200), true);
		c.addSelectedList(b2);
		Base b3 = new BaseStub(new MyPoint(300, 300), true);
		c.addSelectedList(b3);
		Base b4 = new BaseStub(new MyPoint(400, 400), true);
		c.addSelectedList(b4);
		Base b5 = new BaseStub(new MyPoint(500, 500), true);
		c.addSelectedList(b5);
		c.clearSelectedList();
		assertEquals( c.getSelectedList().isEmpty(), true);
	}
	
	@Test
	void UnSelectedAll__UnSelectAll_EmptySelectedList() {
		CanvasInterface c = new Canvas();
		assertEquals( c.getSelectedList().isEmpty(), true);
		Base b1 = new BaseStub(new MyPoint(100, 100), true);
		b1.setSelect(true);
		c.addSelectedList(b1);
		Base b2 = new BaseStub(new MyPoint(200, 200), true);
		b2.setSelect(true);
		c.addSelectedList(b2);
		Base b3 = new BaseStub(new MyPoint(300, 300), true);
		b3.setSelect(true);
		c.addSelectedList(b3);
		Base b4 = new BaseStub(new MyPoint(400, 400), true);
		b4.setSelect(true);
		c.addSelectedList(b4);
		Base b5 = new BaseStub(new MyPoint(500, 500), true);
		b5.setSelect(true);
		c.addSelectedList(b5);
		c.unselectAll();;
		ArrayList<Base> arrb = c.getSelectedList();
		for(int i = 0; i < arrb.size(); i++) {
			assertEquals(((BaseStub)arrb.get(i)).isSelected(), false);
		}
	}
}
