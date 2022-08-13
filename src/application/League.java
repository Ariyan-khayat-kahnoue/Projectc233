package application;

import java.util.ArrayList;

public class League {
	private String Name;
	private ArrayList <Team> TeamList;
	public League(String League) {
		this.Name = League;
		this.TeamList = new ArrayList <Team>();
	}
		public void addTeam(Team ToAdd) {
			TeamList.add(ToAdd);
		
	}
		public ArrayList <Team> getTeams(){
			
			return TeamList;
			
		}
		
		public String getName(){
			
			return Name;
		}
}
	
