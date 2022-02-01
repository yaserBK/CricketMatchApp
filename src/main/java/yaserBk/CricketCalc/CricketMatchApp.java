package yaserBk.CricketCalc;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class CricketMatchApp {
	public static void main(String[] args) {
		//Objects manipulated/managed by user
		final CricketData cricketData = new CricketData();
		final CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
		final AvgScoreDisplay avgScoreDisplay = new AvgScoreDisplay();
		//adding observers to observe observable object "cricketData"
		cricketData.addObserver(currentScoreDisplay);
		cricketData.addObserver(avgScoreDisplay);

		//creating a main JFrame
		JFrame mainFrame = new JFrame("Cricket Data");
		//setting layout
			mainFrame.setLayout(new GridLayout(4,2));
		// defining what the mainframe does when told to close
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		/*All mainframe labels are positioned to the right of the window
		* this is defined by the SwingConstraints.RIGHT value*/

		//creating and adding Label and textfield for Runs to mainframe
		JLabel runsLabel = new JLabel("Runs: ", SwingConstants.RIGHT);
		mainFrame.add(runsLabel);
		final JFormattedTextField runsField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		mainFrame.add(runsField); //adding to frame

		//creating and adding Label and textfield for Overs to mainframe
		JLabel oversLabel = new JLabel("Overs: ", SwingConstants.RIGHT);
		mainFrame.add(oversLabel);
		final JFormattedTextField oversField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		mainFrame.add(oversField); //adding to frame

		//creating and adding Label and textField for Wickets to mainframe
		JLabel wicketsLabel = new JLabel("Wickets: ", SwingConstants.RIGHT);
		mainFrame.add(wicketsLabel);
		final JFormattedTextField wicketsField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		mainFrame.add(wicketsField);

		// blank label to help position JButton "button'
		JLabel blank = new JLabel(" ", SwingConstants.RIGHT);
		mainFrame.add(blank);

		//creating and adding button to mainFrame
		JButton button = new JButton("Submit Score"); //submit button
		mainFrame.add(button); //adding button to frame


		mainFrame.pack(); //brings components together and defines layout before making the window visible
		mainFrame.setSize(300, 200 ); //altering default size
		mainFrame.setLocation(600, 250); //sets position of window
		mainFrame.setVisible(true); //displays window to user

		//adding an action listener to the submit button
		button.addActionListener(e -> { //when ActionEvent e occurs
			//values present in the textFields are stored in the following variables:
			int runs = ((Number)runsField.getValue()).intValue();
			float overs = ((Number)oversField.getValue()).floatValue();
			int wickets = ((Number)wicketsField.getValue()).intValue();
			// variables are then pushed into the setScore method of CricketData object
			cricketData.setScore(runs, overs, wickets);
			//all observers observing cricketData are notified.
			cricketData.notifyObservers();
		});

	}

}
