package application;

import java.io.IOException;
import java.lang.reflect.Array;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.util.*;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class TrackerAppController{
	int counter=0;
	
	@FXML
	private ChoiceBox<String> LeaguesChoiceBox;
	
	@FXML
	private ChoiceBox<String> TeamOne;
	
	@FXML
	private ChoiceBox<String> TeamTwo;
	
	@FXML
	private CheckBox T1player5;
	@FXML
	private CheckBox T1player4;
	@FXML
	private CheckBox T1player1;
	@FXML
	private CheckBox T1player3;
	@FXML
	private CheckBox T1player2;
	@FXML
	private CheckBox T1player6;
	@FXML
	private CheckBox T1player7;
	@FXML
	private CheckBox T1player8;
	@FXML
	private CheckBox T1player9;
	@FXML
	private CheckBox T1player10;
	@FXML
	private CheckBox T2player5;
	@FXML
	private CheckBox T2player4;
	@FXML
	private CheckBox T2player1;
	@FXML
	private CheckBox T2player3;
	@FXML
	private CheckBox T2player2;
	@FXML
	private CheckBox T2player6;
	@FXML
	private CheckBox T2player7;
	@FXML
	private CheckBox T2player8;
	@FXML
	private CheckBox T2player9;
	@FXML
	private CheckBox T2player10;
	@FXML 
	private Button ConfirmButton;
	@FXML 
	private Button ConfirmButtonTeams;
	
	
	public Stage applicationStage;
		
	@FXML
	private void ConfirmLeague(ActionEvent event) throws IOException {
		String getLeagueValue = LeaguesChoiceBox.getValue();
		
		if(counter==0) {
			if("La Liga".equals(getLeagueValue)){
			TeamOne.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			TeamTwo.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			counter++;
		}
		else if("MLS" == getLeagueValue){
			TeamOne.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			TeamTwo.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			counter++;
			
		}
		else if("Premier league" == getLeagueValue){
			TeamOne.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			TeamTwo.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			counter++;
		}
		else if("Bundesliga" == getLeagueValue){
			TeamOne.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			TeamTwo.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			counter++;
		}
		}
		else {
			
		}
	}
	String[] RealMadrid = {"Courtois","Carvajal","Nacho","Alaba","Kroos","Modric","Hzard","Benzema","Asensio","Casemiro"};
	@FXML
	private void ConfirmTeams(ActionEvent event) throws IOException {
		String TeamOneName = TeamOne.getValue();
		String TeamTwoName= TeamTwo.getValue();
//		if (TeamOneName == "Real Madrid") {
//			T1player1.setText(RealMadrid.getItem(int 1));
			
		}
		
		
}