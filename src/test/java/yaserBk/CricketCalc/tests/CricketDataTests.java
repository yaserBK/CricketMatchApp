package yaserBk.CricketCalc.tests;

import yaserBk.CricketCalc.CricketData;
import org.junit.Test;
import  static org.junit.Assert.*;

public class CricketDataTests {
	@Test
	public void createAndTest(){
		CricketData cd = new CricketData();
		assertNotNull(cd);
	}

	@Test
	public void setterTest(){
		CricketData cd = new CricketData(); //creating an instance of CricketData object
		cd.setScore(20,14,16);//using the setter
		//ensuring the set values match the variables values (called with getters from that class)
		assertEquals(cd.getRuns(), 20,0);
		assertEquals(cd.getOvers(), 14,0);
		assertEquals(cd.getWickets(), 16,0);
	}

}
