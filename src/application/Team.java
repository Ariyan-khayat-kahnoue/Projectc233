package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;

public class Team {
	private String[] players; 
	private String TeamName;
	public Team(String TeamName,String[] players) {
		this.TeamName = TeamName;
		this.players = players;
		
	}
	public String getTeamName() {
		
		return TeamName;
	}
	public String[] getPlayers() {
		
		return players;
		}

}