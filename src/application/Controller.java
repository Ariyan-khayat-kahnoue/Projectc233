package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

 //   @FXML
 //   private ChoiceBox<?> TeamOne;

    @FXML
    private ChoiceBox<String> Leauges;
    
    
    
    @FXML
    private void initialize() {
//    	Leauges.setItems(LeagueList);
//    	Leauges.setValue("Real madrid");
    	
    	Leauges.getItems().add("La Liga");
    	Leauges.getItems().add("MLS");
    	Leauges.getItems().add("Bundesliga");
    	Leauges.getItems().add("Premier League");
    	}
    
		/*
		 * if (Leauges == "La Liga") {
		 * 
		 * @FXML private ChoiceBox<String> TeamOne;
		 * 
		 * public void initialize() { TeamOne.getItems().addall("FC Barcelona",
		 * "Real Madrid", "Atletico Madrid"); } } if (Leauges == "MLS") {
		 * 
		 * @FXML private ChoiceBox<String> TeamOne;
		 * 
		 * public void initialize() { TeamOne.getItems().addall("New York Red Bulls",
		 * "Chicago Fire", "Seattle Sounders"); } } if (Leauges == "Bundesliga") {
		 * 
		 * @FXML private ChoiceBox<String> TeamOne;
		 * 
		 * public void initialize() { TeamOne.getItems().addall("Borussia Dortmund",
		 * "Bayern Munich", "RB leipzig"); } } if (Leauges == "Premier League") {
		 * 
		 * @FXML private ChoiceBox<String> TeamOne;
		 * 
		 * public void initialize() { TeamOne.getItems().addall("Liverpool FC",
		 * "Manchester United", "Chealsea FC"); } } }
		 */
   
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
    
    private String[] leagues = {"Laliga", "asdasdasd"};
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Leauges.getItems().addAll(leagues);
        Leauges.setOnAction(this::getLeague);       


    }
    public void getLeague(ActionEvent event) {
    	String myLeague = Leauges.getValue();
    	LeagueLabel.setText(myLeague);
    }
	

}
