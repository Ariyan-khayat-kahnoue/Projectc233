package application;

import java.awt.Checkbox;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.util.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrackerAppController<T1>{
	// I got help from Scott polton.
    public Stage applicationStage;   
	private League currentLeague;
    private League MLS;
	private League LaLiga;
	private League PremierLeague;
	private League Bundesliga;
	
	
    @FXML
	private ChoiceBox<String> LeaguesChoiceBox;
	@FXML
	private ChoiceBox<String> TeamOne;
	@FXML
	private ChoiceBox<String> TeamTwo;
	
	@FXML
	private Label ErrorLabel;
	@FXML
	private Label Team1;
	@FXML
	private Label Team2;
	
	@FXML
	private VBox Vbox1;
	@FXML
	private VBox Vbox2;
	@FXML
	private VBox Vbox3;
	@FXML
	private VBox Vbox4;

	@FXML 
	private Button ConfirmButton;
	@FXML 
	private Button ConfirmButtonTeams;
	@FXML 
	private Button StartMatch;
	
	@FXML
    public void initialize() {
        MLS = new League ("MLS");
        LaLiga = new League ("La Liga");
        PremierLeague = new League ("Premier league");
        Bundesliga = new League ("Bundesliga");
        
        
        
        Team RealMadrid = new Team("Real Madrid",new String[]{"Courtois","Carvajal","Nacho","Alaba","Kroos","Modric","Casemiro","Benzema","Asensio","Hzard"});
        Team FC_Barscelona = new Team ("FC Barcelona",new String[]{"Ter Stegen","Jordi Alba","Pique","Garcia","Busquets","S.Roberto","Lewandowski","Raphinha","Dembele","Braithwaite"});
        Team Atletico_de_Madrid =new Team("Atletico",new String[]{"Ivo Grbic","Giménez","Renan Lodi","Nahuel Molina","Kondogbia","Llorente","Thomas Lemar","João Félix","Griezmann","Cunha"});
    	Team ValenciaCF = new Team("Valencia CF",new String[]{"Domenech", "Correia", "Toni Lato", "Gabriel" , "Guillamon", "Diakhaby" , "Foulquier", "Mosquera", "Ribeiro" , "Lino" });
    	Team Philadelphia_Union = new Team ("Philadelphia",new String[]{"Bendik", "Aaronson" , "Bedoya", "Bendik", "Blake", "Bueno", "Burke", "Carranza","Craig", "Donovan"});
    	Team New_York_Redbulls = new Team ("New York Redbulls",new String[]{"Coronel", "Duncan" , "Edelman", "Edwards", "Estela", "Barlow", "Amaya", "Castellano", "Long", "Marcucci"});
    	Team CF_Montreal = new Team ("Montreal",new String[]{"Logan Ketterer", "Kamal Miller", "Rudy Camacho", "Corbo", "Waterman", "Wanyama", "Piette", "Hamdi", "Torres", "Zouhir"});
    	Team New_York_CityFC = new Team ("New York City FC",new String[]{"Sean Johnson", "Talles Magno", "Gabriel Pereira", "Callens", "Moralez", "Rosriguez", "Thiago Martins", "Gedion Zelalem", "Maxime Chanot", "Tayvon Gray"});
    	Team Tottenham = new Team ("Tottenham",new String[]{"Brandon Austin", "Dejan Kulusevski", "Harry Kane", "Richarlison", "Ivan Perisic", "Cristian Romero", "Tanguy Ndombele", "Eric Dier", "Ben Davies", "Sergia Reguilon"});
    	Team Arsenal = new Team ("Arsenal",new String[]{"Aaron Ramsdale", "Ben White", "Thomas Partey", "Kieran Tierney", "Fabio Vieira", "Mohamed Elneny", "Rob Holding", "Granit Xhaka", "Bukayo Saka", "Gabriel Jesus"});
    	Team Liverpool = new Team ("Liverpool",new String[]{"Alisson Becker", "Mohamed Salah", "Darwin Nunez", "Luis Diaz", "Thiago Alcantara", "Roberto Firmino", "Diogo Jota", "Calvin Ramsay", "James Milner", "Harvey Elliott"});
    	Team Man_United = new Team ("Manchester United F.C.",new String[]{"David de Gea", "Lisandro Martinez", "Christian Eriksen", "Harry Maguire", "Jadon Sancho", "Marcus Rashford", "Tyrell Malacia", "Anthony Martial", "Anthony Elanga", "Fred"});
    	Team B_Munich = new Team ("B. Munich",new String[]{"Manuel Neuer", "Thomas Muller", "Sadio Mane", "Leroy Sane", "Joshua Kimmich", "Serge Gnabry", "Kingsley Coman", "Benjamin Pavard", "Leon Goretzka", "Dayot Upamecano"});
    	Team B_Dortmund = new Team ("Dortmund",new String[]{"Alexander Meyer", "Marco Reus", "Sebastien Haller", "Karim Adeyemi", "Niklas Sule", "Mats Hummels", "Emre Can", "Manuel Akanji", "Julian Brandt", "Anthony Modeste"});
    	Team SV_Werder = new Team ("SV Werder Bremen",new String[]{"Louis Sascha Lord", "Philipp Bargfrede", "Dejan Galjen", "Jakob Lopping", "Ole Springer", "Alexander Hock", "Abdul Gafar", "Timur Pazhigov", "Ole Schulz", "Marc Schroder"});
    	Team Hamburger = new Team ("Hamburger SV",new String[]{"Matheo Raab", "Sebastian Schonlau", "Jonas David", "Maximilian Rohr", "Xavier Amaechi", "Sonny Kittel", "Filip Bilbija", "Mario Vuskovic", "Xavier Amaechi", "Tim Leibold"});
        
        
        LaLiga.addTeam(RealMadrid);
        LaLiga.addTeam(FC_Barscelona);
        LaLiga.addTeam(Atletico_de_Madrid);
        LaLiga.addTeam(ValenciaCF);
        MLS.addTeam(Philadelphia_Union);
        MLS.addTeam(New_York_Redbulls);
        MLS.addTeam(CF_Montreal);
        MLS.addTeam(New_York_CityFC);
        PremierLeague.addTeam(Tottenham);
        PremierLeague.addTeam(Arsenal);
        PremierLeague.addTeam(Liverpool);
        PremierLeague.addTeam(Man_United);
        Bundesliga.addTeam(B_Munich);
        Bundesliga.addTeam(B_Dortmund);
        Bundesliga.addTeam(SV_Werder);
        Bundesliga.addTeam(Hamburger);
	}
	
	private void NamePlayer(String[] playerList,VBox firstColumn,VBox secondColumn) {
		for(int Index=0;Index < 5;Index++) {
			
			CheckBox c1 = new CheckBox();
			c1.setText(playerList[Index]);
			firstColumn.getChildren().add(c1);
			CheckBox c2 = new CheckBox();
			c2.setText(playerList[Index+5]);
			secondColumn.getChildren().add(c2);
			
		}
	}
	

	@FXML
	private void ConfirmLeague(ActionEvent event) throws IOException {
		String getLeagueValue = LeaguesChoiceBox.getValue();
		
		TeamOne.getItems().clear();
		TeamTwo.getItems().clear();
			if("La Liga".equals(getLeagueValue)){
			currentLeague = LaLiga;
			TeamOne.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			TeamTwo.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			
		}
		else if("MLS".equals(getLeagueValue)){
			currentLeague = MLS;
			TeamOne.getItems().addAll("Philadelphia","New York Redbulls","Montreal","New York City FC");
			TeamTwo.getItems().addAll("Philadelphia","New York Redbulls","Montreal","New York City FC");
			
			
		}
		else if("Premier league".equals(getLeagueValue)){
			currentLeague = PremierLeague;
			TeamOne.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			TeamTwo.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			
		}
		else if("Bundesliga".equals(getLeagueValue)){
			currentLeague = Bundesliga;
			TeamOne.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			TeamTwo.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			
		}
	}
		


	
	
	@FXML
	private void ConfirmTeams(ActionEvent event) throws IOException {
		ErrorLabel.setText("");
		String teamOneName = TeamOne.getValue();
		String teamTwoName= TeamTwo.getValue();
		if (teamOneName == null|| teamTwoName == null){
			Team1.setText("");
			Team2.setText("");
			Vbox1.getChildren().clear();
			Vbox2.getChildren().clear();
			Vbox3.getChildren().clear();
			Vbox4.getChildren().clear();
			ErrorLabel.setText("Please first pick the teams then press Confirm Teams");
		}
		else if (teamOneName != teamTwoName) {
			Team1.setText(teamOneName);
			Team2.setText(teamTwoName);
			Vbox1.getChildren().clear();
			Vbox2.getChildren().clear();
			Vbox3.getChildren().clear();
			Vbox4.getChildren().clear();
			for(Team T:currentLeague.getTeams()) {
				if(teamOneName.equals(T.getTeamName())) {
					
					NamePlayer(T.getPlayers(), Vbox1, Vbox2);	
				}
				if(teamTwoName.equals(T.getTeamName())) {
					NamePlayer(T.getPlayers(), Vbox3, Vbox4);
				}		
			}
			}
		
		else if (teamOneName != null|| teamTwoName !=null) {
			Vbox1.getChildren().clear();
			Vbox2.getChildren().clear();
			Vbox3.getChildren().clear();
			Vbox4.getChildren().clear();	
			ErrorLabel.setText("You can't have Two "+teamOneName+"s Please pick diffrent Teams");
			}
	}
	
	private ArrayList<String> getPlayersSelected(VBox first, VBox second){
		ObservableList<CheckBox> checkBoxList1 = (ObservableList) first.getChildren();
		ObservableList<CheckBox> checkBoxList2 = (ObservableList) second.getChildren();
		ArrayList <String> playersSelected = new ArrayList<String> ();
		
		for(int Index=0;Index < 5;Index++) {
			if (checkBoxList1.get(Index).isSelected()) {
				playersSelected.add(checkBoxList1.get(Index).getText());
				
			}
			if (checkBoxList2.get(Index).isSelected()) {
				playersSelected.add(checkBoxList2.get(Index).getText());
			
			}
		}
		return playersSelected;
		
	}
	
	
	@FXML
	private void StartMatch(ActionEvent event)  throws IOException {
		
		ArrayList<String> playersTeam1 = getPlayersSelected(Vbox1,Vbox2);
		ArrayList<String> PlayersTeam2 = getPlayersSelected(Vbox3,Vbox4);
		
		
		if (playersTeam1.size()==5 && PlayersTeam2.size()==5) {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/MatchScene.fxml"));
		MatchSceneController controller = (MatchSceneController)loader.getController();
		Scene scene = new Scene(root);
		controller.initialize(playersTeam1, PlayersTeam2);
		controller.applicationStage = applicationStage;
		controller.previousScene = applicationStage.getScene();
		applicationStage.setScene(scene);
		applicationStage.setTitle("Football Simiulator");
		applicationStage.show();
		}
		else {
			ErrorLabel.setText("Select exactly 5 player for each Team.");
			
		}
	}
}	
