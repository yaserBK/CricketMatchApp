package yaserBk.CricketCalc.tests;

import yaserBk.CricketCalc.CricketData;
import yaserBk.CricketCalc.CurrentScoreDisplay;
import org.junit.Test;
import static org.junit.Assert.*;

public class CurrentScoreDisplayTests {

	@Test
	public void createAndTest(){
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
		assertNotNull(currentScoreDisplay);
	}

	@Test // testing if object reacts appropriately to changes in the object it observers
	public void observationTest(){
		CricketData cricketData = new CricketData(); //object to be observed
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay(); //the observer
		cricketData.addObserver(currentScoreDisplay); //adding observer to observable object
		cricketData.setScore(3,5,9); //providing values (int runs, float overs, int wickets)
		cricketData.notifyObservers(); //notifying the observer (CurrentScoreDisplay object)

		// insuring the values of the observer match the values given to cricketData.setScore.
		assertEquals(3, Integer.parseInt(currentScoreDisplay.getRuns().getText()), 0);
		assertEquals(5, Float.parseFloat(currentScoreDisplay.getOvers().getText()), 0);
		assertEquals(9, Integer.parseInt(currentScoreDisplay.getWickets().getText()), 0);


	}

}
