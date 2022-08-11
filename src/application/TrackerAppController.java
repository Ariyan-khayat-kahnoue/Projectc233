package application;

import javafx.fxml.FXML;

import application.League; 

import javafx.scene.control.TextField;

import javafx.scene.control.CheckBox;

import javafx.scene.control.ChoiceBox;

public class TrackerAppController extends League {
	
		public TrackerAppController(Object Leauge, Object Team1, Object Team2) {
		super(Leauge, Team1, Team2);
		// TODO Auto-generated constructor stub
		LeaguesChoiceBox.getValue();
		TeamOne.getValue();
		TeamTwo.getValue();
		getLeague();
	}

		// TODO Auto-generated constructor stub
	
	@FXML
	private ChoiceBox LeaguesChoiceBox;
	@FXML
	private ChoiceBox TeamOne;
	@FXML
	private TextField Team1Name;
	@FXML
	private ChoiceBox TeamTwo;
	@FXML
	private TextField Team2Name;
	@FXML
	private CheckBox T1player5;
	@FXML
	private CheckBox T1player4;
	@FXML
	private CheckBox T1player1_Goal_Keeper;
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
	private CheckBox T2player1_Goal_Keeper;
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
}	
//	@FXML
//	void LeagueTeams(Boolean LaLiga, BundasLiga, PremereLeague, SerieA) {
//		
//	}
//}	

