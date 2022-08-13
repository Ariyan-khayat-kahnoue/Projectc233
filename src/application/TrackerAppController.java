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
	private VBox VBoxTeam1; 
	@FXML
	private VBox VBoxTeam2; 
	
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
    public void initialize() {
        MLS = new League ("MLS");
        LaLiga = new League ("La Liga");
        PremierLeague = new League ("Premier league");
        Bundesliga = new League ("Bundesliga");
        
        
        
        Team RealMadrid = new Team("Real Madrid",new String[]{"Courtois","Carvajal","Nacho","Alaba","Kroos","Modric","Casemiro","Benzema","Asensio","Hzard"});
        Team FC_Barscelona = new Team ("FC Barcelona",new String[]{"Ter Stegen","Jordi Alba","Pique","Garcia","Busquets","S.Roberto","Lewandowski","Raphinha","Dembele","sdfdf"});
        Team Atletico_de_Madrid =new Team("Atletico",new String[]{"Ivo Grbic","Giménez","Renan Lodi","Nahuel Molina","Kondogbia","Llorente","Thomas Lemar","João Félix","Griezmann","Cunha"});
    	Team ValenciaCF = new Team("Valencia CF",new String[]{"Jaume Domenech", "Thierry Correia", "Toni Lato", "Gabriel" , "Hugo Guillamon", "Mouctar Diakhaby" , "Dimitri Foulquier", "Cristhian Mosquera", "Tiago Ribeiro" , "Samuel Lino" });
    	Team Philadelphia_Union = new Team ("Philadelphia",new String[]{"Bendik", "Aaronson" , "Bedoya", "Bendik", "Blake", "Bueno", "Burke", "Carranza","Craig", "Donovan"});
    	Team New_York_Redbulls = new Team ("Montreal",new String[]{"Coronel", "Duncan" , "Edelman", "Edwards", "Estela", "Barlow", "Amaya", "Castellano", "Long", "Marcucci"});
    	Team CF_Montreal = new Team ("New York",new String[]{"Logan Ketterer", "Kamal Miller", "Rudy Camacho", "Gabriele Corbo", "Joel Waterman", "Victor Wanyama", "Samuel Piette", "Ahmed Hamdi", "Joaquin Torres", "Rida Zouhir"});
    	Team New_York_CityFC = new Team ("TeamName",new String[]{"Sean Johnson", "Talles Magno", "Gabriel Pereira", "Alexander Callens", "Moralez", "Rosriguez", "Thiago Martins", "Gedion Zelalem", "Maxime Chanot", "Tayvon Gray"});
    	Team Tottenham = new Team ("TeamName",new String[]{"Brandon Austin", "Dejan Kulusevski", "Harry Kane", "Richarlison", "Ivan Perisic", "Cristian Romero", "Tanguy Ndombele", "Eric Dier", "Ben Davies", "Sergia Reguilon"});
    	Team Arsenal = new Team ("TeamName",new String[]{"Aaron Ramsdale", "Ben White", "Thomas Partey", "Kieran Tierney", "Fabio Vieira", "Mohamed Elneny", "Rob Holding", "Granit Xhaka", "Bukayo Saka", "Gabriel Jesus"});
    	Team Liverpool = new Team ("TeamName",new String[]{"Alisson Becker", "Mohamed Salah", "Darwin Nunez", "Luis Diaz", "Thiago Alcantara", "Roberto Firmino", "Diogo Jota", "Calvin Ramsay", "James Milner", "Harvey Elliott"});
    	Team Man_United = new Team ("TeamName",new String[]{"David de Gea", "Lisandro Martinez", "Christian Eriksen", "Harry Maguire", "Jadon Sancho", "Marcus Rashford", "Tyrell Malacia", "Anthony Martial", "Anthony Elanga", "Fred"});
    	Team B_Munich = new Team ("TeamName",new String[]{"Manuel Neuer", "Thomas Muller", "Sadio Mane", "Leroy Sane", "Joshua Kimmich", "Serge Gnabry", "Kingsley Coman", "Benjamin Pavard", "Leon Goretzka", "Dayot Upamecano"});
    	Team B_Dortmund = new Team ("TeamName",new String[]{"Alexander Meyer", "Marco Reus", "Sebastien Haller", "Karim Adeyemi", "Niklas Sule", "Mats Hummels", "Emre Can", "Manuel Akanji", "Julian Brandt", "Anthony Modeste"});
    	Team SV_Werder = new Team ("TeamName",new String[]{"Louis Sascha Lord", "Philipp Bargfrede", "Dejan Galjen", "Jakob Lopping", "Ole Springer", "Alexander Hock", "Abdul Gafar", "Timur Pazhigov", "Ole Schulz", "Marc Schroder"});
    	Team Hamburger = new Team ("TeamName",new String[]{"Matheo Raab", "Sebastian Schonlau", "Jonas David", "Maximilian Rohr", "Xavier Amaechi", "Sonny Kittel", "Filip Bilbija", "Mario Vuskovic", "Xavier Amaechi", "Tim Leibold"});
        
        
        
        
        
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
	
	private void NamePlayer(String[] PlayerList,VBox firstColumn,VBox secondColumn) {
		for(int Index=0;Index < 5;Index++) {
			
			CheckBox c1 = new CheckBox();
			c1.setText(PlayerList[Index]);
			firstColumn.getChildren().add(c1);
			CheckBox c2 = new CheckBox();
			c2.setText(PlayerList[Index+5]);
			secondColumn.getChildren().add(c2);
			
		}
	}
	
//	Vbox1.getchildren()
	
	
	
	@FXML
	private void ConfirmLeague(ActionEvent event) throws IOException {
		String getLeagueValue = LeaguesChoiceBox.getValue();
		
//		if(counter==0) {
		TeamOne.getItems().clear();
		TeamTwo.getItems().clear();
			if("La Liga".equals(getLeagueValue)){
			currentLeague = LaLiga;
			TeamOne.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			TeamTwo.getItems().addAll("Real Madrid","FC Barcelona","Atletico","Valencia CF");
			
		}
		else if("MLS".equals(getLeagueValue)){
			currentLeague = MLS;
			TeamOne.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			TeamTwo.getItems().addAll("Philadelphia","New York City","Montreal","New York");
			
			
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
		String TeamOneName = TeamOne.getValue();
		String TeamTwoName= TeamTwo.getValue();
		if (TeamOneName != TeamTwoName) {
			for(Team T:currentLeague.getTeams()) {
				if(TeamOneName.equals(T.getTeamName())) {
					NamePlayer(T.getPlayers(), Vbox1, Vbox2);	
				}
				if(TeamTwoName.equals(T.getTeamName())) {
					NamePlayer(T.getPlayers(), Vbox3, Vbox4);
				}		
			}
			}
		
		else {
			ErrorLabel.setText("You can't have Two "+TeamOneName+"s Please pick diffrent Teams");
		}
	}	
}	
