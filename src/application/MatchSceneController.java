package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MatchSceneController {
	Stage applicationStage;
	Scene previousScene;
	private ArrayList<String> playerT1;
	private ArrayList<String> playerT2;
    public void initialize(ArrayList<String> teamOnePlayers, ArrayList<String> teamTwoPlayers) {
    	playerT1 = teamOnePlayers;
    	playerT2 = teamTwoPlayers;
    	
	}
    
    @FXML
    private Label statusOfMatch;
    @FXML
    private Label reportLabel;
    
    @FXML
    void goBack(ActionEvent event) {
    	applicationStage.setScene(previousScene);
    }
    
    
    
}
