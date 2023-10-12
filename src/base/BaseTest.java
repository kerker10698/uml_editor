package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseTest {

	@Test
	void In_OutOfBase_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(new MyPoint(30, 30)), false);
		assertEquals(b1.in(new MyPoint(132, 265)), false);
		assertEquals(b1.in(new MyPoint(322, 22)), false);
		assertEquals(b1.in(new MyPoint(225, 408)), false);
		assertEquals(b1.in(new MyPoint(123, 175)), true);
		assertEquals(b1.in(new MyPoint(256, 278)), false);
		assertEquals(b1.in(new MyPoint(364, 398)), false);
	}
	
	@Test
	void In_InBase_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(new MyPoint(123, 175)), true);
		assertEquals(b1.in(new MyPoint(176, 145)), true);
		assertEquals(b1.in(new MyPoint(155, 134)), true);
		assertEquals(b1.in(new MyPoint(124, 111)), true);
	}
	
	@Test
	void In_InBaseBoundary_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(new MyPoint(100, 100)), true);
		assertEquals(b1.in(new MyPoint(100, 200)), true);
		assertEquals(b1.in(new MyPoint(200, 100)), true);
		assertEquals(b1.in(new MyPoint(200, 200)), true);
	}
	
	@Test
	void InBorder_CompletelyOutOfBase_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(10, 70), new MyPoint(65, 23))), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(237, 423), new MyPoint(236, 477))), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(426, 413), new MyPoint(435, 577))), false);
	}
	
	@Test
	void InBorder_BasePartiallyIncluded_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(123, 225), new MyPoint(178, 230))), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(92, 28), new MyPoint(128, 333))), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(178, 188), new MyPoint(234, 125))), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(150, 160), new MyPoint(160, 150))), false);
	}
	
	@Test
	void InBorder_CompletelyCoverBase_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(0, 300), new MyPoint(300, 0))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 200), new MyPoint(200, 100))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(200, 100), new MyPoint(100, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(0, 200), new MyPoint(200, 0))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(50, 100), new MyPoint(200, 235))), true);
	}
	
	@Test
	void InBorder_CompletelyCoverBaseBoundary_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), false);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(200, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(0, 100), new MyPoint(200, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(300, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(0, 100), new MyPoint(300, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 0), new MyPoint(200, 200))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(200, 300))), true);
		assertEquals(b1.in(MyPoint.getBorder(new MyPoint(100, 0), new MyPoint(200, 300))), true);
	}
	
	@Test
	void InBB_OutOfBase_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(new MyPoint(30, 30)), false);
		assertEquals(b1.inBB(new MyPoint(132, 265)), false);
		assertEquals(b1.inBB(new MyPoint(322, 22)), false);
		assertEquals(b1.inBB(new MyPoint(225, 408)), false);
		assertEquals(b1.inBB(new MyPoint(123, 175)), true);
		assertEquals(b1.inBB(new MyPoint(256, 278)), false);
		assertEquals(b1.inBB(new MyPoint(364, 398)), false);
	}
	
	@Test
	void InBB_InBase_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(new MyPoint(123, 175)), true);
		assertEquals(b1.inBB(new MyPoint(176, 145)), true);
		assertEquals(b1.inBB(new MyPoint(155, 134)), true);
		assertEquals(b1.inBB(new MyPoint(124, 111)), true);
	}
	
	@Test
	void InBB_InBaseBoundary_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(new MyPoint(100, 100)), true);
		assertEquals(b1.inBB(new MyPoint(100, 200)), true);
		assertEquals(b1.inBB(new MyPoint(200, 100)), true);
		assertEquals(b1.inBB(new MyPoint(200, 200)), true);
	}
	
	@Test
	void InBBBorder_CompletelyOutOfBase_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(10, 70), new MyPoint(65, 23))), false);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(237, 423), new MyPoint(236, 477))), false);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(426, 413), new MyPoint(435, 577))), false);
	}
	
	@Test
	void InBBBorder_BasePartiallyIncluded_False() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(123, 225), new MyPoint(178, 230))), false);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(92, 28), new MyPoint(128, 333))), false);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(178, 188), new MyPoint(234, 125))), false);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(150, 160), new MyPoint(160, 150))), false);
	}
	
	@Test
	void InBBBorder_CompletelyCoverBase_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(0, 300), new MyPoint(300, 0))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 200), new MyPoint(200, 100))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(200, 100), new MyPoint(100, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(0, 200), new MyPoint(200, 0))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(50, 100), new MyPoint(200, 235))), true);
	}
	
	@Test
	void InBBBorder_CompletelyCoverBaseBoundary_True() {
		Base b1 = new BaseStub(new MyPoint(100, 200), new MyPoint(200, 100), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(200, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(0, 100), new MyPoint(200, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(300, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(0, 100), new MyPoint(300, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 0), new MyPoint(200, 200))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 100), new MyPoint(200, 300))), true);
		assertEquals(b1.inBB(MyPoint.getBorder(new MyPoint(100, 0), new MyPoint(200, 300))), true);
	}
	
	@Test
	void PortIn_PointInUp_Get1() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(150, 206)), 1);
	}
	
	@Test
	void PortIn_PointInUpBoundary_Get1() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(144, 206)), 1);
		assertEquals(b1.portIn(new MyPoint(147, 206)), 1);
		assertEquals(b1.portIn(new MyPoint(152, 206)), 1);
		assertEquals(b1.portIn(new MyPoint(156, 206)), 1);
		assertEquals(b1.portIn(new MyPoint(150, 200)), 1);
		assertEquals(b1.portIn(new MyPoint(150, 205)), 1);
		assertEquals(b1.portIn(new MyPoint(150, 207)), 1);
		assertEquals(b1.portIn(new MyPoint(150, 212)), 1);
	}
	
	@Test
	void PortIn_PointInLeft_Get2() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(106, 250)), 2);
	}
	
	@Test
	void PortIn_PointInLeftBoundary_Get2() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(100, 250)), 2);
		assertEquals(b1.portIn(new MyPoint(104, 250)), 2);
		assertEquals(b1.portIn(new MyPoint(107, 250)), 2);
		assertEquals(b1.portIn(new MyPoint(112, 250)), 2);
		assertEquals(b1.portIn(new MyPoint(106, 244)), 2);
		assertEquals(b1.portIn(new MyPoint(106, 248)), 2);
		assertEquals(b1.portIn(new MyPoint(106, 253)), 2);
		assertEquals(b1.portIn(new MyPoint(106, 256)), 2);
	}
	
	@Test
	void PortIn_PointInDown_Get3() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(150, 294)), 3);
	}
	
	@Test
	void PortIn_PointInDownBoundary_Get3() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(144, 294)), 3);
		assertEquals(b1.portIn(new MyPoint(147, 294)), 3);
		assertEquals(b1.portIn(new MyPoint(152, 294)), 3);
		assertEquals(b1.portIn(new MyPoint(156, 294)), 3);
		assertEquals(b1.portIn(new MyPoint(150, 288)), 3);
		assertEquals(b1.portIn(new MyPoint(150, 293)), 3);
		assertEquals(b1.portIn(new MyPoint(150, 295)), 3);
		assertEquals(b1.portIn(new MyPoint(150, 300)), 3);
	}
	
	@Test
	void PortIn_PointInRight_Get4() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(194, 250)), 4);
	}
	
	@Test
	void PortIn_PointInRightBoundary_Get4() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		assertEquals(b1.portIn(new MyPoint(188, 250)), 4);
		assertEquals(b1.portIn(new MyPoint(190, 250)), 4);
		assertEquals(b1.portIn(new MyPoint(196, 250)), 4);
		assertEquals(b1.portIn(new MyPoint(200, 250)), 4);
		assertEquals(b1.portIn(new MyPoint(194, 244)), 4);
		assertEquals(b1.portIn(new MyPoint(194, 248)), 4);
		assertEquals(b1.portIn(new MyPoint(194, 253)), 4);
		assertEquals(b1.portIn(new MyPoint(194, 256)), 4);
	}
		
	
	@Test
	void PortIn_PointOutOfAllPort_Get0() {
		Base b1 = new BaseStub(new MyPoint(100, 200), true);
		
		assertEquals(b1.portIn(new MyPoint(150, 180)), 0);
		assertEquals(b1.portIn(new MyPoint(130, 190)), 0);
		assertEquals(b1.portIn(new MyPoint(170, 190)), 0);
		
		assertEquals(b1.portIn(new MyPoint(80, 250)), 0);
		assertEquals(b1.portIn(new MyPoint(90, 230)), 0);
		assertEquals(b1.portIn(new MyPoint(90, 270)), 0);
		
		assertEquals(b1.portIn(new MyPoint(220, 250)), 0);
		assertEquals(b1.portIn(new MyPoint(210, 230)), 0);
		assertEquals(b1.portIn(new MyPoint(210, 270)), 0);
		
		assertEquals(b1.portIn(new MyPoint(150, 320)), 0);
		assertEquals(b1.portIn(new MyPoint(130, 310)), 0);
		assertEquals(b1.portIn(new MyPoint(170, 310)), 0);
	}
/////////////////////////////////////////////////////////////////
	@Test
	void SetPort_Test() {
		Base b1 = new BaseStub(new MyPoint(100, 100), false);
		b1.testOn();
		b1.setPort();
		assertEquals(b1.up.getBounds().x, 44);
		assertEquals(b1.up.getBounds().y, 0);
		assertEquals(b1.up.getBounds().width, 12);
		assertEquals(b1.up.getBounds().height, 12);
		
		assertEquals(b1.up.getPreferredSize().width, 12);
		assertEquals(b1.up.getPreferredSize().height, 12);
		
		assertEquals(((PortStub)b1.up).length, 12);
		assertEquals(((PortStub)b1.up).show, false);
		
		assertEquals(b1.left.getBounds().x, 0);
		assertEquals(b1.left.getBounds().y, 44);
		assertEquals(b1.left.getBounds().width, 12);
		assertEquals(b1.left.getBounds().height, 12);
		
		assertEquals(b1.left.getPreferredSize().width, 12);
		assertEquals(b1.left.getPreferredSize().height, 12);
		
		assertEquals(((PortStub)b1.left).length, 12);
		assertEquals(((PortStub)b1.left).show, false);
		
		assertEquals(b1.down.getBounds().x, 44);
		assertEquals(b1.down.getBounds().y, 88);
		assertEquals(b1.down.getBounds().width, 12);
		assertEquals(b1.down.getBounds().height, 12);
		
		assertEquals(b1.down.getPreferredSize().width, 12);
		assertEquals(b1.down.getPreferredSize().height, 12);
		
		assertEquals(((PortStub)b1.down).length, 12);
		assertEquals(((PortStub)b1.down).show, false);
		
		assertEquals(b1.right.getBounds().x, 88);
		assertEquals(b1.right.getBounds().y, 44);
		assertEquals(b1.right.getBounds().width, 12);
		assertEquals(b1.right.getBounds().height, 12);
		
		assertEquals(b1.right.getPreferredSize().width, 12);
		assertEquals(b1.right.getPreferredSize().height, 12);

		assertEquals(((PortStub)b1.right).length, 12);
		assertEquals(((PortStub)b1.right).show, false);
	}
	
	@Test
	void SetBorder_Test() {
		Base b1 = new BaseStub(new MyPoint(100, 100), false);
		b1.setBorder();
		assertEquals(b1.innerBorder.getPin().x, 112);
		assertEquals(b1.innerBorder.getPin().y, 112);
		assertEquals(b1.innerBorder.getWidth(), 76);
		assertEquals(b1.innerBorder.getHeight(), 76);
		assertEquals(b1.outerBorder.getPin().x, 100);
		assertEquals(b1.outerBorder.getPin().y, 100);
		assertEquals(b1.outerBorder.getWidth(), 100);
		assertEquals(b1.outerBorder.getHeight(), 100);
	}
	
	@Test
	void Rename_Test() {
		Base b1 = new BaseStub(new MyPoint(100, 100), true);
		b1.rename("haha");
		assertEquals(b1.l1.getText(), "haha");
	}
	
	@Test
	void SetSelected_Test() {
		Base b1 = new BaseStub(new MyPoint(100, 100), false);
		b1.testOn();
		b1.setPort();
		assertEquals(b1.selected, false);
		assertEquals(((PortStub)b1.up).show, false);
		assertEquals(((PortStub)b1.left).show, false);
		assertEquals(((PortStub)b1.down).show, false);
		assertEquals(((PortStub)b1.right).show, false);
		b1.setSelect(true);
		assertEquals(b1.selected, true);
		assertEquals(((PortStub)b1.up).show, true);
		assertEquals(((PortStub)b1.left).show, true);
		assertEquals(((PortStub)b1.down).show, true);
		assertEquals(((PortStub)b1.right).show, true);
		b1.setSelect(false);
		assertEquals(b1.selected, false);
		assertEquals(((PortStub)b1.up).show, false);
		assertEquals(((PortStub)b1.left).show, false);
		assertEquals(((PortStub)b1.down).show, false);
		assertEquals(((PortStub)b1.right).show, false);
	}
	
	@Test
	void ModifyPin() {
		Base b1 = new BaseStub(new MyPoint(100, 100), true);
		assertEquals(b1.getPin().x, 100);
		assertEquals(b1.getPin().y, 100);
		b1.modifyPin(new MyPoint(200, 400));
		assertEquals(b1.getPin().x, 200);
		assertEquals(b1.getPin().y, 400);
		
		assertEquals(b1.innerBorder.getPin().x, 212);
		assertEquals(b1.innerBorder.getPin().y, 412);
		assertEquals(b1.innerBorder.getWidth(), 76);
		assertEquals(b1.innerBorder.getHeight(), 76);
		assertEquals(b1.outerBorder.getPin().x, 200);
		assertEquals(b1.outerBorder.getPin().y, 400);
		assertEquals(b1.outerBorder.getWidth(), 100);
		assertEquals(b1.outerBorder.getHeight(), 100);
	}
	
	@Test
	void ModifyPinRelative() {
		Base b1 = new BaseStub(new MyPoint(100, 100), true);
		assertEquals(b1.getPin().x, 100);
		assertEquals(b1.getPin().y, 100);
		b1.modifyPinRelative(new MyPoint(200, 400));
		assertEquals(b1.getPin().x, 300);
		assertEquals(b1.getPin().y, 500);
		
		assertEquals(b1.innerBorder.getPin().x, 312);
		assertEquals(b1.innerBorder.getPin().y, 512);
		assertEquals(b1.innerBorder.getWidth(), 76);
		assertEquals(b1.innerBorder.getHeight(), 76);
		assertEquals(b1.outerBorder.getPin().x, 300);
		assertEquals(b1.outerBorder.getPin().y, 500);
		assertEquals(b1.outerBorder.getWidth(), 100);
		assertEquals(b1.outerBorder.getHeight(), 100);
	}
}
