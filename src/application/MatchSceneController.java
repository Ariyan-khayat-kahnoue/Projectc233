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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MatchSceneController {
	Stage applicationStage;
	Scene previousScene;
	private ArrayList<String> playerT1;
	private ArrayList<String> playerT2;
    public void initialize(ArrayList<String> teamOnePlayers, ArrayList<String> teamTwoPlayers,
    		String teamOneName,String teamTwoName) {
    	
    	playerT1 = teamOnePlayers;
    	playerT2 = teamTwoPlayers;
    	reportLabel.setWrapText(true);
    	
    	generateReport(teamOneName, teamTwoName);
    	
	}
    @FXML
    private Label statusOfMatch;
    @FXML
    private Label reportLabel;
    
    @FXML
    void goBack(ActionEvent event) {
    	applicationStage.setScene(previousScene);
    }
    @FXML
    void sentenceGenerator() {
    	int rand = ThreadLocalRandom.current().nextInt(0,2);
    	if (rand == 1) {
    		int teamone = ThreadLocalRandom.current().nextInt(1,7);
    		int teamtwo = ThreadLocalRandom.current().nextInt(0,teamone-1);
    	}
    	if (rand == 2) {
    		int teamtwo = ThreadLocalRandom.current().nextInt(1,7);
    		int teamone = ThreadLocalRandom.current().nextInt(0,teamtwo-1);
    	}
    	if (rand == 0) {
    		int teamtwo = ThreadLocalRandom.current().nextInt(0,4);
    		int teamone = teamtwo;
    	}
    	
    }
    private boolean getWinner() {
    		int teamone = ThreadLocalRandom.current().nextInt(0,6);
    		int teamtwo = ThreadLocalRandom.current().nextInt(0,6);
    		
    		if (teamone > teamtwo) {
    			return true;
    		}
    		if (teamone < teamtwo) {
    			return false;
    		}
    		
    	return true;
    	
    }
//  https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
    private String[][] readFile() throws IOException {
    File file = new File("src/application/Report.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String[][] script= new String[11][];
        int index =0;
        while ((st = br.readLine()) != null) {
        	
        String[] options = st.split(":");
        
        script[index] = options;
        index++;
        }
        return script;
        	 
    }
    private void animation(String str) {
    	final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(100),
                event -> {
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
    private String attackerTeam(String report, String[][] script) {
		String playerWithBall = getPlayer(playerT1, "");    	
    	if (getWinner()) {
    		String teamMate = getPlayer(playerT1, playerWithBall);
    		report += String.format(addScript(script, 5),playerWithBall,teamMate);
    		playerWithBall = teamMate;
    	}
    	else {
    		report += String.format(addScript(script, 6),playerWithBall,getPlayer(playerT2,""));
    				return report;
    	}
    	String teamMate = getPlayer(playerT1, playerWithBall);
	    report += String.format(addScript(script, 7),playerWithBall,teamMate);
	   	report += String.format(addScript(script, 8),playerWithBall,getPlayer(playerT2,""));
		    	
    	if (getWinner())
    		report += String.format(addScript(script, 9),playerWithBall);
    		
    	else {
    		report += String.format(addScript(script, 10));
    	}
    	
    	return report;
    }
    private void generateReport(String teamOneName,String teamTwoName) {
    	String[][] script = null;
    	String report = "";
    	try {
			script = readFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	String attackingTeam;
    	report += String.format(addScript(script, 1));
    	report += String.format(addScript(script, 2),"first" );
    	if (getWinner()) {
    	report += String.format(addScript(script, 4),teamOneName);
    	attackingTeam = teamOneName;}
    	else {
    		report += String.format(addScript(script, 4),teamTwoName);
    		attackingTeam = teamTwoName;
    	}
    	report = attackerTeam(report, script);
    	
    	
    	report += String.format(addScript(script, 3),"first");
    	report += String.format(addScript(script, 11));
    	animation(report);
    
    }
    private String addScript(String[][] script,int index) {
    	index--;
    	return script[index][ThreadLocalRandom.current().nextInt(0,script[index].length)];
    }
    private String getPlayer(ArrayList <String> team,String duplicatePlayer) {
    	
    	String current = team.get(ThreadLocalRandom.current().nextInt(0,5));
    	while (current.equals(duplicatePlayer)) {
    		current = team.get(ThreadLocalRandom.current().nextInt(0,5));
    	}
    	return current;
    }
}
