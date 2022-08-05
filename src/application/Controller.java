package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable{
	
	@FXML
	private Label LeagueLabel;

    @FXML
    private CheckBox T2player10;

    @FXML
    private ChoiceBox<?> TeamOne;

    @FXML
    private ChoiceBox<String> Leauges;
    
    private String[] leagues = {"La Liga", "Bundesliga","MLS","Premier League"};

    public void initialize(URL arg0, ResourceBundle arg1) {
    	Leauges.getItems().addAll(leagues);
    }
    @FXML
    private CheckBox T1player10;

    @FXML
    private CheckBox T2player2;

    @FXML
    private CheckBox T2player1_Goal_Keeper;

    @FXML
    private CheckBox T1player1_Goal_Keeper;

    @FXML
    private CheckBox T1player4;

    @FXML
    private CheckBox T2player6;

    @FXML
    private CheckBox T1player5;

    @FXML
    private CheckBox T2player5;

    @FXML
    private CheckBox T1player2;

    @FXML
    private CheckBox T2player4;

    @FXML
    private CheckBox T1player3;

    @FXML
    private CheckBox T2player3;

    @FXML
    private CheckBox T1player8;

    @FXML
    private CheckBox T1player9;

    @FXML
    private CheckBox T2player9;

    @FXML
    private CheckBox T1player6;

    @FXML
    private CheckBox T2player8;

    @FXML
    private CheckBox T1player7;

    @FXML
    private CheckBox T2player7;

}
