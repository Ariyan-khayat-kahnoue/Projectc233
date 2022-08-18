package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
//I got help from Scott polton in some parts of this project.
public class MatchSceneController {
	Stage applicationStage;
	Scene previousScene;

	private String teamOneName;
	private String teamTwoName;
	private Integer periodCounter;
	private Integer goal1;
	private Integer goal2;
	private ArrayList<String> playerT1;
	private ArrayList<String> playerT2;
	
	/**
	 * 
	 * @param teamOnePlayers list of player in the first team.
	 * @param teamTwoPlayers list of player in the first team.
	 * @param teamOneName name of the first team.
	 * @param teamTwoName name of the second team.
	 */
	public void initialize(ArrayList<String> teamOnePlayers, ArrayList<String> teamTwoPlayers, String teamOneName,
			String teamTwoName) {

		playerT1 = teamOnePlayers;
		playerT2 = teamTwoPlayers;
		this.teamOneName = teamOneName;
		this.teamTwoName = teamTwoName;
		periodCounter = 0;
		goal1 = 0;
		goal2 = 0;
		setStatus(goal1, goal2);
		reportLabel.setWrapText(true);

		String[][] script = null;
		String report = "";
		try {
			script = readFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String attackingTeam;

		report += String.format(addScript(script, 1));

		animation(report);
	//	https://stackoverflow.com/questions/37000532/disable-and-enable-the-button-using-java
		continueButton.setDisable(false);

	}

	@FXML
	private Label statusOfMatch;
	@FXML
	private Label reportLabel;

	@FXML
	private VBox team1VBox;
	@FXML
	private VBox team2VBox;

	@FXML
	private Button continueButton;

	// By clicking on this button the user proceeds to next stage of application
	@FXML
	void continueGame(ActionEvent event) {
		continueButton.setDisable(false);
		periodCounter++;
		if (periodCounter == 1) {
			generateReport("first");
		} else if (periodCounter == 2) {
			generateReport("second");
			continueButton.setDisable(true);
		}
	}

	// By clicking on this button user can go back to the first scene.
	@FXML
	void goBack(ActionEvent event) {
		applicationStage.setScene(previousScene);
	}
//	this is were I found my solution for code below
//	https://www.tutorialspoint.com/java_concurrency/concurrency_threadlocalrandom.htm
	/**
	 * this method randomly picks the team that is going to score.
	 * @param probablity
	 * @return
	 */
	private boolean getWinner(int probablity) {
		int i = ThreadLocalRandom.current().nextInt(1, 7);
		if (i <= probablity) {
			return true;
		}

		return false;

	}

	/**
	 * This method adds Teams, Players and goals that each team scores in two V
	 * boxes
	 * 
	 * 
	 * @param team1Goal Goals Scored by first team.
	 * @param team2Goal Goals Scored by second team.
	 */
	private void setStatus(Integer team1Goal, Integer team2Goal) {
		team1VBox.getChildren().clear();
		team2VBox.getChildren().clear();
		Label name = new Label(teamOneName);
		Label goals = new Label("goals : " + team1Goal);
		Label playersPlaying = new Label("Playing for " + teamOneName);
		team1VBox.getChildren().addAll(name, goals);
		for (String player : playerT1) {
			team1VBox.getChildren().addAll(new Label(player));
		}
		Label name2 = new Label(teamTwoName);
		Label goals2 = new Label("goals : " + team2Goal);
		Label playersPlaying2 = new Label("Playing for " + teamTwoName);
		team2VBox.getChildren().addAll(name2, goals2);
		for (String player : playerT2) {
			team2VBox.getChildren().addAll(new Label(player));
		}
	}

//  https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
	/**
	 * this method will read the file and store all of its data in a variable
	 * @return script is list of list of strings.
	 * @throws IOException
	 */
	private String[][] readFile() throws IOException {
		File file = new File("src/application/Report.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String[][] script = new String[11][];
		int index = 0;
		while ((st = br.readLine()) != null) {

			String[] options = st.split(":");

			script[index] = options;
			index++;
		}
		return script;

	}
	// found this method here.
// https://stackoverflow.com/questions/33646317/typing-animation-on-a-text-with-javafx
//	This method animates the report
	/**
	 * 
	 * @param str is a string and a sentence that will be displayed as match report
	 */
	private void animation(String str) {
		final IntegerProperty i = new SimpleIntegerProperty(0);
		Timeline timeline = new Timeline();
		KeyFrame keyFrame = new KeyFrame(Duration.millis(80), event -> {
			if (i.get() > str.length()) {
				timeline.stop();
			} else {
				reportLabel.setText(str.substring(0, i.get()));
				i.set(i.get() + 1);
			}
		});
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	/**
	 * 
	 * @param report is a string which is a sentence of match report.
	 * @param script is a list of string lists which each index of first least is a line from report file
	 *  an second list a string sentence picked randomly from an index first list.
	 * @param attacker is the player that is going to attack and will be shown in animation.
	 * @param defender the player defending against attacker.
	 * @return a string which is a modified sentence of report file.
	 */
	private String attackerTeam(String report, String[][] script, ArrayList<String> attacker,
			ArrayList<String> defender) {
		String playerWithBall = getPlayer(attacker, "");

		if (getWinner(4)) {
			String teamMate = getPlayer(attacker, playerWithBall);
			report += String.format(addScript(script, 5), playerWithBall, teamMate);
			playerWithBall = teamMate;
		} else {
			report += String.format(addScript(script, 6), playerWithBall, getPlayer(defender, ""));
			return report;
		}
		String teamMate = getPlayer(attacker, playerWithBall);
		report += String.format(addScript(script, 7), playerWithBall, teamMate);
		report += String.format(addScript(script, 8), playerWithBall, getPlayer(defender, ""));

		if (getWinner(3)) {
			report += String.format(addScript(script, 9), playerWithBall);
			if (attacker == playerT1) {
				goal1++;
				setStatus(goal1, goal2);
			} else if (attacker == playerT2) {
				goal2++;
				setStatus(goal1, goal2);
			}
		} else {
			report += String.format(addScript(script, 10));
		}

		return report;
	}
	//https://stackoverflow.com/questions/35544985/java-update-stage-in-a-for-loop
	
	/**
	 * This method generates the report labels to the application screen
	 *
	 * @param string period is either string first or string second.
	 */
	
	private void generateReport(String period) {
		String[][] script = null;
		String report = "";
		try {
			script = readFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String attackingTeam;

		report += String.format(addScript(script, 2), period);
//		https://www.tutorialspoint.com/java_concurrency/concurrency_threadlocalrandom.htm
		for (int goal = 0; goal <= (ThreadLocalRandom.current().nextInt(1, 5)); goal++) {

			if (getWinner(3)) {

				report += String.format(addScript(script, 4), teamOneName);
				attackingTeam = teamOneName;
			} else {
				report += String.format(addScript(script, 4), teamTwoName);
				attackingTeam = teamTwoName;
			}
			if (attackingTeam.equals(teamOneName)) {
				report = attackerTeam(report, script, playerT1, playerT2);
			} else if (attackingTeam.equals(teamTwoName)) {

				report = attackerTeam(report, script, playerT2, playerT1);
			}
			report += "\n";
		}
		report += String.format(addScript(script, 3), period);
		report += String.format(addScript(script, 11));
		animation(report);

	}


	/** this method returns a random string
	 * 
	 * @param script a List of List of Strings
	 * @param index Just an integer
	 * @return value of an index from list script
	 */
	private String addScript(String[][] script, int index) {
		index--;
		return script[index][ThreadLocalRandom.current().nextInt(0, script[index].length)];
	}
	/**
	 * 
	 * @param team an array list of strings which is a list of players in that team
	 * @param duplicatePlayer value of an index from list team.
	 * @return an index from team.
	 */
	private String getPlayer(ArrayList<String> team, String duplicatePlayer) {

		String current = team.get(ThreadLocalRandom.current().nextInt(0, 5));
		while (current.equals(duplicatePlayer)) {
			current = team.get(ThreadLocalRandom.current().nextInt(0, 5));
		}
		return current;
	}
}
