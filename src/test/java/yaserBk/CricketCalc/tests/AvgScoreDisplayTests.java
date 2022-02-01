package yaserBk.CricketCalc.tests;
import yaserBk.CricketCalc.AvgScoreDisplay;
import yaserBk.CricketCalc.CricketData;
import org.junit.Test;
import static org.junit.Assert.*;
public class AvgScoreDisplayTests {
	@Test
	public void createAndTest(){
		AvgScoreDisplay asd = new AvgScoreDisplay();
		assertNotNull(asd);
	}
	@Test
	public void observationTest(){
		CricketData cricketData = new CricketData(); //cricketData object (Observable)
		AvgScoreDisplay avgScoreDisplay = new AvgScoreDisplay(); // our observer
		//declaring variables for testing
		int runs = 45;
		float overs = 7;
		int wickets = 2;
		//setting score to the variables declared above
		cricketData.setScore(runs,overs,wickets);
		//adding avgScoreDisplay as observer observing cricketData object
		cricketData.addObserver(avgScoreDisplay);
		cricketData.notifyObservers(); //notifying avgScoreDisplay of event
		//insuring that values and output to user match calculations
		assertEquals(Float.toString(runs/overs), avgScoreDisplay.getRunsPerOver().getText());
		assertEquals(Float.toString((float)runs/(float)wickets), avgScoreDisplay.getRunsPerWicket().getText());
		assertEquals(Float.toString(wickets/overs), avgScoreDisplay.getWicketsPerOver().getText());
	}

}
