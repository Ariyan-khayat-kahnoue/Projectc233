package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {
	
	@FXML
	private Label LeagueLabel;

   @FXML
   private CheckBox T2player10;

 
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
    
    @FXML
    private ChoiceBox<String> TeamOne;
    
    @FXML
    private ChoiceBox<String> TeamTwo;
    
    @FXML
    private ChoiceBox<String> Leauges;
      
    @FXML
    private Button ConfirmLeague;
    
    @FXML
    void AddTeams(ActionEvent event) {

    	ObservableList<String> teams= FXCollections.observableArrayList();
    	TeamOne.setItems(teams);
    	TeamTwo.setItems(teams);
    	if(Leauges.getValue().equals("La Liga")) {
    	            teams.addAll("FC Barcelona", "Sevilla FC", "Real Madrid", "Atletico Madrid");
    	}
    	if(Leauges.getValue().equals("Bundesliga"))  {
    		teams.addAll("Bayern Munich", "Borussia Dortmund", "RB leipzig", "SC freiburg");
    	}
    	if(Leauges.getValue().equals("MLS"))  {
    		teams.addAll("LA galaxy", "Toronto Fc", "New york Red bulls", "Seattle Sounders");
    	}
    	if(Leauges.getValue().equals("Premier league"))  {
    		teams.addAll("Manchester City", "Machester United", "Chealsea FC", "Arsenal");
    	}
    	

    	        }
    	    }

  

    
  	


