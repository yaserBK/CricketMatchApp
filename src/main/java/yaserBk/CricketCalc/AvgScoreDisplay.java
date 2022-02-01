package yaserBk.CricketCalc;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/* class creates a new window(JFrame)
 *
 * Observers Cricket data class
 *
 * and has fields that are updated on the basis of changes
 * made to the cricket data jframe by the user (ie user input)
 */

@SuppressWarnings("deprecation")
public class AvgScoreDisplay extends JFrame implements Observer {

	//fields updated whenever observable object has changed
	private JLabel runsPerOver;
	private JLabel runsPerWicket;
	private JLabel wicketsPerOver;

	public AvgScoreDisplay(){
		super("Average scores"); //title of frame
		this.setLayout(new GridLayout(3,2)); //layout
		//creating and adding labels to AvgScoreDisplay frame
		//( initialising private JLabels declared in the class before adding them)
		this.add(new JLabel("Runs per over: "));
		runsPerOver = new JLabel();
		this.add(runsPerOver);
		this.add(new JLabel("Runs per wicket: "));
		runsPerWicket = new JLabel();
		this.add(runsPerWicket);
		this.add(new JLabel("Wickets per over"));
		wicketsPerOver = new JLabel();
		this.add(wicketsPerOver);
		this.pack();
		// size and location and presence on screen
		this.setSize(300, 200);
		this.setLocation(800,500);
		this.setVisible(true);
	}


	/*
	 * following method calculates relevant values with user inputted data from main JFrame ("Cricket Data")
	 * and sets the text in the respective fields in the AvgScoreDisplay frame to said updated values
	 */
	public void update(Observable o, Object arg) {

		float runsPerOver = ((CricketData)o).getRuns() / ((CricketData)o).getOvers(); //(runs/overs)
		//setting runsPerOver label text to runsPerOver variable after parsing to string
		this.runsPerOver.setText(Float.toString(runsPerOver));

		//the values returned by get runs and get wickets cast to float to maintain precision of calculation
		float runsPerWicket = ((float)((CricketData)o).getRuns()) / (float)(((CricketData)o).getWickets()); //(runs/wickets)
		//setting runsPerWicket label to runsPerWicket variable after parsing to string
		this.runsPerWicket.setText(Float.toString(runsPerWicket));

		float wicketsPerOver = ((CricketData)o).getWickets() / ((CricketData)o).getOvers(); // (wickets/overs)
		//setting wicketsPerOver label text to wicketsPerOver variable after parsing to string
		this.wicketsPerOver.setText(Float.toString(wicketsPerOver));
	}


	//getters used for junit tests.
	public JLabel getRunsPerOver(){
		return runsPerOver;
	}
	public JLabel getRunsPerWicket() {
		return runsPerWicket;
	}
	public JLabel getWicketsPerOver() {
		return wicketsPerOver;
	}


}
