package application;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.util.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
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
	private Label ErrorLabel;
	
	@FXML
	private VBox VBoxTeam1; 
	@FXML
	private VBox VBoxTeam2; 
	
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
	
	@FXML
    public void initialize() {
        System.out.println("Application Started");

        VBoxTeam1.setVisible(false);
        VBoxTeam2.setVisible(false);
	}
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
		else if("MLS".equals(getLeagueValue)){
			TeamOne.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			TeamTwo.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			counter++;
			
		}
		else if("Premier league".equals(getLeagueValue)){
			TeamOne.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			TeamTwo.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			counter++;
		}
		else if("Bundesliga".equals(getLeagueValue)){
			TeamOne.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			TeamTwo.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			counter++;
		}
		}
		else {
			
		}
		
	}
	

//	CheckBox[] players = new CheckBox[10];
//	players.addA(Arrays.asList(T1player1,T1player2,T1player3,T1player4,T1player5,T1player6,T1player7,T1player8,T1player9,T1player10));
//	ArrayList<CheckBox> players = new ArrayList<CheckBox>();

	String[] RealMadrid = new String[]{"Courtois","Carvajal","Nacho","Alaba","Kroos","Modric","Casemiro","Benzema","Asensio","Hzard"};
	String[] FC_Barscelona = new String[] {"Ter Stegen","Jordi Alba","Pique","Garcia","Busquets","S.Roberto","Lewandowski","Raphinha","Dembele"};
	String[] Atletico_de_Madrid = {"Ivo Grbic","Giménez","Renan Lodi","Nahuel Molina","Kondogbia","Llorente","Thomas Lemar","João Félix","Griezmann","Cunha"};
	
	@FXML
	private void ConfirmTeams(ActionEvent event) throws IOException {
		String TeamOneName = TeamOne.getValue();
		String TeamTwoName= TeamTwo.getValue();
		if (TeamOneName != TeamTwoName) {
			VBoxTeam1.setVisible(true);
	        VBoxTeam2.setVisible(true);
	        
//		for(int Index = 0;Index!=9;Index++) {
			if (TeamOneName == "Real Madrid"||TeamTwoName=="Real Madrid") {
				T1player1.setText(RealMadrid[0]);
				T1player2.setText(RealMadrid[1]);
				T1player3.setText(RealMadrid[2]);
				T1player4.setText(RealMadrid[3]);
				T1player5.setText(RealMadrid[4]);
				T1player6.setText(RealMadrid[5]);
				T1player7.setText(RealMadrid[6]);
				T1player8.setText(RealMadrid[7]);
				T1player9.setText(RealMadrid[8]);
				T1player10.setText(RealMadrid[9]);
			if(TeamOneName == "FC Barscelona"||TeamTwoName=="FC Barscelona") {
				T1player1.setText(FC_Barscelona[0]);
				T1player2.setText(FC_Barscelona[1]);
				T1player3.setText(FC_Barscelona[2]);
				T1player4.setText(FC_Barscelona[3]);
				T1player5.setText(FC_Barscelona[4]);
				T1player6.setText(FC_Barscelona[5]);
				T1player7.setText(FC_Barscelona[6]);
				T1player8.setText(FC_Barscelona[7]);
				T1player9.setText(FC_Barscelona[8]);
				T1player10.setText(FC_Barscelona[9]);
			}
			if(TeamOneName == "Atletico"||TeamTwoName=="Atletico") {
				T1player1.setText(Atletico_de_Madrid[0]);
				T1player2.setText(Atletico_de_Madrid[1]);
				T1player3.setText(Atletico_de_Madrid[2]);
				T1player4.setText(Atletico_de_Madrid[3]);
				T1player5.setText(Atletico_de_Madrid[4]);
				T1player6.setText(Atletico_de_Madrid[5]);
				T1player7.setText(Atletico_de_Madrid[6]);
				T1player8.setText(Atletico_de_Madrid[7]);
				T1player9.setText(Atletico_de_Madrid[8]);
				T1player10.setText(Atletico_de_Madrid[9]);
			}	
			}	
			
		}
		else {
			ErrorLabel.setText("You can't have Two "+TeamOneName+"s Please pick diffrent Teams");
		}
	}	
		
}