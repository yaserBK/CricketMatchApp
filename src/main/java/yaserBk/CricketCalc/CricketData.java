package yaserBk.CricketCalc;

import java.util.Observable;


/*Object of this class observed by CurrentScoreDisplay and AvgScoreDisplay objects*/
@SuppressWarnings("deprecation")
public class CricketData extends Observable {
	//private variables
	private int runs;
	private float overs;
	private int wickets;

	/* following getters used to calculate values and update fields in
	* CurrentScoreDisplay and AvgScoreDisplay frames */
	public int getRuns() {
		return runs;
	}
	public float getOvers(){
		return overs;
	}
	public int getWickets(){
		return wickets;
	}

	//sets values for runs, overs and wickets.
	public void setScore(int runs, float overs, int wickets){
		this.runs  = runs;
		this.overs = overs;
		this.wickets =  wickets;
		this.setChanged(); //Marks the observable object as having been changed
	}
}

