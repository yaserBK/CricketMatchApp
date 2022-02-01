package yaserBk.CricketCalc;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/*
* class creates a new window(JFrame)
*
* Observers Cricket data class
*
* and has fields that are updated on the basis of changes
* made to the cricket data jframe by the user (ie user input)*/

@SuppressWarnings("deprecation")
public class CurrentScoreDisplay extends JFrame implements Observer{
	//JLabels whose values will be updated on button actionEvent
	private JLabel runs;
	private JLabel overs;
	private JLabel wickets;

	//constructor
	public CurrentScoreDisplay (){
		super("Current scores"); //window title
		this.setLayout(new GridLayout(3,2)); //setting layout
		//creating and adding labels to CurrentScoreDisplay frame
		//( initialising private JLabels declared in the class before adding them)
		this.add(new JLabel("Runs: "));
		runs = new JLabel();
		this.add(runs);
		this.add(new JLabel("Overs: "));
		overs = new JLabel();
		this.add(overs);
		this.add(new JLabel("Wickets: "));
		wickets = new JLabel();
		this.add(wickets);
		this.pack();
		// size and location and presence on screen
		this.setSize(300, 200);
		this.setLocation(500,500);
		this.setVisible(true);
	}

	/*
	* following method updates labels in CurrentScore JFrame
	* with  values provided by user in the Main Jframe ("Cricket Data")
	* this is done as follows:
	* 	getters from CricketData class used to return relevant values
	*	these values are then parsed into strings
	*	content of relevant labels are then updated using setText methods
	*/
	public void update(Observable o, Object arg) {
		runs.setText(Integer.toString(((CricketData)o).getRuns()));
		overs.setText(Float.toString(((CricketData)o).getOvers()));
		wickets.setText(Integer.toString(((CricketData)o).getWickets()));
	}


	//getters that return JLabels for junit testing
	public JLabel getRuns() {
		return runs;
	}
	public JLabel getOvers() {
		return overs;
	}
	public JLabel getWickets() {
		return wickets;
	}


}
