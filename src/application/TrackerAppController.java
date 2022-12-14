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
	private ChoiceBox<String> leaguesChoiceBox;
	@FXML
	private ChoiceBox<String> teamOne;
	@FXML
	private ChoiceBox<String> teamTwo;
	
	@FXML
	private Label errorLabel;
	@FXML
	private Label team1;
	@FXML
	private Label team2;
	
	@FXML
	private VBox vBox1;
	@FXML
	private VBox vBox2;
	@FXML
	private VBox vBox3;
	@FXML
	private VBox vBox4;

	@FXML 
	private Button confirmButton;
	@FXML 
	private Button confirmButtonTeams;
	@FXML 
	private Button startMatch;
	
	@FXML
    public void initialize() {
        MLS = new League ("MLS");
        LaLiga = new League ("La Liga");
        PremierLeague = new League ("Premier league");
        Bundesliga = new League ("Bundesliga"); 
        
        // these are all the players of all the team of all leagues.
        Team RealMadrid = new Team("Real Madrid",new String[]{"Courtois","Carvajal","Nacho","Alaba","Kroos","Modric","Casemiro","Benzema","Asensio","Hzard"});
        Team FC_Barscelona = new Team ("FC Barcelona",new String[]{"Ter Stegen","Jordi Alba","Pique","Garcia","Busquets","S.Roberto","Lewandowski","Raphinha","Dembele","Braithwaite"});
        Team Atletico_de_Madrid =new Team("Atletico",new String[]{"Ivo Grbic","Gim??nez","Renan Lodi","Nahuel Molina","Kondogbia","Llorente","Thomas Lemar","Jo??o F??lix","Griezmann","Cunha"});
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
        
        // here I add the teams to the league they belong.
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
	/** This method adds the players of chosen teams to check boxes.
	 * 
	 * @param playerList This is the list of players used to set the text of each check box. 
	 * @param firstColumn a V box which is empty and the first five check boxes will be added to it.
	 * @param secondColumn another V box which is empty and the last five check boxes will be added to it.
	 */
	private void namePlayer(String[] playerList,VBox firstColumn,VBox secondColumn) {
		for(int index=0;index < 5;index++) {
			// https://www.javatpoint.com/javafx-checkbox
			CheckBox c1 = new CheckBox();
			c1.setText(playerList[index]);
			firstColumn.getChildren().add(c1);
			CheckBox c2 = new CheckBox();
			c2.setText(playerList[index+5]);
			secondColumn.getChildren().add(c2);
			
		}
	}
	
	// user Clicks on this button and confirm the leagues and the teams in that league are then added
	// to the team choice boxes.
	@FXML
	private void confirmLeague(ActionEvent event) throws IOException {
		String getLeagueValue = leaguesChoiceBox.getValue();
		
		teamOne.getItems().clear();
		teamTwo.getItems().clear();
			if("La Liga".equals(getLeagueValue)){
			currentLeague = LaLiga;
			teamOne.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			teamTwo.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			
		}
		else if("MLS".equals(getLeagueValue)){
			currentLeague = MLS;
			teamOne.getItems().addAll("Philadelphia","New York Redbulls","Montreal","New York City FC");
			teamTwo.getItems().addAll("Philadelphia","New York Redbulls","Montreal","New York City FC");
			
			
		}
		else if("Premier league".equals(getLeagueValue)){
			currentLeague = PremierLeague;
			teamOne.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			teamTwo.getItems().addAll("Tottenham","Arsenal","Liverpool","Manchester United F.C.");
			
		}
		else if("Bundesliga".equals(getLeagueValue)){
			currentLeague = Bundesliga;
			teamOne.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			teamTwo.getItems().addAll("B. Munich","Dortmund","SV Werder Bremen","Hamburger SV");
			
		}
	}
		


	
	// user Clicks on this button to confirm the teams they chose and the players of that those teams
	// are then added as check boxes
	@FXML
	private void confirmTeams(ActionEvent event) throws IOException {
		errorLabel.setText("");
		String teamOneName = teamOne.getValue();
		String teamTwoName= teamTwo.getValue();
		if (teamOneName == null|| teamTwoName == null){
			team1.setText("");
			team2.setText("");
			vBox1.getChildren().clear();
			vBox2.getChildren().clear();
			vBox3.getChildren().clear();
			vBox4.getChildren().clear();
			errorLabel.setText("Please first pick the teams then press Confirm Teams");
		}
		else if (teamOneName != teamTwoName) {
			team1.setText(teamOneName);
			team2.setText(teamTwoName);
			vBox1.getChildren().clear();
			vBox2.getChildren().clear();
			vBox3.getChildren().clear();
			vBox4.getChildren().clear();
			for(Team T:currentLeague.getTeams()) {
				if(teamOneName.equals(T.getTeamName())) {
					
					namePlayer(T.getPlayers(), vBox1, vBox2);	
				}
				if(teamTwoName.equals(T.getTeamName())) {
					namePlayer(T.getPlayers(), vBox3, vBox4);
				}		
			}
			}
		
		else if (teamOneName != null|| teamTwoName !=null) {
			vBox1.getChildren().clear();
			vBox2.getChildren().clear();
			vBox3.getChildren().clear();
			vBox4.getChildren().clear();	
			errorLabel.setText("You can't have Two "+teamOneName+"s Please pick diffrent Teams");
			}
	}
	/** This method checks and find the players chosen by use and adds them to a list.
	 * 
	 * @param first is a V box which contains Check boxes of players.
	 * @param second is a V box which contains Check boxes of players.

	 * @return Text of those check boxes that were selected by user.
	 */
	private ArrayList<String> getPlayersSelected(VBox first, VBox second){
		ObservableList<CheckBox> checkBoxList1 = (ObservableList) first.getChildren();
		ObservableList<CheckBox> checkBoxList2 = (ObservableList) second.getChildren();
		ArrayList <String> playersSelected = new ArrayList<String> ();
		
		for(int index=0;index < 5;index++) {
			if (checkBoxList1.get(index).isSelected()) {
				playersSelected.add(checkBoxList1.get(index).getText());
				
			}
			if (checkBoxList2.get(index).isSelected()) {
				playersSelected.add(checkBoxList2.get(index).getText());
			
			}
		}
		return playersSelected;
		
	}
	
	// user finalize their choice by clicking on this button and the match will be generated.
	@FXML
	private void StartMatch(ActionEvent event)  throws IOException {
		try {
		
			ArrayList<String> playersTeam1 = getPlayersSelected(vBox1,vBox2);
			ArrayList<String> playersTeam2 = getPlayersSelected(vBox3,vBox4);
		
		
		if (playersTeam1.size()==5 && playersTeam2.size()==5) {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/MatchScene.fxml"));
		MatchSceneController controller = (MatchSceneController)loader.getController();
		Scene scene = new Scene(root,800 ,600);
		controller.initialize(playersTeam1, playersTeam2,teamOne.getValue(),teamTwo.getValue());
		controller.applicationStage = applicationStage;
		controller.previousScene = applicationStage.getScene();
		applicationStage.setScene(scene);
		applicationStage.setTitle("Football Simiulator");
		applicationStage.show();
		}
		else {
			errorLabel.setText("Select exactly 5 player for each Team.");
			
		}
		}
		catch(IndexOutOfBoundsException e){
			errorLabel.setText("Please first select a league then the teams and 5 players for each team");
		}
	}
}	
