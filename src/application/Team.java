package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;

public class Team {
	private String[] players; 
	private String teamName;
	public Team(String teamName,String[] players) {
		this.teamName = teamName;
		this.players = players;
		
	}
	public String getTeamName() {
		
		return teamName;
	}
	public String[] getPlayers() {
		
		return players;
		}

}